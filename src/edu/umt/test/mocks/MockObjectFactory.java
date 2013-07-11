package edu.umt.test.mocks;

import edu.umt.db.Application;
import edu.umt.db.DatabaseManager;
import edu.umt.db.User;
import edu.umt.db.UserType;

public class MockObjectFactory {
	private static final String USERTYPE = "USERTYPE";
	private static final String USER = "USER";
	private static final String APPLICATION = "APPLICATION";
	private static DatabaseManager dm;
	
	private static void init(){
		dm = new DatabaseManager();
	}
	
	
	public static Object getMockObject(String objectype){
		if(objectype.equals(USERTYPE)){
			UserType usertype = new UserType();
			initializeUserType(usertype);
			return usertype;
		}else if(objectype.equals(USER)){
			User user = new User();
			initializeUser(user);
			return user;
		}else if(objectype.equals(APPLICATION)){
			Application application = new Application();
			initializeApplication(application);
			return application;
		}
		return null;
	}
	
	private static void initializeUserType(UserType usertype){
		usertype.setDescription("Admin");
		usertype.setUsertypecol((new Long(System.currentTimeMillis()).toString()));
	}
	
	private static void initializeUser(User user){
		user.setFname("Jim");
		user.setLname("Smith");
		
		String currentTime = ((Long)System.currentTimeMillis()).toString();
		int lastIndex = currentTime.length();
		int beginIndex = lastIndex-7;
		user.setNetid(currentTime.substring(beginIndex, lastIndex));
	
		user.setDepartment("IT");
		user.setPhone(2436985);
		user.setEmail("jim.smith@umontana.edu");
		user.setSchool("CAS");
	}

	private static void initializeApplication(Application application){
		init();
		application.setIndex_charge("MIT654");
		application.setBalance("600");
		application.setRequest_amount("300");
		application.setEquipment_description("Computers for student use");
		application.setOutside_funds("N/A");
		application.setUse_description("Lab use");
		application.setMaintenance_responsibility("IT Staff");
		application.setNew_connections("none");
		application.setProvided_by("N/A");
		application.setPilot("No");
		application.setPilot_summary("N/A");
		application.setApprovedUser(dm.getUser(1));
		application.setApproved(1);
		application.setApprovedAmount(10.00d);
	}
}
