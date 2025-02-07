package com.jsp.cloth_show_room.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.cloth_show_room.dao.CartDao;
import com.jsp.cloth_show_room.dto.UserCart;

@SuppressWarnings("serial")
@WebServlet(value = "/place-order")
public class MultipleCartPlaceOrderInsertController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		CartDao cartDao = new CartDao();
		
		List<UserCart> userCarts=cartDao.getAllCarts();
		
		req.setAttribute("clothDetails", userCarts);
		
	}
}
