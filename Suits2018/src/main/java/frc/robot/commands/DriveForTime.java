package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForTime extends  Command {

	private double xSpeed = 0;
	private double zRotation = 0;
	
	public DriveForTime(double xSpeed, double zRotation, double runTime) {
		super("Drive for Time");
		requires(Robot.drivetrain);
		setInterruptible(true);
		//set runTime to 5 seconds if not set
		if(runTime <= 0)
			runTime = 5;
		setTimeout(runTime);
		
	}
	
	@Override 
	protected void execute() {
		Robot.drivetrain.arcadeDrive(xSpeed, zRotation);
	}
	
	@Override
	protected boolean isFinished() {
		//this command is never finished so that it will always run.
		return false;
	}
	
	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.drivetrain.stop();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.drivetrain.stop();
	}
		
			

}
