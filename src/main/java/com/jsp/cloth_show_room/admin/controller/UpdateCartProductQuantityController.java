package com.jsp.cloth_show_room.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.cloth_show_room.dao.CartDao;
import com.jsp.cloth_show_room.dto.UserCart;

@WebServlet(value = "/updateCartProductQuantity")
public class UpdateCartProductQuantityController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//old quantity + 1 new quantity
		
		int cartId = Integer.parseInt(req.getParameter("id"));
		
		double price = Double.parseDouble(req.getParameter("price"));
		
		CartDao cartDao=new CartDao();
		
		UserCart cart=cartDao.getUserCartByIdDao(cartId);
		
		int quantity = cart.getQuantity();
		
		quantity=quantity+1;
		
		price = price*quantity;
		
		cart.setClothPrice(price);
		cart.setQuantity(quantity);
		
		UserCart cart2=cartDao.updateUserCartQuantityAndPriceDao(cart);
		
		req.getRequestDispatcher("user-cart.jsp").forward(req, resp);
	}
}
