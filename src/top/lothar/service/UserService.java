package top.lothar.service;

import top.lothar.bean.User;

public interface UserService {
	
	public User findByUser(String username , String password);
	
}
