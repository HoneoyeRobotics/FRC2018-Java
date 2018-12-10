
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.RobotMap.Direction;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCenter extends CommandGroup {
	public AutonomousCenter() {
		//run the arms up for 15 seconds, or until we interrupt the command with the next one.		
		addParallel(new ArmsToSpitHold(15));
		//drive forward 45 inches, timeout at 5 seconds
		addSequential(new DriveForDistance(RobotMap.driveDistanceSpeed, 45, 5));
		
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		boolean TeamSwitchLeft = false;
        if(gameData.length() > 0)
        {
        	TeamSwitchLeft = gameData.charAt(0) == 'L';
        }
        if(TeamSwitchLeft == true) {
    		//rotate left 90 degrees, for 5 sec max, deadband 5 degrees
    		addSequential(new RotateDegrees(90, Direction.LEFT, 5, RobotMap.rotateDegreesDeadband));
    		//drive forward 75 inches, timeout at 5 seconds
    		addSequential(new DriveForDistance(RobotMap.driveDistanceSpeed, 75, 5));
    		//rotate back to 0
    		addSequential(new RotateToDegrees(0, Direction.RIGHT, 5, RobotMap.rotateDegreesDeadband));
    		
    	} else {
    		////rotate left 90 degrees, for 5 sec max, deadband 5 degrees
    		addSequential(new RotateDegrees(90, Direction.RIGHT, 5, RobotMap.rotateDegreesDeadband));
    		//drive forward 49 inches, timeout at 5 seconds
    		addSequential(new DriveForDistance(RobotMap.driveDistanceSpeed, 49, 5));
    		//rotate back to 0
    		addSequential(new RotateToDegrees(0, Direction.LEFT, 5, RobotMap.rotateDegreesDeadband));
    		
    	}
        
        //drive forward 66 inches, timeout at 5 seconds
        addSequential(new DriveForDistance(RobotMap.driveDistanceSpeed, 66, 5));
        addSequential(new SpitCube());        
	}
}
