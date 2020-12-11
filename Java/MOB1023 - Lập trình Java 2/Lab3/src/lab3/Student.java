package lab3;

public class Student {
	public String name;
	public double marks;
	public String major;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, double marks, String major) {
		super();
		this.name = name;
		this.marks = marks;
		this.major = major;
	}

	public String getName() {
		return name;
	}
	
	public String stringMarks() {
		return Double.toString(marks);
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

	public String getGrade(double diem) {
		if (diem < 3) {
			return "Kém";
		}
		if (diem < 5) {
			return "Yếu";
		}
		if (diem < 6.5) {
			return "Trung bình";
		}
		if (diem < 7.5) {
			return "Khá";
		}
		if (diem < 9) {
			return "Giỏi";
		}
		return "Xuất sắc";
	}
	
	public boolean isBonus(double diem){
		return diem >= 7.5;
		}


}
