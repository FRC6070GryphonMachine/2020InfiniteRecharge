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
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
<<<<<<< Updated upstream
=======
import frc.robot.Constants;
>>>>>>> Stashed changes

public class Chassis extends SubsystemBase {
  /**
   * Creates a new Chassis.
   */

  TalonSRX right, left;
  VictorSPX rightSlave, leftSlave;
  

  public Chassis() {
<<<<<<< Updated upstream
    lf = new TalonSRX(0);
    lb = new TalonSRX(1);
    rf = new TalonSRX(2);
    rb = new TalonSRX(3);
=======
    //init speed controllers
    right = new TalonSRX(Constants.rightTalon);
    left = new TalonSRX(Constants.leftTalon);
    rightSlave = new VictorSPX(Constants.rightSlave);
    leftSlave = new VictorSPX(Constants.leftSlave);

    //set brakemode
    right.setNeutralMode(NeutralMode.Brake);
    left.setNeutralMode(NeutralMode.Brake);
    rightSlave.setNeutralMode(NeutralMode.Brake);
    leftSlave.setNeutralMode(NeutralMode.Brake);

    //set slaves
    rightSlave.follow(right);
    leftSlave.follow(left);

    
>>>>>>> Stashed changes
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    lb.follow(lf);
    rb.follow(rf);

  }

  public void tankDrive(double left, double right){
<<<<<<< Updated upstream
    lf.setNeutralMode(NeutralMode.Coast);
    rf.setNeutralMode(NeutralMode.Coast);

    lb.setNeutralMode(NeutralMode.Coast);
    rb.setNeutralMode(NeutralMode.Coast);

    lf.set(ControlMode.PercentOutput, left);
    rf.set(ControlMode.PercentOutput, right);
  }

  public void stop(){
    lf.setNeutralMode(NeutralMode.Brake);
    rf.setNeutralMode(NeutralMode.Brake);

    lb.setNeutralMode(NeutralMode.Brake);
    rb.setNeutralMode(NeutralMode.Brake);

    lf.set(ControlMode.PercentOutput, 0);
    rf.set(ControlMode.PercentOutput, 0);
=======
    this.left.set(ControlMode.PercentOutput, left);
    this.right.set(ControlMode.PercentOutput, right);
  }

  public void stop(){
    left.set(ControlMode.PercentOutput, 0);
    right.set(ControlMode.PercentOutput, 0);
>>>>>>> Stashed changes
  }

}
