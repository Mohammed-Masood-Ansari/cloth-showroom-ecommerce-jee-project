package com.jsp.cloth_show_room.admin.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.cloth_show_room.dao.CartDao;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class UserCartDeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cartid  = Integer.parseInt(req.getParameter("cartId"));
		
		CartDao cartDao = new CartDao();
		
		cartDao.deleteUserCartByIdDao(cartid);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("user-cart.jsp");
		dispatcher.forward(req, resp);
	}
	
}
