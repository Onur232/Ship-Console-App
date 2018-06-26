package com.myconsole.gui;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import com.myconsole.controller.ControlPanelController;
import com.myconsole.scopeobjects.ScopePanelController;

public class MainFrame extends JFrame{
	
	private JFrame frame;
	private ControlPanel controlPanel;
	private ScopePanel scopePanel;
	private static MainFrame mainFrame=new MainFrame();
	
	private MainFrame() {
		initializeComponents();
	}
	
	//Singleton
	public static MainFrame getInstance(){
		return mainFrame;
	}
	

	private void initializeComponents() {
		frame = new JFrame("My Console");
		frame.setSize(800, 800);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		scopePanel = ScopePanel.getInstance();
		ScopePanelController scopePanelController=new ScopePanelController(scopePanel);
		
		controlPanel = new ControlPanel();
		ControlPanelController controlPanelController=new ControlPanelController(this);
		frame.add(controlPanel, BorderLayout.WEST);
		frame.add(scopePanel,BorderLayout.CENTER);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	public ControlPanel getControlPanel() {
		return controlPanel;
	}

	public void setControlPanel(ControlPanel controlPanel) {
		this.controlPanel = controlPanel;
	}

	public ScopePanel getScopePanel() {
		return scopePanel;
	}

	public void setScopePanel(ScopePanel scopePanel) {
		this.scopePanel = scopePanel;
	}

}
