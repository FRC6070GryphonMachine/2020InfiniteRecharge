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
import frc.robot.RobotContainer;

public class SparkMaxes extends SubsystemBase {
  /**
   * Creates a new SparkMaxes.
   */
  CANSparkMax spark;

  public SparkMaxes() {
    spark = new CANSparkMax(4, MotorType.kBrushless);
    
  }

  @Override
  public void periodic() {
    spark.set(RobotContainer.getYLeft());
  }
}
