/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {

  // declare IDs for our arm subsystem
  public static final int elbowMotorCanID = 7;
  public static final int leftArmWheelCanID = 9;
  public static final int rightArmWheelCanID = 10;  
  public static final int armElbowEncoderAChannelDIO = 0;
  public static final int armElbowEncoderBChannelDIO = 1;
  public static final int armLimitSwitchDIO = 2;
   
  //declare Ids for our drivetrain subsystem
  public static final int frontLeftDriveMotorCanID = 1;
  public static final int rearLeftDriveMotorCanID = 2;
  public static final int frontRightDriveMotorCanID = 3;
  public static final int rearRightDriveMotorCanID = 4;


  public static final int climbWinchMotorFrontCanID = 5; // Victor SPX
	public static final int climbWinchMotorRearCanID = 6; //Victor SPX 	
	public static final int climbTowerMotorCanID = 11; // Victor SPX
	public static final int climbTowerLimitSwitchCanID = 3; // tower position limit switch on DIO 3
  public static final int climbTowerHookReleasePWM = 0;
  
	public static final double gyroRotateMaxSpeed = 0.6;
	public static final double gyroRotateMinSpeed = 0.4;
	public static final double gyroRotateSlowFactor = 60;
	
	public static final double wheelDiameter = 6;
	public static final int encoderUnitsPerRevolution = 4096;
	public static final double driveDistanceYFactor = 0;
	public static final double driveDistanceSpeed = 0.6; 
	public static final double rotateDegreesDeadband = 8;

	public enum Direction {
    LEFT,
    RIGHT
   }
}
