package com.ty.passwordstore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.passwordstore.dto.User;
import com.ty.passwordstore.service.UserService;

public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("UserName");
		String email = req.getParameter("UserEmail");
		String password = req.getParameter("UserPassword");
		String gender = req.getParameter("gender");

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setGender(gender);
		user.setPassword(password);

		UserService userService = new UserService();
		User user1 = userService.saveUser(user);
		PrintWriter printWriter = resp.getWriter();
		if (user1 != null) {
			String html1 = "<html><body><h1>" + user1.getId() + "</body></html>";
			printWriter.write(html1);
			String html2 = "<html><body><h1>" + user1.getName() + "</body></html>";
			printWriter.write(html2);
			String html3 = "<html><body><h1>" + user1.getEmail() + "</body></html>";
			printWriter.write(html3);
			String html4 = "<html><body><h1>" + user1.getGender() + "</body></html>";
			printWriter.write(html4);
			String html5 = "<html><body><h1>" + user1.getPassword() + "</body></html>";
			printWriter.write(html5);
			printWriter.write("<html><body><h1> User register successfully </h1></body></html>");
		} else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>User is not register</h1>");
			printWriter.write("</html></body>");
		}

	}

}
