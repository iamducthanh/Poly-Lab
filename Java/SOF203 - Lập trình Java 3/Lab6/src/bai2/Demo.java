package bai2;

import java.util.*;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Demo extends javax.swing.JFrame {
	boolean addNew = false;
	boolean fill = false;
	Vector data = new Vector();
	Vector header = new Vector();
	Vector col = new Vector();
	Connection con = null;
	PreparedStatement pstDetails = null;
	PreparedStatement pstInsert = null;
	PreparedStatement pstDelete = null;
	PreparedStatement pstUpdate = null;
	String sqlInsert = "Insert into Students ([Name],Address,ParentName,Phone,standard) values(?,?,?,?,?)";
	String sqlDelete = "Delete from Students where Name=?";
	String sqlUpdate = "Update Students set Address=?, ParentName=?,Phone=? ,standard=? where Name=?";
	ResultSet rts;

	/** Creates new form Assignment */
	public Demo() {
		getComponents();
		// this.cbMID.setVisible(false);
		// this.pnlDetails.setVisible(false);
		// connect database
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager
					.getConnection("jdbc:sqlserver://localhost:1433;database=KIDSZONESCHOOL;userName=sa;password=123");
			pstInsert = con.prepareStatement(this.sqlInsert);
			pstUpdate = con.prepareStatement(this.sqlUpdate);
			pstDelete = con.prepareStatement(this.sqlDelete);
			pstDetails = con.prepareStatement("select * from Students", ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			rts = pstDetails.executeQuery();
			JOptionPane.showMessageDialog(this, "Connection Database Successful!");
			loadCombobox();
			this.loadData();
			fill = true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
		btnUpdate.setEnabled(false);
	}

	private void loadCombobox() {
		String sql1 = "select * from Standards";
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql1);
			Vector<String> standards = new Vector<String>();
			Vector<Integer> fees = new Vector<Integer>();
			while (rs.next()) {
				cbb_Stan.addItem(rs.getString(1));
				cbb_Fees.addItem(rs.getInt(2));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			System.exit(0);
		}
	}

	private void loadData() throws SQLException {
		String sql = "Select [Name], standard from Students";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			data.removeAllElements();
			if (!fill) {
				// get header
				ResultSetMetaData rsmd = rs.getMetaData();
				int n = rsmd.getColumnCount();

				col.add(rsmd.getColumnName(1));
				col.add(rsmd.getColumnName(2));
			}
			// get data
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString(1));
				v.add(rs.getString(2));
				data.add(v);
			}
			TableModel tbl = new DefaultTableModel(data, col);
			this.tblStudent.setModel(tbl);
			rs.close();
			st.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}

	boolean validates() {
		if (txt_Name.getText().matches("^\\w+$") == false) {
			JOptionPane.showMessageDialog(this, "Name ko dc trong ", "Chu y", 1);
			txt_Name.requestFocus();
			return false;
		}
		String pName = this.txt_Name.getText().trim();
		Iterator it = data.iterator();
		while (it.hasNext()) {
			Vector v = (Vector) it.next();
			String name = ((String) v.get(0)).trim();
			if (pName.equalsIgnoreCase(name)) {
				JOptionPane.showMessageDialog(this, "Ten Sinh Vien nay da ton tai!");
				this.txt_Name.grabFocus();
				return false;
			}
		}
		if (txt_Address.getText().matches("^\\w+$") == false) {
			JOptionPane.showMessageDialog(this, "Address khong duoc de trong ", "Chu y", 1);
			txt_Address.requestFocus();
			return false;
		}
		if (txt_PName.getText().matches("^\\w+$") == false) {
			JOptionPane.showMessageDialog(this, "ParentsName khong duoc de trong ", "Chu y", 1);
			txt_PName.requestFocus();
			return false;
		}

		if (txt_Con.getText().matches("^\\d{7,11}$") == false) {
			JOptionPane.showMessageDialog(this, "Contact(Phone) khong duoc de trong va phai la 7-12 so ", "Chu y", 1);
			txt_Con.requestFocus();
			return false;
		}
		if ((cbb_Stan.getSelectedIndex() == 0)) {
			JOptionPane.showMessageDialog(this, cbb_Stan.getSelectedItem());
		}
		return true;
	}

	boolean duplicate(String s) {
		if (addNew == false)
			return false;
		for (int i = 0; i < data.size(); i++) {
			Vector v = (Vector) data.get(i);
			if (s.equalsIgnoreCase((String) v.get(0)))
				return true;
		}
		return false;
	}

	private void clearForm() {
		txt_Name.setText("");
		txt_Address.setText("");
		txt_PName.setText("");
		txt_Con.setText("");
		cbb_Stan.setSelectedIndex(0);
		cbb_Fees.setSelectedIndex(0);
		txt_Name.requestFocus();
	}

	private void cbb_StanActionPerformed(java.awt.event.ActionEvent evt) {
		cbb_Fees.setSelectedIndex(cbb_Stan.getSelectedIndex());
	}

	private void cbb_FeesActionPerformed(java.awt.event.ActionEvent evt) {
		cbb_Stan.setSelectedIndex(cbb_Fees.getSelectedIndex());
	}

	private void tblStudentMouseReleased(java.awt.event.MouseEvent evt) {
		if (this.tblStudent.getCellEditor() != null)
			this.tblStudent.getCellEditor().cancelCellEditing();
	}

	private void tblStudentMouseClicked(java.awt.event.MouseEvent evt) {
		// TODO add your handling code here:
		try {
			rts.beforeFirst();
			this.clearForm();
			int row = tblStudent.getSelectedRow();
			String name = (String) tblStudent.getValueAt(row, 0);
			while (rts.next()) {
				String str = rts.getString(2); // JOptionPane.showMessageDialog(null,""+jrs.getString(2)+" "+name);
				if (str.equalsIgnoreCase(name)) {
					txt_Name.setText(rts.getString(2));
					txt_Address.setText(rts.getString(3));
					txt_Con.setText(rts.getInt(5) + "");
					// String parent=dencry(rts.getString(5));
					txt_PName.setText(rts.getString(4));
					cbb_Stan.setSelectedItem(rts.getString(6));
					// com_fees.setSelectedItem(rts.getInt(7));
					break;
				}
			}
		} catch (Exception e) {
		}
		txt_Name.setEnabled(false);
		txt_Address.setEnabled(false);
		txt_PName.setEnabled(false);
		txt_Con.setEnabled(false);
		cbb_Stan.setEnabled(false);
		cbb_Fees.setEnabled(false);
	}

	private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			int n;
			if (addNew) {
				// them moi
				// set cac tham so
				pstInsert.setString(1, this.txt_Name.getText().trim());
				pstInsert.setString(2, txt_Address.getText().trim());
				pstInsert.setString(3, txt_PName.getText().trim());
				pstInsert.setString(4, txt_Con.getText().trim());
				pstInsert.setString(5, (String) cbb_Stan.getSelectedItem());
				n = pstInsert.executeUpdate();// thuc thi
				this.loadData();
			} else {
				// update
				// set cac tham so
				pstUpdate.setString(5, this.txt_Name.getText().trim());
				pstUpdate.setString(2, this.txt_Address.getText().trim());
				pstUpdate.setString(1, this.txt_PName.getText().trim());
				pstUpdate.setString(3, this.txt_Con.getText().trim());
				pstUpdate.setString(4, (String) cbb_Stan.getSelectedItem());
				n = pstUpdate.executeUpdate();// thuc thi
				this.loadData();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
		clearForm();
		txt_Name.setEnabled(true);
		txt_Address.setEnabled(true);
		txt_PName.setEnabled(true);
		txt_Con.setEnabled(true);
		cbb_Fees.setEnabled(true);
		cbb_Stan.setEnabled(true);
		txt_Name.requestFocus();
	}

	private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
		btnUpdate.setEnabled(true);
		btnCancel.setEnabled(true);
		btnEdit.setEnabled(true);
		txt_Name.setEnabled(true);
		txt_Address.setEnabled(true);
		txt_PName.setEnabled(true);
		txt_Con.setEnabled(true);
		cbb_Stan.setEnabled(true);
	}

	private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			// JOptionPane.showMessageDialog(this, "Co loi xay ra");
			rts.previous();
			// JOptionPane.showMessageDialog(this, "Co loi xay ra");
			btnNext.setEnabled(true);
			if (rts.isBeforeFirst()) {
				// System.out.println("co loi xay ra");
				btnPre.setEnabled(false);
				btnNext.setEnabled(true);
				JOptionPane.showMessageDialog(null, "You have reached the first record " + "of the ResultSet!!!!");
			} else {
				txt_Name.setText(rts.getString(2));
				txt_Address.setText(rts.getString(3));
				txt_PName.setText(rts.getString(4));
				txt_Con.setText(rts.getString(5));
				cbb_Stan.setSelectedItem(rts.getString(6));
			}
		} catch (Exception e) {
			// JOptionPane.showConfirmDialog(this,"co loi xay ra");
		}
	}

	private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
		// loadCombobox();
		try {
			rts.next();
			btnPre.setEnabled(true);
			if (rts.isAfterLast() || rts.isBeforeFirst()) {
				btnNext.setEnabled(false);
				btnPre.setEnabled(true);
				JOptionPane.showMessageDialog(null, "You have reached the last record" + " of the ResultSet!!!!");
			} else {
				txt_Name.setText(rts.getString(2));
				txt_Address.setText(rts.getString(3));
				txt_PName.setText(rts.getString(4));
				txt_Con.setText(rts.getString(5));
				cbb_Stan.setSelectedItem(rts.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
		fill = false;
		System.exit(0);
	}

	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			int n = this.tblStudent.getSelectedRow();
			if (n >= 0)// nguoi dung co chon
			{
				// this.pnlDetails.setVisible(false);
				Vector v = (Vector) data.get(n);
				int ans = JOptionPane.showConfirmDialog(this,
						"Ban co thuc su muon xoa Sinh Vien " + ((String) v.get(0)).trim() + " khong?");
				if (ans == JOptionPane.YES_OPTION) {
					pstDelete.setString(1, (String) v.get(0));
					pstDelete.executeUpdate();
					this.loadData();
				}
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}

	private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {
		if (!validates())
			return;
		String name = txt_Name.getText();
		String addr = txt_Address.getText();
		String parentName = txt_PName.getText();
		String phone = txt_Con.getText();
		String standard = (String) cbb_Stan.getSelectedItem();
		try {
			pstInsert.setString(1, name);
			pstInsert.setString(2, addr);
			pstInsert.setString(3, parentName);
			pstInsert.setString(4, phone);
			pstInsert.setString(5, standard);
			int addRows = pstInsert.executeUpdate();
			this.loadData();
			clearForm();
			if (addRows > 0)
				JOptionPane.showMessageDialog(this, "Students Details Have Been Save", "Successfull",
						JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Failed to save data in database", "Error", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Demo().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnEdit;
	private javax.swing.JButton btnExit;
	private javax.swing.JButton btnInsert;
	private javax.swing.JButton btnNext;
	private javax.swing.JButton btnPre;
	private javax.swing.JButton btnUpdate;
	private javax.swing.JComboBox cbb_Fees;
	private javax.swing.JComboBox cbb_Stan;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable tblStudent;
	private javax.swing.JTextArea txt_Address;
	private javax.swing.JTextField txt_Con;
	private javax.swing.JTextField txt_Name;
	private javax.swing.JTextField txt_PName;
	// End of variables declaration
}
