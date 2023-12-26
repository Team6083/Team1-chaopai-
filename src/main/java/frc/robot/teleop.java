package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

public class teleop {
    public static WPI_VictorSPX L2 = new WPI_VictorSPX(13);
    public static WPI_VictorSPX R2 = new WPI_VictorSPX(12);
    public static WPI_VictorSPX top2 = new WPI_VictorSPX(0);
    // public static VictorSP L2 = new VictorSP(2);
    // public static VictorSP R2 = new VictorSP(3);
    public static Joystick joy = new Joystick(0);
    public static Timer timer = new Timer();

    public static void setting() {
        ServoController.servoSet(0);
    }

    public static void loop() {
        L2.set(-joy.getRawAxis(1) * 0.5);
        R2.set(joy.getRawAxis(5) * 0.5);
        // if (joy.getRawButton(3)) {
        // ServoController.servoSet(0.5);
        // top2.set(0.2);
        // } else if (joy.getRawButton(1)) {
        // ServoController.servoSet(0.5);
        // top2.set(0.5);
        // } else
        if (joy.getRawButtonPressed(2)) {
            top2.set(0.5);

        } else if (joy.getRawButtonPressed(1)) {

            top2.set(0);
        }

    }
}
// top2.set(0);
// }

// } else if (joy.getPOV() == 90) {
// ServoController.servoSet(0.5);
// top2.set(-0.7);
// } else if (joy.getPOV() == 180) {
// ServoController.servoSet(0.5);
// top2.set(-0.5);
// } else if(joy.getPOV() == 270){
// ServoController.servoSet(0.5);
// top2.set(1);
// } else{
// top2.set(0);
// ServoController.servoSet(0);
// }
// }
// }
