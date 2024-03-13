// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootCMD extends SequentialCommandGroup {

      ShooterSubsystem shoot = RobotContainer.shooterSubsystem;
      PneumaticsSubsystem pSubsystem = RobotContainer.pneumaticsSubsystem;

  /** Creates a new ShootCMD. */
  public ShootCMD() {

    addCommands(    
    new RunCommand(()-> shoot.flywheelSpeed()).withTimeout(0.5),
    new PistonCMD(pSubsystem),
    new WaitCommand(0.25),
    new PistonCMD(pSubsystem),
    new InstantCommand(()-> shoot.flywheelEnd()));
  }
}
