package org.usfirst.frc.team3951.autoreplay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandSequence {
	private HashMap<Integer, Iteration> Iterations;
	public int StopIteration;
	public CommandSequence() {
		Iterations = new HashMap<Integer, Iteration>();
		StopIteration = 750;
	}
	public void addIteration(Iteration iteration) {
		Iterations.put(iteration.iteration, iteration);		
	}
	
	public Iteration get(Integer iteration) {
		return Iterations.get(iteration);
	}
}
