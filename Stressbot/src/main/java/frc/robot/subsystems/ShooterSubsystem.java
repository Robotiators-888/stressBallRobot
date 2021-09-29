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

   public void flywheelSpeed(double flywheelSpeed) {
      FlywheelRight.setSpeed(1.0);
      FlywheelLeft.setSpeed(1.0);

   }

   //
   public void elevation(double elevationSpeed){
    elevationSpeed = Constants.FLYWHEEL_SPEED;
      elevation.setSpeed(elevationSpeed);
   }
}
 