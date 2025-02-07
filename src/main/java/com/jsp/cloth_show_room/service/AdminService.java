package com.jsp.cloth_show_room.service;

import javax.persistence.Query;

import com.jsp.cloth_show_room.dao.AdminDao;
import com.jsp.cloth_show_room.dto.Admin;

public class AdminService {

	
	AdminDao adminDao = new AdminDao();
	
	/*
	 * login with admin
	 */
	public Admin loginAdmin(String adminEmail) {
		
		return adminDao.loginAdmin(adminEmail);
	}
}
