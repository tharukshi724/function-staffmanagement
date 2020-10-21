package model;



public class JavaStaff {
        
	    //declare private attributes
	    private int staffid;
	    private String firstname;
	    private String lastname;
	    private String position;
	    private String salary;
	    private String contactNo;
	    private String workingTime;
	    
	    /**
		 * @param staffid
		 * @param firstname
		 * @param lastname
		 * @param position
		 * @param salary
		 * @param contactNo
		 * @param workingTime
		 */
	    
	    //create default constructor
	    public JavaStaff() {}

        //overloaded constructor with staffid
		public JavaStaff(int staffid,String firstname, String lastname,String position,String salary) {
		 
			this.staffid = staffid;
			this.firstname = firstname;
			this.lastname = lastname;
			this.position = position;
			this.salary = salary;
			
		}
       
		
		  //overloaded constructor without staffid
		public JavaStaff(String firstname, String lastname,String position,String salary) {
		
			
			this.firstname = firstname;
			this.lastname = lastname;
			this.position = position;
			this.salary = salary;
			
		}

		//get method to get private attribute staffid
		public int getStaffid() {
			return staffid;
		}

		//set method to set value for private attribute staffid
		public void setStaffid(int staffid) {
			this.staffid = staffid;
		}

		//get method to get private attribute firstname
		public String getFirstname() {
			return firstname;
		}

		//set method to set value for private attribute firstname
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		//get method to get private attribute lastname
		public String getLastname() {
			return lastname;
		}

		//set method to set value for private attribute lastname
		public void setLastname(String lastname) {
	     	this.lastname = lastname;
		}

		//get method to get private attribute position
        public String getPosition() {
        	return position;
        }
	     
      //set method to set value for private attribute position
        public void setPosition(String position) {
        	this.position = position;
        }

      //get method to get private attribute salary
		public String getSalary() {
			return salary;
		}

		 //set method to set value for private attribute salary
		public void setSalary(String salary) {
			this.salary = salary;
		}

		//get method to get private attribute contactNo
		
		


		
		
		
		
	    
	    
	    	
	   
	    
	    
	    
}
