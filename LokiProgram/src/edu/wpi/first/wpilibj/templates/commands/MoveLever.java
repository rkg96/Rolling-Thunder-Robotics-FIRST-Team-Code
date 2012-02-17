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
        if (oi.getJoystick2().getY() > 1.0)
             leverSubsystem.setLeverSpeed(1);
        else if (oi.getJoystick2().getY() < -1.0)
             leverSubsystem.setLeverSpeed(-1);
        else
             leverSubsystem.setLeverSpeed(oi.getJoystick2().getY());
    }

    //Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (oi.getJoystick2().getY() == 0)
        return true;
        else return false;
             //if (LeverSubsystem.get() == false)
    }

    // Called once after isFinished returns true
    protected void end() {
        leverSubsystem.setLeverSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        leverSubsystem.setLeverSpeed(0);
    }
}
