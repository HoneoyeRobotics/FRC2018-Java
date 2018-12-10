/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDriveWithJoystick;
import edu.wpi.first.wpilibj.SPI;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
	private WPI_TalonSRX frontLeftDriveMotor;
	private WPI_VictorSPX rearLeftDriveMotor;
	private SpeedControllerGroup leftDriveMotorGroup;
	
	private WPI_TalonSRX frontRightDriveMotor;
	private WPI_VictorSPX rearRightDriveMotor;	
  private SpeedControllerGroup rightDriveMotorGroup;
  
  
	private ADXRS450_Gyro gyro;	
  
  private DifferentialDrive drivetrain;

  public Drivetrain(){
    frontLeftDriveMotor = new WPI_TalonSRX(RobotMap.frontLeftDriveMotorCanID);
    rearLeftDriveMotor = new WPI_VictorSPX(RobotMap.frontLeftDriveMotorCanID);
    leftDriveMotorGroup = new SpeedControllerGroup(frontLeftDriveMotor, rearLeftDriveMotor);
    
    frontRightDriveMotor = new WPI_TalonSRX(RobotMap.frontRightDriveMotorCanID);
    rearRightDriveMotor = new WPI_VictorSPX(RobotMap.frontRightDriveMotorCanID);
    rightDriveMotorGroup = new SpeedControllerGroup(frontRightDriveMotor, rearRightDriveMotor);
    
    drivetrain = new DifferentialDrive(leftDriveMotorGroup, rightDriveMotorGroup);
    gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);	
  }

  
	public void arcadeDrive(double xSpeed,double zRotation) {				
		drivetrain.arcadeDrive( xSpeed * -1, zRotation);
  }	
  

  public int getLeftMotorPosition()	{
		return frontLeftDriveMotor.getSelectedSensorPosition(0);
	}
	public int getLeftMotorVelocity()	{
		return frontLeftDriveMotor.getSelectedSensorVelocity(0);
	}

	public int getRightMotorPosition()	{
		return frontRightDriveMotor.getSelectedSensorPosition(0);
	}
	public int getRightMotorVelocity()	{
		return frontRightDriveMotor.getSelectedSensorVelocity(0);
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
  
  public void stop(){
    drivetrain.stopMotor();
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ArcadeDriveWithJoystick());
  }
}
