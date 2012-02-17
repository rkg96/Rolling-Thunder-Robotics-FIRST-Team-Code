package edu.wpi.first.wpilibj.templates;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
   
    //Victors slots #...drive
    public static final int frontrightWheelDrive=2;
    public static final int frontleftWheelDrive=1;
    public static final int backleftWheelDrive=4;
    public static final int backrightWheelDrive=3;
    
    //Canjaguar slots #...drive
    public static final int frontrightWheelTurn=3;
    public static final int frontleftWheelTurn=2;
    public static final int backleftWheelTurn=5;
    public static final int backrightWheelTurn=4;
    
    //Button 4 movable mass...
   // public static final Button autoMoveMass = stick1.getButton();
    //public static final Button
    //Victors slots #...movable mass and lever
    public static final int massVictor=20;
    public static final int leverVictor=21;
    
    //Accelerometers chanel #...auto movable mass
    public static final int accChanel=30;
       
}
