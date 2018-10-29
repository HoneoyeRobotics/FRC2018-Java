package org.usfirst.frc.team3951.robot.subsystems;

import org.usfirst.frc.team3951.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
	private WPI_VictorSPX winchFrontMotor;
	private WPI_VictorSPX winchRearMotor;
	private SpeedControllerGroup winchMotors;

	private WPI_VictorSPX towerMotor;
	private DigitalInput towerLimitSwitch;	
	private PWM hookReleaseMotor;
		
	
	public Climber() {
		super("Climber");
		
		winchFrontMotor = new WPI_VictorSPX(RobotMap.CLIMB_WINCH_MOTOR_FRONT_CANID);
		winchRearMotor = new WPI_VictorSPX(RobotMap.CLIMB_WINCH_MOTOR_REAR_CANID);
		winchMotors = new SpeedControllerGroup(winchFrontMotor, winchRearMotor);
		

		towerMotor = new WPI_VictorSPX(RobotMap.CLIMB_TOWER_MOTOR_CANID);
		towerLimitSwitch = new DigitalInput(RobotMap.CLIMB_TOWER_POSITION_LIMIT_SWITCH_DIO_INPUT);	
		hookReleaseMotor = new PWM(RobotMap.CLIMB_TOWER_ARM_HOOK_RELEASE_LATCH_PWM_INPUT);
			
		
	}
	
	public void OpenReleaseHook() {
		hookReleaseMotor.setRaw(2000);
	}
	
	public void CloseReleaseHook() {
		hookReleaseMotor.setRaw(0);
	}
	
	public void MoveTower(double speed) {
		//disable winch so it wont fight it
		winchMotors.stopMotor();
		towerMotor.set(speed);
	}
	
	public boolean TowerAtTop() {
		return towerLimitSwitch.get();
	}
	
	
	public void RunWinch(double speed) {
		winchMotors.set(speed);
		towerMotor.stopMotor();
	}
	
	public void StopWinch() {
		winchMotors.stopMotor();
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
