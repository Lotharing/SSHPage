package top.lothar.dao;

import top.lothar.bean.User;

public interface UserDao {
	
	public User findByUser(String username , String password);
	
}
