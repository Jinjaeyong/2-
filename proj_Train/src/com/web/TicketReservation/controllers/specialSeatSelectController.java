package com.web.TicketReservation.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.controllers.Controller;

public class specialSeatSelectController implements Controller {

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String mid = (String) session.getAttribute("mid");
		String tnum = (String) session.getAttribute("tnum");
		String error = request.getParameter("error");
		String errorMsg = null;
		String errorMsg2 = null;
		if(error != null && !error.equals("")){
			if(error.equals("seatselectO")){
				errorMsg = "이미 예약된 자리입니다. 다시 선택해주세요.";
			}else if(error.equals("trtcX")){
				errorMsg2 = "정보가 잘못입력되었습니다. 다시 입력하세요.";
			}
		}
		
		request.setAttribute("error", error);
		request.setAttribute("errorMsg", errorMsg);
		request.setAttribute("errorMsg2", errorMsg2);
		
		return "specialSeatSelect.jsp";
	}

}
