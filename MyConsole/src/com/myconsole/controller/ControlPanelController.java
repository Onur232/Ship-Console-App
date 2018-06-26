package com.myconsole.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTextField;

import com.myconsole.gui.ControlPanel;
import com.myconsole.gui.MainFrame;
import com.myconsole.gui.ScopePanel;
import com.myconsole.scopeobjects.ScopePanelController;
import com.myconsole.scopeobjects.Target;

public class ControlPanelController {
	
	ControlPanel controlPanel;
	ScopePanel scopePanel;
	Map<String, JTextField> textFields;

	public ControlPanelController(MainFrame mainFrame) {
		textFields=new HashMap<>();
		this.controlPanel=mainFrame.getControlPanel();
		this.scopePanel=mainFrame.getScopePanel();
		registerListeners();
	}

	private void registerListeners() {
		controlPanel.addBtnOkListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textFields=controlPanel.getTextFieldMap();
				Target.COURSE_ANGLE=Integer.valueOf(textFields.get("course").getText());
				Target.SPEED=Integer.valueOf(textFields.get("speed").getText());
				Target.TOSO_ANGLE=Integer.valueOf(textFields.get("toso_angle").getText());
				ScopePanelController.SLEEP_TIME=Integer.valueOf(textFields.get("refresh_time").getText());
			}
		});
		
		controlPanel.addBtnResetListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				scopePanel.initializeScopeLocations();
			}
		});
		
	}
	
	

}
