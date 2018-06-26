package com.myconsole.util;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class WidgetFactory {
	
	public static JLabel createLabel(String text){
		JLabel label=new JLabel(text);
		label.setForeground(Color.GREEN);
		return label;
	}
	
	public static JTextField createTextField(int column){
		JTextField textField=new JTextField(column);
		return textField;
		
		
	}
	

}
