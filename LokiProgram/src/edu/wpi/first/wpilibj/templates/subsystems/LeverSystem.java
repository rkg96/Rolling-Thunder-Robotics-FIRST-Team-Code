package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.commands.MoveLever;

/**
 * TODO: Add movement commands, hook up buttons
 */
public class LeverSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private Victor leverVictor;
    public NetworkTable table;
    
    public void setLeverSpeed(double x)
    {
        leverVictor.set(x);
    }

    public NetworkTable getTable() {
        if (table == null) {
            table = super.getTable();
        }
        table.putDouble("Speed", leverVictor.getSpeed());
        table.putInt("Channel", leverVictor.getChannel());
        return table;
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Sends current lever angle to smartdashboard?
        setDefaultCommand(new MoveLever());
    }
}
