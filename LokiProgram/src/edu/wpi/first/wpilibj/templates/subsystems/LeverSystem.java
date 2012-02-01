package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LeverSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Jaguar leverJaguar;

    public LeverSystem() {
        leverJaguar = new Jaguar(1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Sends current lever angle to smartdashboard?
        //setDefaultCommand(new MySpecialCommand());
    }
}
