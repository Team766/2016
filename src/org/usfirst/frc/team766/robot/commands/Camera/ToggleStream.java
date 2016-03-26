package org.usfirst.frc.team766.robot.commands.Camera;

import org.usfirst.frc.team766.lib.DeviceManager;
import org.usfirst.frc.team766.robot.commands.CommandBase;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;

import edu.wpi.first.wpilibj.CameraServer;

public class ToggleStream extends CommandBase{
	
	private Image img;
	private boolean usb;
	
	public ToggleStream(){
		usb = true;
		DeviceManager.getInstance().getUSBCam().startCapture();
		img = NIVision.imaqCreateImage(ImageType.IMAGE_RGB, 0);
//		CameraServer.getInstance().startAutomaticCapture("cam1");
	}
	
	protected void initialize() {
	}

	protected void execute() {
		
		usb = !OI.getCameraToggle();
		
		if(!usb && !DeviceManager.getInstance().getCam().isFreshImage()){
			System.out.println("Failing to grab image!");
			return;
		}
		
		if(!usb)
			DeviceManager.getInstance().getCam().getImage(img);
		else
			DeviceManager.getInstance().getUSBCam().getImage(img);
	
		CameraServer.getInstance().setImage(img);
	}

	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
