package com.web.member.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.train.dao.MemberDAO;
import com.train.vo.Member;
import com.web.controllers.Controller;

public class updateMemberProcController implements Controller{

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String mid = request.getParameter("mid");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String mid = (String)session.getAttribute("mid");
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		//String name=request.getParameter("name");
		String age = request.getParameter("age");
		int iage = Integer.parseInt(age);
		//String gender=request.getParameter("gender");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String birthday = String.format("%s-%s-%s", year, month, day);
		String phone = request.getParameter("phone");

		if(!pwd.equals(pwd2)){
			//esponse.sendRedirect("updateMember.jsp?error=nosame");
			return "redirect:updateMember.do?error=nosame";
		}else{
			Member m = new Member();
			m = new Member();
			m.setPwd(pwd);
			m.setAge(iage);
			m.setBirthday(birthday);
			m.setPhone(phone);
			m.setMid(mid);
			
			MemberDAO dao = new MemberDAO();
			int changeRow = dao.updateMember(m);
			if (changeRow == 1) {
				System.out.println("회원 정보 수정 성공");
				//response.sendRedirect("memberMenu.jsp");
				return "redirect:memberMenu.do";
			} else {
				System.out.println("회원 정보 수정 실패");
				//response.sendRedirect("../bankMain.jsp");
				return "redirect:../bankMain.do";
			}	
		}
	}

}
