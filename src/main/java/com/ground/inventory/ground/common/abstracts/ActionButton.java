package com.ground.inventory.ground.common.abstracts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.ground.inventory.FrmInvoice;

public class ActionButton implements ActionListener {
	private FrmInvoice form;
	public ActionButton(FrmInvoice form){
		this.form = form;
	}
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand == "add") {
			  System.out.println(form.getTfUsername().getText());
			  form.getTfUsername().setText(form.getTfUsername().getText()+"1");
		}

	}

}
