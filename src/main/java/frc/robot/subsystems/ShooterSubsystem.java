package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterSubsystem extends SubsystemBase {
   Spark FlywheelLeft = new Spark(Constants.FLYWHEEL_LEFT);
   Spark FlywheelRight = new Spark(Constants.FLYWHEEL_RIGHT);
   Spark elevation = new Spark(Constants.ELEVATION);
   double flywheelSpeed = Constants.FLYWHEEL_SPEED;
   double elevationSpeed = Constants.ELEVATION_SPEED;

   //toggles from trigger, FlywheelCMD checks if true to run the flyWheels
   public boolean flywheelToggle; 

   MotorControllerGroup FlywheelGroup = new MotorControllerGroup(FlywheelLeft, FlywheelRight);

   public void periodic() {

   }

   // returns true when the flywheel is running
   public boolean getFlyWheelIsOn(){
      return (Math.abs(this.FlywheelLeft.get())>0.1);
   }

   public void toggleFlywheel(){
      this.flywheelToggle = !flywheelToggle;
   }

   public void flywheelSpeed() {
      FlywheelRight.set(Constants.FLYWHEEL_SPEED * -1);
      FlywheelLeft.set(Constants.FLYWHEEL_SPEED);
      SmartDashboard.putNumber("FLywheel Speed: ", FlywheelLeft.get()); 

   }

   public void flywheelEnd() {
      FlywheelLeft.set(0.0);
      FlywheelRight.set(0.0);
      SmartDashboard.putNumber("FLywheel Speed: ", FlywheelLeft.get()); 
   }

   //
   public void elevationUp() {
      elevationSpeed = Constants.FLYWHEEL_SPEED;
      elevation.set(elevationSpeed);
   }

   public void elevationDown() {
      elevationSpeed = Constants.FLYWHEEL_SPEED * -1;
      elevation.set(elevationSpeed);
   }

   public void elevationEnd() {
      elevationSpeed = 0;
      elevation.set(0.0);
   }

}
