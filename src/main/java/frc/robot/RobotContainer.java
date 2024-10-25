
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.commands.ElevationDownCMD;
import frc.robot.commands.ElevationUpCMD;
import frc.robot.commands.PistonCMD;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PivotSubsystem PivotSubsystem = new PivotSubsystem();
  private final PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();
  private final FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();

  // Creates joystick and joystick objects
  public final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  public final JoystickButton aButton = new JoystickButton(joystick, 1);
  public final JoystickButton bButton = new JoystickButton(joystick, 2);
  public final JoystickButton rBumper = new JoystickButton(joystick, 6);
  public final JoystickButton lBumper = new JoystickButton(joystick, 5);
  public final JoystickButton yButton = new JoystickButton(joystick, 4);

  Trigger rightTrigger = new Trigger(() -> (joystick.getRawAxis(3) > 0.5));

  public RobotContainer() {
    configureButtonBindings();
    // CameraServer.startAutomaticCapture()
    // .setVideoMode(new VideoMode(VideoMode.pixelFormat.kMJPEG, 416, 240, 60));
    // // // This is creating a CMD that will be called and excuted as the robot is
    // enabled we do this by making a defualt command
    // This gets the requirements and the cmd construtor from eariler This gets the
    // left stick so it controls the left motors This gets the right stick that
    // controls the right motors this is the speed
    driveSubsystem.setDefaultCommand(new RunCommand(
        () -> driveSubsystem.setMotors(joystick.getRawAxis(Constants.RIGHT_AXIS),
            joystick.getRawAxis(Constants.LEFT_AXIS), Constants.DRIVE_SPEED),
        driveSubsystem));

    // flywheelSubsystem.setDefaultCommand(new RunCommand(
    // ()->flywheelSubsystem.flywheelEnd()));
    // PivotSubsystem.setDefaultCommand(new FlywheelCMD(PivotSubsystem, () ->
    // joystick.getRawAxis((Constants.RIGHT_TRIGGER))-0.5));
  }

  private void configureButtonBindings() {

    // Creates the A button to spin flywheels
    // aButton.whileHeld(new FlywheelCMD(PivotSubsystem, () ->
    // joystick.getRawButton(Constants.A_BUTTON)));

    rightTrigger.onTrue(new InstantCommand(() -> FlywheelSubsystem.flywheelSpeed()))
        .onFalse(new InstantCommand(() -> FlywheelSubsystem.flywheelEnd()));

    // Creates the Left bumper to lift elevation up
    lBumper.whileTrue((new ElevationUpCMD(PivotSubsystem, () -> joystick.getPOV(Constants.DAPD_UP))));

    // Creates the Right bumper to lower elevation down
    rBumper.whileTrue(new ElevationDownCMD(PivotSubsystem, () -> joystick.getPOV(Constants.DAPD_DOWN)));

    // Creates B button to fire the piston when pressed
    bButton.onTrue(new PistonCMD(pneumaticsSubsystem));

    yButton.toggleOnTrue(Commands.startEnd(() -> FlywheelSubsystem.flywheelSpeed(),
        () -> FlywheelSubsystem.flywheelEnd(), flywheelSubsystem));

  }

  public Command getAutonomousCommand() {

    return null;
  }
}
