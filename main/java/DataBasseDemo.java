import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class DataBasseDemo {

	public static void main(String[] args) {
		String jdbcUrl =  "jdbc:mysql://localhost:3306/demo?useSSL=false";
		String userName = "root";
		String password = "Karad@123";
		String query ="select * from employee_details";
				
		try {
				Connection connection = DriverManager.getConnection(jdbcUrl,userName,password);
				java.sql.Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(query);
						
				while (resultSet.next()){
				System.out.println("Employee ID : " +resultSet.getInt("Emp_id"));
				System.out.println("First Name : " +resultSet.getString("first_name"));
				System.out.println("last Name : " +resultSet.getString("last_name"));
				System.out.println("Salary : " +resultSet.getInt("salary"));
				System.out.println("City : " +resultSet.getString("City"));
				System.out.println("Designation : " +resultSet.getString("Designation"));
				
				}
		 	}
		
		 	catch (SQLException e){
				e.printStackTrace();
				}
		
				}
			}
		
	

