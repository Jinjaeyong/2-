package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.TicketReservationDAO;
import com.train.vo.TicketReservation;
import com.web.controllers.Controller;

public class basicSeatSelectprocController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String mid = (String) session.getAttribute("mid");
		String tnum = (String) session.getAttribute("tnum");
		String basicseat = request.getParameter("basicseat");
		
		System.out.println("회원번호 : " + tnum);
		System.out.println("선택 좌석 : 일반실 " + basicseat);
		
		TicketReservationDAO dao = new TicketReservationDAO();
		TicketReservation tr = dao.getBasicseat(basicseat);
		if(tr != null){
			//response.sendRedirect("basicSeatSelect.jsp?error=seatselectO");
			System.out.println("이미 예약된 자리입니다. 다른 곳을 선택해주세요.");
			return "redirect:basicSeatSelect.do";
		}else if (basicseat == null) {
			//response.sendRedirect("../TicketReservation/reservationMenu.jsp?error=trtcX");
			return "redirect:reservationMenu.do";
		} else {	
			tr = new TicketReservation();
			tr.setBasicseat(basicseat);
			
				if(basicseat!=null){
					System.out.println("좌석선택 성공");
					session.setAttribute("basicseat", basicseat);
					//response.sendRedirect("checkMenu.jsp");
					return "redirect:checkMenu.do";
				}else{
					System.out.println("좌석선택 실패");
					//response.sendRedirect("basicSeatSelect.jsp");
					return "redirect:basicSeatSelect.do";
				}
		}
	}

}
