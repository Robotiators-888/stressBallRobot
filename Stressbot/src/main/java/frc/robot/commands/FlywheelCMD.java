package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;


public class FlywheelCMD extends CommandBase {
    
   private final ShooterSubsystem shooterSubsystem;
   private  Supplier<Boolean> Flywheel;
   private  Supplier<Double> flywheelSpeed;
   
   
   public FlywheelCMD(ShooterSubsystem shooterSubsystem, Supplier<Boolean> Flywheel){
   this.shooterSubsystem = shooterSubsystem;
    this.Flywheel = Flywheel;
   
    addRequirements(shooterSubsystem);
   }
   
  






// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

      shooterSubsystem.flywheelSpeed();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
     shooterSubsystem.flywheelSpeed();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
