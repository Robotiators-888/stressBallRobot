package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class PneumaticsSubsystem extends SubsystemBase {

    //Solenoid constructor 1st num is pcm port, second is solenoid channel
     DoubleSolenoid piston = new DoubleSolenoid(0,1);

    Compressor c = new Compressor(0);


    public void pistonInt(){
        piston.set(Value.kForward);
        piston.set(Value.kReverse);
    }

    public void pistonGo(){
        piston.toggle();
    
    }




    public void periodic() {

    }




}
