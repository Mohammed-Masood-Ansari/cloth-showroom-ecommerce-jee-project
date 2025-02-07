package com.jsp.cloth_show_room.admin.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.cloth_show_room.dto.User;
import com.jsp.cloth_show_room.service.UserService;

@WebServlet(value = "/insertSave")
public class UserInsertController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserService service = new UserService();
		
		User user = new User();
		
		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		String confirmPassword = req.getParameter("userCurrentPassword");
		
		user.setUserEmail(email);
		user.setUserPassword(confirmPassword);
		user.setUserConfirmPassword(confirmPassword);
		
		if(password.equals(confirmPassword)) {
			service.saveUser(user);
			req.setAttribute("equals","user----registered");
			RequestDispatcher dispatcher = req.getRequestDispatcher("user-login.jsp");
			dispatcher.forward(req, resp);
		}else {       
			req.setAttribute("message", "password is not matched");
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
}
