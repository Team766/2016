package org.usfirst.frc.team766.lib.Tester;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.wpi.first.wpilibj.SpeedController;

public class BearlyVictor extends Callable implements SpeedController{
	private final double THRESHOLD = 1;
	
	public BearlyVictor(int port) {
//		super(port);
	}

	public void pidWrite(double output) {
	}

	public double get() {
		return getNextValue();
	}

	public void set(double speed, byte syncGroup) {
	}

	@Test
	public void set(double speed) {
		assertEquals("", getNextValue(), speed, THRESHOLD);
	}

	public void setInverted(boolean isInverted) {
	}

	public boolean getInverted() {
		return false;
	}

	public void disable() {
	}

	public void stopMotor() {
		set(0.0);
	}

}
