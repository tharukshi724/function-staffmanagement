<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Staff Management</title>
           <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<style>

 body { margin-top:20px;
          background-color: #87CEFA;
   }
</style>
        </head>

        <body>
            
        
              <div class="container">
                    <h3 class="text-center">Staff Details</h3>
                    <hr>
                    <ul class="list-link">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Staff List</a></li>
                    </ul>
                    <img src="images/staff.jsp">
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
     New Staff</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>staffid</th>
                                <th>firstName</th>
                                <th>LastName</th>
                                <th>Position</th>
                                <th>Salary</th>
                                
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                           <!-- table data -->
                            <c:forEach var="user" items="${listStaff}">

                                <tr>
                                    <td>
                                        <c:out value="${user.staffid}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.firstname}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.lastname}" />
                                    </td>
                                   <td>
                                        <c:out value="${user.position}" />
                                    </td>
                                    <td>
                                        <c:out value="${user.salary}" />
                                    </td>
                                    
                                    
                                    
                                    <!-- action column links -->
                                    <td><a href="edit?staffid=<c:out value='${user.staffid}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?staffid=<c:out value='${user.staffid}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                           
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>