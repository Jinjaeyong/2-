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
				errorMsg = "�̹� ����� �ڸ��Դϴ�. �ٽ� �������ּ���.";
			}else if(error.equals("trtcX")){
				errorMsg2 = "������ �߸��ԷµǾ����ϴ�. �ٽ� �Է��ϼ���.";
			}
		}
		
		request.setAttribute("error", error);
		request.setAttribute("errorMsg", errorMsg);
		request.setAttribute("errorMsg2", errorMsg2);
		
		return "specialSeatSelect.jsp";
	}

}
