package edu.umt.db;

import edu.umt.exceptions.UserException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
//Talk take 2


public class DatabaseManager {
    private static Logger log = LoggerFactory.getLogger(DatabaseManager.class);

	static Session session;
	
	public static UserType getUserType(int usertype_id){
		try{
			session = HibernateSessionFactory.currentSession();
			UserType userType = (UserType)session.get(UserType.class, usertype_id);
			return userType;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return null;
	}
	
	public static User getUser(int user_id){
		try{
			session = HibernateSessionFactory.currentSession();
			User user = (User)session.get(User.class, user_id);
			return user;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return null;
	}

	
	public static Application getApplication(int application_id){
		try{
			session = HibernateSessionFactory.currentSession();
			Application application = (Application)session.get(Application.class, application_id);
			return application;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return null;
	}
	
	public static List<UserType> getUserTypes(){
		List<UserType> userTypes=null;
		try{
			session = HibernateSessionFactory.currentSession();
			Query q = session.createQuery(" from UserType");
			userTypes = q.list();
			return userTypes;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return userTypes;
	}
	
	public static List<User> getUsers(){
		List<User> users = null;
        log.debug("Entering getUsers() method.");
		try{
			session = HibernateSessionFactory.currentSession();
			Query q = session.createQuery(" from User");
			users = q.list();
			return users;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return users;
	}
	
	public static List<Application> getApplications() {
		List<Application> applications = null;
        log.debug("Executing the getApplications() method.");
		try{
			session = HibernateSessionFactory.currentSession();
			Query q= session.createQuery(" from Application");
			applications = q.list();
			return applications;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
		return applications;
	}
	
	public static void insertUsertype(UserType usertype){
		try{
			session = HibernateSessionFactory.currentSession();
			session.saveOrUpdate(usertype);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public static void insertUser(User user) throws UserException {
		try{
			session = HibernateSessionFactory.currentSession();
			session.save(user);
		}catch(Exception e){
			log.error("Failed to insert user: " + user.getLname() + " " + user.getFname());
            log.error(e.toString());
            throw new UserException("Could not insert the user: " + user.getFname() + " " + user.getLname());
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public static void insertApplication(Application application){
		try{
			session = HibernateSessionFactory.currentSession();
			session.save(application);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public static void updateUsertype(UserType usertype){
		try{
			session = HibernateSessionFactory.currentSession();
			session.saveOrUpdate(usertype);
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	
	}
	
	public static void updateUser(User user){
		try{
			session = HibernateSessionFactory.currentSession();
			session.saveOrUpdate(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public static void updateApplication (Application application){
		try{
			session = HibernateSessionFactory.currentSession();
			session.saveOrUpdate(application);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public static void deleteUserType(UserType usertype){
		try{
			session = HibernateSessionFactory.currentSession();
			//session.update(usertype);
			session.delete(usertype);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public static void deleteUser(User user){
		try{
			session = HibernateSessionFactory.currentSession();
			session.delete(user);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public static void deleteApplication(Application application){
		try{
			session = HibernateSessionFactory.currentSession();
			session.delete(application);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	}
	
	public static void reattachObject(Object o){
		try{
			session = HibernateSessionFactory.currentSession();
			session.refresh(o);
			System.out.println(o);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.flush();
			session.close();
		}
	}
}
