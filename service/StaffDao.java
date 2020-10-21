package service;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dbconnection.ProviderIml;
import model.JavaStaff;
import servlet.StaffServlet;

//provides the CRUD database operations 
public class StaffDao implements IStaff {
         
	     
	     
	     
	     
	     public StaffDao() {} //create a default constructor
	     
	    
	     static Connection connection;
	     
	     //method for create or insert staff
	     public void insertStaff(JavaStaff javastaff) throws SQLException {
	    	
	    	 
	    	 try {
	    		 // calling the DBconnection 
	    		    connection = ProviderIml.getConnection();
	    			 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO staff " + " (firstname,lastname,position,salary) VALUES " + " (?,?,?,?)");
	    		         
	    		          preparedStatement.setString(1, javastaff.getFirstname());
	    		          preparedStatement.setString(2, javastaff.getLastname());
	    		          preparedStatement.setString(3, javastaff.getPosition());
	    		          preparedStatement.setString(4, javastaff.getSalary());
	    		         
	    		          
	    		        
	    		          
	    		          System.out.println(preparedStatement);
	    		          preparedStatement.executeLargeUpdate();
	    		          
	    	 }catch(SQLException e) {
	    		 
	    		 printSQLException1(e);
	    	 }
	     }
	     
	     //method for select staff
	     public JavaStaff selectStaff( int staffid) {
	    	  JavaStaff javastaff = null;
	    	  
	    	  try {
	    		     // calling the DBconnection 
	    		     connection = ProviderIml.getConnection();
	    			  PreparedStatement preparedStatement = connection.prepareStatement("SELECT staffid,firstname,lastname,position,salary FROM staff WHERE staffid = ?");	  
	    		      preparedStatement.setInt(1, staffid);
	    		      System.out.println(preparedStatement);
	    		      ResultSet rs = preparedStatement.executeQuery();
	    		    
	    		    while(rs.next()) {
	    		    	
	    		    	String firstname = rs.getString("firstname");
	    		    	String lastname = rs.getString("lastname");
	    		    	String position = rs.getString("position");
	    		    	String salary = rs.getString("salary");
	    		    	
	    		    	
	    		    	
	    		    	
	    		    	javastaff = new JavaStaff(staffid,firstname, lastname,position,salary);
	    		    }
	    	  }catch(SQLException e) {
	    		  printSQLException1(e);
	    	  }
	    			  
			return javastaff;
	    	 
	    	     
	     }
	     
	   //method for select and view the staff details
		public List < JavaStaff > selectAllStaff() {

	         //use arraylist to store list of staff
	         List < JavaStaff > users = new ArrayList <> ();
	         //  Establishing a Connection
	         try {
                  
	        	 connection = ProviderIml.getConnection();
	             //Create a statement using connection object
	             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM staff");
	             System.out.println(preparedStatement);
	             //  Execute the query or update query
	             ResultSet rs = preparedStatement.executeQuery();

	             //  Process the ResultSet object.
	             while (rs.next()) {
	            	 int staffid = rs.getInt("staffid");
	                String firstname = rs.getString("firstname");
	                String lastname = rs.getString("lastname");
	               String position = rs.getString("position");
	               String salary = rs.getString("salary");
	              
	               
	                 users.add(new JavaStaff(staffid,firstname,lastname,position,salary));
	             }
	         } catch (SQLException e) {
	             printSQLException1(e);
	         }
	         return users;
	     }
        
		//method for delete the staff member
	     public boolean deleteStaff(int staffid) throws SQLException {
	         boolean rowDeleted = false;
	         try {
	        	 
	        	    connection = ProviderIml.getConnection();
	        		 PreparedStatement statement = connection.prepareStatement("DELETE FROM staff where staffid = ?");
	          
				statement.setInt(1,staffid);
				//use to update the query
	             rowDeleted = statement.executeUpdate() > 0;//return number of rows deleted
	         }catch (SQLException e) {
	        	 printSQLException1(e);
	         }
	         return rowDeleted;
	     }
         
	     //method for update the staff member
	     public  boolean updateStaff(JavaStaff javastaff) throws SQLException {
	         boolean rowUpdated = false;
	         try {
	        	 
	         
	        	 connection = ProviderIml.getConnection();		 
	        		 PreparedStatement statement = connection.prepareStatement("UPDATE staff set firstname = ?,lastname = ?,position = ?,salary = ? where staffid = ?");
	        	
	             statement.setString(1, javastaff.getFirstname());
	             statement.setString(2,javastaff.getLastname());
	             statement.setString(3, javastaff.getPosition());
	            statement.setString(4,javastaff.getSalary());
	            
	             statement.setInt(5, javastaff.getStaffid());

	             rowUpdated = statement.executeUpdate() > 0;//return number of rows updated
	         }catch (SQLException e) {
	        	 printSQLException1(e);
	         }
	         return rowUpdated;
	     }

	     private void printSQLException1(SQLException ex) {
	         for (Throwable e: ex) {
	             if (e instanceof SQLException) {
	                 e.printStackTrace(System.err);
	                 System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                 System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                 System.err.println("Message: " + e.getMessage());
	                 Throwable t = ex.getCause();
	                 while (t != null) {
	                     System.out.println("Cause: " + t);
	                     t = t.getCause();
	                 }
	             }
	         }
	     }

		

	
} 
