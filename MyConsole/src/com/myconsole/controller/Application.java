package com.myconsole.controller;
import javax.swing.SwingUtilities;

import com.myconsole.gui.MainFrame;

public class Application implements Runnable {
	
	

	public void start() {
		SwingUtilities.invokeLater(this);
	}

	@Override
	public void run() {
		MainFrame mainFrame=MainFrame.getInstance();
		mainFrame.setVisible(true);
	}

}
