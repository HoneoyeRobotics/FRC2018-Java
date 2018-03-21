package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class RaiseWinch extends  Command {

	public RaiseWinch() {
		super("Raise Winch");
		requires(Robot.climber);
		setInterruptible(true);
		//set timeout to 1 second (long enough for the latch to release)		
		
		
	}
	
	//run in full reverse
	@Override 
	protected void execute() {	
		Robot.climber.RunWinch(Robot.oi.getCoPilotJoystick().getRawAxis(Robot.oi.CLIMB_WINCH_AXIS));
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
		Robot.climber.StopWinch();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.climber.StopWinch();
	}

}
