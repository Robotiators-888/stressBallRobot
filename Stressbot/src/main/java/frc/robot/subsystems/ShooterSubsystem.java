package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class ShooterSubsystem extends SubsystemBase {
   Spark FlywheelLeft = new Spark(Constants.FLYWHEEL_LEFT);
   Spark FlywheelRight = new Spark(Constants.FLYWHEEL_RIGHT);
   Spark elevation = new Spark(Constants.ELEVATION);
   double flywheelSpeed = Constants.FLYWHEEL_SPEED;
   double elevationSpeed = Constants.ELEVATION_SPEED;

   SpeedControllerGroup FlywheelGroup = new SpeedControllerGroup(FlywheelLeft, FlywheelRight);

   public void periodic() {

   }

   //

   public void flywheelSpeed() {
      FlywheelRight.setSpeed(Constants.FLYWHEEL_SPEED);
      FlywheelLeft.setSpeed(Constants.FLYWHEEL_SPEED*-1);

   }


   public void flywheelEnd(){
      FlywheelLeft.setSpeed(0.0);
      FlywheelRight.setSpeed(0.0);
   }
  
   //
   public void elevationUp(){
    elevationSpeed = Constants.FLYWHEEL_SPEED;
      elevation.setSpeed(elevationSpeed);
   }
   public void elevationDown(){
      elevationSpeed = Constants.FLYWHEEL_SPEED * -1;
        elevation.setSpeed(elevationSpeed);
     }



     public void elevationEnd(){
        elevationSpeed = 0;
        elevation.setSpeed(0.0);
     }


   }
 