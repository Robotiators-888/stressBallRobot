package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;

public class PistonCMD extends CommandBase{
    
  // Constructor of the cmd that creates the ability to fire a piston
    private final PneumaticsSubsystem pneumaticsSubsystem;
    
    public PistonCMD(PneumaticsSubsystem pneumaticsSubsystem){
      this.pneumaticsSubsystem = pneumaticsSubsystem;

      addRequirements(pneumaticsSubsystem);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    pneumaticsSubsystem.pistonGo();
    pneumaticsSubsystem.PistonReverse();
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   pneumaticsSubsystem.PistonToggle();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
