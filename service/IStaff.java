package service;

import java.sql.SQLException;
import java.util.List;

import model.JavaStaff;

/**
 * interface for the StaffDao class
 * 
 */
public interface IStaff {
       
	 public void insertStaff(JavaStaff javastaff) throws SQLException;
	 
	 
	 public JavaStaff selectStaff( int staffid);
	 
	 
	 public List < JavaStaff > selectAllStaff();
	 
	 
	 public boolean deleteStaff(int staffid) throws SQLException;
	 
	 public  boolean updateStaff(JavaStaff javastaff) throws SQLException;
	 
	 
}
