package com.web.member.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controllers.Controller;

public class createMemberController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = request.getParameter("error");
	  	String errorMsg= null;
	  	String errorMsg2= null;
	  if(error != null && !error.equals("")){
		  if(error.equals("midO")){
			  errorMsg = "�̹� �����ϴ� ���̵� �Դϴ�. �ٽ� �Է��� �ּ���.";
		  }else if(error.equals("nosame")){
			  errorMsg2 = "��й�ȣ�� ���� �ٸ��ϴ�.";
		  }
	  }
	  
	  request.setAttribute("error", error);
	  request.setAttribute("errorMsg", errorMsg);
	  request.setAttribute("errorMsg2", errorMsg2);
	  
	  return "createMember.jsp";
	}

}
