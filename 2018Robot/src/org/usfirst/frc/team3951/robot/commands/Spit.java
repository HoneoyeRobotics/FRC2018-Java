package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class Spit extends  Command {

	public Spit() {
		this(1);
	}
	public Spit(double Timeout) {
		super("Spit");
		requires(Robot.arms);
		setInterruptible(true);
		//if no timeout set, set to 1.
		if(Timeout <= 0)
			Timeout = 1;
		setTimeout(Timeout);
	}
	
	//run in full reverse
	@Override 
	protected void execute() {		
		Robot.arms.RunArmWheels(-1);
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
		Robot.arms.StopArmWheels();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.arms.StopArmWheels();
	}

}
