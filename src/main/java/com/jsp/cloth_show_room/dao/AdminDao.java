package com.jsp.cloth_show_room.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.cloth_show_room.dto.Admin;


/**
 * 
 * @author asus
 *
 */
public class AdminDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("showroom").createEntityManager();
	
	
	
	
	public List<Admin> getAllAdmin() {
		return entityManager.createQuery("FROM Admin").getResultList();
	}
	
	
	/*
	 * login with admin
	 */
	public Admin loginAdmin(String adminEmail) {
		
		List<Admin> admins=getAllAdmin();
		
		for (Admin admin : admins) {
			if(admin.getAdminEmail().equals(adminEmail)) {
				return admin;
			}
		}
		return null;
	}
}
