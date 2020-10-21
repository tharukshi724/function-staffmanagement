<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Staff Management </title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
            <style>
         body { margin-top:20px;
          background-color: #87CEFA;
   }    
  .form-control {
        min-height: 41px;
		background: #fff;
		box-shadow: none !important;
		border-color: #e3e3e3;
	}
	.form-control:focus {
		border-color: #70c5c0;
	}
    .form-control, .btn {        
        border-radius: 2px;
    }
	.staff-form {
		width: 350px;
		margin: 0 auto;
		padding: 100px 0 30px;		
	}
	.staff-form form {
		color: #7a7a7a;
		border-radius: 2px;
    	margin-bottom: 15px;
        font-size: 13px;
        background: #ececec;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;	
        position: relative;	
    }
	.staff-form h2 {
		font-size: 22px;
        margin: 35px 0 25px;
    }
	.staff-form .avatar {
		position: absolute;
		margin: 0 auto;
		left: 0;
		right: 0;
		top: -50px;
		width: 95px;
		height: 95px;
		border-radius: 50%;
		z-index: 9;
		background: #70c5c0;
		padding: 15px;
		box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
	}
	.staff-form .avatar img {
		width: 100%;
	}	
    .staff-form input[type="checkbox"] {
        margin-top: 2px;
    }
    .staff-form .btn {        
        font-size: 16px;
        font-weight: bold;
		background: #70c5c0;
		border: none;
		margin-bottom: 20px;
    }
	.staff-form .btn:hover, .login-form .btn:focus {
		background: #50b8b3;
        outline: none !important;
	}    
	.staff-form a {
		color: #fff;
		text-decoration: underline;
	}
	.login-form a:hover {
		text-decoration: none;
	}
	.staff-form form a {
		color: #7a7a7a;
		text-decoration: none;
	}
	.staff-form form a:hover {
		text-decoration: underline;
	}
            </style>
            
        </head>

        <body>
            <header>
                        
             
                  
                    <ul class="navbar-nav">
                        <!--  provide link ,when click that link "/list" url will be called and show list of staff -->
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Staff</a></li>
                    </ul>
                </nav>
            </header>
                      
            
            
           
             
            <div class="staff-form">
                <div class="card">
                    <div class="card-body">
                       
                       <!-- this form provide 2 functionalities -->
                        <c:if test="${user != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${user == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${user != null}">
                                    Edit Staff
                                </c:if>
                                <c:if test="${user == null}">
                                    Add New staff
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test='${user != null}'>
                            <input type="hidden" name="staffid" value="<c:out value='${user.staffid}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>First name</label> <input type="text" value="<c:out value='${user.firstname}' />" class="form-control" name="firstname" required>
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Last name</label> <input type="text" value="<c:out value='${user.lastname}' />" class="form-control" name="lastname" required>
                        </fieldset>
                         
                          <fieldset class="form-group">
                            <label>Position</label> <input type="text" value="<c:out value='${user.position}' />" class="form-control" name="position" required>
                        </fieldset>
                       
                         <fieldset class="form-group">
                            <label>Staffmember Salary</label> <input type="text" id="salary" value="<c:out value='${user.salary}' />" class="form-control" name="salary" required>
                        </fieldset>
                        
                        
                        <button type="submit" onclick="myFunction()" class="btn btn-success">Save</button>
                       
                        </form>
                        
                    </div>
                </div>
            </div>
            <script>
            
          function myFunction(){
            var input=document.getElementById("salary").value;
            if(input=="")
      	  {
      	     alert("field cannot be null");
      	  }
      	  if(isNaN(input))
      	  {
      	     alert("Cannot enter a letters to salary");
      	  }
      	  if(input<0)
      	  {
      	     alert("negative numbers are not accepted to salary ");
      	  }
          }

            </script>
         
        </body>

        </html>