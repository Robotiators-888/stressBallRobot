package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.XboxController;



public class DriveTrain extends SubsystemBase {
    private VictorSPX motorLeft1 = new VictorSPX(Constants.LEFT_MOTOR_1_ID);
    private VictorSPX motorLeft2 = new VictorSPX(Constants.LEFT_MOTOR_2_ID);
    SpeedControllerGroup m_left;

    private VictorSPX motorRight1 = new VictorSPX(Constants.RIGHT_MOTOR_1_ID);
    private VictorSPX motorRight2 = new VictorSPX(Constants.RIGHT_MOTOR_2_ID);

    SpeedControllerGroup m_right;

    DifferentialDrive m_drive = new DifferentialDrive(m_left, m_right);

    public void setLeftMotors(double speed){
    
        motorLeft1.set(ControlMode.PercentOutput, -speed);
        motorLeft2.set(ControlMode.PercentOutput, -speed);
          }
        
          public void setRightMotors(double speed){
        motorRight1.set(ControlMode.PercentOutput, speed);
        motorRight2.set(ControlMode.PercentOutput, speed);  
        }


    public void XboxController(int port){
        

    }





}