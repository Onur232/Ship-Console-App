package com.myconsole.program;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.myconsole.controller.Application;

public class Driver {
	
	static{
		LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
		try {
			UIManager.setLookAndFeel(installedLookAndFeels[3].getClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Application application=new Application();
		application.start();
	}

}
