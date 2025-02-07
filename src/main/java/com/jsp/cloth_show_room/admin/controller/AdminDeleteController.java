package com.jsp.cloth_show_room.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.cloth_show_room.dto.ClothDetails;
import com.jsp.cloth_show_room.service.ClothDetailsService;

@WebServlet(value = "/deleteCloth")
public class AdminDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		
		ClothDetailsService clothDetailsService = new ClothDetailsService();
		
		int barCode = Integer.parseInt(req.getParameter("id"));
		
		ClothDetails clothDetails=clothDetailsService.getClothDetails(barCode);
		
		if(clothDetails!=null) {
			
			clothDetailsService.deleteCloth(barCode);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("admin-cloth-details.jsp");
			dispatcher.forward(req, resp);
			
		}else {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("admin-cloth-details.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
