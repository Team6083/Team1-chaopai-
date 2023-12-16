package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;

public class teleop {
    public static WPI_VictorSPX L = new WPI_VictorSPX(6);
    public static WPI_VictorSPX R = new WPI_VictorSPX(7);
    public static WPI_VictorSPX top = new WPI_VictorSPX(0);
    public static Joystick joy = new Joystick(0);
    public static void loop(){
    L.set(-joy.getRawAxis(1));
    R.set(joy.getRawAxis(5));
    if (joy.getRawButtonPressed(0)) {
      top.set(0.2);
    } else if (joy.getRawButtonPressed(1)) {
      top.set(0.5);
    } else if (joy.getRawButtonPressed(2)) {
      top.set(0.7);
    }
    }
}
