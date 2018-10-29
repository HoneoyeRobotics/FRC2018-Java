package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class SwitchCamera extends  Command {

	public SwitchCamera(){	
		super("Switch Camera");
		requires(Robot.camera);
		setInterruptible(true);
		
		Robot.camera.SwitchCamera();
		
	}
		
	
	@Override 
	protected void execute() {
	}
		
	@Override
	protected boolean isFinished() {
		return true;
	}


	
		
}
