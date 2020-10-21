package servlet;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.JavaStaff;
import service.StaffDao;

@SuppressWarnings("unused")
@WebServlet("/")
public class StaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
   
    private StaffDao staffdao;//create StaffDao object

     public void init() {
    	this.staffdao = new StaffDao();
   }
    
   

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.doGet(request, response);  //call doGet method
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                	insertStaff(request, response);
                    break;
                case "/delete":
                    deleteStaff(request, response);
                    break;
                case "/edit":
                	showEditForm(request, response);
                    break;
                case "/update":
                    updateStaff(request, response);
                    break;
                default:
                    listStaff(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listStaff(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List <JavaStaff> listStaff = staffdao.selectAllStaff();
        request.setAttribute("listStaff", listStaff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff-form.jsp"); // create requestDispatcher object request pass to staff-form.jsp page
        dispatcher.forward(request, response);                                         
    }

   private void showEditForm(HttpServletRequest request, HttpServletResponse response)
   throws SQLException, ServletException, IOException {
       int staffid = Integer.parseInt(request.getParameter("staffid"));
    JavaStaff existingUser = staffdao.selectStaff(staffid);
      RequestDispatcher dispatcher = request.getRequestDispatcher("staff-form.jsp");
      request.setAttribute("user", existingUser);
       dispatcher.forward(request, response);

    }

     //method that handle insert staff operation
    private void insertStaff(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String position = request.getParameter("position");
        String salary= request.getParameter("salary");
       
       
        
        JavaStaff newStaff = new JavaStaff(firstname,lastname,position,salary);
        staffdao.insertStaff( newStaff);
        response.sendRedirect("list");
    }

    //method to handle update staff operation
    private void updateStaff(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	
    	 String firstname = request.getParameter("firstname");
         String lastname = request.getParameter("lastname");
         String position = request.getParameter("position");
        String salary= request.getParameter("salary");
      
        int staffid = Integer.parseInt(request.getParameter("staffid"));
       

         
         JavaStaff javastaff = new JavaStaff(staffid,firstname,lastname,position,salary);
         staffdao.updateStaff(javastaff);
        response.sendRedirect("list");
    }
    
    //method to handle delete staff operation
    private void deleteStaff(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
   	     int staffid = Integer.parseInt(request.getParameter("staffid"));//get staffid from request object
    	  
       staffdao.deleteStaff(staffid);
        response.sendRedirect("list");

    }
}