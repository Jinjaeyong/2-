package com.web.member.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web.controllers.Controller;

public class updateMemberController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		 String mid = (String)session.getAttribute("mid");
		  
		  	String error = request.getParameter("error");
		  String errorMsg= null;
		  if(error != null && !error.equals("")){
			  if(error.equals("nosame")){
				  errorMsg = "비밀번호 확인이 일치하지 않습니다.";
			  }
		  }
		  
		  request.setAttribute("mid", mid);
		  request.setAttribute("error", error);
		  request.setAttribute("errorMsg", errorMsg);
		  
		  return "updateMember.jsp";
	}

}
