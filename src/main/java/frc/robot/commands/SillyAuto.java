package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;
import frc.robot.subsystems.PneumaticsSubsystem;


public class SillyAuto extends SequentialCommandGroup {
  /**
   * Creates a new SillyAutoCMD.
   * 
   * @return
   */
  public SillyAuto() {

    DriveSubsystem drive = RobotContainer.driveSubsystem;

    addCommands(new InstantCommand(() -> FlywheelSubsystem.setFlyWheelSpeed(0.6)),
        new InstantCommand(() -> DriveSubsystem.SetChildSafeOff()),
        new ParallelCommandGroup(new RunCommand(() -> drive.setMotors(1, -1), drive),
            new RunCommand(() -> FlywheelSubsystem.flywheelSpeed()),
            new RepeatCommand(new SequentialCommandGroup(
                new InstantCommand(() -> PneumaticsSubsystem.pistonGo()), new WaitCommand(.1),
                new InstantCommand(() -> PneumaticsSubsystem.PistonReverse()),
                new WaitCommand(.3)))));
  }
}
