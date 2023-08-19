package dbpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
	
	public static void main(String[] args) throws SQLException {
		String host = "localhost";
		String port = "3306";
		String db = "jayashdb";
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db,"root","Mandarin@123");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from employeeinfo");
		//System.out.println(rs.getString("firstName"));
		while(rs.next()) {
			System.out.println(rs.getString("firstName"));
		}
		//System.out.println(rs.getString("firstName"));
		}
		
	
}
