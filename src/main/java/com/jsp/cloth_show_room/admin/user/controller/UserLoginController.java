package com.jsp.cloth_show_room.admin.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.cloth_show_room.dto.User;
import com.jsp.cloth_show_room.service.UserService;

@SuppressWarnings("serial")
@WebServlet(value = "/userLogin")
public class UserLoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession httpSession = req.getSession();
		UserService service = new UserService();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
	
		
		User user = service.getUserById(email);
		
		req.setAttribute("user",user);
		
		if(user!=null) {
			if(user.getUserPassword().equals(password)) {
				httpSession.setAttribute("email", email);
				RequestDispatcher dispatcher = req.getRequestDispatcher("user-home.jsp");
				dispatcher.forward(req, resp);
				
			}else {
				req.setAttribute("messagepassword", "user password is incorrect");
				RequestDispatcher dispatcher = req.getRequestDispatcher("user-login.jsp");
				dispatcher.forward(req, resp);
			}
		}else {
			req.setAttribute("messageemail", "user email is incorrect");
			RequestDispatcher dispatcher = req.getRequestDispatcher("user-login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
