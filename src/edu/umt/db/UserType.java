package edu.umt.db;

import java.sql.Timestamp;
import java.util.Set;

public class UserType {
	private int usertype_id;
	private String description;
	private String usertypecol;
	private Set<User> user;
	private Timestamp created;



	/**
	 * @return the usertype_id
	 */
	public int getUsertype_id() {
		return usertype_id;
	}
	/**
	 * @param usertype_id the usertype_id to set
	 */
	public void setUsertype_id(int usertype_id) {
		this.usertype_id = usertype_id;
	}
	/**
	 * @return the requesttype
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param requesttype the requesttype to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the usertypecol
	 */
	public String getUsertypecol() {
		return usertypecol;
	}
	/**
	 * @param usertypecol the usertypecol to set
	 */
	public void setUsertypecol(String usertypecol) {
		this.usertypecol = usertypecol;
	}
	/**
	 * @return the user
	 */
	public Set<User> getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	//testing
	public boolean setDescription(boolean equals) {
		// TODO Auto-generated method stub
		return false;
	}


}
