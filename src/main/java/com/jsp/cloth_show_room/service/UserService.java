package com.jsp.cloth_show_room.service;

import com.jsp.cloth_show_room.dao.UserDao;
import com.jsp.cloth_show_room.dto.User;

public class UserService {

	UserDao userDao = new UserDao();
	
	/*
	 * saveUser
	 */
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
	
	/*
	 * getUserByName
	 */
	public User getUserById(String userName) {
		return userDao.getUserById(userName);
	}
}
