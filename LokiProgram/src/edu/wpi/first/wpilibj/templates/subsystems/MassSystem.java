package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.LogFile;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 */
public class MassSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Victor massVictor = new Victor(RobotMap.massVictor);
    public Accelerometer accelerometer = new Accelerometer(RobotMap.accChanel); // TODO : Aren't we using a gyro?
    public NetworkTable table = new NetworkTable();

    public void moveMass(double n) {
        massVictor.set(n);
        try {
            wait(250); // TODO: This will freeze the entire main thread!
        } catch (Exception exception) {
        LogFile log = LogFile.getInstance();
        log.logString(exception.toString());
        }
        massVictor.set(0.0);
    }

    public NetworkTable getTable() {
        table.putDouble("Speed", massVictor.getSpeed());
        table.putInt("Channel", massVictor.getChannel());
        return table;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Send Mass position?
        //setDefaultCommand(new MySpecialCommand());
    }
}
