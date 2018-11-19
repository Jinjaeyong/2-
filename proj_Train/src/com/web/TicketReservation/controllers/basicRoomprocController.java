package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.TicketReservationDAO;
import com.train.vo.TicketReservation;
import com.web.controllers.Controller;

public class basicRoomprocController implements Controller {

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
		System.out.println("basicseat : " + basicseat);
		String ticketnum = (String)session.getAttribute("ticketnum");
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
		
		tr.setBasicseat(basicseat);
		tr.setPaynum(tnum);
		/* if() */
		int cr = dao.insertTRB(tr);
		System.out.println("tr : " + tr);
		System.out.println("tc.getBasicseat() :"+tr.getBasicseat());
		System.out.println("cr : " + cr);
		System.out.println("tc.getTnum():"+tr.getTnum());
		System.out.println("tnum : " + tnum);
		if(tr!=null){
			//response.sendRedirect("TicketingClear.jsp");
			return "redirect:TicketingClear.do";
		}else{
			System.out.println("오류 발생");
			return "redirect:basicRoomproc.do";
		}
	}

}
