package com.myconsole.scopeobjects;
import java.awt.Graphics2D;

public abstract class ScopeObjects {
	
	private int xPosition;
	private int yPosition;
	public static final int TOSO_WIDTH=100;
	public static final int TOSO_HEIGHT=100;
	
	public abstract void drawObject(Graphics2D graphics2d);
	
	public int getxPosition() {
		return xPosition;
	}
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	
	
}
