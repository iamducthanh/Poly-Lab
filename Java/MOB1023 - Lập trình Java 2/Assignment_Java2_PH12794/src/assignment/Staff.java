package assignment;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Staff implements Serializable {
	private String code;
	private String name;
	private int age;
	private String email;
	private double salary;

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String code, String name, int age, String email, double salary) {
		super();
		this.code = code;
		this.name = name;
		this.age = age;
		this.email = email;
		this.salary = salary;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
