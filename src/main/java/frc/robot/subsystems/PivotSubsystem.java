package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class PivotSubsystem extends SubsystemBase {
   Spark elevation = new Spark(Constants.ELEVATION);
   double elevationSpeed = Constants.ELEVATION_SPEED;

   public void periodic() {

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
