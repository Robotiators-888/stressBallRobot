
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.VideoMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.tankDriveCMD;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.ElevationDownCMD;
import frc.robot.commands.ElevationUpCMD;
import frc.robot.commands.FlywheelCMD;
import frc.robot.commands.PistonCMD;
import frc.robot.commands.ShootCMD;
import frc.robot.commands.SillyAutoCMD;

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
   public final static DriveSubsystem driveSubsystem = new DriveSubsystem();
   public final static ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
   public final static PneumaticsSubsystem pneumaticsSubsystem = new PneumaticsSubsystem();

  // Creates joystick and joystick objects
  public final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
  public final JoystickButton aButton = new JoystickButton(joystick, 1);
  public final JoystickButton bButton = new JoystickButton(joystick, 2);
  //public final JoystickButton yButton = new
  public final JoystickButton rBumper = new JoystickButton(joystick, 6);
  public final JoystickButton lBumper = new JoystickButton(joystick, 5);

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
    driveSubsystem.setDefaultCommand(new tankDriveCMD(driveSubsystem, () -> Constants.speed*joystick.getRawAxis(Constants.RIGHT_AXIS),
        () -> Constants.speed*joystick.getRawAxis(Constants.LEFT_AXIS), () -> Constants.speed));
    // shooterSubsystem.setDefaultCommand(new FlywheelCMD(shooterSubsystem, () ->
    // joystick.getRawAxis((Constants.RIGHT_TRIGGER))-0.5));
  }

  private void configureButtonBindings() {

    // Creates the A button to spin flywheels
    // aButton.whileHeld(new FlywheelCMD(shooterSubsystem, () ->
    // joystick.getRawButton(Constants.A_BUTTON)));

    rightTrigger.whileTrue(new FlywheelCMD(shooterSubsystem));
    aButton.onTrue(new ShootCMD());

    // Creates the Left bumper to lift elevation up
    lBumper.whileTrue((new ElevationUpCMD(shooterSubsystem, () -> joystick.getPOV(Constants.DAPD_UP))));

    // Creates the Right bumper to lower elevation down
    rBumper.whileTrue(new ElevationDownCMD(shooterSubsystem, () -> joystick.getPOV(Constants.DAPD_DOWN)));

    // Creates B button to fire the piston when pressed
    //bButton.toggleOnTrue();
    bButton.onTrue(new PistonCMD(pneumaticsSubsystem)).onFalse(new PistonCMD(pneumaticsSubsystem));

   // yButton.onTrue(getAutonomousCommand());
  }


  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new SillyAutoCMD();
  }

  public static Command shoot(){
    return new SequentialCommandGroup(
     
    );
  }
}
