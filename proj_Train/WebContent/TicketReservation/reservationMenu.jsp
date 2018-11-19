<%@page import="com.train.dao.TicketReservationDAO"%>
<%@page import="com.train.vo.TicketReservation"%>
<%@page import="java.util.List"%>
<%@page import="com.train.vo.Member"%>
<%@page import="com.train.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	
	/* MemberDAO dao = new MemberDAO();
	Member m = dao.getMember(mid);  */
	
	//TicketReservationDAO ddao = new TicketReservationDAO();
	//List<TicketReservation> list = ddao.getTRtnum(mid);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);
html, body { height:100%; overflow:hidden } 
.h-div {height:96%; border:3px #f99 solid}

body {

  background-image: url('../images/korail.jpg');
  background-size: 100% 100%;
  
  /* background: #456; */
  font-family: 'Open Sans', sans-serif;
}

.login {
  width: 400px;
  margin: 16px auto;
  font-size: 16px;
}

/* Reset top and bottom margins from certain elements */
.login-header,
.login p {
  margin-top: 0;
  margin-bottom: 0;
}

/* The triangle form is achieved by a CSS hack */
.login-triangle {
  width: 0;
  margin-right: auto;
  margin-left: auto;
  border: 12px solid transparent;
  border-bottom-color: #28d;
}

.login-header {
  background: #28d;
  padding: 20px;
  font-size: 1.4em;
  font-weight: normal;
  text-align: center;
  text-transform: uppercase;
  color: #fff;
}

.login-container {
  background: #ebebeb;
  padding: 12px;
}

/* Every row inside .login-container is defined with p tags */
.login p {
  padding: 12px;
}

.login input {
  box-sizing: border-box;
  display: block;
  width: 100%;
  border-width: 1px;
  border-style: solid;
  padding: 16px;
  outline: 0;
  font-family: inherit;
  font-size: 0.95em;
}

.login input[type="email"],
.login input[type="password"] {
  background: #fff;
  border-color: #bbb;
  color: #555;
}

/* Text fields' focus effect */
.login input[type="email"]:focus,
.login input[type="password"]:focus {
  border-color: #888;
}

.login input[type="submit"] {
  background: #28d;
  border-color: transparent;
  color: #fff;
  cursor: pointer;
}

.login input[type="submit"]:hover {
  background: #17c;
}

/* Buttons' focus effect */
.login input[type="submit"]:focus {
  border-color: #05a;
}
.login input[color="color4"] {
  background: #28d;
  border-color: transparent;
  color: #fff;
  cursor: pointer;
}
.login input[type="button"]:hover {
  background: #D8D8D8;
}
.mainBtn {}
</style>
<script>
	function moves(link){
		switch(link){
		
		case "cancle":
			location.href="ticketMenu.do";
		break;
		}
		
	}
</script>
</head>
<body>
<div class="login">
	<div class="login-triangle"></div>
	<div id="login-form">
	<h2 class="login-header">ticket reservation</h2>
	
	<form class="login-container" action="reservationMenuProc.do" method="post">
	<p>회원번호 : ${m.getMnum()}</p>
	<p><input type="tnum" name="tnum" placeholder="티켓번호"></p>
	
			<p>출발
				<select name="gogo">	
					<option value="1">1. 서울</option>
					<option value="2">2. 원주</option>
					<option value="3">3. 강릉</option>
					<option value="4">4. 부산</option>				
				</select> ->  	도착
			
				<select name="finish">
					<option value="1">1. 서울</option>
					<option value="2">2. 원주</option>
					<option value="3">3. 강릉</option>
					<option value="4">4. 부산</option>
				</select> 
			</p>
		
			 <p>출발날짜 2018년 10월
					<select name="day">
						<c:forEach var="i" begin="0" end="29">
							<c:if test="${i<10 }">
							<option value="0${i+1 }">${i+1 }</option>
							</c:if>
							<c:if test="${i>=10 }">
							<option value="${i+1 }">${i+1 }</option>
							</c:if>
						</c:forEach>
					</select>일
			
					<select name="hour">
						<c:forEach var="i" begin="0" end="23">
								<c:if test="${i<10 }">	
								<option value="0${i }">${i }</option>
								</c:if>
								<c:if test="${i>=10 }">
								<option value="${i }">${i }</option>
								</c:if>
						</c:forEach>
					</select>시
				
					<select name="minute">
						<c:forEach var="i" begin="0" end="59">
							
							<c:if test="${i<10 }">	
							<option value="${i }">${i }</option>
							</c:if>
							<c:if test="${i>=10 }">
							<option value="${i }">${i }</option>
							</c:if> 
						</c:forEach>
					</select>분
				</p>
			<p>인원 정보<br />
					<select name="adult">
					<option name="adultcnt" value="0" selected="selected">어른</option>
						<c:forEach var="i" begin="0" end="8">
							<c:if test="${i<10 }">
							<option value="${i+1 }">어른 ${i+1 }명</option>
							</c:if>
							<c:if test="${i>=10 }">
							<option value="${i+1 }">어른 ${i+1 }명</option>
							</c:if>
						</c:forEach>
					</select>
					<select name="child">
						<option name="childcnt" value="0" selected="selected">만 4세~12세</option>
						<c:forEach var="i" begin="0" end="8">
							<c:if test="${i<10 }">
							<option value="${i+1 }">어린이 ${i+1 }명</option>
							</c:if>
							<c:if test="${i>=10 }">
							<option value="${i+1 }">어린이 ${i+1 }명</option>
							</c:if>
						</c:forEach>
					</select>
					<select name="old">
						<option name="oldcnt" value="0" selected="selected">만 65세이상</option>
						<c:forEach var="i" begin="0" end="8">
							<c:if test="${i<10 }">
							<option value="${i+1 }">경로 ${i+1 }명</option>
							</c:if>
							<c:if test="${i>=10 }">
							<option value="${i+1 }">경로 ${i+1 }명</option>
							</c:if>
						</c:forEach>
					</select>
				</p>			
	<input type="submit" value="열차 조회하기">
	<br />
	<input type="button" class="mainBtn" value="뒤로가기" onclick="moves('cancle');" />
	</form>
	</div>
	</div>
</body>
</html>