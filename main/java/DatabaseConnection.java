import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;

import com.mysql.cj.jdbc.Driver;

public class DatabaseConnection {
//connection between database and java
	
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/payroll_services?useSSL=false";
		String userName = "root";
		String password = "Karad@123";
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		listDrivers();

		try {
			System.out.println("Connecting to data: " + jdbcUrl);
			connection = DriverManager.getConnection(jdbcUrl, userName, password);
			System.out.println("Connection is successful!!!" + connection);
			String myQuery = "select * from Employee_payroll";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listDrivers() {
		Enumeration<java.sql.Driver> driverList = DriverManager.getDrivers();
		while (driverList.hasMoreElements()) {
			Driver driverClass = (Driver) driverList.nextElement();
			System.out.println("  " + driverClass.getClass().getName());
		}
	}
}
