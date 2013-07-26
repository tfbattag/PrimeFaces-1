package edu.umt.jsf.managedbeans;

import edu.umt.db.DatabaseManager;
import edu.umt.db.User;
import edu.umt.exceptions.ApplicationDetailsException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
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
    private User userToView;
    /* To create new users-- data from form */
    private String fname;
    private String lname;
    private String netid;
    private String department;
    private String  phone;
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

    public User getUserToView() {
        return userToView;
    }

    public void setUserToView(User userToView) {
        this.userToView = userToView;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public String newUserAction() throws Exception{
        User u = new User();
        u.setFname(this.fname);
        u.setLname(this.lname);
        u.setSchool(this.school);
        u.setDepartment(this.department);
        u.setEmail(this.email);
        u.setPhone(new BigInteger(this.phone));
        u.setNetid(this.netid);
        u.setUsertype(DatabaseManager.getUserType(this.usertype));
        try{
            DatabaseManager.insertUser(u);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "new-user-created";
    }

    public String userDetailAction() throws Exception{
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        try{
            userToView = DatabaseManager.getUser(new Integer(request.getParameter("userId")));
        }catch(Exception e){
            if (userToView == null) throw new ApplicationDetailsException("Could not retrieve user.");
        }

        return "user-details";
    }
}
