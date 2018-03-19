package org.usfirst.frc.team3951.robot.subsystems;

import org.usfirst.frc.team3951.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arms extends Subsystem {
	
	private WPI_VictorSPX armWheelLeftMotor = new WPI_VictorSPX(RobotMap.ARM_WHEEL_LEFT_MOTOR_CANID);
	private WPI_VictorSPX armWheelRightMotor = new WPI_VictorSPX(RobotMap.ARM_WHEEL_RIGHT_MOTOR_CANID);
	private SpeedControllerGroup armWheelMotors = new SpeedControllerGroup(armWheelLeftMotor, armWheelRightMotor);
	

	private WPI_VictorSPX armPositionMotor = new WPI_VictorSPX(RobotMap.ARM_POSITION_MOTOR_CANID);
	private DigitalInput armPositionLimitSwitch = new DigitalInput(RobotMap.ARM_POSITION_LIMIT_SWITCH_DIO_INPUT);	
	private AnalogInput armPositionSensor = new AnalogInput(RobotMap.ARM_POSITION_SENSOR_ANALOG_INPUT);
	
	
	public Arms() {
		super("Arms");
	}
	
	public void RunArmWheels(double speed)
	{
		armWheelMotors.set(speed);
	}
	
	public boolean CubeInArms()
	{
		return armPositionLimitSwitch.get();
	}
	public void StopArmWheels() {
		armWheelMotors.set(0);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
