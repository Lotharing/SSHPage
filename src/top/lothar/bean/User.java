package top.lothar.bean;

import javax.persistence.Entity;

/**
 * 
 * 用户实体类
 * @author Lothar
 *
 */
public class User {
	
	private long id;
	
	private String username;
	
	private String password;
	
	public User() {
		super();
	}

	public User(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
