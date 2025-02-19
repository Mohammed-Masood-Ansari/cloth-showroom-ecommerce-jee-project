package com.jsp.cloth_show_room.admin.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.cloth_show_room.dao.BuyNowDao;
import com.jsp.cloth_show_room.dao.CartDao;
import com.jsp.cloth_show_room.dao.ClothDetailsDao;
import com.jsp.cloth_show_room.dao.UserDao;
import com.jsp.cloth_show_room.dto.BuyNow;
import com.jsp.cloth_show_room.dto.ClothDetails;
import com.jsp.cloth_show_room.dto.User;
import com.jsp.cloth_show_room.dto.UserCart;
import com.jsp.cloth_show_room.service.BuyNowService;

@SuppressWarnings("serial")
@WebServlet("/placeAllCartOrder")
public class UserCartOrderController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		
		String userEmail = (String) httpSession.getAttribute("email");
		
		User user = new UserDao().getUserById(userEmail);
		
		CartDao cartDao = new CartDao();

		List<UserCart> userCarts = cartDao.getAllCarts();

		ClothDetailsDao clothDetailsDao = new ClothDetailsDao();

		
		
		BuyNowDao buyNowDao = new BuyNowDao();
		
		
		
		int count  = 0;
		
		//List<BuyNow> buyNows = new ArrayList<BuyNow>();
		
		for (UserCart userCart : userCarts) {
			
			count++;
			
			BuyNow buyNow = new BuyNow();
			
			
			buyNow.setAddress(req.getParameter("address"));
			buyNow.setPinCode(req.getParameter("pinCode"));
			buyNow.setQuantity(Integer.parseInt(req.getParameter("quantity")));
			
			int clothId = userCart.getUserCartId();
			buyNow.setDelivarDate(LocalDate.now().plusDays(3));
			buyNow.setPrice(userCart.getClothPrice() * Integer.parseInt(req.getParameter("quantity")));
			buyNow.setUser(user);
			buyNow.setClothDetails(clothDetailsDao.getClothDetails(clothId));

			buyNowDao.saveBuyNow(buyNow);
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("my-order.jsp");
		dispatcher.forward(req, resp);

	}
}
