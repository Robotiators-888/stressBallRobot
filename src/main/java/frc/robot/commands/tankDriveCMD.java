//888 robotiators 2021

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class tankDriveCMD extends CommandBase {

  public tankDriveCMD(DriveSubsystem subsystem) {
    

    addRequirements(subsystem);
  }

 
  public void initialize() {}

  
  public void execute() {
    
  }


  public void end(boolean interrupted) {}


  public boolean isFinished() {
    return false;
  }
}
