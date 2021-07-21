package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class OI {
   private XboxController driverController = new XboxController(Constants.DriverController);

    public double GetDriverRawAxis(int axis){
       return driverController.getRawAxis(axis);
    }
    
}
