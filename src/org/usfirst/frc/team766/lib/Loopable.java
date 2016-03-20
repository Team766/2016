package org.usfirst.frc.team766.lib;

public abstract class Loopable {

	protected abstract void initialize();
	protected abstract void run();
	protected abstract void end();
	protected abstract boolean isFinished();
}
