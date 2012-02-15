/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

//import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.can.CANTimeoutException;


/**
 *
 * @author Giang
 */
public class Wheel {

    private Jaguar turnJaguar;
    //public Jaguar driveJaguar;
    private Victor driveVictor;

    public Wheel(int turnchannel, int drivechannel){
        
            turnJaguar = new Jaguar(turnchannel);//CANJaguar.ControlMode.kPercentVbus
            driveVictor = new Victor(drivechannel);        
        
        
    }
    public void setWheel(double turnRate, double driveRate){
            turnJaguar.set(turnRate);
        
        driveVictor.set(driveRate);
        
    }
}
