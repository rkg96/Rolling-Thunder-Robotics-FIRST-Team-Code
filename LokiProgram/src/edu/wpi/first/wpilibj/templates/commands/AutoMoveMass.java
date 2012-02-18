/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;
import com.sun.squawk.util.MathUtils;


/**
 *
 * @author Giang
 */
public class AutoMoveMass extends CommandBase {
    
    public AutoMoveMass() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
      requires(massSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {   
    if (oi.getAuto().get()) {
      massSubsystem.moveMass(getMassSpeed(massSubsystem.getAccel().getAcceleration()));
    }    
    }

    protected double getMassSpeed(double acc)
    {
       return MathUtils.asin(acc/9.8)*(180/Math.PI)*-.25;
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (massSubsystem.getAccel().getAcceleration() == 0) {
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
