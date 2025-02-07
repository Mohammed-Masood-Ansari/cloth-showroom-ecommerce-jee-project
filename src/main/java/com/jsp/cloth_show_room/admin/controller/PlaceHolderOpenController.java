package com.jsp.cloth_show_room.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.cloth_show_room.dao.ClothDetailsDao;
import com.jsp.cloth_show_room.dto.ClothDetails;

@SuppressWarnings("serial")
@WebServlet("/openPlaceOrder")
public class PlaceHolderOpenController extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClothDetailsDao clothDetailsDao = new ClothDetailsDao();
		
		
		int barCode = Integer.parseInt(req.getParameter("barcode"));
		
		ClothDetails clothDetails = clothDetailsDao.getClothDetails(barCode);
		
		req.setAttribute("clothDetails", clothDetails);
		
		System.out.println("barCode = "+clothDetails.getClothBarCode());
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("user-placeorder.jsp");
		dispatcher.forward(req, resp);
	}
}
