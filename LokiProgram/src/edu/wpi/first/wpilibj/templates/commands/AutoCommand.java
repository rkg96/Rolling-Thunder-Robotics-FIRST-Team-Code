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
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Giang
 */
public class AutoCommand extends DriverCommand {
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
//    double L = 9.5;
//    double W = 14.0;
//    double R = Math.sqrt(MathUtils.pow(L, 2.0) + MathUtils.pow(W, 2.0));
    private static int counter = 0; 
    private static int counter2 = 0; 
    private static int counter3 = 0;
    private static int counter4 = 0;
    private static int counter5 = 0;
    private static int counter6 = 0;
    private static int counter7 = 0;
    private static int counter8 = 0;
    private static int counter9 = 0;
    private static int counter10 = 0;
    private static int counter11 = 0;
    private static int counter12 = 0;
    
    public AutoCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //DEFAULT POSITION: left
        
        //FIRST BRIDGE
        if (counter < 15) {//lasts for 5 seconds
            counter++;
        try {
              swerveWithRotation(0, 1, 0); //moves forward, change values later
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
      }
        
        else if (counter2 < 9) { //lasts 3 seconds
            counter2++;
        
        leverSubsystem.setLeverSpeed(1); //moves lever down, change value
        }
        
        else if (counter3 < 9) { // lasts 3 seconds
           counter3++;
         leverSubsystem.setLeverSpeed(-1); //moves lever up, change value
        }
        
        else if (counter4 < 9) { // lasts 3 seconds
            counter4++;
         try {           
        swerveWithRotation(0, 0, 90); //turns 90 degrees to right???, fix value
       } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
        //SECOND BRIDGE
        else if (counter5 < 15) { //lasts 5 seconds
        counter5++;    
         try {           
        swerveWithRotation(0, 1, 0); //moves robot forward
       } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
       
        else if (counter6 < 9) { // lasts 3 seconds
            counter6++;
         try {           
        swerveWithRotation(0, 0, -90); //turns 90 degrees to left???, fix value
       } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
        
        else if (counter7 < 9) { //lasts 3 seconds
            counter2++;
        
        leverSubsystem.setLeverSpeed(1); //moves lever down, change value
        }
        
        else if (counter8 < 9) { // lasts 3 seconds
           counter3++;
         leverSubsystem.setLeverSpeed(-1); //moves lever up, change value
        }
        
        //THIRD BRIDGE
        else if (counter9 < 9) { // lasts 3 seconds
            counter9++;
         try {           
        swerveWithRotation(0, 0, 90); //turns 90 degrees to right???, fix value
       } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
        else if (counter10 < 15) { //lasts 5 seconds
        counter10++;    
         try {           
        swerveWithRotation(0, 1, 0); //moves robot forward
       } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
       
        else if (counter11 < 9) { // lasts 3 seconds
            counter11++;
         try {           
        swerveWithRotation(0, 0, -90); //turns 90 degrees to left???, fix value
       } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
       }
        
        else if (counter12 < 9) { //lasts 3 seconds
            counter12++;
        leverSubsystem.setLeverSpeed(1); //moves lever down, change value
        }
        
        else if (counter8 < 9) { // lasts 3 seconds
           counter3++;
         leverSubsystem.setLeverSpeed(-1); //moves lever up, change value
        }
        //CODE GOES OVER 15 SECOND TIME LIMIT 
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
}