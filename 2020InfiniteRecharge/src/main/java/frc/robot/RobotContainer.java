/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.StartDriving;
import frc.robot.subsystems.Chassis;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static Chassis chassis;
  public static XboxController xbox;
  public static StartDriving startDriving;




  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    chassis = new Chassis();
    startDriving = new StartDriving();
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    xbox = new XboxController(0);
    
  }

  public static double getYLeft(){
    if(Math.abs(xbox.getY(Hand.kLeft)) <= 0.1){
      return 0;
    } else {
      return xbox.getY(Hand.kLeft)*Math.abs(xbox.getY(Hand.kLeft)); //Math.abs to preserve sign
    }
  }

  public static double getYRight(){
    if(Math.abs(xbox.getY(Hand.kRight)) <= 0.1){
      return 0;
    } else {
      return xbox.getY(Hand.kRight)*Math.abs(xbox.getY(Hand.kRight)); //Math.abs to preserve sign
    }
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return startDriving;
  }
    // An ExampleCommand will run in autonomous
    
  //}
}
