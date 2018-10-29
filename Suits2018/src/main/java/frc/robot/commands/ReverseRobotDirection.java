package frc.robot.commands;

import frc.robot.Robot;
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
