package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import java.util.function.Supplier;



public class ElevationCMD extends CommandBase{
    private final ShooterSubsystem shooterSubsystem;
    private Supplier<Boolean> elevationH;
    private Supplier<Double> elevationSpeed;

    public ElevationCMD(ShooterSubsystem shooterSubsystem, Supplier<Boolean> elevationH){
        this.shooterSubsystem = shooterSubsystem;
        this.elevationH = elevationH;
   
        addRequirements(shooterSubsystem);
    }


// Called when the command is initially scheduled.
@Override
public void initialize() {}

// Called every time the scheduler runs while the command is scheduled.
@Override
public void execute() {
    shooterSubsystem.elevation(elevationSpeed.get());
}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {
   
}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}
}

