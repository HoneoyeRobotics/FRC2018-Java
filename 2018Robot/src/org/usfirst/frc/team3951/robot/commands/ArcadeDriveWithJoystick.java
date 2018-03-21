package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDriveWithJoystick extends  Command {

	private Joystick joystick;
	public ArcadeDriveWithJoystick(Joystick joystick) {
		super("Arcade Drive With Joystick");
		requires(Robot.drivetrain);
		this.joystick = joystick;
	}
	
	@Override 
	protected void execute() {
		
		double forwardSpeed = joystick.getRawAxis(OI.DRIVER_FORWARD_AXIS);
		double leftButton = joystick.getRawAxis(OI.DRIVER_ROTATE_LEFT_AXIS);
		double rightButton = joystick.getRawAxis(OI.DRIVER_ROTATE_RIGHT_AXIS);		
		double turnSpeed = rightButton - leftButton;
		if(Robot.drivetrain.isDriveReversed())
			turnSpeed *= -1;
		
		if(joystick.getRawButton(Robot.oi.SLOW_SPEED_BUTTON)) {
			forwardSpeed *= 0.5;
			turnSpeed *= 0.5;
		}
		
		Robot.drivetrain.arcadeDrive(forwardSpeed, turnSpeed);
	}
	
	@Override
	protected boolean isFinished() {
		//this command is never finished so that it will always run.
		return false;
	}

}
