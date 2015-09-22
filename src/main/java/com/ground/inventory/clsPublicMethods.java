package com.ground.inventory;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.io.EOFException;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class clsPublicMethods {

	public static boolean recordExist(String strSQL, Connection connection){
		Statement statement;
		ResultSet resultSet;
		int total = 0;
		try{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(strSQL);
			//Move to the last record
			resultSet.afterLast(); 
			//Get the current record position
			if(resultSet.previous()){
				total = resultSet.getRow();
			}else{
				total = 0;
			}
		}catch(SQLException sqlEx){
				System.out.println("\nERROR IN clsPublicMethods(recordExist):" + sqlEx + "\n");
			}
		resultSet = null;
		statement = null;
		if(total == 0){
			return false;
		}else{
			return true;
		}
	}

	public static int getMaxNum(String strSQL, Connection connection, String columnLabel){
		Statement statement;
		ResultSet resultSet;
		int max = 0;
		try{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(strSQL);
			//Move to the last record
			resultSet.afterLast(); 
			//Get the current record position
			if(resultSet.previous()){
				max = resultSet.getInt(columnLabel);
			}else{
				max = 0;
			}
		}catch(SQLException sqlEx){
				System.out.println("\nERROR IN clsPublicMethods(getMaxNum):" + sqlEx + "\n");
			}
		
		resultSet = null;
		statement = null;
		return max;
	}
	
	public static JComboBox fillCombo(String strSQL,Connection connection,String columnLabel){
		Statement statement;
		ResultSet resultSet;
		String comboList[] =new String[0];
		int totalRowNumber = 0;
		int rowNum = 0;
		try{
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(strSQL);
			resultSet.afterLast();
			//Get the current record position
			if(resultSet.previous())totalRowNumber = resultSet.getRow();
			//Move back to the first record; 
			resultSet.beforeFirst();
			if(totalRowNumber > 0){
				comboList = new String[totalRowNumber];				
				while(resultSet.next()){
					comboList[rowNum] = "" + resultSet.getString(columnLabel);
					rowNum++;
				}
			}else{
				comboList[0] ="";
			}
		}catch(SQLException sqlEx){
				System.out.println("\nERROR IN clsPublicMethods(fillCombo):" + sqlEx + "\n");
			}
		resultSet = null;
		statement = null;
		totalRowNumber=0;
		return new JComboBox(comboList);
	}
	
	public void printRecord (String rec,JFrame JFMainParent) {

		StringReader SRReader = new StringReader (rec);
		LineNumberReader LNRReader = new LineNumberReader (SRReader);
		Font typeface = new Font ("Courier New", Font.PLAIN,10);
		PrintJob PJPrint = Toolkit.getDefaultToolkit().getPrintJob (JFMainParent, "", new Properties());

		if (PJPrint != null) {
			Graphics GGraph = PJPrint.getGraphics ();
			if (GGraph != null) {
				FontMetrics FMFont = GGraph.getFontMetrics (typeface);
				int PAGE_HEIGHT = PJPrint.getPageDimension().height - 75;
    				int FONT_HEIGHT = FMFont.getHeight();
	    			int FONT_DESCENT = FMFont.getDescent();
    				int CURRENT_HEIGHT = 75;
				String NEXT_LINE;
				GGraph.setFont (typeface);

				try {
					do {
						NEXT_LINE = LNRReader.readLine ();
						if (NEXT_LINE != null) {         
							if ((CURRENT_HEIGHT + FONT_HEIGHT) > PAGE_HEIGHT) {
								GGraph.dispose();
								GGraph = PJPrint.getGraphics ();
								CURRENT_HEIGHT = 75;
							}							
							CURRENT_HEIGHT += FONT_HEIGHT;
							if (GGraph != null) {
								GGraph.setFont (typeface);
								GGraph.drawString (NEXT_LINE, 75, CURRENT_HEIGHT - FONT_DESCENT);
							}
						}
					}
					while (NEXT_LINE != null);					
				}
				catch (EOFException EOF_EXCEPTION) { }
				catch (Throwable TROW_ERR) { }
			}
			GGraph.finalize();
			GGraph.dispose();
		}
		if (PJPrint != null)
			PJPrint.end ();
	}
}