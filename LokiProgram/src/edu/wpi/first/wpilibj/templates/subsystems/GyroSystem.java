 package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableGyro;

/**
 *
 */
public class GyroSystem extends Subsystem {

    double gyroAngle = 0.0;
    public SendableGyro SendableGyro;
    //public SendableGyro ySendableGyro;

    public GyroSystem() {
        //SendableGyro = new SendableGyro(1);
        // ySendableGyro = new SendableGyro(1);
    }

    public double getAngle() {
        return gyroAngle;
    }

    public void updateAngle(double angle) {
        gyroAngle += angle;
    }
    /*
    private NetworkTable table;

    public NetworkTable getTable() {
        if (table == null) {
            table = super.getTable();
            table.putSubTable("xGyro", xSendableGyro.getTable());
            table.putSubTable("yGyro", ySendableGyro.getTable());
        }
        return table;
    }

    ;
    */
    public void initDefaultCommand() {
        // Set the default command for a subsystem here. This should probably be something that sends the gyro values to the dashboard
        //setDefaultCommand(new MySpecialCommand());
    }
}
