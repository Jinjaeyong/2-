<%@page import="com.train.dao.TicketReservationDAO"%>
<%@page import="com.train.vo.TicketReservation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 	String mid = (String)session.getAttribute("mid");
    String tnum = (String)session.getAttribute("tnum");
    List<TicketReservation> trlist = (List<TicketReservation>)request.getAttribute("trlist");
    
    
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
		table, td,th{ background-color:#BDBDBD; border: 1px solid black; border-collapse: collapse; text-align: center;}
	th{ background-color: gray; }
	
	th,td { padding: 15px;	}
	
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
  width: 520px;
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
	width:480px;
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
.login input[color="color4"] {
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
.mainBtn {}
</style>
</head>
<body>
<div style="overflow:scroll; width 600px; height: 100%">
<div class="login">
	<div class="login-triangle"></div>
	<div id="login-form">
	<h2 class="login-header">내 승차권 조회</h2>
	<div class="login-container">
		<table>
			<thead>
				<tr>
					<td>출발지</td>
					<td>도착지</td>
					<td>출발시간</td>
					<td>티켓번호</td>
					<td>일반실</td>
					<td>특실</td>
				</tr>
			</thead>
			<tbody>
				 <%for(int i =0; i<trlist.size();i++){%>
				<tr>
					<td>
					 	<%if(trlist.get(i).getGogo().equals("1")) {%>서울
						<%} else if(trlist.get(i).getGogo().equals("2")) {%>원주
						<%} else if(trlist.get(i).getGogo().equals("3")) {%>강릉
						<%} else if(trlist.get(i).getGogo().equals("4")) {%>부산
						<%}%>
					</td>	
					<td>
						<%if(trlist.get(i).getFinish().equals("1")) {%>서울
						<%} else if(trlist.get(i).getFinish().equals("2")) {%>원주
						<%} else if(trlist.get(i).getFinish().equals("3")) {%>강릉
						<%} else if(trlist.get(i).getFinish().equals("4")) {%>부산
						<%}
						%>
					</td>
					<td><%=trlist.get(i).getDay()%>일 <%=trlist.get(i).getHour()%>시 <%=trlist.get(i).getMinute()%>분</td>
					<td><%=trlist.get(i).getTnum() %></td>
					<td>
						<%if(trlist.get(i).getBasicseat() == null||trlist.get(i).getBasicseat().equals(null)) {%>-
						<%} else if( trlist.get(i).getBasicseat() != null||! trlist.get(i).getBasicseat().equals(null)){%>
						<%=trlist.get(i).getBasicseat() %>
						<%}%>
					</td>
					<td>
						<%if(trlist.get(i).getSpecialseat() == null || trlist.get(i).getSpecialseat().equals(null)) {%>-
						<%} else if(trlist.get(i).getSpecialseat() == null || !trlist.get(i).getSpecialseat().equals(null)){%>
						<%=trlist.get(i).getSpecialseat() %>
						<%}%>
					</td>  
				</tr>
				<% }%>
					
			</tbody>
		</table>
		<form class="login-container"  action="ticketMenu.do">
				<p><input color="color4" type="submit" value="뒤로가기"/></p>
		</form>
		</div>
	</div>
	</div>
	</div>
</body>
</html>