package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Drive extends CommandBase {
    public Drive(){
        addRequirements(Robot.tankdrive);
    }





    @Override
    public void initialize() {}
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double leftStickY = Robot.m_oi.GetDriverRawAxis(Constants.LEFT_STICK_Y);
        double rightStickY = Robot.m_oi.GetDriverRawAxis(Constants.RIGHT_STICK_Y);

        Robot.tankdrive.setLeftMotors(leftStickY);
        Robot.tankdrive.setRightMotors(rightStickY);
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        Robot.tankdrive.setRightMotors(0);
        Robot.tankdrive.setLeftMotors(0);
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
}