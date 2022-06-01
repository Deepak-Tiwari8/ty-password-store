package com.ty.passwordstore.service;

import com.ty.passwordstore.dao.UserDao;
import com.ty.passwordstore.dto.User;

public class UserService {

	 UserDao  userDao = new  UserDao();
	public User saveUser(User user)
	{
		return userDao.saveUser(user);
	}
}
