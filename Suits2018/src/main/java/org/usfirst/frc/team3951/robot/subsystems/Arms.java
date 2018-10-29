package org.usfirst.frc.team3951.robot.subsystems;

import org.usfirst.frc.team3951.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arms extends Subsystem {
	
	private WPI_VictorSPX armWheelLeftMotor;
	private WPI_VictorSPX armWheelRightMotor;
	private SpeedControllerGroup armWheelMotors;
	

	private WPI_VictorSPX armPositionMotor;
	private Encoder armPositionEncoder;
	private DigitalInput armPositionLimitSwitch;	
	private AnalogInput armPositionSensor;
	
	
	public Arms() {
		super("Arms");
		
		armWheelLeftMotor = new WPI_VictorSPX(RobotMap.ARM_WHEEL_LEFT_MOTOR_CANID);
		armWheelRightMotor = new WPI_VictorSPX(RobotMap.ARM_WHEEL_RIGHT_MOTOR_CANID);
		armWheelMotors = new SpeedControllerGroup(armWheelLeftMotor, armWheelRightMotor);
		

		armPositionMotor = new WPI_VictorSPX(RobotMap.ARM_POSITION_MOTOR_CANID);
		armPositionEncoder = new Encoder(RobotMap.ARM_POSITION_ENCODER_A_CHANNEL_DIO_INPUT, RobotMap.ARM_POSITION_ENCODER_B_CHANNEL_DIO_INPUT);
		armPositionEncoder.reset();
		
		armPositionLimitSwitch = new DigitalInput(RobotMap.ARM_POSITION_LIMIT_SWITCH_DIO_INPUT);	
		armPositionSensor = new AnalogInput(RobotMap.ARM_POSITION_SENSOR_ANALOG_INPUT);
		
		
	}
	
	public void RunArmWheels(double speed)
	{
		armWheelMotors.set(speed);
	}
	
	public boolean CubeInArms()
	{
		//disabled code!
		return false;
		//trigger if voltage > 5?
		//return armPositionSensor.getAverageVoltage() > 5;
	}
	
	
	public void StopArmWheels() {
		armWheelMotors.stopMotor();
	}
	
	public void MoveArmsTowardsPosition(int position) {
		//lower at speed of -0.2
		double speed = -0.2;
		//is the encoder value higher than where we need to go? 
		//higher = arm is below. 0 = up position, 130 = down.
		if(GetArmPosition() > position)
			speed = 1;
		MoveArms(speed);			
	}
	
	public int GetArmPosition() {
		return armPositionEncoder.get();
	}
	
	public void ResetArmEncoder() {
		armPositionEncoder.reset();
	}
	public void MoveArms(double speed) {
		armPositionMotor.set(ControlMode.PercentOutput, speed);
	}
	
	public void ArmsToSpit() {
		armPositionMotor.set(ControlMode.Position, 25);
	}
	
	public void ArmsToBottom() {
		armPositionMotor.set(ControlMode.Position, 130);
	}
	public void StopArms() {
		armPositionMotor.stopMotor();
	}
	
	public int ArmPosition() {
		return armPositionMotor.getSelectedSensorPosition(0);
	}
	
	public boolean ArmsAtTop() {
		// top = 0 with deadband of 5
		return armPositionEncoder.get() < 5;
	}
	public boolean ArmsAtSpit() {
		//target 25 with deadband of 5
		return armPositionEncoder.get() < 30 && armPositionEncoder.get() < 20;
	}
	public boolean ArmsAtBottom() {
		//target 130 with deadband of 5
		return armPositionEncoder.get() < 135 && armPositionEncoder.get() < 125;
	}
	public boolean ArmsAtLimitSwitch()
	{
		return armPositionLimitSwitch.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
