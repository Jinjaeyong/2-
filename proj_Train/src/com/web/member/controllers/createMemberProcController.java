package com.web.member.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.train.dao.MemberDAO;
import com.train.vo.Member;
import com.web.controllers.Controller;

public class createMemberProcController implements Controller {

	@Override
	public String doController(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String mid = request.getParameter("mid"); 
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age =  request.getParameter("age");
		int agestr = Integer.parseInt(age);
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String birthday = String.format("%s-%s-%s", year, month,day);
		String phone = request.getParameter("phone");
		String regdate = request.getParameter("regdate");

		double randomMnum = Math.random();
		int mnum = (int)(randomMnum * 100000)+10000;
		MemberDAO dao = new MemberDAO();
		Member m = dao.getMember(mid);
		//List<Member> list = dao.getMemberMnum(mid);
		
		System.out.println("mnum : " + mnum);
		System.out.println("mid : " + mid);
		System.out.println("pwd : " + pwd);
		System.out.println("pwd2 : " + pwd2);
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("birthday : " + birthday);;
		System.out.println("phone : " + phone);
		
		if(m != null){
			//response.sendRedirect("createMember.jsp?error=midO");
			return "redirect:createMember.do?error=midO";
		}else if(!pwd.equals(pwd2)){
			//response.sendRedirect("createMember.jsp?error=nosame");
			return "redirect:createMember.do?error=nosame";
		}else{
			m = new Member();
			m.setMid(mid);
			m.setPwd(pwd);
			m.setMnum(mnum);
			m.setName(name);
			m.setGender(gender);
			m.setAge(agestr);
			m.setBirthday(birthday);
			m.setPhone(phone);
			m.setRegdate(regdate);
			
			int cr =dao.addMember(m);
			if(cr==1){
				System.out.println("회원가입 성공");
				
				//response.sendRedirect("login.jsp");
				return "redirect:login.do";
			}else{
				System.out.println("회원가입 실패");
				//response.sendRedirect("../bankMain.jsp");
				return "redirect:../bankMain.do";
			}
		}
	}

}
