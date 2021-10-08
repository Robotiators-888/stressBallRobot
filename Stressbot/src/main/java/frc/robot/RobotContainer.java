
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.tankDriveCMD;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.ElevationUpCMD;
import frc.robot.commands.ElevationDownCMD;
import frc.robot.commands.FlywheelCMD;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  
  private final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  private final JoystickButton aButton = new JoystickButton(joystick, 6);
  private final JoystickButton upDpad = new JoystickButton(joystick, 0);
  private final JoystickButton DownDpad = new JoystickButton(joystick, 0);
  


  public RobotContainer() {
    configureButtonBindings();
    //This is creating a CMD that will be called and excuted as the robot is enabled we do this by making a defualt command
    // This gets the requirements and the cmd construtor from eariler  This gets the left stick so it controls the left motors   This gets the right stick that controls the right motors   this is the speed
    driveSubsystem.setDefaultCommand(new tankDriveCMD(driveSubsystem,  () -> joystick.getRawAxis(Constants.LEFT_AXIS),  () -> joystick.getRawAxis(Constants.RIGHT_AXIS), () -> Constants.speed));
 
  }


  private void configureButtonBindings() {
    aButton.toggleWhenPressed(new FlywheelCMD(shooterSubsystem, () ->  joystick.getRawButton(Constants.A_BUTTON)));
    upDpad.toggleWhenPressed(new ElevationUpCMD(shooterSubsystem));
    DownDpad.toggleWhenPressed(new ElevationDownCMD(shooterSubsystem));
  }


  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

