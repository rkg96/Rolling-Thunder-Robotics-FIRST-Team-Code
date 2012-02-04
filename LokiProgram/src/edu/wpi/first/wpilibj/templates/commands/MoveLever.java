/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Robert Truong
 */
public class MoveLever extends CommandBase {
    
    public MoveLever() {
        requires(LeverSubsystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        LeverSubsystem.leverJaguar.set(-.1);
    }

     //Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //if (LeverSubsystem.get() == false)
                //return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        LeverSubsystem.leverJaguar.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        LeverSubsystem.leverJaguar.set(0);
    }
}
