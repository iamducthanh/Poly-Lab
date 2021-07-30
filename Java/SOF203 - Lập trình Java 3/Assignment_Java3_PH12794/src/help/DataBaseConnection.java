package help;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	public static Connection Connect() throws ClassNotFoundException, SQLException {
		Connection connection;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=QLSV", "sa", "123");
		return connection;
	}
}
