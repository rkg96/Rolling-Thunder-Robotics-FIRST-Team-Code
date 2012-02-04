/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Robert Truong
 */
public class MoveMass extends CommandBase {

    public MoveMass() {
        requires(MassSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (RobotMap.stick1.getY() > 0) {
            MassSubsystem.massJaguar.set(.5);
        } else if (RobotMap.stick1.getY() < 0) {
            MassSubsystem.massJaguar.set(-.5);
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (RobotMap.stick1.getY() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        MassSubsystem.massJaguar.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        MassSubsystem.massJaguar.set(0);
    }
}
