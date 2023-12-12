package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class auto {
    public static SendableChooser<String> chooser = new SendableChooser<String>();
    public static final String kshootball = "shootball";
    public static String autoselected;
    public static Timer timer = new Timer();
    public static WPI_VictorSPX L = new WPI_VictorSPX(12);
    public static WPI_VictorSPX R = new WPI_VictorSPX(13);
    public static WPI_VictorSPX top = new WPI_VictorSPX(0);
    public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();
    public static int a = 0; 
    public static void setting (){
        chooser.setDefaultOption("shootball", kshootball);

    }
    public static void start(){
        SmartDashboard.putData("Auto Choise", chooser);
        autoselected = chooser.getSelected();
    } 
    public static void loop(){
        switch (autoselected){
            case kshootball:
            gyro.reset();
            timer.reset();
            kshootball();
        }
        
    }
    public static void kshootball(){
        gyro.reset();
        if(a==0){
            if(gyro.getAngle()>-45){
                R.set(0.5);

            }else{
                a=1;
            }
        }else if(a==1){
            timer.start();
            if(timer.get()<2){
                L.set(1);
                R.set(1);
            }else{
                a=2;
                gyro.reset();
            }
        }else if(a==2){
            if(gyro.getAngle()<90){
                L.set(0.5);

            }else{
                a=3;
            }
        }else if(a==3){
            top.set(0.2);
        }

    }
}