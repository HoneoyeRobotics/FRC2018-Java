package org.usfirst.frc.team3951.robot.subsystems;

import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.commands.ArcadeDriveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {
	private WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(RobotMap.FRONT_LEFT_MOTOR_CHANNEL);
	private WPI_TalonSRX rearLeftMotor = new WPI_TalonSRX(RobotMap.REAR_LEFT_MOTOR_CHANNEL);
	private SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
	
	
	private WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(RobotMap.FRONT_RIGHT_MOTOR_CHANNEL);
	private WPI_TalonSRX rearRightMotor = new WPI_TalonSRX(RobotMap.REAR_RIGHT_MOTOR_CHANNEL);	
	private SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
	
	private DifferentialDrive drivetrain = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
	
	public Drivetrain() {
		super("Drivetrain");
	}

	public void arcadeDrive(double xSpeed,double zRotation) {		
		drivetrain.arcadeDrive(zRotation, zRotation);
	}
	
	public void stop() {
		drivetrain.stopMotor();
	}
	
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick(Robot.oi.getDriverJoystick()));
		
	}
}
