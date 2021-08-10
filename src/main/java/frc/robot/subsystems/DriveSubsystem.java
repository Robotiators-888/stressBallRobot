package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  //create motor controller objects
  private WPI_VictorSPX leftPrimary = new WPI_VictorSPX(0);
  private WPI_VictorSPX leftSecondary = new WPI_VictorSPX(0);
  private WPI_VictorSPX rightPrimary = new WPI_VictorSPX(0);
  private WPI_VictorSPX rightSecondary = new WPI_VictorSPX(0);

  //create a speed controller group for each side
  private SpeedControllerGroup groupLeft = new SpeedControllerGroup(leftPrimary, leftSecondary);
  private SpeedControllerGroup groupRight = new SpeedControllerGroup(rightPrimary, rightSecondary);

  //create a drive train group with the speed controller groups
  private DifferentialDrive driveTrain = new DifferentialDrive(groupLeft, groupRight);

  public DriveSubsystem() {
    //set one motor on each side inverted so we dont destroy the gearbox
    leftSecondary.setInverted(true);
    rightSecondary.setInverted(true);
  }

  public void periodic() {
    //SmartDashboard.putNumber("",);
  }

  /**
  * Sets speed of the motors in the drivetrain
  * @param leftSpeed Speed of the left drivetrain
  * @param rightSpeed Speed of right drivetrain
  * @param Speed set a precentage of max speed the robot can use
  */
  public void setMotors(double leftSpeed, double rightSpeed, double Speed) {
    driveTrain.tankDrive(leftSpeed * Speed, rightSpeed * Speed);
  }
}
