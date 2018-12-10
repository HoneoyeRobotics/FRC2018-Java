
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;

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
		Robot.climber.RunWinch(OI.coPilotJoystick.getRawAxis(OI.climbWinchAxis));
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
