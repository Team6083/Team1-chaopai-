package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class auto {
    public static SendableChooser<String> chooser = new SendableChooser<String>();
    public static final String kshootball = "shootball";
    public static final String kdonothing = "donothing";
    public static final String kmove = "move";
    public static String autoselected;
    public static Timer timer = new Timer();
    public static WPI_VictorSPX L = new WPI_VictorSPX(6);
    public static WPI_VictorSPX R = new WPI_VictorSPX(7);
    public static WPI_VictorSPX top = new WPI_VictorSPX(0);
    // public static VictorSP L = new VictorSP(6);
    // public static VictorSP R = new VictorSP(7);

    public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    public static int a = 0;

    public static void setting() {
        chooser.setDefaultOption("shootball", kshootball);
        chooser.addOption("donothing", kdonothing);
        chooser.addOption("move", kmove);
    }

    public static void start() {
        SmartDashboard.putData("Auto Choise", chooser);
        autoselected = chooser.getSelected();
    }

    public static void loop() {
        switch (autoselected) {
            case kshootball:
                timer.reset();
                kshootball();
                break;
            case kdonothing :
                 L.set(0);
                 R.set(0);
                 break;
            case kmove:
                timer.reset();
                kmove();
                break;

        }

    }

    public static void kshootball() {
        gyro.reset();
        if (a == 0) {
            if (gyro.getAngle() > -45) {
                R.set(0.3);

            } else {
                a = 1;
            }
        } else if (a == 1) {
            timer.start();
            if (timer.get() < 2) {
                L.set(-0.5);
                R.set(0.5);
            } else {
                a = 2;
                gyro.reset();
            }
        } else if (a == 2) {
            if (gyro.getAngle() < 90) {
                L.set(-0.3);

            } else {
                a = 3;
                timer.reset();
                timer.start();
            }
            }else if(a==3){
                if(timer.get()<=5){
                    top.set(0.2);
                }else{
                    a = 4;
                }
            }
    

    }
    public static void kmove(){
        gyro.reset();
        if (a == 0) {
            if (gyro.getAngle() > -45) {
                R.set(0.3);

            } else {
                a = 1;
            }
        } else if (a == 1) {
            timer.start();
            if (timer.get() < 2) {
                L.set(-0.5);
                R.set(0.5);
            } else {
                a = 2;
            }
    }
}
}