/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3951.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	
	
	//define IDs for the drive subsystem
	public static final int DRIVE_LEFT_FRONT_MOTOR_CANID = 1; // Talon SRX
	public static final int DRIVE_LEFT_REAR_MOTOR_CANID = 2; //Victor SPX
	public static final int DRIVE_RIGHT_FRONT_MOTOR_CANID = 3;	//Talon SRX
	public static final int DRIVE_RIGHT_REAR_MOTOR_CANID = 4; //Victor SPX

	//define IDs for the arm subsystem
	public static final int ARM_WHEEL_LEFT_MOTOR_CANID = 9; // Victor SPX
	public static final int ARM_WHEEL_RIGHT_MOTOR_CANID = 10; // Victor SPX	
	public static final int ARM_POSITION_MOTOR_CANID = 7; //Victor SPX
	public static final int ARM_POSITION_ENCODER_A_CHANNEL_DIO_INPUT = 0; //Victor SPX
	public static final int ARM_POSITION_ENCODER_B_CHANNEL_DIO_INPUT = 1; //Victor SPX
	public static final int ARM_POSITION_SENSOR_ANALOG_INPUT = 0; // Arm Sensor / Analog
	public static final int ARM_POSITION_LIMIT_SWITCH_DIO_INPUT = 2; // Arm position limit switch on DIO 2
	
	//define IDs for the climb subsystem 
	public static final int CLIMB_WINCH_MOTOR_FRONT_CANID= 5; // Victor SPX
	public static final int CLIMB_WINCH_MOTOR_REAR_CANID = 6; //Victor SPX 	
	public static final int CLIMB_TOWER_MOTOR_CANID = 11; // Victor SPX
	public static final int CLIMB_TOWER_POSITION_LIMIT_SWITCH_DIO_INPUT = 3; // tower position limit switch on DIO 3
	public static final int CLIMB_TOWER_ARM_HOOK_RELEASE_LATCH_PWM_INPUT = 0; // P
	

	public static final int BELLY_SENSOR_ANALOG_INPUT = 1; // Belly Sensor / Analog
		
	
	public static final double GYRO_ROTATE_MAX_SPEED = 0.6;
	public static final double GYRO_ROTATE_MIN_SPEED = 0.4;
	public static final double GYRO_ROTATE_SLOW_FACTOR = 60;
	
	public static final double WHEEL_DIAMETER = 6;
	public static final int ENCODER_UNITS_PER_REVOLUTION = 4096;
	public static final double DRIVE_DISTANCE_Y_FACTOR = 0;
	public static final double DRIVE_DISTANCE_SPEED = 0.6; 
	public static final double ROTATE_DEGREES_DEADBAND = 8;
	
	
	public static final double ARM_RAISE_SPEED = 0.7;
	public static final double ARM_LOWER_SPEED = 0.3;
	public enum Direction {
		 LEFT,
		 RIGHT
		}
	
}



