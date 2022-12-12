package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class PistonCMD extends CommandBase{
    
  // Constructor of the cmd that creates the ability to fire a piston
    private final PneumaticsSubsystem pneumaticsSubsystem;
    private final ShooterSubsystem shooterSubsystem;
    
    public PistonCMD(PneumaticsSubsystem pneumaticsSubsystem, ShooterSubsystem shooterSubsystem){
      this.pneumaticsSubsystem = pneumaticsSubsystem;
      this.shooterSubsystem = shooterSubsystem;

      addRequirements(pneumaticsSubsystem);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (shooterSubsystem.getFlyWheelIsOn()){
      //pneumaticsSubsystem.pistonGo();
      pneumaticsSubsystem.PistonReverse();
    }
    SmartDashboard.putBoolean("flywheel running?: ",shooterSubsystem.getFlyWheelIsOn());
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //pneumaticsSubsystem.PistonReverse();
    pneumaticsSubsystem.pistonGo();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return !(shooterSubsystem.getFlyWheelIsOn());
  }
}
