package com.ground.inventory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AutoSuggest extends JPanel {
    private static final long serialVersionUID = 1L;
    private final JTextField tf;
    private final JComboBox<String> combo = new JComboBox<String>();
    private final Vector<String> v = new Vector<String>();

    public AutoSuggest() {
	super(new BorderLayout());
	combo.setEditable(true);
	tf = (JTextField) combo.getEditor().getEditorComponent();

	tf.addKeyListener(new KeyAdapter() {
	    public void keyTyped(KeyEvent e) {
		EventQueue.invokeLater(new Runnable() {
		    public void run() {
			String text = tf.getText();
			if (text.length() == 0) {
			    combo.hidePopup();
			    setModel(new DefaultComboBoxModel<String>(v), "");
			} else {
			    DefaultComboBoxModel<String> m = getSuggestedModel(
				    v, text);
			    if (m.getSize() == 0 || hide_flag) {
				combo.hidePopup();
				hide_flag = false;
			    } else {
				setModel(m, text);
				combo.showPopup();
			    }
			}
		    }
		});
	    }

	    public void keyPressed(KeyEvent e) {
		String text = tf.getText();
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_ENTER) {
		    if (!v.contains(text)) {
			v.addElement(text);
			Collections.sort(v);
			setModel(getSuggestedModel(v, text), text);
		    }
		    hide_flag = true;
		} else if (code == KeyEvent.VK_ESCAPE) {
		    hide_flag = true;
		} else if (code == KeyEvent.VK_RIGHT) {
		    int vSize = v.size();
		    for (int i = 0; i < vSize; i++) {
			String str = v.elementAt(i);
			if (str.startsWith(text)) {
			    combo.setSelectedIndex(-1);
			    tf.setText(str);
			    return;
			}
		    }
		}
	    }
	});

	String[] countries = { "Afghanistan", "Albania", "Algeria", "Andorra",
		"Angola", "Argentina", "Armenia", "Austria", "Bahamas",
		"Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
		"Benin", "Bhutan", "Bolivia", "Bosnia & Herzegovina",
		"Botswana", "Brazil", "Bulgaria", "Burkina Faso", "Burma",
		"Burundi", "Cambodia", "Cameroon", "Canada", "China",
		"Colombia", "Comoros", "Congo", "Croatia", "Cuba", "Cyprus",
		"Czech Republic", "Denmark", "Georgia", "Germany", "Ghana",
		"Great Britain", "Greece", "Hungary", "Holland", "India",
		"Iran", "Iraq", "Italy", "Somalia", "Spain", "Sri Lanka",
		"Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland",
		"Syria", "Uganda", "Ukraine", "United Arab Emirates",
		"United Kingdom", "United States", "Uruguay", "Uzbekistan",
		"Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zaire", "Zambia",
		"Ar1", "Ar2", "Ar3", "Ar4", "Ar5", "Ar6", "Ar7", "Ar8", "Ar9",
		"Ar10", null, "Ar12", "Ar13", "Ar14", "Zimbabwe" };
	for (int i = 0; i < countries.length; i++) {
	    v.addElement(countries[i]);
	}
	setModel(new DefaultComboBoxModel<String>(v), "");
	JPanel p = new JPanel(new BorderLayout());
	p.setBorder(BorderFactory.createTitledBorder("AutoSuggestion Box"));
	p.add(combo, BorderLayout.NORTH);
	add(p);
	setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
	setPreferredSize(new Dimension(300, 150));
    }

    private boolean hide_flag = false;

    private void setModel(DefaultComboBoxModel<String> mdl, String str) {
	combo.setModel(mdl);
	combo.setSelectedIndex(-1);
	tf.setText(str);
    }

    private static DefaultComboBoxModel<String> getSuggestedModel(Vector<String> list, String text) {
	List<String> filtered = list.stream().filter(p -> p != null).filter(x -> x.toLowerCase().startsWith(text.toLowerCase())).collect(Collectors.toList());
	return new DefaultComboBoxModel<String>(new Vector<String>(filtered));
    }

    public static void main(String[] args) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.getContentPane().add(new AutoSuggest());
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
    }
}