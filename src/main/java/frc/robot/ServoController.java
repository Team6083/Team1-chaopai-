package frc.robot;

import edu.wpi.first.wpilibj.Servo;

public class ServoController {
    public static Servo servo = new Servo(0);
    public static void servoSet(double b){
        servo.set(b);
    }
    

}
