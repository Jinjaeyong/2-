package com.web.member.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.controllers.Controller;

public class loginController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cookieMid=null;	
		String cookiePwd=null;	
		Cookie[] coos = request.getCookies();
		if(coos != null){
			for(Cookie ck : coos){
				if(ck.getName().equals("mid")){
					cookieMid = ck.getValue();
				}else if(ck.getName().equals("pwd")){
					cookiePwd = ck.getValue();
				}
			}		
		}
		System.out.println("cookieMid : " +cookieMid);
		System.out.println("cookiePwd : " +cookiePwd);

	    String error = request.getParameter("error");
		String errorMsg=null;
		if(error != null && !error.equals("")){
			if(error.equals("IDx")){
				errorMsg = "아이디가 틀렸습니다.";
				System.out.println("");
			}else if(error.equals("PWDx")){
				errorMsg = "비밀번호가 틀렸습니다.";
				System.out.println("");
			}
		}
		
		request.setAttribute("cookieMid", cookieMid);
		request.setAttribute("cookiePwd", cookiePwd);
		request.setAttribute("coos", coos);
		request.setAttribute("error", error);
		request.setAttribute("errorMsg", errorMsg);
		
		return "login.jsp";
	}

}
