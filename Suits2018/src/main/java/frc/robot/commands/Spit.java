package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Spit extends  Command {

	public Spit() {
		this(1);
	}
	public Spit(double timeout) {
		super("Spit");
		requires(Robot.arms);
		setInterruptible(true);
		//if no timeout set, set to 1.
		if(timeout <= 0)
			timeout = 1;
		setTimeout(timeout);
	}
	
	//run in full reverse
	@Override 
	protected void execute() {		
		Robot.arms.RunArmWheels(-1);
	}
	
	//run until the arm spit button is release
	@Override
	protected boolean isFinished() {
		//chew until they release the button.
		return isTimedOut();
	}
	
	//at the end, stop the motor.
	@Override
	protected void end() {
		Robot.arms.StopArmWheels();
	}
	

	//if the command is interrupted(cancelled), stop the motor.
	@Override
	protected void interrupted() {
		Robot.arms.StopArmWheels();
	}

}
