package com.ground.inventory.ground.common.abstracts;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public abstract class GDAbstractMainJFrame extends JFrame implements WindowListener {
	
	private static final long serialVersionUID = 1L;
	private JLabel BusinessTitleLabel = new JLabel();
	private JDesktopPane desktopPane  = new JDesktopPane();
	
	
	protected boolean isLoaded(String FormTitle) {
			JInternalFrame Form[] = getDesktopPane().getAllFrames();
			for (int i = 0; i < Form.length; i++) {
				if (Form[i].getTitle().equalsIgnoreCase(FormTitle)) {
					Form[i].show();
					try {
						Form[i].setIcon(false);
						Form[i].setSelected(true);
					} catch (PropertyVetoException e) {
						e.printStackTrace();
					}
					return true;
				}
			}
			return false;
		}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	public GDAbstractMainJFrame(String title) throws HeadlessException {
		super(title);
	}
	
	public JLabel getBusinessTitleLabel() {
		return BusinessTitleLabel;
	}

	
	public void setBusinessTitleLabel(JLabel businessTitleLabel) {
		BusinessTitleLabel = businessTitleLabel;
	}

	// Interface event from WindowListener start
	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		UnloadWindow();
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
	
	protected void UnloadWindow() {
		String ObjButtons[] = { "Yes", "No" };
		int PromptResult = JOptionPane.showOptionDialog(null,
				"Are you sure you want to exit?",
				"MHTSOFTWARE Inventory System", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[0]);
		if (PromptResult == 0) {
			System.out.println("\n\n"
					+ " ------------------------------------------------------------\n\n"
					+ " THANK YOU FOR USING NAPARANSOFT INVENTORY SYSTEM VERSION 1.1\n\n"
					+ " ------------------------------------------------------------\n\n"
					+ " Programmer: Philip V. Naparan\n"
					+ " Address: Apo Sandawa Homes Phase 1 Block 6 Lot 18\n"
					+ " City/Province: Kidapawan\n"
					+ " Zip Code: 9400\n"
					+ " Country: Philippines\n"
					+ " Website: www.naparansoft.cjb.net\n"
					+ " Email Address: philipnaparan@yahoo.com\n"
					+ " Contact No: 639186443161\n\n"
					+ " ------------------------------------------------------------\n"
					+ " ITOY 100% GAWANG PINOY! MABUHAY ANG MGA PINOY!\n"
					+ " PLS. DONT FORGET TO VOTE THIS AT www.pscode.com!\n"
					+ " ------------------------------------------------------------\n"
					+ "\n\n");
			System.exit(0);
		}
	}

}
