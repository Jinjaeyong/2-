package com.web.member.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controllers.Controller;

public class indexController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//response.sendRedirect("login.jsp");
		return "login.jsp";
	}

}
