package lab2;

public class Users {
	private String useName;
	private String pass;
	private String role;

	public Users() {
		// TODO Auto-generated constructor stub
	}

	public Users(String user, String pass, String role) {
		super();
		this.useName = user;
		this.pass = pass;
		this.role = role;
	}

	public String getUser() {
		return useName;
	}

	public void setUser(String user) {
		this.useName = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
