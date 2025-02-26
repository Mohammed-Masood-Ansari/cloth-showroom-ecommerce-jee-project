package com.jsp.cloth_show_room.admin.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.cloth_show_room.dao.ClothDetailsDao;
import com.jsp.cloth_show_room.dao.UserDao;
import com.jsp.cloth_show_room.dto.BuyNow;
import com.jsp.cloth_show_room.dto.ClothDetails;
import com.jsp.cloth_show_room.dto.User;
import com.jsp.cloth_show_room.service.BuyNowService;

@SuppressWarnings("serial")
@WebServlet(value = "/placeOrder")
public class BuyNowInsertController extends HttpServlet {

	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		String userEmail = (String) httpSession.getAttribute("email");
		
		System.out.println(userEmail);
		
		
		User user = new UserDao().getUserById(userEmail);
		
		System.out.println(user.getUserId());
		
		ClothDetailsDao clothDetailsDao = new ClothDetailsDao();
		
		int barCode = Integer.parseInt(req.getParameter("barcode"));
		
		ClothDetails clothDetails = clothDetailsDao.getClothDetails(barCode);
		
		double price =Double.parseDouble(req.getParameter("price"));
		
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		BuyNow buyNow = new BuyNow();
		
		buyNow.setDelivarDate(LocalDate.now().plusDays(3));
		buyNow.setAddress(req.getParameter("address"));
		buyNow.setPinCode(req.getParameter("pinCode"));
		buyNow.setPrice(price);
		buyNow.setQuantity(quantity);
		buyNow.setClothDetails(clothDetails);
		buyNow.setUser(user);
		
		BuyNowService buyNowService = new BuyNowService();
		
		buyNowService.saveBuyNow(buyNow);
	}
	
}
