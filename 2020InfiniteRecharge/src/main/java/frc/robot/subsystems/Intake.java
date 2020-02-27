/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  /**
   * Creates a new Intake.
   */

  TalonSRX intake;
  public Intake() {
    intake = new TalonSRX(Constants.INTAKE_TALON);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void pull(){
    intake.setNeutralMode(NeutralMode.Coast);
    intake.set(ControlMode.PercentOutput, 0.5);
  }

  public void eject(){
    intake.setNeutralMode(NeutralMode.Coast);
    intake.set(ControlMode.PercentOutput, -0.5);
  }

  public void stop(){
    intake.setNeutralMode(NeutralMode.Brake);
    intake.set(ControlMode.PercentOutput, 0);
  }
}
