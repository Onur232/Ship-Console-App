package com.myconsole.scopeobjects;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Stroke;

import com.myconsole.util.AngleConversion;

public class Target extends ScopeObjects{
	
	//iki doðru arasýndaki açý
	public static  int TOSO_ANGLE=90;
	public static  int COURSE_ANGLE=45;
	public static  int RANGE=100;
	public static  int SPEED=1;
	
	private int firstX=0;
	private int firstY=0;
	private int secondX=0;
	private int secondY=0;
	private int courseX=0;
	private int courseY=0;
	

	@Override
	public void drawObject(Graphics2D graphics2d) {
		setXAndY();
		calculateCourseXandY();
		drawTarget(graphics2d);
	}


	private void calculateCourseXandY() {
		StartPointOfAngle startPointOfAngle=AngleConversion.calculateCourse(COURSE_ANGLE);
		courseX = (int) startPointOfAngle.getxValue();
		courseY=(int) startPointOfAngle.getyValue();
		courseX+=getxPosition()+30/2;
		courseY=getyPosition()+30/2-courseY;
	}

	private void setXAndY() {
		StartPointOfAngle startPointOfAngle = AngleConversion.convertAngleToWidthAndHeight(TOSO_ANGLE);
		double width=startPointOfAngle.getxValue();
		double height=startPointOfAngle.getyValue();
//		System.out.println("Width="+width+" Height="+height);
		firstX=getxPosition()-(int)width;
		firstY=getyPosition()-(int)height;
		secondX=getxPosition()+(int)width;
		secondY=getyPosition()-(int)height;
	}

	private void drawTarget(Graphics2D graphics2d) {
		graphics2d.drawRect(getxPosition(), getyPosition(), 30, 30);
		
		
//		graphics2d.drawArc(getxPosition()-TOSO_WIDTH-30, getyPosition()-TOSO_HEIGHT, 225, 100, 45, 90);
//		graphics2d.drawArc(getxPosition(), getyPosition(), 225, 100, 45, 90);
//		graphics2d.drawArc(getxPosition()-TOSO_WIDTH-30, getyPosition()-TOSO_HEIGHT, TOSO_WIDTH*2-30, TOSO_HEIGHT, 45, 90);

//		graphics2d.drawLine(getxPosition()+30/2, getyPosition()+30/2, getxPosition()+TOSO_WIDTH, getyPosition()-TOSO_HEIGHT);
//		graphics2d.drawLine(getxPosition()+30/2, getyPosition()+30/2, getxPosition()-TOSO_WIDTH, getyPosition()-TOSO_HEIGHT);
//		graphics2d.drawLine(getxPosition()-TOSO_WIDTH, getyPosition()-TOSO_HEIGHT, getxPosition()+TOSO_WIDTH, getyPosition()-TOSO_HEIGHT);
		

		graphics2d.drawLine(getxPosition()+30/2, getyPosition()+30/2, firstX, firstY);
		graphics2d.drawLine(getxPosition()+30/2, getyPosition()+30/2, secondX, secondY);
		graphics2d.drawString("Toso Angle = "+TOSO_ANGLE, getxPosition(), getyPosition()+100);
		graphics2d.drawString("Course = "+COURSE_ANGLE, courseX, courseY+25);
		Stroke oldStroke = graphics2d.getStroke();
		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
		graphics2d.setStroke(dashed);
		graphics2d.drawLine(firstX, firstY, secondX, secondY);
		graphics2d.drawLine(getxPosition()+30/2, getyPosition()+30/2, courseX, courseY);
		graphics2d.setStroke(oldStroke);
		graphics2d.drawLine(getxPosition()+30/2, getyPosition()+30/2, getxPosition()+30/2, getyPosition()-RANGE*3);
		
		
		
		
	}

}
