package com.myconsole.gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.myconsole.scopeobjects.Ownship;
import com.myconsole.scopeobjects.ScopeObjects;
import com.myconsole.scopeobjects.Target;

public class ScopePanel extends JPanel{
	
	private ArrayList<ScopeObjects> scopeObjects;
	private static ScopePanel instance=new ScopePanel();
	
	public static ScopePanel getInstance(){
		return instance;
	}
	
	
	private ScopePanel(){
		initializeComponents();
	}

	private void initializeComponents() {
		setScopeObjects(new ArrayList<>());
		scopeObjects.add(new Ownship());
		scopeObjects.add(new Target());
		setBackground(Color.BLACK);
		
	}

	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		Graphics2D graphics2d=(Graphics2D) g;
		drawAllScopeObjects(graphics2d);
	}

	private void drawAllScopeObjects(Graphics2D graphics2d) {
		for (ScopeObjects scopeObject : getScopeObjects()) {
			scopeObject.drawObject(graphics2d);
		}
	}

	public ArrayList<ScopeObjects> getScopeObjects() {
		return scopeObjects;
	}

	public void setScopeObjects(ArrayList<ScopeObjects> scopeObjects) {
		this.scopeObjects = scopeObjects;
	}


	public void initializeScopeLocations() {
		for (ScopeObjects scopeObject : scopeObjects) {
			scopeObject.setxPosition(400);
			scopeObject.setyPosition(400);
			
		}
	}
	
}
