/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author Clay
 */
public class Wheel {

    public Jaguar turnJaguar;
    public Jaguar driveJaguar;

    public Wheel(int turnchannel, int drivechannel) {
        turnJaguar = new Jaguar(turnchannel);
        driveJaguar = new Jaguar(drivechannel);
    }
}
