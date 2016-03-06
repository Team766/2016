package org.usfirst.frc.team766.lib.Tester;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BearlyVictor extends CallableVictor{
	private final double THRESHOLD = 1;
	
	public BearlyVictor(int port) {
		super(port);
	}

	public void pidWrite(double output) {
	}

	public double get() {
		return 0;
	}

	public void set(double speed, byte syncGroup) {
	}

	@Test
	public void set(double speed) {
		if(readyForNext())
			assertEquals("", getNextValue(), speed, THRESHOLD);
	}

	public void setInverted(boolean isInverted) {
	}

	public boolean getInverted() {
		return false;
	}

	public void disable() {
	}

}
