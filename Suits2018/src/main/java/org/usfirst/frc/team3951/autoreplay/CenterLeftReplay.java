package org.usfirst.frc.team3951.autoreplay;

public class CenterLeftReplay {
	public CommandSequence CommandSequence;
	
	public CenterLeftReplay() {
		
		CommandSequence = new CommandSequence();
		
		
		CommandSequence.addIteration(new Iteration(1) {{			
			driveXAxis = 1.0;
			driveZRotation = 0.0;
			cubeArmLiftEncoderValue = 25;					
		}});
		CommandSequence.addIteration(new Iteration(100) {{			
			driveZRotation = -1.0;					
		}});
		CommandSequence.addIteration(new Iteration(150) {{
			driveZRotation = 0.0;							
		}});
		CommandSequence.addIteration(new Iteration(200) {{
			driveZRotation = 1.0;			
		}});
		CommandSequence.addIteration(new Iteration(250) {{
			driveZRotation = 0.0;					
		}});
		CommandSequence.addIteration(new Iteration(300) {{
			driveXAxis = 0.0;
			cubeArmMotorValue = 1.0;
		}});
		CommandSequence.addIteration(new Iteration(400) {{
			cubeArmLiftEncoderValue = -1;
			cubeArmMotorValue = 0.0;
		}});

		CommandSequence.StopIteration = 400;
	}
}
