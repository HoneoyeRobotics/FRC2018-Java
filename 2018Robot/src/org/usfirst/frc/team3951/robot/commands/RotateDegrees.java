package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.OI;
import org.usfirst.frc.team3951.robot.Robot;
import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.RobotMap.Direction;
import org.usfirst.frc.team3951.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class RotateDegrees extends  CommandGroup {

	
	public RotateDegrees(double degreesToTravel,  Direction rotateDirection, double timeout, double deadband) {
		double degreesToSet = 0;
		double startingDegrees = Robot.drivetrain.getGyroAngle();
		
		if(rotateDirection == Direction.LEFT) {
			degreesToSet = startingDegrees - degreesToSet;			
		}
		else {
			degreesToSet = degreesToSet - startingDegrees;			
		}
			
		//get a degrees to travel between 0 and 360		
		if(degreesToSet >= 360)
			degreesToSet -= 360;		
		if(degreesToSet < 0)
			degreesToSet += 360;
		
		
		addSequential(new RotateToDegrees(degreesToSet, rotateDirection, timeout, deadband));		
		
	}	
}
