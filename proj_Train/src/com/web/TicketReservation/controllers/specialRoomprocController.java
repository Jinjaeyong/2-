package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.TicketReservationDAO;
import com.train.vo.TicketReservation;
import com.web.controllers.Controller;

public class specialRoomprocController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
		String specialseat = (String)session.getAttribute("specialseat");
		System.out.println("specialseat : " + specialseat);
		String paynum = (String)session.getAttribute("paynum");
		TicketReservationDAO dao = new TicketReservationDAO();
		/* TicketReservation tr = dao.getInfor(tnum); */
		TicketReservation tr = new TicketReservation();
		tr = new TicketReservation();
		tr.setTnum(tnum);
		tr.setGogo(gogo);
		tr.setFinish(finish);
		tr.setOwner(mid);
		tr.setAdult(adult);
		tr.setChild(child);
		tr.setOld(old);
		tr.setDay(day);
		tr.setHour(hour);
		tr.setMinute(minute);
		/* TrainCheck tc = ddao.getBasicseat(basicseat); */
		System.out.println("tnum : " + tnum);
		tr.setSpecialseat(specialseat);
		tr.setPaynum(paynum);
		/* if() */
		int cr = dao.insertTRS(tr);
		System.out.println("cr : " + cr);
		
		if(cr==1){
			//response.sendRedirect("TicketingClear.jsp");
			return "TicketingClear.do";
		}else{
			System.out.println("오류 발생");
			return "specialRoom.do";
		}
	}

}
