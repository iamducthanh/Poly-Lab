package com.edusys.helper;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormHelper {
	
	public static void clear(List<JTextField> list) {
		list.forEach((textFiled) -> {
			textFiled.setText("");
		});
	}
	
	public static void display(ArrayList<JTextField> list, DefaultTableModel model, int r, JTable table) {
		for(int i = 0; i< list.size();i++) {
			list.get(i).setText((String) model.getValueAt(r, i));
		}
		table.setRowSelectionInterval(r, r);
	}
	
	public static Image resize(Image image, int width, int height) {
		Image reImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		return reImage;
	}

	
}
