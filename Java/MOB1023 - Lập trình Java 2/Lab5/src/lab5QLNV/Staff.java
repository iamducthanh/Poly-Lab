package lab5QLNV;

import java.io.Serializable;

public class Staff implements Serializable {
	private String fullName;
	private double salary;

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String fullname, double salary) {
		super();
		this.fullName = fullname;
		this.salary = salary;
	}

	public String getFullname() {
		return fullName;
	}

	public void setFullname(String fullname) {
		this.fullName = fullname;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
