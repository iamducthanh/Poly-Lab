package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Users;
import help.DataBaseConnection;

public class UserDao {
	@SuppressWarnings("unlikely-arg-type")
	public static ArrayList<Users> loadUser() throws ClassNotFoundException, SQLException {
		ArrayList<Users> listUser = new ArrayList<Users>();
		Connection connection = DataBaseConnection.Connect();
		Statement statement = connection.createStatement();
		ResultSet tbUser = statement.executeQuery("SELECT * FROM NguoiDung");
		while (tbUser.next()) {
			listUser.remove(listUser);
			String username = tbUser.getString(1);
			String password = tbUser.getString(2);
			String vaiTro = tbUser.getString(3);
			listUser.add(new Users(username, password, vaiTro));
		}
		connection.close();
		return listUser;
	}
}
