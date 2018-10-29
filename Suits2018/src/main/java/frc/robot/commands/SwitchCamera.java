package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SwitchCamera extends  Command {

	public SwitchCamera(){	
		super("Switch Camera");
		requires(Robot.camera);
		setInterruptible(true);
		
		Robot.camera.SwitchCamera();
		
	}
		
	
	@Override 
	protected void execute() {
	}
		
	@Override
	protected boolean isFinished() {
		return true;
	}


	
		
}
