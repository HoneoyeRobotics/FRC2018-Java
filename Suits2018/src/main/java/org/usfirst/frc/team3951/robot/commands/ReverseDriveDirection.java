package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReverseDriveDirection extends  CommandGroup {
	
	public ReverseDriveDirection() {
		addSequential(new ReverseDriveDirection());
		addSequential(new SwitchCamera());
	}	

}
