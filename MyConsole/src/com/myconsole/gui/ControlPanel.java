package com.myconsole.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.myconsole.util.WidgetFactory;

public class ControlPanel extends JPanel {
	
	public static int TEXTFIELD_COLUMN=5;
	private JButton btnOk;
	private Map<String, JTextField> textFieldMap;
	private JButton btnResetAll;
	
	//TODO panelden týklanýnca açýlan dialog'a geç. Daha sonra ethernet'ten kontrol edilecek deðerler.
	public ControlPanel() {
		textFieldMap=new HashMap<>();
		initializeComponents();
	}

	private void initializeComponents() {
		setBackground(Color.DARK_GRAY);
//		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(4, 2));
		panel.setBackground(Color.DARK_GRAY);
		JLabel lblCourseAngle=WidgetFactory.createLabel("COURSE");
		JTextField txtCourseAngle=WidgetFactory.createTextField(TEXTFIELD_COLUMN);
		JLabel lblTosoAngle=WidgetFactory.createLabel("TOSO ANGLE");
		JTextField txtTosoAngle=WidgetFactory.createTextField(TEXTFIELD_COLUMN);
		JLabel lblSpeed=WidgetFactory.createLabel("SPEED"); 
		JTextField txtSpeed=WidgetFactory.createTextField(TEXTFIELD_COLUMN);
		JLabel lblRefreshTime=WidgetFactory.createLabel("Refresh Time(Speed)");
		JTextField txtRefreshTime=WidgetFactory.createTextField(TEXTFIELD_COLUMN);
		
		
		btnOk = new JButton("OK");
		btnResetAll = new JButton("Reset To Defaults");
		
		//default deðerler
		txtCourseAngle.setText("45");
		txtSpeed.setText("2");
		txtTosoAngle.setText("90");
		txtRefreshTime.setText("200");
		
		textFieldMap.put("course", txtCourseAngle);
		textFieldMap.put("speed", txtSpeed);
		textFieldMap.put("toso_angle", txtTosoAngle);
		textFieldMap.put("refresh_time", txtRefreshTime);
		
		
		panel.add(lblCourseAngle);
		panel.add(txtCourseAngle);
		panel.add(lblTosoAngle);
		panel.add(txtTosoAngle);
		panel.add(lblSpeed);
		panel.add(txtSpeed);
		panel.add(lblRefreshTime);
		panel.add(txtRefreshTime);
		add(panel);
		add(btnOk);
		add(btnResetAll);
		
	}
	
	public void addBtnOkListener(ActionListener actionListener){
		btnOk.addActionListener(actionListener);
	}
	
	public void addBtnResetListener(ActionListener actionListener){
		btnResetAll.addActionListener(actionListener);
	}

	
	
	public Map<String, JTextField> getTextFieldMap() {
		return textFieldMap;
	}

	public void setTextFieldMap(Map<String, JTextField> textFieldMap) {
		this.textFieldMap = textFieldMap;
	}
	
	

	
	
	
	
}
