package com.myconsole.util;

import com.myconsole.scopeobjects.StartPointOfAngle;
import com.myconsole.scopeobjects.Target;

public class AngleConversion {
	
	public static StartPointOfAngle convertAngleToWidthAndHeight(int angle){
		StartPointOfAngle startPointOfAngle=new StartPointOfAngle();
		double radian=degreeToRadian(angle/2);
		startPointOfAngle.setxValue( Math.sin(radian)*Target.RANGE);
		startPointOfAngle.setyValue( Math.cos(radian)*Target.RANGE);
//		startPointOfAngle.setyValue( Math.sin(90-angle)*Target.RANGE);
		return startPointOfAngle;
	}
	
	
	public static double degreeToRadian(int angle){
		double radian=0;
		radian=0.01745*angle;
		return radian;
	}

	public static StartPointOfAngle calculateCourse(int angle){
		StartPointOfAngle startPointOfAngle=new StartPointOfAngle();
		double radian=degreeToRadian(angle);
		startPointOfAngle.setxValue( Math.sin(radian)*Target.RANGE);
		startPointOfAngle.setyValue( Math.cos(radian)*Target.RANGE);
		return startPointOfAngle;
	}
	
	public static StartPointOfAngle moveToCourse(int angle){
		StartPointOfAngle startPointOfAngle=new StartPointOfAngle();
		double radian = degreeToRadian(angle);
		startPointOfAngle.setxValue( Math.sin(radian)*Target.SPEED);
		startPointOfAngle.setyValue( Math.cos(radian)*Target.SPEED);
		return startPointOfAngle;
	}
	
}
