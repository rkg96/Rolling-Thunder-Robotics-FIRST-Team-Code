/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.OI;

/**
 *
 * @author Robert Truong
 */
public class MoveLever extends CommandBase {

    public MoveLever() {
        requires(leverSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (OI.upMass.get()) {
            massSubsystem.massVictor.set(.1);
        } else if (OI.downMass.get()) {
            massSubsystem.massVictor.set(-.1);
        }

    }

    //Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //if (LeverSubsystem.get() == false)
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        leverSubsystem.leverJaguar.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        leverSubsystem.leverJaguar.set(0);
    }
}
