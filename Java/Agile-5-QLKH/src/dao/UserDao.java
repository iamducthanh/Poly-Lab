package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.User;
import help.DataBaseConnect;

public class UserDao {
	public static ArrayList<User> loadUser(){
		ArrayList<User> listUser = new ArrayList<User>();
		try {
			Connection conn = DataBaseConnect.Connect();
			Statement statement = conn.createStatement();
			ResultSet tbUser = statement.executeQuery("select * from Users");
			while(tbUser.next()) {
				String username = tbUser.getString(1);
				String password = tbUser.getString(2);
				String vaiTro = tbUser.getString(3);
				listUser.add(new User(username, password, vaiTro));
			}
			conn.close();
			return listUser;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser;
	}
}
