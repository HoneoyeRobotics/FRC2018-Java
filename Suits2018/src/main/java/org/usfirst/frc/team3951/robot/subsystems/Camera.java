package org.usfirst.frc.team3951.robot.subsystems;

import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Camera extends Subsystem {
	public UsbCamera frontCamera;
	public UsbCamera rearCamera;
	public CvSink frontCameraCvSink;
	public CvSink rearCameraCvSink;
	public VideoSink cameraServer;
	public volatile boolean UseFrontCamera = true;

	public Camera() {
		super("Camera");
		cameraServer = CameraServer.getInstance().getServer();
		frontCamera = CameraServer.getInstance().startAutomaticCapture(0);
		rearCamera = CameraServer.getInstance().startAutomaticCapture(1);
		frontCameraCvSink = new CvSink("cam1cv");
		frontCameraCvSink.setSource(frontCamera);
		frontCameraCvSink.setEnabled(true);		
		
		frontCameraCvSink = new CvSink("cam2cv");
		frontCameraCvSink.setSource(rearCamera);
		frontCameraCvSink.setEnabled(true);
	}
	
	
	public void SwitchCamera()
	{
		if(UseFrontCamera == true) {
			UseFrontCamera = false;
			cameraServer.setSource(frontCamera);			
		}
		else
		{
			UseFrontCamera = true;
			cameraServer.setSource(rearCamera);			
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
