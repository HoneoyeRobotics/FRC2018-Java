package frc.robot.commands;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForDistance extends  Command {

	private double xSpeed = 0;	
	private int lastEncoderValue = 0;
	private double unitsPerInch = 0;
	private double endingEncoderValue = 0;
	private double distance = 0;
	public DriveForDistance(double xSpeed, double distance, double timeout) {
		super("Drive for Distance");
		requires(Robot.drivetrain);
		setInterruptible(true);
		//set runTime to 5 seconds if not set
		if(timeout <= 0)
			timeout = 10;
		setTimeout(timeout);
		this.xSpeed = xSpeed;
		this.distance = distance;
		//int startingEncoderValue = Robot.drivetrain.getLeftMotorPosition();
		lastEncoderValue = 0;
		unitsPerInch = 1 / (Math.PI * RobotMap.WHEEL_DIAMETER) * RobotMap.ENCODER_UNITS_PER_REVOLUTION;
		endingEncoderValue = unitsPerInch * distance;
	}
	
	@Override 
	protected void execute() {			
		Robot.drivetrain.arcadeDrive(xSpeed, RobotMap.DRIVE_DISTANCE_Y_FACTOR);
		lastEncoderValue = Robot.drivetrain.getLeftMotorPosition();
	}
	
	@Override
	protected boolean isFinished() {
		if(distance < 0)
			return lastEncoderValue <= endingEncoderValue;
		else
			return lastEncoderValue >= endingEncoderValue;
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
