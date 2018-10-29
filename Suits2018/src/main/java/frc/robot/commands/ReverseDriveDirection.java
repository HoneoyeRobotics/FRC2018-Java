package frc.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class ReverseDriveDirection extends  CommandGroup {
	
	public ReverseDriveDirection() {
		addSequential(new ReverseDriveDirection());
		addSequential(new SwitchCamera());
	}	

}
