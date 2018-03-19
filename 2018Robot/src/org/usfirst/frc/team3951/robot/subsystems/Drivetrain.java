package org.usfirst.frc.team3951.robot.subsystems;

import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.commands.ArcadeDriveWithJoystick;

import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends Subsystem {
	private WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(RobotMap.DRIVE_LEFT_FRONT_MOTOR_CANID);
	private WPI_VictorSPX rearLeftMotor = new WPI_VictorSPX(RobotMap.DRIVE_LEFT_REAR_MOTOR_CANID);
	private SpeedControllerGroup leftMotorGroup = new SpeedControllerGroup(frontLeftMotor, rearLeftMotor);
	
	private WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(RobotMap.DRIVE_RIGHT_FRONT_MOTOR_CANID);
	private WPI_VictorSPX rearRightMotor = new WPI_VictorSPX(RobotMap.DRIVE_RIGHT_REAR_MOTOR_CANID);	
	private SpeedControllerGroup rightMotorGroup = new SpeedControllerGroup(frontRightMotor, rearRightMotor);
	
	private DifferentialDrive drivetrain = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
	private ADXRS450_Gyro Gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
	
	
	
	public Drivetrain() {
		super("Drivetrain");
		
		frontRightMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		frontRightMotor.setSensorPhase(false);
		frontLeftMotor.configSelectedFeedbackSensor(com.ctre.phoenix.motorcontrol.FeedbackDevice.QuadEncoder, 0, 0);
		frontLeftMotor.setSensorPhase(false);
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
