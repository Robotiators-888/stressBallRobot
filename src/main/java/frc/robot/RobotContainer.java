
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.PivotSubsystem;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final PivotSubsystem pivotSubsystem = new PivotSubsystem();
  private final FlywheelSubsystem flywheelSubsystem = new FlywheelSubsystem();

  // Creates joystick and joystick objects
  public final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  public final JoystickButton aButton = new JoystickButton(joystick, 1);
  public final JoystickButton bButton = new JoystickButton(joystick, 2);
  public final JoystickButton xButton = new JoystickButton(joystick, 3);
  public final JoystickButton yButton = new JoystickButton(joystick, 4);
  public final JoystickButton lBumper = new JoystickButton(joystick, 5);
  public final JoystickButton rBumper = new JoystickButton(joystick, 6);
  


  Trigger rightTrigger = new Trigger(() -> (joystick.getRawAxis(3) > 0.5));

  public RobotContainer() {
    configureButtonBindings();

    // Make the drive system to default to driving based on joystick inputs.
    driveSubsystem
        .setDefaultCommand(
            new RunCommand(
                () -> driveSubsystem.setMotors(joystick.getRawAxis(Constants.RIGHT_AXIS),
                    joystick.getRawAxis(Constants.LEFT_AXIS), Constants.DRIVE_SPEED),
                driveSubsystem));
                
    // Make the pivot subsystem default to stopped.
    pivotSubsystem
        .setDefaultCommand(new RunCommand(() -> pivotSubsystem.elevationEnd(), pivotSubsystem));
  }

  private void configureButtonBindings() {

    // While right trigger is pressed run the flywheels.
    rightTrigger.onTrue(new InstantCommand(() -> FlywheelSubsystem.flywheelSpeed()))
        .onFalse(new InstantCommand(() -> FlywheelSubsystem.flywheelEnd()));

    // Left bumper runs the elevation down command while held.
    lBumper.whileTrue(new RunCommand(() -> pivotSubsystem.elevationDown(), pivotSubsystem));

    // Right bumper runs the elevation up command while held.
    rBumper.whileTrue(new RunCommand(() -> pivotSubsystem.elevationUp(), pivotSubsystem));

    // On B button press extend the piston, wait .1 seconds, then retract the piston.
    bButton
        .onTrue(new SequentialCommandGroup(new InstantCommand(() -> PneumaticsSubsystem.pistonGo()),
            new WaitCommand(.1), new InstantCommand(() -> PneumaticsSubsystem.PistonReverse())));

    // Create a toggle for the Y button to start and stop the flywheels.
    yButton.toggleOnTrue(Commands.startEnd(() -> FlywheelSubsystem.flywheelSpeed(),
        () -> FlywheelSubsystem.flywheelEnd(), flywheelSubsystem));

    // Decrease the RPM Setpoint for the flywheels if it is not out of range.
    aButton.onTrue(
        new SequentialCommandGroup(new InstantCommand(() -> FlywheelSubsystem.decreaseRpm()),
            new InstantCommand(() -> FlywheelSubsystem.updateSpeed())));
        
    // Increase the RPM Setpoint for the flywheels if it is not out of range.
    xButton.onTrue(
        new SequentialCommandGroup(new InstantCommand(() -> FlywheelSubsystem.increaseRpm()),
            new InstantCommand(() -> FlywheelSubsystem.updateSpeed())));
  }


  public Command getAutonomousCommand() {
    return null;
  }
}
