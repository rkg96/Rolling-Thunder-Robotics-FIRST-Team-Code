package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import  edu.wpi.first.wpilibj.Accelerometer;

/**
 *
 */
public class MassSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Victor massVictor;
    public Accelerometer accelerometer;
   
    public MassSystem() {

//        massVictor = new Victor(RobotMap.massVictor);
  //      accelerometer=new Accelerometer(RobotMap.accChanel);
    }

    public synchronized void moveMass(double n) {
        massVictor.set(n);
        try {
            wait(250);
        } catch (InterruptedException ex) {
        }
        massVictor.set(0.0);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Send Mass position?
        //setDefaultCommand(new MySpecialCommand());
    }
}
