package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ArmsDown extends  Command {

	public ArmsDown() {
		this(2);
	}
	public ArmsDown(double timeout) {
		super("Arms Down");
		requires(Robot.arms);
		setInterruptible(true);
		//if no timeout set, set to 1.
		if(timeout <= 0)
			timeout = 2;
		setTimeout(timeout);
	}
	
	//run in full reverse
	@Override 
	protected void execute() {	
		Robot.arms.MoveArmsTowardsPosition(130);
	}
	
	//run until the arm spit button is release
	@Override
	protected boolean isFinished() {
		//chew until they release the button.
		return isTimedOut() || Robot.arms.ArmsAtBottom();
	}
	
	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.arms.StopArms();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.arms.StopArms();
	}

}
