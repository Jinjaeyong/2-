<%@page import="com.train.vo.TicketReservation"%>
<%@page import="com.train.dao.TicketReservationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<% 
String mid = (String)session.getAttribute("mid");
String tnum = (String)session.getAttribute("tnum");
String gogo = (String)session.getAttribute("gogo");
System.out.println("gogo : " + gogo);
String finish = (String)session.getAttribute("finish");
System.out.println("finish : " + finish);
String day = (String)session.getAttribute("day");
String hour = (String)session.getAttribute("hour");
String minute = (String)session.getAttribute("minute");

String adult = (String)session.getAttribute("adult");
System.out.println("adult : " + adult);
int adultstr = Integer.parseInt(adult);
String child = (String)session.getAttribute("child");
System.out.println("child : " + child);
int childstr = Integer.parseInt(child);
String old = (String)session.getAttribute("old");
System.out.println("old : " + old);
int oldstr = Integer.parseInt(old);
String specialseat = (String)session.getAttribute("specialseat"); 
System.out.println("specialseat : " + specialseat); 
/* TicketReservationDAO dao = new TicketReservationDAO();
TicketReservation tr = dao.getInfor(tnum); */
 //TrainCheckDAO ddao = new TrainCheckDAO();
 //TicketReservation tc = dao.getSpecialseat(specialseat);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
		table, td,th{ background-color:#F2F2F2; border: 1px solid black; border-collapse: collapse;}
	th{ background-color: gray; }
	
	th,td { padding: 12px;	width: 400px;}
	
	td:HOVER {
		color: red;
		cursor: pointer;
	}
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
</style>
<script>
	function moves(link){
		switch(link){
		
		case "cancle":
			location.href="checkMenu.do";
		break;
		}
		
	}
</script>
</head>
<body>
<div class="login">
	<div class="login-triangle"></div>
	<div id="login-form">
	<h2 class="login-header">특실 예매페이지</h2>
	
	<form class="login-container" action="specialRoomproc.do" method="post">
	 <table>
		<tr>
			<td>출발 :<c:if test="${gogo == '1'}"> 서울
			</c:if>
			<c:if test="${gogo == '2'}">원주
			</c:if>
			<c:if test="${gogo == '3'}">강릉
			</c:if>
			<c:if test="${gogo == '4'}">부산
			</c:if>
			</td>
		</tr>
			<td>
			도착 :<c:if test="${finish == '1'}">서울
			</c:if>
			<c:if test="${finish == '2'}">원주
			</c:if>
			<c:if test="${finish == '3'}">강릉
			</c:if>
			<c:if test="${finish == '4'}">부산
			</c:if>
			</td>
		</tr>
			<td>출발날짜 : 2018년 10월${day}일 ${hour}시${minute}분</td>
		</tr>
			<td>인원 정보(어른-어린이-경로 순) : ${adult}-${child}-${old}</td>
		</tr>
			<td>좌석 : 특실${specialseat }</td>
		</tr>
			<td>가격 :
			<c:if test="${adult != 0 or child !=0 or old != 0 }">
				<c:if test="${adult != 0 or child !=0 or old != 0 }">
				<c:if test="${gogo == '1' and finish == '2' }">${adult*6000+child*5000+old*5500 }원
				</c:if>
				<c:if test="${gogo == '1' and finish == '3' }">${adult*10000+child*9000+old*9500 }원
				</c:if>
				<c:if test="${gogo == '1' and finish == '4' }">${adult*20000+child*19000+old*19500 }원
				</c:if>
				<c:if test="${gogo == '2' and finish == '1' }">${adult*6000+child*5000+old*5500 }원
				</c:if>
				<c:if test="${gogo == '2' and finish == '3' }">${adult*5000+child*4000+old*4500 }원
				</c:if>
				<c:if test="${gogo == '2' and finish == '4' }">${adult*18000+child*17000+old*17500 }원
				</c:if>
				<c:if test="${gogo == '3' and finish == '1' }">${adult*10000+child*9000+old*9500 }원
				</c:if>
				<c:if test="${gogo == '3' and finish == '2' }">${adult*5000+child*4000+old*4500 }원
				</c:if>
				<c:if test="${gogo == '3' and finish == '4' }">${adult*16000+child*15000+old*15500 }원
				</c:if>
				<c:if test="${gogo == '4' and finish == '1' }">${adult*20000+child*19000+old*19500 }원
				</c:if>
				<c:if test="${gogo == '4' and finish == '2' }">${adult*18000+child*17000+old*17500 }원
				</c:if>
				<c:if test="${gogo == '4' and finish == '3' }">${adult*16000+child*15000+old*15500 }원
				</c:if>
			</c:if>	
			</c:if>	
			<c:if test="${adult == 0 and child ==0 and old == 0 }">
			인원선택해주세요
			</c:if>	
			</td>
		</tr>
	</table>
	<p><input type="submit" value="예약하기"></p>
	<input type="hidden" name="mid" value="아이디">
	<p><input type="button" class="mainBtn" value="뒤로가기" onclick="moves('cancle');"/></p>
		</form>
		</div>
		</div>
</body>
</html>