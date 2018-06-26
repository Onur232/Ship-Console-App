package com.myconsole.scopeobjects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

import com.myconsole.gui.ScopePanel;
import com.myconsole.util.AngleConversion;
import com.myconsole.util.RandomGenerator;

public class ScopePanelController implements ActionListener {
	
	public static int SCOPE_REFRESH_TIME = 200;
	public static int SLEEP_TIME=200;
	
	private int courseChangerCounter=0;
	private final Timer scopeRefreshTimer=new Timer(SCOPE_REFRESH_TIME,this);
	private ScopePanel scopePanel;
	private ArrayList<ScopeObjects> scopeObjects;
	private Direction direction=Direction.SOUTH;
	
	private int stepX=0;
	private int stepY=0;

	private final double SPEED_REDUCE_FACTOR=0.3;
	
	public ScopePanelController(ScopePanel scopePanel) {
		this.scopePanel=scopePanel;
		this.scopeObjects=scopePanel.getScopeObjects();
		//ilk x ve y'si ortada olsun.
		initializeScopeLocations();
//		scopeRefreshTimer.start();
		scopeRefresherThread.start();
	}

	private void initializeScopeLocations() {
		scopePanel.initializeScopeLocations();
	}
	
	Thread scopeRefresherThread=new Thread(new Runnable() {
		
		@Override
		public void run() {
			while (true) {
				
				moveScopeObjectsToCourse();
				refreshScope();
				try {
					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
	});

	
	//timer'ýn actionPerfomed'u. kullanýlmýyor.
	@Override
	public void actionPerformed(ActionEvent e) {
		//her 10 saniyede bir yön deðiþtirsin.
		courseChangerCounter++;
		if (courseChangerCounter==40) {
			//direction'ý random olarak seç.
			direction=RandomGenerator.generateDirection();
			courseChangerCounter=0;
		}
//		setScopeObjectsLocation();
		moveScopeObjectsToCourse();
		refreshScope();
//		controlOutOfBounds();
//		controlOutOfBounds2();
	}

	private void controlOutOfBounds() {
		//object'in panel dýþýna kaçmasýný önler. 
		for (ScopeObjects scopeObject : scopeObjects) {
			if (scopeObject.getxPosition()>799) {
				scopeObject.setxPosition(scopeObject.getxPosition()-1);
			}
			if (scopeObject.getxPosition()<0) {
				scopeObject.setxPosition(scopeObject.getxPosition()+1);
			}
			if (scopeObject.getyPosition()>799) {
				scopeObject.setyPosition(scopeObject.getyPosition()-1);
			}
			if (scopeObject.getyPosition()<0) {
				scopeObject.setyPosition(scopeObject.getyPosition()+1);
			}
		}
	}
	
	private void controlOutOfBounds2() {
		//object'in panel dýþýna kaçmasýný önler.
		for (ScopeObjects scopeObject : scopeObjects) {
			if (scopeObject.getxPosition()>799) {
				direction=Direction.WEST;
			}
			if (scopeObject.getxPosition()<0) {
				direction=Direction.EAST;
			}
			if (scopeObject.getyPosition()>799) {
				direction=Direction.NORTH;
			}
			if (scopeObject.getyPosition()<0) {
				direction=Direction.SOUTH;
			}
		}
	}

	private void setScopeObjectsLocation() {
		for (ScopeObjects scopeObject : scopeObjects) {
//			scopeObject.setxPosition(scopeObject.getxPosition()+1);
//			scopeObject.setyPosition(scopeObject.getyPosition()+1);
			switch (direction) {
			case NORTH:
				scopeObject.setxPosition(scopeObject.getxPosition());
				scopeObject.setyPosition(scopeObject.getyPosition()-1);
				break;
			case SOUTH:
				scopeObject.setxPosition(scopeObject.getxPosition());
				scopeObject.setyPosition(scopeObject.getyPosition()+1);
				break;
			case EAST:
				scopeObject.setxPosition(scopeObject.getxPosition()+1);
				scopeObject.setyPosition(scopeObject.getyPosition());
				break;
			case WEST:
				scopeObject.setxPosition(scopeObject.getxPosition()-1);
				scopeObject.setyPosition(scopeObject.getyPosition());
				break;

			default:
				break;
			}
//			scopeObject.setxPosition(RandomGenerator.generateNumber(1000));
//			scopeObject.setyPosition(RandomGenerator.generateNumber(1000));
		}
	}
	
	
	private void moveScopeObjectsToCourse(){
		StartPointOfAngle startPointOfAngle=AngleConversion.moveToCourse(Target.COURSE_ANGLE);
		stepX=(int) startPointOfAngle.getxValue();
		stepY=(int) startPointOfAngle.getyValue();
		
		System.out.println(stepX+" "+stepY);
		
		for (ScopeObjects scopeObject : scopeObjects) {
			scopeObject.setxPosition(scopeObject.getxPosition()+stepX);
			scopeObject.setyPosition(scopeObject.getyPosition()-stepY);
			
			
		}
	}

	public void refreshScope() {
		scopePanel.repaint();
	}

}
