package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.Wheel;
/*
 * The DriveSystem class represents the robot's physical drive system.
 * Each wheel is comprised of two motors
 */

public class DriveSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Wheel frontleftWheel;
    public Wheel frontrightWheel;
    public Wheel backleftWheel;
    public Wheel backrightWheel;

    public DriveSystem() {
        frontleftWheel = new Wheel(1, 1);
        frontrightWheel = new Wheel(1, 1);
        backleftWheel = new Wheel(1, 1);
        backrightWheel = new Wheel(1, 1);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Something that sends current motor speeds to the dashboard?
        //setDefaultCommand(new MySpecialCommand());
    }
}
