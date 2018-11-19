<%@page import="com.train.vo.TicketReservation"%>
<%@page import="com.train.dao.TicketReservationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String mid = (String)session.getAttribute("mid");  
	System.out.println("mid : " + mid);	
	String tnum =(String)session.getAttribute("tnum");
	System.out.println("tnum : " + tnum);
	String gogo =(String)session.getAttribute("gogo");
	System.out.println("gogo : " + gogo);
	String finish =(String)session.getAttribute("finish");
	System.out.println("finish : " + finish);
	String day =(String)session.getAttribute("day");
	System.out.println("day : " + day);
	String hour =(String)session.getAttribute("hour");
	int hourstr = Integer.parseInt(hour);
	System.out.println("hourstr : " + hourstr);
	String minute =(String)session.getAttribute("minute");
	
	TicketReservationDAO dao = new TicketReservationDAO();
	TicketReservation tr =dao.getInfor(tnum);
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, td,th{ background-color:#F2F2F2; border: 1px solid black; border-collapse: collapse; text-align: center;}
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
</style>
</head>
<body>
<div style="overflow:scroll; width 600px; height: 100%">
<div class="login">
	<div class="login-triangle"></div>
	<div id="login-form">
	<h2 class="login-header">Train Check</h2>
			<table>
			<tr>
				<td>출발</td>
				<td>도착</td>
				<td>일반실</td>
				<td>특실</td>
				<td>운임요금</td>
				<td>소요시간</td>
			</tr>
			 <tr><%for(int i =0 ; i<24; i++) { %> 
				<% if(hourstr <i){ %>
				<td><%if(gogo.equals("1")){ %>서울 <br><%=i%>: 00
				<%}else if(gogo.equals("2")){ %>원주 <br><%=i%>: 00
				<%}else if(gogo.equals("3")){ %>강릉 <br><%=i%>: 00
				<%}else if(gogo.equals("4")){ %>부산  <br><%=i%>: 00
				<%} %>
				</td>
				<td><%if(finish.equals("1")){ %>서울 
				<%}else if(finish.equals("2")){ %>원주 
				<%}else if(finish.equals("3")){ %>강릉 
				<%}else if(finish.equals("4")){ %>부산
				<%} %>	
				</td>
				<td>
				<a href="basicRoom.do" >예매</a><br>
				<a href="basicSeatSelect.do">좌석선택</a>
				</td>
				<td>
				<a href="specialRoom.do" >예매</a><br>
				<a href="specialSeatSelect.do">좌석선택</a>
				</td>
				<td>
				<a href="needFare.do" >조회</a>
				</td>
				<td>
				
					<%if(gogo.equals("1") && finish.equals("2")){%>1:00
					<%}else if(gogo.equals("1") && finish.equals("3")) {%>2:00
					<%}else if(gogo.equals("1") && finish.equals("4")) {%>3:30
					<%}else if(gogo.equals("2") && finish.equals("1")) {%>1:00
					<%}else if(gogo.equals("2") && finish.equals("3")) {%>1:00
					<%}else if(gogo.equals("2") && finish.equals("4")) {%>3:00
					<%}else if(gogo.equals("3") && finish.equals("1")) {%>2:00
					<%}else if(gogo.equals("3") && finish.equals("2")) {%>1:00
					<%}else if(gogo.equals("3") && finish.equals("4")) {%>4:00
					<%}else if(gogo.equals("4") && finish.equals("1")) {%>3:30
					<%}else if(gogo.equals("4") && finish.equals("2")) {%>3:30
					<%}else if(gogo.equals("4") && finish.equals("3")) {%>4:00
					<%}else{ %>X
					<%}
					} %>
				</td>
			</tr> <%} %>
		</table>
		<form class="login-container"  action="reservationMenu.do">
				<p><input color="color4" type="submit" value="뒤로가기"/></p>
		</form>
	</div>
	</div></div>
</body>
</html>