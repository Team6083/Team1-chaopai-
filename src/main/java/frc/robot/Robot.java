// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  // VictorSP L = new VictorSP(6);
  // VictorSP R = new VictorSP(7);
  // WPI_VictorSPX top = new WPI_VictorSPX(12);
  // Joystick joy = new Joystick(0);

  @Override
  public void robotInit() {
    auto.setting();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    auto.start();

  }

  @Override
  public void autonomousPeriodic() {
    auto.loop();
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    teleop.loop();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {}  

  @Override
  public void simulationInit() {
  }

  @Override
  public void simulationPeriodic() {
  }
}
