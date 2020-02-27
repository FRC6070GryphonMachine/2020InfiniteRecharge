/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterProto extends SubsystemBase {
  /**
   * Creates a new ShooterProto.
   */
  CANSparkMax leftRoller;
  CANSparkMax rightRoller;
  
  public ShooterProto() {
    leftRoller = new CANSparkMax(Constants.SHOOTER_LEFT, MotorType.kBrushless);
    rightRoller = new CANSparkMax(Constants.SHOOTER_RIGHT, MotorType.kBrushless);
    rightRoller.setInverted(true);
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
