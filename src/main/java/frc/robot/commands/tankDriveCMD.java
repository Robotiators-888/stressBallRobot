//888 robotiators 2021

package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;
import java.util.function.Supplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class tankDriveCMD extends CommandBase {

  private final DriveSubsystem driveSubsystem;
  private Supplier<Double> speedLeft, speedRight, speed;
 
  public tankDriveCMD(DriveSubsystem driveSubsystem, Supplier<Double> speedLeft, Supplier<Double> speedRight, Supplier<Double> speed) {
    this.driveSubsystem = driveSubsystem;
    this.speedLeft = speedLeft;
    this.speedRight = speedRight;
    this.speed = speed;

    addRequirements(driveSubsystem);
  }
 
  public void initialize() {}

  public void execute() {
    driveSubsystem.setMotors(speedLeft.get(), speedRight.get(), speed.get());
    
    SmartDashboard.putNumber("Left side speed",speedLeft.get());
    SmartDashboard.putNumber("Right side speed",speedRight.get());
    SmartDashboard.putNumber("speed",speed.get());
  }

  public void end(boolean interrupted) {}

  public boolean isFinished() {
    return false;
  }
}
