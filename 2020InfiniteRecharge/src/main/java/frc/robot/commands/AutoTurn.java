/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class AutoTurn extends CommandBase {
  /**
   * Creates a new AutoTurn.
   */


  double kp=0,ki=0,kd=0;
  private PIDController controller = new PIDController(kp, ki, kd);
  private double tolerance = 3;

  
  

  public AutoTurn(double target) {
    controller.setSetpoint(target);
    addRequirements(RobotContainer.chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    RobotContainer.chassis.resetGyro();
    controller.setTolerance(tolerance);
    controller.enableContinuousInput(0, 360);
    SmartDashboard.putNumber("p", kp);
    SmartDashboard.putNumber("i", ki);
    SmartDashboard.putNumber("d", kd);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    updateValues();
    RobotContainer.chassis.tankDrive(calculate(), -1*calculate());
  }

  double calculate(){
    return controller.calculate(RobotContainer.chassis.getGyro());
  }

  public void updateValues(){
    double p = SmartDashboard.getNumber("p", 0);
    double i = SmartDashboard.getNumber("i", 0);
    double d = SmartDashboard.getNumber("d", 0);
    controller.setPID(p, i, d);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return controller.atSetpoint();
  }
}
