/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboardData;

/**
 *
 * @author Giang
 */
public class Wheel /*implements SmartDashboardData*/ {

    private CANJaguar turnJaguar;
    //public Jaguar driveJaguar;
    private Victor driveVictor;
    public NetworkTable table;

    public Wheel(int turnchannel, int drivechannel) {
        try {
            turnJaguar = new CANJaguar(turnchannel);//, CANJaguar.ControlMode.kPercentVbus);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
            driveVictor = new Victor(drivechannel);
        
    }

    public void setWheel(double turnRate, double driveRate) throws CANTimeoutException {
        //btwn -1 and 1
        turnJaguar.setX(turnRate);
        driveVictor.set(driveRate);
    }

  public NetworkTable getTable() {
        if (table == null) {
            table = new NetworkTable();
        }
        try {
            table.putInt("Jaguar Faults", turnJaguar.getFaults());
        } catch (Exception exception) {
            table.putString("FaultException", exception.toString());
        }
        try {
            table.putBoolean("Jaguar Forward Limit", turnJaguar.getForwardLimitOK());
        } catch (Exception exception) {
            table.putString("ForwardException", exception.toString());
        }
        try {
            table.putBoolean("Jaguar Reverse Limit", turnJaguar.getReverseLimitOK());
        } catch (Exception exception) {
            table.putString("ReverseException", exception.toString());
        }
        try {
            table.putDouble("Jaguar Speed", turnJaguar.getSpeed());
        } catch (Exception exception) {
            table.putString("SpeedException", exception.toString());
        }
        // Victor Values
        try {
            table.putDouble("Victor Speed", driveVictor.getSpeed());
        } catch (Exception exception) {
            table.putString("VSpeed Exception", exception.toString());
        }
        try {
            table.putInt("Victor Channel", driveVictor.getChannel());
        } catch (Exception exception) {
            table.putString("VChannel Exception", exception.toString());
        }
        return table;
    }

    public String getType() {
        return "Wheel";
    }
}
