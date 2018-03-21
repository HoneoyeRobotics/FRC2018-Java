package org.usfirst.frc.team3951.robot.commands;

import org.usfirst.frc.team3951.robot.RobotMap;
import org.usfirst.frc.team3951.robot.RobotMap.Direction;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCenter extends CommandGroup {
	public AutonomousCenter() {
		//run the arms up for 15 seconds, or until we interrupt the command with the next one.		
		addParallel(new ArmsToSpitHold(15));
		//drive forward 45 inches, timeout at 5 seconds
		addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 45, 5));
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		boolean TeamSwitchLeft = false;
        if(gameData.length() > 0)
        {
        	TeamSwitchLeft = gameData.charAt(0) == 'L';
        }
        if(TeamSwitchLeft == true) {
    		//rotate left 90 degrees, for 5 sec max, deadband 5 degrees
    		addSequential(new RotateDegrees(90, Direction.LEFT, 5, RobotMap.ROTATE_DEGREES_DEADBAND));
    		//drive forward 75 inches, timeout at 5 seconds
    		addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 75, 5));
    		//rotate back to 0
    		addSequential(new RotateToDegrees(0, Direction.RIGHT, 5, RobotMap.ROTATE_DEGREES_DEADBAND));
    		
    	} else {
    		////rotate left 90 degrees, for 5 sec max, deadband 5 degrees
    		addSequential(new RotateDegrees(90, Direction.RIGHT, 5, RobotMap.ROTATE_DEGREES_DEADBAND));
    		//drive forward 49 inches, timeout at 5 seconds
    		addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 49, 5));
    		//rotate back to 0
    		addSequential(new RotateToDegrees(0, Direction.LEFT, 5, RobotMap.ROTATE_DEGREES_DEADBAND));
    		
    	}
        
        //drive forward 66 inches, timeout at 5 seconds
        addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 66, 5));
        addSequential(new Spit());        
	}
}
