package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ArmsToSpit extends  Command {

	public ArmsToSpit() {
		this(5);
	}
	public ArmsToSpit(double timeout) {
		super("Arms To Spit");
		requires(Robot.arms);
		setInterruptible(true);
		//if no timeout set, set to 1.
		if(timeout <= 0)
			timeout = 1;
		setTimeout(timeout);
	}
	
	//run in full reverse
	@Override 
	protected void execute() {		
		Robot.arms.MoveArmsTowardsPosition(25);
	}
	
	//run down
	@Override
	protected boolean isFinished() {
		return isTimedOut() || Robot.arms.ArmsAtSpit();
	}
	
	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.arms.StopArms();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.arms.StopArms();
	}

}
