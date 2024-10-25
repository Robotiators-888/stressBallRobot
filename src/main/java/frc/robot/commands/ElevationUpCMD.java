package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PivotSubsystem;




public class ElevationUpCMD extends Command{
    private final PivotSubsystem PivotSubsystem;
    private final Supplier<Integer> ElevationUp;

    // Constructor of the cmd that creates the ability to move elevation up
    public ElevationUpCMD(PivotSubsystem PivotSubsystem, Supplier<Integer> Elevation){
        this.PivotSubsystem = PivotSubsystem;
        this.ElevationUp = Elevation;
        addRequirements(PivotSubsystem);
    }


// Called when the command is initially scheduled.
@Override
public void initialize() {}

// Called every time the scheduler runs while the command is scheduled.
@Override
public void execute() {
  PivotSubsystem.elevationUp();

}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {
   PivotSubsystem.elevationEnd();
}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}
}

