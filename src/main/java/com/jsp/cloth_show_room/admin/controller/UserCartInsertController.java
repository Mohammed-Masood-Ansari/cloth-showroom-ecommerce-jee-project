package com.jsp.cloth_show_room.admin.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.jsp.cloth_show_room.dao.CartDao;
import com.jsp.cloth_show_room.dao.ClothDetailsDao;
import com.jsp.cloth_show_room.dao.UserDao;
import com.jsp.cloth_show_room.dto.ClothDetails;
import com.jsp.cloth_show_room.dto.User;
import com.jsp.cloth_show_room.dto.UserCart;

@SuppressWarnings("serial")
@WebServlet(value = "/userCartInsert")
public class UserCartInsertController  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		
		String userEmail = (String) httpSession.getAttribute("email");
		
		User user = new UserDao().getUserById(userEmail);
		
		int barCode = Integer.parseInt(req.getParameter("barcode"));
		
		ClothDetailsDao clothDetailsDao = new ClothDetailsDao();
		
		UserCart userCart = new UserCart();
		
		CartDao cartDao = new CartDao();
		
		ClothDetails clothDetails=clothDetailsDao.getClothDetails(barCode);
		
		if(clothDetails!=null) {
			
			double finalPrice = clothDetails.getClothPrice()-(clothDetails.getClothPrice()*clothDetails.getOffer())/100;
			userCart.setClothPrice(finalPrice);
			userCart.setClothType(clothDetails.getClothType());
			userCart.setOffer(clothDetails.getClothBarCode());
			userCart.setWearType(clothDetails.getWearType());
			userCart.setOffer(clothDetails.getOffer());
			userCart.setUser(user);
			userCart.setClothDetails(clothDetails);
			cartDao.saveUserCart(userCart);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("user-cart.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
