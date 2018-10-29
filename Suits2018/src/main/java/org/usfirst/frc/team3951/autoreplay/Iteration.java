package org.usfirst.frc.team3951.autoreplay;

public class Iteration {
	public int iteration;
	public Double driveXAxis;
	public Double driveZRotation;
	public Integer cubeArmLiftEncoderValue;
	public Double cubeArmMotorValue;
	
	
	public Iteration() {
		
	}
	
	public Iteration(int iteration) {
		this.iteration = iteration;
	}
	
}
