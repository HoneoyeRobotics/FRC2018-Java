package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ReleaseClimbHook extends  Command {

	public ReleaseClimbHook() {
		super("Release Climb Hook");
		requires(Robot.climber);
		//set timeout to 1 second (long enough for the latch to release)		
		setTimeout(1);
		setInterruptible(false);
	}
	
	//run in full reverse
	@Override 
	protected void execute() {	
		Robot.climber.OpenReleaseHook();
	}
	
	//run until the arm spit button is release
	@Override
	protected boolean isFinished() {
		//chew until they release the button.
		return isTimedOut();
	}
	
	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.climber.CloseReleaseHook();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.climber.CloseReleaseHook();
	}

}
