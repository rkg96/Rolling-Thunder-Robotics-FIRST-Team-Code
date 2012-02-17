     /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
 
//import edu.wpi.first.wpilibj.AnalogChannel;
//import edu.wpi.first.wpilibj.AnalogModule;
//import edu.wpi.first.wpilibj.CANJaguar;
//import edu.wpi.first.wpilibj.Encoder;
//import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Victor;
//import edu.wpi.first.wpilibj.can.CANTimeoutException;
//import edu.wpi.first.wpilibj.Gyro;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.OI;

/**
 *
 * @author Giang
 */
public class DriverCommand extends CommandBase {
    //joystick and it's values...

    //rotation motor controller.
    //Victor frTurn = new Victor(1);
    //Victor flTurn = new Victor(2);
    //Victor rlTurn = new Victor(3);
    //Victor rrTurn = new Victor(4);
    //speed controller.
    //CANJaguar frAcc;
    //CANJaguar flAcc;
    //CANJaguar rlAcc;
    //CANJaguar rrAcc;
    //represent the desired speed and direction of travel
    //[0]= frontLeft, [1]=frontright,[2]=Rearright,[3]=Rearleft
    //double[] magnitude = new double[4];
    //double[] angle = new double[4];
    // double lastfrDrive, lastflDrive, lastrlDrive,lastrrDrive;//last speed? need this??
    //double[] lastAngle = new double[4];//last current angle...
    // frAngle,flAngle,rlAngle,rrAngle;//actual angles, not encoder values
    //constants...
    double L = 9.5;
    double W = 14.0;
    double R = Math.sqrt(MathUtils.pow(L, 2.0) + MathUtils.pow(W, 2.0));

    public DriverCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            swerveWithRotation(oi.getJoystick1().getX(), oi.getJoystick1().getY(), oi.getJoystick1().getTwist());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

    protected void swerveWithRotation(double STR, double FWD, double RCW) throws CANTimeoutException {
        //convert to field-centric...
        double temp = FWD * Math.cos(gyroSubsystem.getAngle()) + STR * Math.sin(gyroSubsystem.getAngle());
        STR = -FWD * Math.sin(gyroSubsystem.getAngle()) + STR * Math.cos(gyroSubsystem.getAngle());
        FWD = temp;
        gyroSubsystem.updateAngle(RCW);
        //Vector components...
        double A = STR - RCW * (L / R);
        double B = STR + RCW * (L / R);
        double C = FWD - RCW * (W / R);
        double D = FWD + RCW * (W / R);

        //temp speed for each wheel
        driveSubsystem.setMagnitude(0 ,Math.sqrt(MathUtils.pow(B, 2.0) + MathUtils.pow(C, 2.0)));
        driveSubsystem.setMagnitude(1 , Math.sqrt(MathUtils.pow(B, 2.0) + MathUtils.pow(D, 2.0)));
        driveSubsystem.setMagnitude(2,  Math.sqrt(MathUtils.pow(A, 2.0) + MathUtils.pow(D, 2.0)));
        driveSubsystem.setMagnitude(3 , Math.sqrt(MathUtils.pow(A, 2.0) + MathUtils.pow(C, 2.0)));
        // temp angle for each wheel
        driveSubsystem.setAngle(0, MathUtils.atan2(B, C) * 180 / Math.PI);
        driveSubsystem.setAngle(1, MathUtils.atan2(B, D) * 180 / Math.PI);
        driveSubsystem.setAngle(2, MathUtils.atan2(A, D) * 180 / Math.PI);
        driveSubsystem.setAngle(3, MathUtils.atan2(A, C) * 180 / Math.PI);

        //normalize the speed...
        double max = driveSubsystem.getMagnitude(0);
        if (driveSubsystem.getMagnitude(1) > max) {
            max = driveSubsystem.getMagnitude(1);
        }
        if (driveSubsystem.getMagnitude(2) > max) {
            max = driveSubsystem.getMagnitude(2);
        }
        if (driveSubsystem.getMagnitude(3) > max) {
            max = driveSubsystem.getMagnitude(3);
        }
        if (max > 1) {
            driveSubsystem.setMagnitude(0, driveSubsystem.getMagnitude(0) /max);
            driveSubsystem.setMagnitude(1, driveSubsystem.getMagnitude(1) /max);
            driveSubsystem.setMagnitude(2, driveSubsystem.getMagnitude(2) /max);
            driveSubsystem.setMagnitude(3, driveSubsystem.getMagnitude(3) /max);
        }
        adjustSpeedAndAngle();

        //saving angles...
        for (int i = 0; i <= 3; i++) {
            driveSubsystem.setLastAngle(i, driveSubsystem.getLastAngle(i) + driveSubsystem.getAngle(i));
        }
        //set motors speed for each wheel...
        driveSubsystem.setWheel();

    }
    //reverse speed rather than turn >180
    //Cannot turn more than 180 on map...

    protected void adjustSpeedAndAngle() 
    {
        for (int i = 0; i <= 3; i++) 
        {
            driveSubsystem.setMagnitude(i , driveSubsystem.getMagnitude(i) * MathUtils.pow(-1, (int) (driveSubsystem.getAngle(i) / 180.0)));
            driveSubsystem.setAngle(i, (driveSubsystem.getAngle(i) % 180.0));
            if (Math.abs(driveSubsystem.getAngle(i) + driveSubsystem.getLastAngle(i)) > 180) 
            {
                driveSubsystem.setAngle(i,driveSubsystem.getAngle(i) - 180.0);
                driveSubsystem.setMagnitude(i,driveSubsystem.getMagnitude(i) * -1);
            }
        }
    }

    protected void resetAngle() {
        for (int i = 0; i <= 3; i++) {
            driveSubsystem.setLastAngle(i, 0.);
        }

    }
}
