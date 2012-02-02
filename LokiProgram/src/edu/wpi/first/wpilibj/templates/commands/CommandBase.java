package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.DriveSystem;
import edu.wpi.first.wpilibj.templates.subsystems.GyroSystem;
import edu.wpi.first.wpilibj.templates.subsystems.LeverSystem;
import edu.wpi.first.wpilibj.templates.subsystems.MassSystem;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    public static MassSystem MassSubsystem = new MassSystem();
    public static LeverSystem LeverSubsystem = new LeverSystem();
    public static GyroSystem GyroSubsystem = new GyroSystem();
    public static DriveSystem DriveSubsystem = new DriveSystem();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(MassSubsystem);
        SmartDashboard.putData(LeverSubsystem);
        SmartDashboard.putData(GyroSubsystem);
        SmartDashboard.putData(DriveSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
