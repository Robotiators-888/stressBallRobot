package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;




public class ElevationUpCMD extends CommandBase{
    private final ShooterSubsystem shooterSubsystem;
    private final Supplier<Integer> ElevationUp;

    public ElevationUpCMD(ShooterSubsystem shooterSubsystem, Supplier<Integer> Elevation){
        this.shooterSubsystem = shooterSubsystem;
        this.ElevationUp = Elevation;
        addRequirements(shooterSubsystem);
    }


// Called when the command is initially scheduled.
@Override
public void initialize() {}

// Called every time the scheduler runs while the command is scheduled.
@Override
public void execute() {
  shooterSubsystem.elevationUp();

}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {
   shooterSubsystem.elevationEnd();
}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}
}

