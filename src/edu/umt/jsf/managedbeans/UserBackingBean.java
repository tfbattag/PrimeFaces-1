package edu.umt.jsf.managedbeans;

import edu.umt.db.DatabaseManager;
import edu.umt.db.User;
import edu.umt.db.UserType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 7/3/13
 * Time: 10:28 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserBackingBean {
    private List<User> users;
    private User user;
    /* To create new users-- data from form */
    private String fname;
    private String lname;
    private String netid;
    private String department;
    private Integer phone;
    private String email;
    private String school;
    private int usertype;

    public List<User> getUsers() {
        return DatabaseManager.getUsers();
    }

    public void setUsers(List<User> users) {
        users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNetid() {
        return netid;
    }

    public void setNetid(String netid) {
        this.netid = netid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
}
