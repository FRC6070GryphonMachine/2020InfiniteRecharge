/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import javax.print.attribute.standard.JobHoldUntil;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.StartDriving;
import frc.robot.commands.AutoTurn;
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
  public static Joystick stick;

  public static StartDriving startDriving;




  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    //subsystems
    chassis = new Chassis();
    

    // Configure the button bindings
    configureButtonBindings();

    //commands
    chassis.setDefaultCommand(new StartDriving());
  
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    xbox = new XboxController(0);
    stick = new Joystick(1);
  }

  public static double getYLeft(){
    double kleft = xbox.getY(Hand.kLeft);
    if(Math.abs(kleft) <= 0.1){
      return 0;
    } else {
      return kleft; //Math.abs to preserve sign
    }
  }

  public static double getYRight(){
    double kright = xbox.getY(Hand.kRight);
    if(Math.abs(kright) <= 0.1){
      return 0;
    } else {
      return kright; //Math.abs to preserve sign
    }
  }

  public static double getRightTrigger(){
    return xbox.getTriggerAxis(Hand.kRight);
  }
  public static double getLeftTrigger(){
    return xbox.getTriggerAxis(Hand.kLeft);
  }

  public static double getStickY(){  //used for ball shooter
    if(Math.abs(stick.getY()) <= 0.1){
      return 0;
    } else {
      return stick.getY();
    }
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return new AutoTurn(90);
  }
    // An ExampleCommand will run in autonomous
    
  //}
}
