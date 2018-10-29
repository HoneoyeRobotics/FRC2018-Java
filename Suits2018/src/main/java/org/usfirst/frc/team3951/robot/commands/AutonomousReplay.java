package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.autoreplay.*;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousReplay extends  Command {

	private CommandSequence commandSequence;
	private int iteration;
	private double currentDriveXAxis = 0;
	private double currentDriveZRotation = 0;
	
	public AutonomousReplay(CommandSequence commandSequence) {
		super("Autonomous Replay");
		requires(Robot.arms);
		requires(Robot.drivetrain);
		setInterruptible(true);
		//set timeout to 15 seconds - autonomous mode timeframe
		setTimeout(15);
		this.commandSequence = commandSequence;
		iteration = 0;
	}
	
	//run in full reverse
	@Override 
	protected void execute() {
		//increment iteration
		iteration++;
		
		//search for anything to do with current iteration
		Iteration currentIteration = commandSequence.get(iteration);
		//if its found, do something
		if(currentIteration != null) {
			
			//check for action for cubeArmLift
			if(currentIteration.cubeArmLiftEncoderValue != null) {
				if(currentIteration.cubeArmLiftEncoderValue == -1) {
					//if set to -1, stop arms
					Robot.arms.StopArms();
				} else {
					//if not -1, move towards position
					Robot.arms.MoveArmsTowardsPosition(currentIteration.cubeArmLiftEncoderValue.intValue());	
				}			
			}
			
			//check for action for cube wheels
			if(currentIteration.cubeArmMotorValue != null) {
				// -1 is reverse, 0 is stop, 1 is full forward
				Robot.arms.RunArmWheels(currentIteration.cubeArmMotorValue.doubleValue());								
			}
			
			//check change on action for drive motors 			
			if(currentIteration.driveXAxis != null || currentIteration.driveZRotation != null) {
				if(currentIteration.driveXAxis != null) {
					//update what the new drive setpoint should be
					currentDriveXAxis = currentIteration.driveXAxis.doubleValue();
				}
				if(currentIteration.driveZRotation != null) {
					//update what the new drive setpoint should be
					currentDriveZRotation = currentIteration.driveZRotation.doubleValue();
				}
				//change the drive motors based on what current setpoints are
				Robot.drivetrain.arcadeDrive(currentDriveXAxis, currentDriveZRotation);
			}
			
		}
		
		
	}
	
	//run until the timeout, or iteration is higher than the stop iteration.
	@Override
	protected boolean isFinished() {
		return isTimedOut() || iteration >= commandSequence.StopIteration;
	}
	
	//at the end, stop the motors.
	@Override
	protected void end() {
		Robot.arms.StopArms();
		Robot.arms.StopArmWheels();
		Robot.drivetrain.stop();
	}
	

	//if the command is interrupted(cancelled), stop the motors.
	@Override
	protected void interrupted() {
		Robot.arms.StopArms();
		Robot.arms.StopArmWheels();
		Robot.drivetrain.stop();
	}

}
