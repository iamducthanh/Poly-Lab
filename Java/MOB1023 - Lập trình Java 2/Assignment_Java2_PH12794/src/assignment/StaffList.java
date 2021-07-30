package assignment;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StaffList {
	public static ArrayList<Staff> listStaffs = new ArrayList<Staff>();
	public int i;

	@SuppressWarnings("unchecked")
	public void open(String path) throws IOException {
		listStaffs = (ArrayList<Staff>) XFile.readObject(path);
	}

	public void save(String path) throws IOException {
		XFile.writeObject(listStaffs,path);
		JOptionPane.showMessageDialog(null, "Save thành công!");
	}

	public static void addList(String code, String name, int age, String email, double salary) {
		listStaffs.add(new Staff(code, name, age, email, salary));
	}
	
	public void delete(int staffIndex) {
		JOptionPane.showMessageDialog(null, "Đã xóa nhân viên: " + listStaffs.get(staffIndex).getCode());
		listStaffs.remove(staffIndex);
	}

	public void setList(int index) {
		int lastIndex = listStaffs.size() - 1;
		listStaffs.get(index).setCode(listStaffs.get(lastIndex).getCode());
		listStaffs.get(index).setName(listStaffs.get(lastIndex).getName());
		listStaffs.get(index).setAge(listStaffs.get(lastIndex).getAge());
		listStaffs.get(index).setEmail(listStaffs.get(lastIndex).getEmail());
		listStaffs.get(index).setSalary(listStaffs.get(lastIndex).getSalary());
		listStaffs.remove(lastIndex);
		JOptionPane.showMessageDialog(null, "Update thành công!");
	}

	public static DefaultTableModel fillTable(DefaultTableModel model) {
		DecimalFormat fmSalary = new DecimalFormat("#,###");
		model.setRowCount(0);
		listStaffs.forEach((o1) -> {
			model.addRow(new Object[] { o1.getCode(), o1.getName(), o1.getAge(), o1.getEmail(),
					fmSalary.format(o1.getSalary()) });
		});

		return model;
	}

	public int first() {
		i = 0;
		return i;
	}

	public int previous() {
		if (i == 0) {
			i = listStaffs.size() - 1;
		} else {
			i--;
		}
		return i;
	}

	public int next() {
		if (i == listStaffs.size() - 1) {
			i = 0;
		} else {
			i++;
		}
		return i;
	}

	public int last() {
		i = listStaffs.size() - 1;
		return i;
	}

}
