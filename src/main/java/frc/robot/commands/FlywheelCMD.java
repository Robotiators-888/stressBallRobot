package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.Supplier;

// Constructor of the cmd that creates the ability to spin the flywheels
public class FlywheelCMD extends CommandBase {
    
   private final ShooterSubsystem shooterSubsystem;
   private  Supplier<Double> Flywheel;
   private  Supplier<Double> flywheelSpeed;
   
   public final Joystick joystick = new Joystick(Constants.JOYSTICK_PORT);
   public FlywheelCMD(ShooterSubsystem shooterSubsystem, Supplier<Double> Flywheel){
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
    if(joystick.getRawAxis(Constants.RIGHT_TRIGGER) >= .5){
      shooterSubsystem.flywheelSpeed();
      if(joystick.getRawAxis(Constants.RIGHT_TRIGGER) <= .25){
        shooterSubsystem.flywheelEnd();
      }
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.flywheelEnd();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
