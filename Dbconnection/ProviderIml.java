package Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProviderIml implements Provider{
	
	//get connection method
	public static Connection getConnection() {
  	  Connection connection = null;
  	  
  	  try {
  		    Class.forName("com.mysql.cj.jdbc.Driver");
  		    connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);//pass url,username ,paasword 
  		                                                                                //to get connection method
  		  
  	  }catch(SQLException e) {
  		    e.printStackTrace();
  	  }catch(ClassNotFoundException e) {
  		   e.printStackTrace();
  	  }
		  return connection;
  	  
   }
	 
}
