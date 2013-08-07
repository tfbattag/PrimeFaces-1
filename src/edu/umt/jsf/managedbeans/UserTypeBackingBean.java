package edu.umt.jsf.managedbeans;

import edu.umt.db.DatabaseManager;
import edu.umt.db.UserType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 7/3/13
 * Time: 12:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserTypeBackingBean {
    private List<UserType> userTypes;
    private UserType userType;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserType> getUserTypes() {
        return DatabaseManager.getUserTypes();
    }

    public void setUserTypes(List<UserType> userTypes) {
        this.userTypes = userTypes;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String newUserTypeAction(){
        UserType ut = new UserType();
        ut.setDescription(this.getDescription());
        try{
            DatabaseManager.insertUsertype(ut);
        }catch(Exception e){
            e.printStackTrace();
        }
        return "ok";
    }
}
