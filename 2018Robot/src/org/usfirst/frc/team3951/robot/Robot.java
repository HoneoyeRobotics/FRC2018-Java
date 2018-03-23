/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3951.robot;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3951.robot.commands.AutonomousCenter;
import org.usfirst.frc.team3951.robot.commands.AutonomousLeft;
import org.usfirst.frc.team3951.robot.commands.AutonomousRight;
import org.usfirst.frc.team3951.robot.commands.Chew;
import org.usfirst.frc.team3951.robot.commands.Spit;
import org.usfirst.frc.team3951.robot.subsystems.Arms;
import org.usfirst.frc.team3951.robot.subsystems.Camera;
import org.usfirst.frc.team3951.robot.subsystems.Climber;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Drivetrain drivetrain;
	public static OI oi;
	public static Arms arms;
	public static Climber climber;
	public Command autonomousCommand;
	public SendableChooser autoChooser;
	public static Camera camera;
	
	
	@Override
	public void robotInit() {
		RobotMap.init();
		drivetrain = new Drivetrain();
		oi = new OI();
		arms = new Arms();
		climber = new Climber();
		camera = new Camera();
		
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Center - Either Switch", new AutonomousCenter());
		autoChooser.addObject("Left - Switch or Wait", new AutonomousLeft());
		autoChooser.addObject("Right - Switch or Wait", new AutonomousRight());
		SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		SmartDashboard.putData(Scheduler.getInstance());
		SmartDashboard.putData("Chew", new Chew());
		SmartDashboard.putData("Spit", new Spit());
		
	
	}
	
	//Runs code during the teleop, every 20ms
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}
	
	
    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand = (Command)autoChooser.getSelected();
        autonomousCommand.start();
    }
    
	  public void autonomousPeriodic() {
	        Scheduler.getInstance().run();
	    }
	
}
