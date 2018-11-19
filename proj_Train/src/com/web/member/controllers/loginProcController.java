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
			if(m == null){ /* ���̵� �ߺ��˻� */
				System.out.println("�������� �ʴ� ���̵��Դϴ�.");
				//response.sendRedirect("login.jsp?error=IDx");
				return "redirect:login.do?error=IDx";
			}else if(!m.getPwd().equals(pwd)){
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				//response.sendRedirect("login.jsp?error=PWDx");
				return "redirect:login.do?error=PWDx";
			}else{
				System.out.println(m.getName()+" �� ȯ���մϴ�.");
				HttpSession session=request.getSession();
				session.setAttribute("mid", mid);
				
				if(rememberID != null && !rememberID.equals("")){
					Cookie ckmid = new Cookie("mid", mid);
					ckmid.setMaxAge(60*60*24*30); //������ ����ϸ�� 
					response.addCookie(ckmid);	
					System.out.println("ckmid ��Ű����");
				}else{
					Cookie ckmid = new Cookie("mid", null);
					ckmid.setMaxAge(0); 
					response.addCookie(ckmid);
					System.out.println("ckmid ��Ű����");
				}
				
				if(rememberPWD != null && !rememberPWD.equals("")){
					Cookie ckpwd = new Cookie("pwd", pwd);
					ckpwd.setMaxAge(60*60*24*30); //������ ����ϸ�� 
					response.addCookie(ckpwd);	
					System.out.println("ckpwd ��Ű����");
				}else{
					Cookie ckpwd = new Cookie("pwd", pwd);
					ckpwd.setMaxAge(0); //������ ����ϸ�� 
					response.addCookie(ckpwd);	
					System.out.println("ckpwd ��Ű����");
				}
				
				//response.sendRedirect("myMenu.jsp");
				return "redirect:myMenu.do";
			}
	}

}
