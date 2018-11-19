package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.TicketReservationDAO;
import com.train.vo.TicketReservation;
import com.web.controllers.Controller;

public class basicRoomController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String mid = (String)session.getAttribute("mid");
		String tnum = (String)session.getAttribute("tnum");
		String gogo = (String)session.getAttribute("gogo");
		System.out.println("gogo : " + gogo);
		String finish = (String)session.getAttribute("finish");
		System.out.println("finish : " + finish);
		String day = (String)session.getAttribute("day");
		String hour = (String)session.getAttribute("hour");
		String minute = (String)session.getAttribute("minute");

		String adult = (String)session.getAttribute("adult");
		System.out.println("adult : " + adult);
		int adultstr = Integer.parseInt(adult);
		String child = (String)session.getAttribute("child");
		System.out.println("child : " + child);
		int childstr = Integer.parseInt(child);
		String old = (String)session.getAttribute("old");
		System.out.println("old : " + old);
		int oldstr = Integer.parseInt(old);
		String basicseat = (String)session.getAttribute("basicseat"); 
		TicketReservationDAO dao = new TicketReservationDAO();
		TicketReservation tr = dao.getInfor(tnum);
		 /* System.out.println("tr.getTnum() : " + tr.getTnum()); */
		System.out.println("basicseat : " + basicseat); 
		
		/*request.setAttribute("mid", mid);
		request.setAttribute("tnum", tnum);
		request.setAttribute("gogo", gogo);
		request.setAttribute("finish", finish);
		request.setAttribute("day", day);
		request.setAttribute("hour", hour);
		request.setAttribute("minute", minute);
		request.setAttribute("adult", adultstr);
		request.setAttribute("child", childstr);
		request.setAttribute("old", oldstr);
		request.setAttribute("basicseat", basicseat);*/
		
		return "basicRoom.jsp";
	}

}
