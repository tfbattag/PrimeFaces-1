package edu.umt.test;

import edu.umt.db.Application;
import edu.umt.db.DatabaseManager;
import edu.umt.db.User;
import edu.umt.db.UserType;
import edu.umt.test.mocks.MockObjectFactory;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class DatabaseManagerTest extends TestCase {
	// Test the Get
	@Test
	public void testGetUserType() {
		UserType usertype = DatabaseManager.getUserType(1);
		try {
			assertTrue(usertype != null);
			assertEquals(usertype.getUsertype_id(), 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(usertype == null);
	}

	@Test
	public void testGetUser() {
		User user = DatabaseManager.getUser(1);
		try {
			assertTrue(user != null);
			assertEquals(user.getFname(), "Bob");
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(user == null);
	}

	@Test
	public void testGetApplication() {
		Application application = DatabaseManager.getApplication(1);
		try {
			assertTrue(application != null);
			assertEquals(application.getApplication_id(), 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(application == null);
	}

	// Test the Get<Lists>
	@Test
	public void testGetUserTypes() {
		List<UserType> userTypes = DatabaseManager.getUserTypes();
		UserType usertype = DatabaseManager.getUserType(1);

		try {
			assertTrue(usertype != null);
			assertEquals(usertype.getUsertype_id(), 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(usertype == null);
	}

	@Test
	public void testGetUsers() {
		List<User> users = DatabaseManager.getUsers();
		User user = DatabaseManager.getUser(1);

		try {
			assertTrue(user != null);
			assertEquals(user.getUser_id(), 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(user == null);
	}

	@Test
	public void testGetApplications() {
		List<Application> applications = DatabaseManager.getApplications();
		Application application = DatabaseManager.getApplication(1);

		try {
			assertTrue(application != null);
			assertEquals(application.getApplication_id(), 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(application == null);
	}

	// Test the Inserts
	@Test
	public void testInsertUsertype() {
		UserType usertype = (UserType) MockObjectFactory
				.getMockObject("USERTYPE");
		DatabaseManager.insertUsertype(usertype);
		try {
			assertTrue(usertype != null);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(usertype == null);
	}

	@Test
	public void testInsertUser() {
		User user = (User) MockObjectFactory.getMockObject("USER");
		user.setUsertype(DatabaseManager.getUserType(1));
		DatabaseManager.insertUser(user);
		try {
			assertTrue(user != null);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(user == null);
	}

	@Test
	public void testInsertApplication() {
		Application application = (Application) MockObjectFactory
				.getMockObject("APPLICATION");
		application.setUser(DatabaseManager.getUser(1));
		DatabaseManager.insertApplication(application);

		try {
			assertTrue(application != null);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(application == null);
	}

	// Test the Updates
	@Test
	public void testUpdateUsertype() {
		UserType usertype = DatabaseManager.getUserType(6);
		usertype.setDescription("stuff");
		DatabaseManager.updateUsertype(usertype);

		try {
			assertTrue(usertype != null);
			assertEquals(usertype.getUsertype_id(), 6);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(usertype == null);
	}

	@Test
	public void testUpdateUser() {
		User user = DatabaseManager.getUser(35);
		user.setFname("JIMMY");
		DatabaseManager.updateUser(user);

		try {
			assertTrue(user != null);
			assertEquals(user.getUser_id(), 35);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(user == null);
	}

	@Test
	public void testUpdateApplication() {
		Application application = DatabaseManager.getApplication(1);
		application.setUse_description("Test");
		DatabaseManager.updateApplication(application);

		try {
			assertTrue(application != null);
			assertEquals(application.getApplication_id(), 1);
		} catch (Exception e) {
			System.out.println(e);
		}
		assertFalse(application == null);

	}

	// Test the Deletes
	@Test
	public void testDeleteUserType() {
		int tempUsertypeId = 0;
		UserType usertype = (UserType) MockObjectFactory
				.getMockObject("USERTYPE");
		DatabaseManager.insertUsertype(usertype);
		tempUsertypeId = usertype.getUsertype_id();
		DatabaseManager.deleteUserType(usertype);

		try {
			assertTrue(DatabaseManager.getUserType(tempUsertypeId) == null);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void testDeleteUser() {
		int tempUserId = 0;
		User user = (User) MockObjectFactory.getMockObject("USER");
		user.setUsertype(DatabaseManager.getUserType(1));
		DatabaseManager.insertUser(user);
		tempUserId = user.getUser_id();
		DatabaseManager.deleteUser(user);
		try {
			assertTrue(DatabaseManager.getUser(tempUserId) == null);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void testDeleteApplication() {
		Application application = (Application)MockObjectFactory.getMockObject("APPLICATION");
		application.setUser(DatabaseManager.getUser(1));
		DatabaseManager.insertApplication(application);
		int tempApplicationId = application.getApplication_id();
		DatabaseManager.deleteApplication(application);
		try {
			assertTrue(DatabaseManager.getApplication(tempApplicationId) == null);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
