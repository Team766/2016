package org.usfirst.frc.team766.robot.commands.Camera;

import java.util.ArrayList;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team766.lib.AxisCamera;
import org.usfirst.frc.team766.robot.RobotValues;
import org.usfirst.frc.team766.robot.commands.CommandBase;

/**
 * Find the x and y component errors between the target and the center of the camera
 *
 * @author blevenson
 */
public class FindErrors extends CommandBase {
	private Mat hsv = new Mat();
	private Mat binaryImage = new Mat();
	private Mat img = new Mat();
	
	//Track image
	List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
	private Mat greenHierarchy = new Mat();
	
	private ArrayList<Rect> boundingRects = new ArrayList<Rect>();
	private ArrayList<Point> centerPoints = new ArrayList<Point>();
	private Rect biggestRect = new Rect();
	
	private AxisCamera cam;
	private Point trackPoint;
	private Point followPoint = new Point();
	private Point largestCenter = new Point();
	
	private int picCount = 0;
	//Box Tracer
	//min
		public int B_HMIN = 73;
		private int B_SMIN = 182;
		private int B_VMIN = 159;
		//Max
		private int B_HMAX = 106;
		private int B_SMAX = 255;
		private int B_VMAX = 255;

	static
	{
		System.load("/usr/local/lib/lib_OpenCV/java/libopencv_java2410.so");
	}

	protected void initialize() {
		cam = new AxisCamera("169.254.2.2");
	}

	protected void execute() {
		img = cam.getImage();
		
		if (img.empty()) return;
		
		Imgproc.cvtColor(img, hsv, Imgproc.COLOR_BGR2HSV);
		
		//Real Values
		Core.inRange(hsv, new Scalar(B_HMIN, B_SMIN, B_VMIN), new Scalar(B_HMAX, B_SMAX, B_VMAX), binaryImage);
		
		Imgproc.erode(binaryImage, binaryImage, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5,5)));
		Imgproc.dilate(binaryImage, binaryImage, Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5,5)));
				
		Imgproc.findContours(binaryImage, contours, greenHierarchy, Imgproc.RETR_LIST, Imgproc.CHAIN_APPROX_TC89_KCOS);
		Imgproc.drawContours(binaryImage, contours, -1, new Scalar(255,255,0));
		
		if(contours.size() == 0){
			System.out.println("No Conters");
			return;
		}

		for(MatOfPoint point : contours)
			boundingRects.add(Imgproc.boundingRect(point));
		
		for(Rect r : boundingRects){
			//Create the arraylist with the center points
			centerPoints.add(new Point(r.x + r.width/2, r.y + r.height/2));
			
			if(r.width * r.height > biggestRect.height * biggestRect.width){
				biggestRect = r;
				largestCenter = centerPoints.get(centerPoints.size() - 1);
			}
		}
		
		if(centerPoints.size() < 1)return;
		followPoint.y = binaryImage.height()/2;

		if(Camera.getTrackPoint() == 4)
			followPoint.x = binaryImage.width()/2;
		else if(centerPoints.size() == 1 || Camera.getTrackPoint() > 2 || contours.size() > 3)
			followPoint.x = largestCenter.x;
		else if(centerPoints.size() == 3){
			switch(Camera.getTrackPoint()){
				case 0:
					followPoint.x = 0;
					break;
				case 1:
					followPoint.x = binaryImage.width()/2;
					break;
				case 2:
					followPoint.x = binaryImage.width();
			}
		}
		
		trackPoint = findClossestPoint(centerPoints, followPoint);
		
		//Find distance
		for(Rect r : boundingRects)
			if(r.contains(trackPoint)){
				Camera.setFocalDistance((RobotValues.TAPE_WIDTH * RobotValues.FOCAL_LENGTH) / r.width);
				Camera.setAngleError(Math.toDegrees(2 * Math.atan(((binaryImage.height()/2) - trackPoint.y)/RobotValues.FOCAL_LENGTH)));
			}
		
		
		Camera.setXError(binaryImage.width()/2 - trackPoint.x);
		Camera.setYError(binaryImage.height()/2 - trackPoint.y);	
		
		//Clean up
		centerPoints.clear();
		boundingRects.clear();
		contours.clear();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {
		end();
	}

	private Point findClossestPoint(ArrayList<Point> points, Point followPoint){
		//Find the center point from all the contours
		trackPoint = points.get(0);
		for(Point p : points){
			if(Math.sqrt(Math.pow(followPoint.x - trackPoint.x ,2) + Math.pow(followPoint.y - trackPoint.y ,2)) > Math.sqrt(Math.pow(binaryImage.width()/2 - p.x ,2) + Math.pow(binaryImage.height()/2 - p.y ,2)))
				trackPoint = p;
		}
		return trackPoint;
	}
}