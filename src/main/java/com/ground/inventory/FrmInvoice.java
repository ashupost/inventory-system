package com.ground.inventory;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.ground.inventory.ground.common.component.GDButton;

public class FrmInvoice extends JInternalFrame {
    private static final long serialVersionUID = 1L;
    
    private JTextField tfUsername = new JTextField();
    private JTextField tfPassword = new JTextField();
    
    private JLabel jLabelCustomerId   = new JLabel("Customer ID:");
    private JLabel jLabelCustomerName = new JLabel("Customer Name:");
    private JLabel jLabelCountry      = new JLabel("Country :");

    String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };

    // Create the combo box, select item at index 4.
    // Indices start at 0, so 4 specifies the pig.
    JComboBox<String> petList = new JComboBox<String>(petStrings);
    private static JScrollPane cusTableJScrollPane = new JScrollPane();
    private static JPanel JPanelContainer = new JPanel();
    private static JTable table;
    JFrame JFParentFrame;
    private static TableRowSorter<TableModel> sorter;

    GDButton JBAddNew = new GDButton("Add New", new ImageIcon("images/new.png"));

    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    public FrmInvoice(Connection srcCN, JFrame getParentFrame) throws SQLException {
	super("Invoice Records", false, true, false, true);

	// Start initialize variables
	JPanelContainer.setLayout(null);

	JFParentFrame = getParentFrame;

	// -- Add the JBAddNew
	// JBAddNew.setBounds(5, 482, 105, 25);
	JBAddNew.setFont(new Font("Dialog", Font.PLAIN, 12));
	JBAddNew.setMnemonic(KeyEvent.VK_A);
	// JBAddNew.addActionListener(new ActionButton(this));
	JBAddNew.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		String text = tfUsername.getText();
		if (text.length() == 0) {
		    sorter.setRowFilter(null);
		} else {
		    sorter.setRowFilter(RowFilter.regexFilter(text));
		}
	    }
	});

	JBAddNew.setActionCommand("add");
	JPanelContainer.add(JBAddNew);

	// -- Add Id Input Field
	jLabelCustomerId.setBounds(5, 50, 105, 25);
	jLabelCustomerId.setFont(new Font("Dialog", Font.BOLD, 12));

	
	jLabelCustomerName.setBounds(5, 80, 105, 25);
	jLabelCustomerName.setFont(new Font("Dialog", Font.PLAIN, 12));
	
	jLabelCountry.setBounds(5, 110, 200, 25);
	jLabelCountry.setFont(new Font("Dialog", Font.PLAIN, 12));

	// -- Add Name Input Field
	tfUsername.setBounds(110, 50, 200, 25);///////////////////////
	tfUsername.setFont(new Font("Dialog", Font.BOLD, 12));

	tfPassword.setBounds(110, 80, 200, 25);//////////////////////
	tfPassword.setFont(new Font("Dialog", Font.PLAIN, 12));
	
	petList.setBounds(110, 110, 200, 25);
	petList.setFont(new Font("Dialog", Font.PLAIN, 12));
	
	JPanelContainer.add(jLabelCustomerId);
	JPanelContainer.add(tfUsername);
	JPanelContainer.add(jLabelCountry);
	JPanelContainer.add(jLabelCustomerName);
	JPanelContainer.add(tfPassword);

	petList.setSelectedIndex(2);
	petList.setActionCommand("country");
	JPanelContainer.add(petList);
	petList.addItemListener(itemListener);

	// -- Add the CusTable
	table = CreateTable();
	cusTableJScrollPane.getViewport().add(table);
	cusTableJScrollPane.setBounds(10, 300, 427, 120);
	JPanelContainer.add(cusTableJScrollPane);

	// Start set the form properties
	getContentPane().add(JPanelContainer);
	setSize(947, 550);
	setLocation((screen.width - 947) / 2, ((screen.height - 550) / 2) - 90);
	setFrameIcon(new ImageIcon("images/customer.png"));
	// End set the form properties
    }

    public JTextField getTfUsername() {
	return tfUsername;
    }

    public void setTfUsername(JTextField tfUsername) {
	this.tfUsername = tfUsername;
    }

    ItemListener itemListener = new ItemListener() {
	public void itemStateChanged(ItemEvent e) {
	    // getItem returns an object so it gets cast as a String to retrieve
	    // the item value
	    String item = (String) e.getItem();
	    
	    if (e.getStateChange() == ItemEvent.SELECTED) {
		JOptionPane.showMessageDialog(null, "Selected : " + item, "No Record Selected", JOptionPane.INFORMATION_MESSAGE);
	    } 
	}
    };

    // private methods
    public static JTable CreateTable() {
	Object rows[][] = { { "A", "About", 44.36 }, { "B", "Boy", 44.84 },
		{ "C", "Cat", 463.63 }, { "D", "Days", 27.14 },
		{ "E", "Eat", 44.57 }, { "F", "Fail", 23.15 },
		{ "G", "Good", 4.40 }, { "H", "Hot", 24.96 },
		{ "I", "Ivey", 5.45 }, { "J", "Aack", 49.54 },
		{ "K", "Kids", 280.00 } };
	String columns[] = { "Symbol", "Name", "Price" };

	TableModel model = new DefaultTableModel(rows, columns) {
	    private static final long serialVersionUID = 1L;

	    public Class<?> getColumnClass(int column) {
		Class<?> returnValue;
		if ((column >= 0) && (column < getColumnCount())) {
		    returnValue = getValueAt(0, column).getClass();
		} else {
		    returnValue = Object.class;
		}
		return returnValue;
	    }
	};
	final JTable table = new JTable(model);
	sorter = new TableRowSorter<TableModel>(model);
	table.setRowSorter(sorter);
	return table;
    }
}