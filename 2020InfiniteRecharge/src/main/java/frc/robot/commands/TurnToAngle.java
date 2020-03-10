/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class TurnToAngle extends PIDCommand {
  /**
   * Creates a new TurnToAngle.
   */
  public TurnToAngle(double targetAngle) {

    super(
        // The controller that the command will use
        new PIDController(Constants.kpGyro, Constants.kiGyro, Constants.kdGyro),
        // This should return the measurement
        RobotContainer.chassis::getGyro,
        // This should return the setpoint (can also be a constant)
        targetAngle,
        // This uses the output
        output -> {
          RobotContainer.chassis.tankDrive(output/120, -1*output/120);
          //DriverStation.reportError(Double.toString(RobotContainer.chassis.getGyro()), false);
        },
        RobotContainer.chassis);
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
      getController().enableContinuousInput(-180,180);
      getController().setTolerance(5);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (getController().atSetpoint()){
      DriverStation.reportError("At Setpoint", false);
    }
    return getController().atSetpoint();
  }
}
