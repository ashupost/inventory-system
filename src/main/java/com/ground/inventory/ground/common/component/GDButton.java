package com.ground.inventory.ground.common.component;

import javax.swing.Icon;
import javax.swing.JButton;

public class GDButton extends JButton  {

	private static final long serialVersionUID = 1L;
	

	public GDButton(String text, Icon icon) {
		super(text, icon);
		setBounds(5, 482, 105, 25);
	}

}