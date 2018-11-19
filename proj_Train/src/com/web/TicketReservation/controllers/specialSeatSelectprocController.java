package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.TicketReservationDAO;
import com.train.vo.TicketReservation;
import com.web.controllers.Controller;

public class specialSeatSelectprocController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String mid = (String) session.getAttribute("mid");
		String tnum = (String) session.getAttribute("tnum");
		String specialseat = request.getParameter("specialseat");
		
		System.out.println("회원번호 : " + tnum);
		System.out.println("선택 좌석 : 특실 " + specialseat);

		TicketReservationDAO dao = new TicketReservationDAO();
		TicketReservation tr = dao.getSpecialseat(specialseat);
		if(tr != null){
			//response.sendRedirect("specialSeatSelect.jsp?error=seatselectO");
			return "redirect:specialSeatSelect.do";
		}else if (specialseat == null) {
			//response.sendRedirect("../TicketReservation/reservationMenu.jsp?error=trtcX");
			System.out.println("왜 일로 넘어와?");
			return "redirect:reservationMenu.do";
		} else {	
			tr = new TicketReservation();
			tr.setSpecialseat(specialseat);
			
				if(specialseat!=null){
					System.out.println("좌석선택 성공");
					session.setAttribute("specialseat", specialseat);
					//response.sendRedirect("checkMenu.jsp");
					return "redirect:checkMenu.do";
				}else{
					System.out.println("좌석선택 실패");
					//response.sendRedirect("specialSeatSelect.jsp");
					return "redirect:specialSeatSelect.do";
				}
		}
	}

}
