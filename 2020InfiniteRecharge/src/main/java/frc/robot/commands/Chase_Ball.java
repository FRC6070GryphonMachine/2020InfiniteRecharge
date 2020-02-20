/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Chase_Ball extends CommandBase {
  /**
   * Creates a new Chase_Ball.
   */
  public Chase_Ball() {
    addRequirements(RobotContainer.chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //get x,y from network table

    //if angular difference large, turn towards ball
    //if small, turn while moving towards ball
    //if no difference, move forward

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //check to see if kill button pressed
      //return true
      
    //check if ball in front of intake 
      //call intake ball command
      //return true

    //else
    return false;
  }
}
