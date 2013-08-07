package edu.umt.db;

import org.hibernate.Session;


//talks to hibernate :D
public class UserService {

	public User getUser(int user_id){

		User u = null;
		try {
			Session s = HibernateSessionFactory.currentSession();
			u=(User) s.get(User.class,  user_id);
			return u;
		}catch (Exception e){
			System.out.println(e);
		}
		return u;
	}

}
