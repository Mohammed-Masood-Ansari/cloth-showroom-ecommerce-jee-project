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

@WebServlet(value = "/clothSave")
@MultipartConfig
public class ClothDetailsInsertController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ClothDetailsService clothDetailsService  = new  ClothDetailsService();
		
		int barCode =Integer.parseInt(req.getParameter("bar"));
		String clothType = req.getParameter("clothtype");
		String wearType = req.getParameter("wearType");
		double price = Double.parseDouble(req.getParameter("price"));
		int offer = Integer.parseInt(req.getParameter("offer"));
		//String image  = req.getParameter("imageFile");
		/*
		 * image file reading
		 */
		Part filePart = req.getPart("imageFile");
		
		InputStream inputStream = filePart.getInputStream();
		
		
		ClothDetails clothDetails = new ClothDetails();
		
		clothDetails.setClothBarCode(barCode);
		clothDetails.setClothPrice(price);
		clothDetails.setClothType(clothType);
		clothDetails.setWearType(wearType);
		clothDetails.setOffer(offer);
		/*
		 * set image file to byte[] object
		 */
		clothDetails.setImage(inputStream.readAllBytes());
		
		ClothDetails clothDetails2=clothDetailsService.saveClothDetails(clothDetails);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("admin-home.jsp");
		dispatcher.forward(req, resp);
		
		inputStream.close();
	}
}
