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
import frc.robot.RobotContainer;

public class AutoDrive extends CommandBase {
  /**
   * Creates a new AutoDrive.
   */
  double kp=0,ki=0,kd=0;
  PIDController controller = new PIDController(kp, ki, kd);
  double tolerance = 3;
  

  public AutoDrive(double distance) {
    controller.setSetpoint(distance);
    addRequirements(RobotContainer.chassis);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //reset encoders
    controller.setTolerance(tolerance);
    SmartDashboard.putNumber("DriveP", kp);
    SmartDashboard.putNumber("DriveI", ki);
    SmartDashboard.putNumber("DriveD", kd);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.chassis.tankDrive(calculate(), calculate());
  }

  double calculate(){// DOOOOOOOOOOOO CALCCCCCCCCCCCC
    //do calc
    return 0;
  }

  public void updateValues(){
    double p = SmartDashboard.getNumber("DriveP", 0);
    double i = SmartDashboard.getNumber("DriveI", 0);
    double d = SmartDashboard.getNumber("DriveD", 0);
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
