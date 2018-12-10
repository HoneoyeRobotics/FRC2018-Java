
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.Direction;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class RotateToDegrees extends  Command {

	
	private double degreesTraveled = 0;
	private double degreesToTravel = 0;
	private double degreesToSet = 0;
	private double startingDegrees = 0;
	private double speedModifier = 1;
	private double deadband = 0;
	private double lastHeading = 0;
	
	public RotateToDegrees(double degreesToSet,  Direction rotateDirection, double timeout, double deadband) {
		super("Rotate Degrees");
		requires(Robot.drivetrain);		

		setInterruptible(true);
		//timeout 5 seconds if not set
		if(timeout <= 0)
			timeout = 5;
		setTimeout(timeout);
		
		this.degreesToSet = degreesToSet;
		this.deadband = deadband;
		//set starting degrees
		startingDegrees = Robot.drivetrain.getGyroAngle();
		lastHeading = startingDegrees;
		
		//calculate data based on rotation direction
		if(rotateDirection == Direction.LEFT) {
			degreesToTravel = startingDegrees - degreesToSet;
			speedModifier = -1;
		}
		else {
			degreesToTravel = degreesToSet - startingDegrees;
			speedModifier = 1;
		}
			
		//get a degrees to travel between 0 and 360		
		if(degreesToTravel >= 360)
			degreesToTravel -= 360;		
		if(degreesToTravel < 0)
			degreesToTravel += 360;
		
	}
	
	@Override 
	protected void execute() {
				
		//get the current gyro heading
		double currentDegrees = Robot.drivetrain.getGyroAngle();
		
		double currentTravel = 0;
		//calculate how far we just traveled
		if(currentDegrees > lastHeading)
			currentTravel = currentDegrees - lastHeading;
		else
			currentTravel = lastHeading - currentDegrees;
		
		//flatten data if traveled over the 0/360 mark
		if(currentTravel >= 360)
			currentTravel -= 360;		
		if(currentTravel < 0)
			currentTravel += 360;
		
		//add current travel to degrees traveled
		degreesTraveled += currentTravel;
		
		//calculate degrees remaining to travel
		double degreesRemaining = degreesToTravel- degreesTraveled;
		
		//calculate speed based on formula - degrees remaining / factor
		double speed = degreesRemaining / RobotMap.gyroRotateSlowFactor;

		//if the speed is outside of the max/min speed, change it.
		if(speed > RobotMap.gyroRotateMaxSpeed)
			speed = RobotMap.gyroRotateMaxSpeed;
		else if (speed < RobotMap.gyroRotateMinSpeed)
			speed = RobotMap.gyroRotateMinSpeed;
		
		//rotate the speed used.
		Robot.drivetrain.arcadeDrive(0, speed);
				
		lastHeading = currentDegrees;
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

		
		
	@Override
	protected boolean isFinished() {
		//run until the timeout is reached, or we have traveled within the deadband or over.
		return isTimedOut() || degreesTraveled + deadband >= degreesToTravel;
	}

}
