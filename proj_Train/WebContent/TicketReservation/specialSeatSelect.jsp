<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<% 
	String mid = (String) session.getAttribute("mid");
	String tnum = (String) session.getAttribute("tnum");
	String error = request.getParameter("error");
	String errorMsg = null;
	String errorMsg2 = null;
	if(error != null && !error.equals("")){
		if(error.equals("seatselectO")){
			errorMsg = "이미 예약된 자리입니다. 다시 선택해주세요.";
		}else if(error.equals("trtcX")){
			errorMsg2 = "정보가 잘못입력되었습니다. 다시 입력하세요.";
		}
	}
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
	width: 535px;
	margin: 16px auto;
	font-size: 16px;
}

/* Reset top and bottom margins from certain elements */
.login-header, .login p {
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
	width: 495px;
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
	text-align: center;
}

/* Every row inside .login-container is defined with p tags */
.login p {
	padding: 12px;
}

.login input {
	box-sizing: border-box;
	display: block;
	/* width: 100%; */
	border-width: 1px;
	border-style: solid;
	padding: 15px;
	outline: 0;
	font-family: inherit;
	font-size: 0.75em;
}

.login input[type="email"], .login input[type="password"] {
	background: #fff;
	border-color: #bbb;
	color: #555;
}

/* Text fields' focus effect */
.login input[type="email"]:focus, .login input[type="password"]:focus {
	border-color: #888;
}

.login input[type="submit"] {
	width: 495px;
	background: #28d;
	border-color: transparent;
	color: #fff;
	cursor: pointer;
}

.login input[type="button"] {

	width: 495px;
	
}

.login input[type="button"]:hover {
  background: #D8D8D8;
}
.login input[type="submit"]:hover {
	background: #17c;
}
/* .login input[type="checkbox"]{
	width:20px;
	height:20px;
} */
/* Buttons' focus effect */
.login input[type="submit"]:focus {
	border-color: #05a;
}

table, td, th {
	background-color: #F2F2F2;
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}

th {
	background-color: gray;
}

th, td {
	padding: 15px;
	/* width: 45px; */
}

td:HOVER {
	color: red;
	cursor: pointer;
}
</style>
<script>
	function moves(link) {
		switch (link) {

		case "cancle":
			location.href = "checkMenu.do";
			break;
		}

	}
</script>
</head>

<body>
<div class="login">
	<div class="login-triangle"></div>
	<div id="login-form">
	<h2 class="login-header">특실 자리선택</h2>
	<form class="login-container" action="specialSeatSelectProc.do" method="post">
		<table>
			<tr>
				<%-- <%for(int i =0 ;i<40; i+=4) {%> --%>
				<c:forEach var="i" begin="0" end="39" step="4">
				<td>
				<input type="checkbox" name="specialseat" value="${i+1}">
					<c:choose>
					<c:when test="${specialseat == i+1 }">
							<font color="red">${i+1}</font>
					</c:when>
					<c:when test="${specialseat != i+1 }">
							<font color="black">${i+1}</font>
					</c:when>
					</c:choose>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<%-- <%for(int j =1 ;j<40; j+=4) {%> --%>
				<c:forEach var="j" begin="1" end="39" step="4">
				<td>
				<input type="checkbox" name="specialseat" value="${j+1}">
					<c:choose>
					<c:when test="${specialseat == j+1 }">
							<font color="red">${j+1}</font>
					</c:when>
					<c:when test="${specialseat != j+1 }">
							<font color="black">${j+1}</font>
					</c:when>
					</c:choose>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<td colspan="10">통로</td>
			</tr>
			<tr>
				<%-- <%for(int x =2 ;x<40; x+=4) {%> --%>
				<c:forEach var="x" begin="2" end="39" step="4">
				<td>
				<input type="checkbox" name="specialseat" value="${x+1}">
					<c:choose>
					
					<c:when test="${specialseat == x+1 }">
							<font color="red">${x+1}</font>
					</c:when>
					<c:when test="${specialseat != x+1 }">
							<font color="black">${x+1}</font>
					</c:when>
					</c:choose>
				</td>
				</c:forEach>
			</tr>
			<tr>
				<%-- <%for(int y =3 ;y<40; y+=4) {%> --%>
				<c:forEach var="y" begin="3" end="39" step="4">
				<td>
				<input type="checkbox" name="specialseat" value="${y+1}">
					<c:choose>
					<c:when test="${specialseat == y+1 }">
							<font color="red">${y+1}</font>
					</c:when>
					<c:when test="${specialseat != y+1 }">
							<font color="black">${y+1}</font>
					</c:when>
					</c:choose>
				</td>
				</c:forEach>
			</tr>
		</table>
		
		<p><input type="submit" value="선택">
		<input type="button" class="mainBtn" value="뒤로가기" onclick="moves('cancle');"></p>
		
	</form>
	</div>
	</div>
</body>

</html>