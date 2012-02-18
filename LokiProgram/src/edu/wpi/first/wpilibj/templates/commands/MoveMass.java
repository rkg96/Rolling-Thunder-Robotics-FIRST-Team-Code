/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Robert Truong
 */
public class MoveMass extends CommandBase {
    
    public MoveMass() {
        
        requires(massSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (oi.getJoystick3().getY() > 1.0) {
            massSubsystem.moveMass(1.); 
        }
        else if (oi.getJoystick3().getY() < -1.0) {
            massSubsystem.moveMass(-1.);
        }
        else { 
            massSubsystem.moveMass(oi.getJoystick3().getY());
        }    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (oi.getJoystick3().getY() == 0) {
        return true;
        }
        else { 
            return false;
    }
    }

    // Called once after isFinished returns true
    protected void end() {
        massSubsystem.moveMass(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        massSubsystem.moveMass(0);
    }
}
