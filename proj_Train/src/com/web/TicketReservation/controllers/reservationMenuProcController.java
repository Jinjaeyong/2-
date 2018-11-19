package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.MemberDAO;
import com.train.dao.TicketReservationDAO;
import com.train.vo.Member;
import com.train.vo.TicketReservation;
import com.web.controllers.Controller;

public class reservationMenuProcController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
		String mid = (String)session.getAttribute("mid"); 
		String tnum = request.getParameter("tnum");
		String gogo = request.getParameter("gogo");
		String finish = request.getParameter("finish");
		
		String day = request.getParameter("day");
		String hour = request.getParameter("hour");
		String minute = request.getParameter("minute");
				
		String adult = request.getParameter("adult");
		String child = request.getParameter("child");
		String old = request.getParameter("old");
		
		MemberDAO dao = new MemberDAO();
		Member m = dao.getMember(mid);

		System.out.println("Ƽ�Ϲ�ȣ :" + tnum);
		System.out.println("ȸ����ȣ : " + m.getMnum());
		System.out.println("����� : " + gogo);
		System.out.println("������ : " + finish);
		System.out.println("��� (��-��-��) : " + day+"-"+hour+"-"+minute);
		System.out.println("�ο����� (�-���-���) : " + adult+"-"+child+"-"+old);
		TicketReservationDAO ddao = new TicketReservationDAO();
		TicketReservation tr = ddao.getInfor(tnum);

		if(gogo.equals(finish)){ 
			System.out.println("������� �������� �����ϴ�.");
			//response.sendRedirect("reservationMenu.jsp");
			return "redirect:reservationMenu.do ";
		}else{
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
		
			 
			if(tnum!=null){
				System.out.println("�����Է� ����");
				session.setAttribute("tnum",tnum);
				session.setAttribute("gogo",gogo);
				session.setAttribute("finish",finish);
				session.setAttribute("owner",mid);
				session.setAttribute("adult",adult);
				session.setAttribute("child",child);
				session.setAttribute("old",old);
				session.setAttribute("day",day);
				session.setAttribute("hour",hour);
				session.setAttribute("minute",minute);
				
				//response.sendRedirect("../TrainCheck/checkMenu.jsp");
				return "redirect:checkMenu.do";
			 }else{
				System.out.println("�����Է� ����");
				//response.sendRedirect("reservationMenu.jsp");
				return "redirect:reservationMenu.do";
		
			} 
		}	
	}

}
