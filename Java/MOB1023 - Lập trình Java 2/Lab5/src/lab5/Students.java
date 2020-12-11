package lab5;

import java.io.Serializable;

public class Students implements Serializable {
	private String name;
	private double marks;
	private String major;

	public Students() {
		// TODO Auto-generated constructor stub
	}

	public Students(String name, double marks, String major) {
		super();
		this.name = name;
		this.marks = marks;
		this.major = major;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getGrade(double marks) {
		if (marks < 3) {
			return "Kém";
		}
		if (marks < 5) {
			return "Yếu";
		}
		if (marks < 6.5) {
			return "Trung bình";
		}
		if (marks < 7.5) {
			return "Khá";
		}
		if (marks < 9) {
			return "Giỏi";
		}
		return "Xuất sắc";
	}

	public boolean isBonus(double marks) {
		return marks >= 7.5;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", marks=" + marks + ", major=" + major + "]";
	}

}
