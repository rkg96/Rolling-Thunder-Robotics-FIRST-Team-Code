/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

//import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.can.CANTimeoutException;


/**
 *
 * @author Giang
 */
public class Wheel {

    private CANJaguar turnJaguar;
    //public Jaguar driveJaguar;
    private Victor driveVictor;

    public Wheel(int turnchannel, int drivechannel){
        try {
            turnJaguar = new CANJaguar(turnchannel,CANJaguar.ControlMode.kPercentVbus);
            turnJaguar.enableControl();
            driveVictor = new Victor(drivechannel);
        } catch (CANTimeoutException ex) {
        }
    }
    public void setWheel(double turnRate, double driveRate){
        try {
            turnJaguar.setX(turnRate);
        } catch (CANTimeoutException ex) {
        }
        driveVictor.set(driveRate);
        
    }
}
