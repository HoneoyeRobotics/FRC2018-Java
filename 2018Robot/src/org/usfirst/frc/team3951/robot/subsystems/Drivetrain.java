package org.usfirst.frc.team3951.robot.subsystems;

import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.commands.ArcadeDriveWithJoystick;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {

	
	private WPI_TalonSRX frontLeftMotor;
	private WPI_VictorSPX rearLeftMotor;
	private SpeedControllerGroup leftMotorGroup;
	
	private WPI_TalonSRX frontRightMotor;
	private WPI_VictorSPX rearRightMotor;	
	private SpeedControllerGroup rightMotorGroup;
	
	private DifferentialDrive drivetrain;
	private ADXRS450_Gyro gyro;	
	private boolean drivingReversed;
	
	public Drivetrain() {
		super("Drivetrain");		
		
		
		frontLeftMotor = new WPI_TalonSRX(RobotMap.DRIVE_LEFT_FRONT_MOTOR_CANID);
		rearLeftMotor = new WPI_VictorSPX(RobotMap.DRIVE_LEFT_REAR_MOTOR_CANID);
		leftMotorGroup = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
		frontLeftMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		frontLeftMotor.setSensorPhase(false);
				
		frontRightMotor = new WPI_TalonSRX(RobotMap.DRIVE_RIGHT_FRONT_MOTOR_CANID);
		rearRightMotor = new WPI_VictorSPX(RobotMap.DRIVE_RIGHT_REAR_MOTOR_CANID);	
		rightMotorGroup = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
		frontRightMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		frontRightMotor.setSensorPhase(false);
				
		drivetrain = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
		gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);	
		drivingReversed = false;
				
		//not sure if we need follow, as we have speed controller groups.
		//rearLeftMotor.follow(frontLeftMotor);		
		//rearRightMotor.follow(frontRightMotor);
	}
	
	public boolean isDriveReversed() {
		return drivingReversed;
	}
	public void reverseDrivingDirection() {
		drivingReversed = !drivingReversed;
	}
	public int getLeftMotorPosition()	{
		return frontLeftMotor.getSelectedSensorPosition(0);
	}
	public int getLeftMotorVelocity()	{
		return frontLeftMotor.getSelectedSensorVelocity(0);
	}

	public int getRightMotorPosition()	{
		return frontRightMotor.getSelectedSensorPosition(0);
	}
	public int getRightMotorVelocity()	{
		return frontRightMotor.getSelectedSensorVelocity(0);
	}

	
	public double getGyroRate() {
		return gyro.getRate();
	}
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}
	
	public void gyroReset() {
		gyro.reset();
	}
	

	public void arcadeDrive(double xSpeed,double zRotation) {		
		drivetrain.arcadeDrive(xSpeed, zRotation);
	}	
	
	public void stop() {
		drivetrain.stopMotor();
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArcadeDriveWithJoystick(Robot.oi.getDriverJoystick()));
		
	}
}
