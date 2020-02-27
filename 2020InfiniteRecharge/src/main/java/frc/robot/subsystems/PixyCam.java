/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2.LinkType;

public class PixyCam extends SubsystemBase {

  Pixy2 pixyCam = Pixy2.createInstance(LinkType.SPI);
  /**
   * Creates a new PixyCam.
   */
  public PixyCam() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
