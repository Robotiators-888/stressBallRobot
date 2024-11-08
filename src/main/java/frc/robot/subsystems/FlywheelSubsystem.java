package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FlywheelSubsystem extends SubsystemBase {
   static Spark FlywheelLeft = new Spark(Constants.FLYWHEEL_LEFT);
   static Spark FlywheelRight = new Spark(Constants.FLYWHEEL_RIGHT);
   public static double FlywheelSpeed = .5;
   public static boolean ChildSafe = true;


   public void periodic() {
      SmartDashboard.putNumber("Flywheel Speed", FlywheelSpeed);
      SmartDashboard.putBoolean("ChildSafe", ChildSafe);
   }

   public static void decreaseRpm() {
      if (FlywheelSpeed >= .3) {
         FlywheelSpeed = FlywheelSpeed - .1;
      }
   }

   public static void increaseRpm() {
      if (ChildSafe) {
         if (FlywheelSpeed < .6) {
            FlywheelSpeed = FlywheelSpeed + .1;
         }
      } else {
         if (FlywheelSpeed < .9) {
            FlywheelSpeed = FlywheelSpeed + .1;
         }
      }
   }

   public static void ToggleChildSafe() {
      ChildSafe = !ChildSafe;
      if (ChildSafe && FlywheelSpeed > .6) {
         FlywheelSpeed = .6;
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


}
