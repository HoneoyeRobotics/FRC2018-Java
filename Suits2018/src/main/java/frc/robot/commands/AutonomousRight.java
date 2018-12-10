package frc.robot.commands;

import frc.robot.RobotMap;
import frc.robot.RobotMap.Direction;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRight extends CommandGroup {
	public AutonomousRight() {
		//run the arms up for 15 seconds, or until we interrupt the command with the next one.		
		addParallel(new ArmsToSpitHold(15));
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		boolean TeamSwitchLeft = false;
        if(gameData.length() > 0)
        {
        	TeamSwitchLeft = gameData.charAt(0) == 'L';
        }
        if(TeamSwitchLeft == true) {

    		// wait a little
    		addSequential(new Wait(3));
    		//drive forward 24 inches, timeout at 2 seconds
        	addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 24, 2));
    		////rotate left 45 degrees, for 3 sec max, deadband 5 degrees
    		addSequential(new RotateDegrees(45, Direction.RIGHT, 3, RobotMap.ROTATE_DEGREES_DEADBAND));
    		//drive forward 16 inches, timeout at 2 seconds
    		addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 16, 2));
    		//rotate back to 0
    		addSequential(new RotateToDegrees(0, Direction.LEFT, 3, RobotMap.ROTATE_DEGREES_DEADBAND));
    		//drive forward 66 inches, timeout at 7 seconds
            addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 150, 7));
    		
    	} else {
    		//drive forward 145 inches, timeout at 5 seconds
        	addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 145, 5));
    		//rotate right 90 degrees, for 5 sec max, deadband 5 degrees
    		addSequential(new RotateDegrees(90, Direction.LEFT, 5, RobotMap.ROTATE_DEGREES_DEADBAND));
    		//drive forward 12 inches, timeout at 5 seconds
    		addSequential(new DriveForDistance(RobotMap.DRIVE_DISTANCE_SPEED, 12, 5));
    		//spit the cube in
    		addSequential(new Spit());    
    	}
        
        
            
	}
}
