package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class FlywheelSubsystem extends SubsystemBase {
   static Spark FlywheelLeft = new Spark(Constants.FLYWHEEL_LEFT);
   static Spark FlywheelRight = new Spark(Constants.FLYWHEEL_RIGHT);
   MotorControllerGroup FlywheelGroup = new MotorControllerGroup(FlywheelLeft, FlywheelRight);
   public static double FlywheelSpeed = .5;
   public void periodic() {

   }

   //

   public static void decreaseRpm() {
      if (FlywheelSpeed >= .3) {
         FlywheelSpeed = FlywheelSpeed -.1;
      }
   }
   public static void increaseRpm() {
      if (FlywheelSpeed < .7) {
         FlywheelSpeed = FlywheelSpeed +.1;
      }
   }

   public static void updateSpeed(){
      if(FlywheelLeft.get() > 0){
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
