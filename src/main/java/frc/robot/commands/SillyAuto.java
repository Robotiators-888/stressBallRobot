package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;


public class SillyAuto extends SequentialCommandGroup {
  /** Creates a new SillyAutoCMD. 
   * @return */
  public void SillyAutoCMD() {

    DriveSubsystem drive = RobotContainer.driveSubsystem;
    addCommands(
      new RunCommand(()->drive.setMotors(1,-1,.5), drive).withTimeout(5)
    );
  }
}