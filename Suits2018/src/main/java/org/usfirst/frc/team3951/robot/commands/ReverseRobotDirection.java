package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ReverseRobotDirection extends  Command {
	
	public ReverseRobotDirection() {
		super("Arcade Drive With Joystick");
		requires(Robot.drivetrain);
		Robot.drivetrain.reverseDrivingDirection();
	}
	
	@Override 
	protected void execute() {
				
	}
	
	@Override
	protected boolean isFinished() {	
		return true;
	}

}
