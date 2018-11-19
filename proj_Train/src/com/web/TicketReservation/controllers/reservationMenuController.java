package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.MemberDAO;
import com.train.vo.Member;
import com.web.controllers.Controller;

public class reservationMenuController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String mid = (String) session.getAttribute("mid");
		
		System.out.println("mid : " + mid);
		
		MemberDAO dao = new MemberDAO();
		Member m = dao.getMember(mid); 
		System.out.println(m.getMid());
		System.out.println(m.getMnum());
		request.setAttribute("m", m);
		
		return "reservationMenu.jsp";
	}

}
