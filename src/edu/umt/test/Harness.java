package edu.umt.test;

import edu.umt.db.Application;
import edu.umt.db.DatabaseManager;
import edu.umt.db.User;
import edu.umt.db.UserType;
import edu.umt.test.mocks.MockObjectFactory;

import java.util.Iterator;
import java.util.List;

public class Harness {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getUserTypes();
//		getUsers();
//		getApplications();
//		insertUserType();
//		insertUser();
//		insertApplication();
//		updateUserType();
//		updateUser();
//		updateApplication();

//		deleteUserType();
//		deleteUser();
		deleteApplication();
	}
	

	private static void getUserTypes(){
		DatabaseManager dm = new DatabaseManager();
		List<UserType> userTypes = dm.getUserTypes();
		Iterator<UserType> i = userTypes.iterator();
		while(i.hasNext()){
			UserType u = i.next();
			System.out.println(u.getDescription());
		}
	}
	
	private static void getUsers(){
		DatabaseManager dm = new DatabaseManager();
		List<User> users = dm.getUsers();
		Iterator<User> i = users.iterator();
		while(i.hasNext()){
			User u = i.next();
			System.out.println(u.getFname() + " " + u.getLname());
		}
	}
	
	private static void getApplications(){
		DatabaseManager dm = new DatabaseManager();
		List<Application> applications = dm.getApplications();
		Iterator<Application> i = applications.iterator();
		while(i.hasNext()){
		Application a = i.next();
		System.out.println(a.getBalance());
		System.out.println(a.getUser().getFname());
		}
	}
	
	private static void insertUserType(){
		DatabaseManager dm = new DatabaseManager();
		UserType usertype = (UserType)MockObjectFactory.getMockObject("USERTYPE");
		dm.insertUsertype(usertype);
	}
	
	private static void insertUser(){
		DatabaseManager dm = new DatabaseManager();
		User user = (User)MockObjectFactory.getMockObject("USER");
		user.setUsertype(dm.getUserType(1));
		dm.insertUser(user);
	}
	
	private static void insertApplication(){
		DatabaseManager dm = new DatabaseManager();
		Application application = (Application)MockObjectFactory.getMockObject("APPLICATION");
		application.setUser(dm.getUser(33));
		dm.insertApplication(application);
	}
	
	private static void updateUserType(){
		DatabaseManager dm = new DatabaseManager();
		UserType usertype = dm.getUserType(5);
		usertype.setDescription("Modified");
		dm.updateUsertype(usertype);
	}
	
	private static void updateUser(){
		DatabaseManager dm = new DatabaseManager();
		User user = dm.getUser(11);
		user.setFname("Erika");
		dm.updateUser(user);
	}
	
	private static void updateApplication(){
		DatabaseManager dm = new DatabaseManager();
		Application application = dm.getApplication(3);
		application.setApprovedUser(dm.getUser(1));
		application.setUse_description("Modified");
		dm.updateApplication(application);
	}

	private static void deleteUserType(){
		DatabaseManager dm = new DatabaseManager();
		UserType usertype = dm.getUserType(5);
		dm.deleteUserType(usertype);
				
	}
	
	private static void deleteUser(){
		DatabaseManager dm = new DatabaseManager();
		User user = dm.getUser(4);
		dm.deleteUser(user);
		
	}
	
	private static void deleteApplication(){
		DatabaseManager dm = new DatabaseManager();
		Application application = dm.getApplication(4);
		dm.deleteApplication(application);
	}
}
