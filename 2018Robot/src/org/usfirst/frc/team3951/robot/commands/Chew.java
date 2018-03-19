package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Chew extends  Command {

	public Chew(){
		this(1);
	}
	public Chew(double Timeout) {
		super("Chew");
		requires(Robot.arms);
		setInterruptible(true);	
		//if no timeout set, set to 1.
		if(Timeout <= 0)
			Timeout = 1;
		setTimeout(Timeout);
	}
		
	
	//run arm wheels full speed
	@Override 
	protected void execute() {		
		Robot.arms.RunArmWheels(1);
	}
	
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}


	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.arms.StopArmWheels();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.arms.StopArmWheels();
	}
	
		
}
