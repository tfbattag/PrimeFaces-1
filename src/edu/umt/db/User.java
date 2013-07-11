package edu.umt.db;

import java.sql.Timestamp;
import java.util.Set;


public class User {
	private int user_id;
	private String fname;
	private String lname;
	private String netid;
	private String department;
	private Integer phone;
	private String email;
	private String school;
	private UserType usertype;
	private Set<Application> application;
	private User approvedUser;
	private Timestamp created;
	
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the netid
	 */
	public String getNetid() {
		return netid;
	}
	/**
	 * @param netid the netid to set
	 */
	public void setNetid(String netid) {
		this.netid = netid;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}


	/**
	 * @return the usertype
	 */
	public UserType getUsertype() {
		return usertype;
	}
	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(UserType usertype) {
		this.usertype = usertype;
	}
	/**
	 * @return the application
	 */
	public Set<Application> getApplication() {
		return application;
	}
	/**
	 * @param application the application to set
	 */
	public void setApplication(Set<Application> application) {
		this.application = application;
	}
	
	
	public User getApprovedUser() {
		return approvedUser;
	}
	public void setApprovedUser(User approvedUser) {
		this.approvedUser = approvedUser;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
	
	

}
