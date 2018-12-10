
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap.Direction;
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
