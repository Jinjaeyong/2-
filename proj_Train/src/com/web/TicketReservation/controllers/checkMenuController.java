package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.TicketReservationDAO;
import com.train.vo.TicketReservation;
import com.web.controllers.Controller;

public class checkMenuController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String mid = (String)session.getAttribute("mid");  
		System.out.println("mid : " + mid);	
		String tnum =(String)session.getAttribute("tnum");
		System.out.println("tnum : " + tnum);
		String gogo =(String)session.getAttribute("gogo");
		System.out.println("gogo : " + gogo);
		String finish =(String)session.getAttribute("finish");
		System.out.println("finish : " + finish);
		String day =(String)session.getAttribute("day");
		System.out.println("day : " + day);
		String hour =(String)session.getAttribute("hour");
		int hourstr = Integer.parseInt(hour);
		System.out.println("hourstr : " + hourstr);
		String minute =(String)session.getAttribute("minute");
		
		TicketReservationDAO dao = new TicketReservationDAO();
		TicketReservation tr =dao.getInfor(tnum);
		
		return "checkMenu.jsp";
	}

}
