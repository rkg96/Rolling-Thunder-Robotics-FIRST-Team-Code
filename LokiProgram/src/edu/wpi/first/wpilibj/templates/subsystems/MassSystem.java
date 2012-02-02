package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class MassSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Jaguar massJaguar;

    public MassSystem() {
        massJaguar = new Jaguar(1);
    }

    public void set(double speed) {
        massJaguar.set(speed);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Send Mass position?
        //setDefaultCommand(new MySpecialCommand());
    }
}
