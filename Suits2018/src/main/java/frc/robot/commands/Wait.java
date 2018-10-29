package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

public class Wait extends  Command {

	public Wait(){
		this(1);
	}
	public Wait(double timeout) {
		super("Wait");		
		setInterruptible(true);	
		//if no timeout set, set to 1.
		if(timeout <= 0)
			timeout = 1;
		setTimeout(timeout);
	}
		
	
	//do nothing.
	@Override 
	protected void execute() {		
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
		
}
