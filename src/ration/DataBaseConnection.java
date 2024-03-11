package ration;
import java.sql.*;
public class DataBaseConnection {
	
	static Connection con=null;

	static final String url="jdbc:mysql://localhost:3306/smart";
	static final String uname="root";
	static final String password="";
	
	public static Connection getConnection()
	{
			try
			{
				
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection(url,uname,password);
				return con;
			}
			catch(Exception exp)
			{
				exp.printStackTrace();
				return con;
			}
	}

}
