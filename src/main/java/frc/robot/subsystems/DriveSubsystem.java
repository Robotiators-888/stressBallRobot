
package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  // create motor controller objects
  private VictorSP leftPrimary = new VictorSP(Constants.ID_LEFT_PRIMARY);
  private VictorSP leftSecondary = new VictorSP(Constants.ID_LEFT_SECONDARY);
  private VictorSP rightPrimary = new VictorSP(Constants.ID_RIGHT_PRIMARY);
  private VictorSP rightSecondary = new VictorSP(Constants.ID_RIGHT_SECONDARY);

  // create a speed controller group for each side
  private MotorControllerGroup groupLeft = new MotorControllerGroup(leftPrimary, leftSecondary);
  private MotorControllerGroup groupRight = new MotorControllerGroup(rightPrimary, rightSecondary);

  // create a drive train group with the speed controller groups
  private DifferentialDrive driveTrain = new DifferentialDrive(groupLeft, groupRight);

  public DriveSubsystem() {
    // set one motor on each side inverted so we dont destroy the gearbox
    groupRight.setInverted(true);
    groupLeft.setInverted(true);
    // leftSecondary.setInverted(true);
    // rightSecondary.setInverted(true);
  }

  public void periodic() {

  }

  /**
   * Sets speed of the motors in the drivetrain
   * 
   * @param leftSpeed  Speed of the left drivetrain
   * @param rightSpeed Speed of right drivetrain
   * @param Speed      set a precentage of max speed the robot can use
   */
  public void setMotors(double leftSpeed, double rightSpeed, double Speed) {
    driveTrain.arcadeDrive(leftSpeed * 0.6, rightSpeed * -0.6);
  }
}
