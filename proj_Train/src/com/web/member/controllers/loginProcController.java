package com.web.member.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.MemberDAO;
import com.train.vo.Member;
import com.web.controllers.Controller;

public class loginProcController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		String rememberID = request.getParameter("rememberID");
		System.out.println("rememberID : " + rememberID);
		String rememberPWD = request.getParameter("rememberPWD");
		System.out.println("rememberPWD : " + rememberPWD);
		System.out.println("mid : " + mid);
		
		MemberDAO dao = new MemberDAO();
		Member m = dao.getMember(mid);
		System.out.println("m : "+ m);
			if(m == null){ /* 아이디 중복검사 */
				System.out.println("존재하지 않는 아이디입니다.");
				//response.sendRedirect("login.jsp?error=IDx");
				return "redirect:login.do?error=IDx";
			}else if(!m.getPwd().equals(pwd)){
				System.out.println("비밀번호가 틀렸습니다.");
				//response.sendRedirect("login.jsp?error=PWDx");
				return "redirect:login.do?error=PWDx";
			}else{
				System.out.println(m.getName()+" 님 환영합니다.");
				HttpSession session=request.getSession();
				session.setAttribute("mid", mid);
				
				if(rememberID != null && !rememberID.equals("")){
					Cookie ckmid = new Cookie("mid", mid);
					ckmid.setMaxAge(60*60*24*30); //연산자 사용하면댐 
					response.addCookie(ckmid);	
					System.out.println("ckmid 쿠키저장");
				}else{
					Cookie ckmid = new Cookie("mid", null);
					ckmid.setMaxAge(0); 
					response.addCookie(ckmid);
					System.out.println("ckmid 쿠키삭제");
				}
				
				if(rememberPWD != null && !rememberPWD.equals("")){
					Cookie ckpwd = new Cookie("pwd", pwd);
					ckpwd.setMaxAge(60*60*24*30); //연산자 사용하면댐 
					response.addCookie(ckpwd);	
					System.out.println("ckpwd 쿠키저장");
				}else{
					Cookie ckpwd = new Cookie("pwd", pwd);
					ckpwd.setMaxAge(0); //연산자 사용하면댐 
					response.addCookie(ckpwd);	
					System.out.println("ckpwd 쿠키저장");
				}
				
				//response.sendRedirect("myMenu.jsp");
				return "redirect:myMenu.do";
			}
	}

}
