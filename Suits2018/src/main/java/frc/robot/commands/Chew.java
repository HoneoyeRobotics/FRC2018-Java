package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Chew extends  Command {

	public Chew(){
		this(1);
	}
	public Chew(double timeout) {
		super("Chew");
		requires(Robot.arms);
		setInterruptible(true);	
		//if no timeout set, set to 1.
		if(timeout <= 0)
			timeout = 1;
		setTimeout(timeout);
		if(Robot.recordMode == true)
		{
			
		}
	}
		
	
	//run arm wheels full speed
	@Override 
	protected void execute() {		
		Robot.arms.RunArmWheels(1);
	}
	
	//Chew is finished when 
	@Override
	protected boolean isFinished() {
		return isTimedOut() || Robot.arms.CubeInArms();
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
