package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.Wheel;
import edu.wpi.first.wpilibj.templates.RobotMap;
/*
 * The DriveSystem class represents the robot's physical drive system. Each
 * wheel is comprised of two motors
 */

public class DriveSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Wheel frontleftWheel;
    public Wheel frontrightWheel;
    public Wheel backleftWheel;
    public Wheel backrightWheel;
    //represent the desired speed and direction of travel
    //[0]= frontLeft, [1]=frontright,[2]=Rearright,[3]=Rearleft
    public double[] magnitude = new double[4];
    public double[] angle = new double[4];
    // double lastfrDrive, lastflDrive, lastrlDrive,lastrrDrive;//last speed? need this??
    public double[] lastAngle = new double[4];//last current angle...

    public DriveSystem() {

        frontrightWheel = new Wheel(RobotMap.frontrightWheelTurn, RobotMap.frontrightWheelDrive);
        frontleftWheel = new Wheel(RobotMap.frontleftWheelTurn, RobotMap.frontleftWheelDrive);
        backleftWheel = new Wheel(RobotMap.backleftWheelTurn, RobotMap.backleftWheelDrive);
        backrightWheel = new Wheel(RobotMap.backrightWheelTurn, RobotMap.backrightWheelDrive);
        for (int i = 0; i <= 3; i++) {
            lastAngle[i] = 0;
        }


    }

    public void setWheel() {
        frontrightWheel.setWheel(angle[0], magnitude[0]);
        frontleftWheel.setWheel(angle[1], magnitude[1]);
        backleftWheel.setWheel(angle[2], magnitude[2]);
        backrightWheel.setWheel(angle[3], magnitude[3]);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here. Something that sends current motor speeds to the dashboard?
        //setDefaultCommand(new MySpecialCommand());
    }
}
