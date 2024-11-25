package frc.robot.utils;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.SillyAuto;

public class AutoSelector {
    private SendableChooser<Command> chooser = new SendableChooser<Command>();
    public AutoSelector(){
        chooser.setDefaultOption("SillyAuto", null);
        chooser.setDefaultOption("SillyAuto", new SillyAuto());
        SmartDashboard.putData("Auto Selector", chooser);
    }
    public Command getSelected() {
        return chooser.getSelected();
    }
    }
