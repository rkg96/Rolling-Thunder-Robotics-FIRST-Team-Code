/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Robert Truong
 */
public class ManualMass extends CommandBase {
    
    public ManualMass() {
        requires(massSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.getUpMass().get() && !oi.getDownMass().get())
            massSubsystem.setManualSpeed(.1);
        else if (oi.getDownMass().get() && !oi.getUpMass().get())
            massSubsystem.setManualSpeed(-.1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ((oi.getUpMass().get() && oi.getDownMass().get()) || (!oi.getUpMass().get() && !oi.getDownMass().get()))
            return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
