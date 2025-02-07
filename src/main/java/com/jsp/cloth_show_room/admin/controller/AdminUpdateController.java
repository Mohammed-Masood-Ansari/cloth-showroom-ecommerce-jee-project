package com.jsp.cloth_show_room.admin.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jsp.cloth_show_room.dto.ClothDetails;
import com.jsp.cloth_show_room.service.ClothDetailsService;

@WebServlet("/adminUpdateController")
@MultipartConfig
public class AdminUpdateController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ClothDetailsService clothDetailsService = new ClothDetailsService();

		int barCode = Integer.parseInt(req.getParameter("updatebar"));
		String clothType = req.getParameter("updateclothtype");
		String wearType = req.getParameter("updatewearType");
		double price = Double.parseDouble(req.getParameter("updateprice"));

		Part filePart = req.getPart("updateimageFile");

		InputStream inputStream = filePart.getInputStream();
		
		ClothDetails clothDetails = clothDetailsService.getClothDetails(900);
		
		
		
		if(clothDetails!=null) {
			
			clothDetails.setClothPrice(price);
			clothDetails.setClothType(clothType);
			clothDetails.setWearType(wearType);
			
			/*
			 * set image file to byte[] object
			 */
			clothDetails.setImage(inputStream.readAllBytes());
			
			clothDetailsService.updateClothDetails(clothDetails);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("admin-cloth-details.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
