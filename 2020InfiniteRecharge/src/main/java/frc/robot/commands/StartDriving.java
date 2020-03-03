/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class StartDriving extends CommandBase {
  /**
   * Creates a new StartDriving.
   */
  public StartDriving() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.chassis);
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(RobotContainer.getRightTrigger() > 0.8){
      RobotContainer.chassis.tankDrive(RobotContainer.getYLeft()*Constants.lSpeedCoefficient, RobotContainer.getYRight()*Constants.lSpeedCoefficient);
    } else {
      RobotContainer.chassis.tankDrive(RobotContainer.getYLeft()*Constants.hSpeedCoefficient, RobotContainer.getYRight()*Constants.hSpeedCoefficient);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
