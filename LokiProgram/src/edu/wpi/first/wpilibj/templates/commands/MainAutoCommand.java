package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
/**
 *
 * @author bradmiller
 */
public class MainAutoCommand extends CommandBase {

    public MainAutoCommand() {
        requires(gyroSubsystem);
        requires(driveSubsystem);
        requires(leverSubsystem);
        requires(massSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {              
        
        
        
        //All of autonomus
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
