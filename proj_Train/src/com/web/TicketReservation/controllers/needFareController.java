package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.controllers.Controller;

public class needFareController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String gogo =(String)session.getAttribute("gogo");
		System.out.println("gogo : " + gogo);
		String finish =(String)session.getAttribute("finish");
		System.out.println("finish : " + finish);
		
		return "needFare.jsp";
				
	}

}
