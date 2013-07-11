package edu.umt.jsf.managedbeans;

/**
 * Created with IntelliJ IDEA.
 * User: tb189431e
 * Date: 7/9/13
 * Time: 9:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class IndexBackingBean {

    public String listUserTypesAction(){
        return "list-usertypes";
    }

    public String listUsersAction(){
        return "list-users";
    }

    public String addUserTypeAction(){
        return "new-usertype";
    }

    public String addUserAction(){
        return "new-user";
    }
}
