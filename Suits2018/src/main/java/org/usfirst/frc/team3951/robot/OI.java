/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3951.robot;

import org.usfirst.frc.team3951.robot.commands.ArmsDown;
import org.usfirst.frc.team3951.robot.commands.ArmsToSpit;
import org.usfirst.frc.team3951.robot.commands.ArmsToTop;
import org.usfirst.frc.team3951.robot.commands.Chew;
import org.usfirst.frc.team3951.robot.commands.ReleaseClimbHook;
import org.usfirst.frc.team3951.robot.commands.ReverseDriveDirection;
import org.usfirst.frc.team3951.robot.commands.Spit;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
		//// CREATING BUTTONS
		// One type of button is a joystick button which is any button on a
		//// joystick.
		// You create one by telling it which joystick it's on and which button
		// number it is.
		// Joystick stick = new Joystick(port);
		// Button button = new JoystickButton(stick, buttonNumber);
	
		// There are a few additional built in buttons you can use. Additionally,
		// by subclassing Button you can create custom triggers and bind those to
		// commands the same as any other Button.
	
		//// TRIGGERING COMMANDS WITH BUTTONS
		// Once you have a button, it's trivial to bind it to a button in one of
		// three ways:
	
		// Start the command when the button is pressed and let it run the command
		// until it is finished as determined by it's isFinished method.
		// button.whenPressed(new ExampleCommand());
	
		// Run the command while the button is being held down and interrupt it once
		// the button is released.
		// button.whileHeld(new ExampleCommand());
	
		// Start the command when the button is released and let it run the command
		// until it is finished as determined by it's isFinished method.
		// button.whenReleased(new ExampleCommand());
	
	//driver controller
	public static final int DRIVER_JOYSTICK_PORT = 0;
	private Joystick driverJoystick = new Joystick(DRIVER_JOYSTICK_PORT);
	public static final int DRIVER_FORWARD_AXIS = 1;
	public static final int DRIVER_ROTATE_LEFT_AXIS = 2;
	public static final int DRIVER_ROTATE_RIGHT_AXIS = 3;	
	public static final int REVERSE_DRIVE_BUTTON = 5;
	public static final int SLOW_SPEED_BUTTON = 2;
	
	//co-pilot joystick
	public static final int COPILOT_JOYSTICK_PORT = 1;	
	private Joystick coPilotJoystick = new Joystick(COPILOT_JOYSTICK_PORT);
	public static final int ARM_SPIT_BUTTON = 1; //B button
	public static final int ARM_CHEW_BUTTON = 2;//X button
	public static final int ARM_LOWER_BUTTON = 0 ;//A button
	public static final int ARM_SPIT_POS_BUTTON = 3;//Y button	
	public static final int CLIMB_LATCH_RELEASE_BUTTON = 4; //lbumper
	public static final int ARM_RESET_POS_BUTTON = 5; //rbumper
	public static final int CUBE_IMMEDIATE_AXIS = 1; // axis 1
	public static final int CLIMB_IMMEDIATE_AXIS = 2; //axis 2
	public static final int CLIMB_TOWER_TOGGLE_BUTTON = 6;
	public static final int CLIMB_WINCH_AXIS = 5;	
	
	public Joystick getDriverJoystick() {
		return driverJoystick;
	}
	
	public Joystick getCoPilotJoystick() {
		return coPilotJoystick;
	}
	
	
	public OI() {	
		
		//set driver joystick
		new JoystickButton(driverJoystick, REVERSE_DRIVE_BUTTON).whenPressed(new ReverseDriveDirection());
		
		//set copilot joystick
		
			
		//set button X to be chew
		new JoystickButton(coPilotJoystick, ARM_CHEW_BUTTON).whileHeld(new Chew());
		//set button Y to arms spit position
		new JoystickButton(coPilotJoystick,ARM_SPIT_POS_BUTTON).whenPressed(new ArmsToSpit());
		//set button A to be arms down
		new JoystickButton(coPilotJoystick,ARM_LOWER_BUTTON).whenPressed(new ArmsDown());
		//set button B to be spit
		new JoystickButton(coPilotJoystick, ARM_SPIT_BUTTON).whileHeld(new Spit());
		
		//set button LB to be release climb latch
		new JoystickButton(coPilotJoystick, CLIMB_LATCH_RELEASE_BUTTON).whenPressed(new ReleaseClimbHook());
		//set button RB to be arm home reset
		new JoystickButton(coPilotJoystick, ARM_RESET_POS_BUTTON).whenPressed(new ArmsToTop());
		//set start to be reset arm lift encoder
		new JoystickButton(coPilotJoystick, ARM_RESET_POS_BUTTON).whenPressed(new ArmsToTop());

		//new JoystickButton(coPilotJoystick, CLIMB_TOWER_TOGGLE_BUTTON);
		
	}
	
}
