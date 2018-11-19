package com.web.TicketReservation.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.TicketReservationDAO;
import com.train.vo.TicketReservation;
import com.web.controllers.Controller;

public class viewTicketController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String mid = (String)session.getAttribute("mid");
		//String tnum = (String)session.getAttribute("tnum");
	    System.out.println("mid : " +mid);
	   
	    
	    TicketReservationDAO dao = new TicketReservationDAO();
	    String tnum = (String)dao.getTnum(mid);
	    List<TicketReservation> trlist = dao.getTRtnum(mid);  
	    
	    
	    System.out.println(trlist.size());
	    
	    request.setAttribute("tnum", tnum);
	    request.setAttribute("trlist", trlist);
	    
	    return "viewTicket.jsp";
	}

}
