/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterProto extends SubsystemBase {
  /**
   * Creates a new ShooterProto.
   */
  Spark leftRoller;
  Spark rightRoller;
  
  public ShooterProto() {
    leftRoller = new Spark(Constants.SHOOTER_LEFT);
    rightRoller = new Spark(Constants.SHOOTER_RIGHT);
    rightRoller.setInverted(true);
    leftRoller.setSafetyEnabled(false);
    rightRoller.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shoot(double val){
    leftRoller.set(val);
    rightRoller.set(val);
  }
}
