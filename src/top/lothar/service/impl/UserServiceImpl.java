package top.lothar.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.lothar.bean.User;
import top.lothar.dao.impl.UserDaoImpl;
import top.lothar.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Override
	public User findByUser(String username, String password) {
		// TODO Auto-generated method stub
		return userDaoImpl.findByUser(username, password);
	}

}
