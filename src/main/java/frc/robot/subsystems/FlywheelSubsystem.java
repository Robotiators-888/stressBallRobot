package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FlywheelSubsystem extends SubsystemBase {
   static Spark FlywheelLeft = new Spark(Constants.FLYWHEEL_LEFT);
   static Spark FlywheelRight = new Spark(Constants.FLYWHEEL_RIGHT);
   public static double FlywheelSpeed = Constants.INITIAL_SPEED;
   public static boolean ChildSafe = true;


   public void periodic() {
      SmartDashboard.putNumber("Flywheel Speed", FlywheelSpeed);
      SmartDashboard.putBoolean("ChildSafe", ChildSafe);
   }

   public static void decreaseSpeed() {
      if (FlywheelSpeed >= .3) {
         FlywheelSpeed = FlywheelSpeed - Constants.SPEED_STEP;
      }
   }

   public static void increaseSpeed() {
      if (ChildSafe) {
         if (FlywheelSpeed < Constants.MAX_CHILD_SAFE_FLYWHEEL_SPEED) {
            FlywheelSpeed = FlywheelSpeed + Constants.SPEED_STEP;
         }
      } else {
         if (FlywheelSpeed < Constants.MAX_SPEED) {
            FlywheelSpeed = FlywheelSpeed + Constants.SPEED_STEP;
         }
      }
   }

   public static void ToggleChildSafe() {
      ChildSafe = !ChildSafe;
      if (ChildSafe && FlywheelSpeed > Constants.MAX_CHILD_SAFE_FLYWHEEL_SPEED) {
         FlywheelSpeed = Constants.MAX_CHILD_SAFE_FLYWHEEL_SPEED;
         updateSpeed();
      }
   }

   public static void updateSpeed() {
      if (FlywheelLeft.get() > 0) {
         FlywheelRight.set(-FlywheelSpeed);
         FlywheelLeft.set(FlywheelSpeed);
      }
   }

   public static void flywheelSpeed() {
      FlywheelRight.set(-FlywheelSpeed);
      FlywheelLeft.set(FlywheelSpeed);
   }

   public static void flywheelEnd() {
      FlywheelLeft.set(0.0);
      FlywheelRight.set(0.0);
   }

   public static void setFlyWheelSpeed(Double speed){
      FlywheelSpeed = speed;
   }


}
