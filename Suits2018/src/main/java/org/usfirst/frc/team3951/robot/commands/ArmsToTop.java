package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ArmsToTop extends  Command {

	public ArmsToTop() {
		this(3);
	}
	public ArmsToTop(double timeout) {
		super("Arms To Top");
		requires(Robot.arms);
		setInterruptible(true);
		//if no timeout set, set to 1.
		if(timeout <= 0)
			timeout = 3;
		setTimeout(timeout);
	}
	
	//run in full reverse
	@Override 
	protected void execute() {	
		Robot.arms.MoveArms(1);
	}
	
	//run until the arm spit button is release
	@Override
	protected boolean isFinished() {
		//chew until they release the button.
		return isTimedOut() || Robot.arms.ArmsAtLimitSwitch();
	}
	
	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.arms.StopArms();
	    Robot.arms.ResetArmEncoder();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.arms.StopArms();
	}

}
