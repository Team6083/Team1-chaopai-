package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class auto {
    public static SendableChooser<String> chooser = new SendableChooser<>();
    public static final String kshootball = "shootball";
    public static final String outcommunity = "outcommunity";
    public static final String donothing = "donothing";
    public static String autoselected;
    public static Timer timer = new Timer();
    // public static WPI_VictorSPX L = new WPI_VictorSPX(6);
    // public static WPI_VictorSPX R = new WPI_VictorSPX(7);
    // public static WPI_VictorSPX top = new WPI_VictorSPX(0);
    public static VictorSP L = new VictorSP(0);
    public static VictorSP R = new VictorSP(1);

    //public static AHRS gyro = new AHRS(SPI.Port.kMXP);
    public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

    public static int a = 0;

    public static void setting() {
        chooser.setDefaultOption("shootball", kshootball);
        chooser.addOption("donothing", donothing);
        chooser.addOption("outcommunity", outcommunity);
    }

    public static void start() {
        SmartDashboard.putData("Auto Choise", chooser);
       // autoselected = chooser.getSelected();
        gyro.reset();
        timer.reset();
        timer.start();
    }

    public static void loop() {
        switch (chooser.getSelected()) {
            case kshootball:
                kshootball();
                break;
            case donothing:
                L.set(0);
                R.set(0);
                break;
            case outcommunity:
                    if (timer.get() < 3) {
                        L.set(0.5);
                        R.set(-0.5);
                    } else {
                        timer.stop();
                    }
                    break;
            default:

                
        }
    }

    public static void kshootball() {

        // if (a == 0) {
        // if (gyro.getAngle() > -45) {
        // R.set(0.3);

        // } else {
        // a = 1;
        // timer.reset();
        // timer.start();
        // }
        // } else if (a == 1) {

        // if (timer.get() < 2) {
        // L.set(-0.5);
        // R.set(0.5);
        // } else {
        // a = 2;
        // gyro.reset();
        // }
        // } else if (a == 2) {
        // if (gyro.getAngle() < 90) {
        // L.set(-0.3);

        // } else {
        // a = 3;
        // }
        // // }else if(a==3){
        // // top.set(0.2);
        // }
        if (a == 0) {

            if (timer.get() < 7) {
                L.set(0.7);
                R.set(-0.7);
            } else {
                timer.stop();
                L.set(0);
                R.set(0);
                a = 1;
            }

        } else if (a == 1) {
         if(gyro.getAngle()>90){
            L.set(0.3);
            R.set(0.3);
         } else{
            a=2;
            timer.reset();
            timer.start();
            L.set(0);
            R.set(0);
         }

        }else if(a==2){
             if (timer.get() < 1) {
                L.set(0.2);
                R.set(-0.2);
            } else {
                timer.reset();
                timer.start();
                L.set(0);
                R.set(0);
                a = 3;
            }
        }else if (a==3){
            if(timer.get()<5){
           // top.set(0.2);     
        }else{
            a=4;
        }

    }
}
}