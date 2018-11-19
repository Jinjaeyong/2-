<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%
	String gogo =(String)session.getAttribute("gogo");
	System.out.println("gogo : " + gogo);
	String finish =(String)session.getAttribute("finish");
	System.out.println("finish : " + finish);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Open+Sans:400,700);
		table, td,th{ background-color:#F2F2F2; border: 1px solid black; border-collapse: collapse; text-align: center;}
	th{ background-color: gray; }
	
	th,td { padding: 15px;	}
	
	td:HOVER {
		color: red;
		cursor: pointer;
	}
html, body { height:100%; overflow:hidden } 
.h-div {height:96%; border:3px #f99 solid}

body {

  background-image: url('../images/korail.jpg');
  background-size: 100% 100%;
  
  /* background: #456; */
  font-family: 'Open Sans', sans-serif;
}


.login {
  width: 420px;
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

.login input[type="mid"],
.login input[type="pwd"] {
  background: #fff;
  border-color: #bbb;
  color: #555;
}

/* Text fields' focus effect */
.login input[type="mid"]:focus,
.login input[type="pwd"]:focus {
  border-color: #888;
}

.login input[color="color1"] {
  background: #F6CEEC;
  border-color: transparent;
  color: #fff;
  cursor: pointer;
}
.login input[color="color2"] {
  background: #FAAC58;
  border-color: transparent;
  color: #fff;
  cursor: pointer;
}
.login input[color="color3"] {
  background: #E2A9F3;
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
<div class="login">
	<div class="login-triangle"></div>
	<div id="login-form">
	<h2 class="login-header">
				
				<c:if test="${gogo =='1'}"> 서울
				</c:if>
				<c:if test="${gogo =='2'}">원주
				</c:if>
				<c:if test="${gogo =='3'}">강릉
				</c:if>
				<c:if test="${gogo =='4'}">부산
				</c:if>
				->  
				<c:if test="${finish =='1'}">서울
				</c:if>
				<c:if test="${finish =='2'}">원주
				</c:if>
				<c:if test="${finish =='3'}">강릉
				</c:if>
				<c:if test="${finish =='4'}">부산
				</c:if>
				행 무궁화열차 요금조회
	</h2>
	<table>
	
	<tr>
		<td colspan="3">특실</td>
		<td colspan="3">일반실</td>
	</tr>
	<tr>
		<td>어른</td>
		<td>어린이</td>
		<td>경로</td>
		<td>어른</td>
		<td>어린이</td>
		<td>경로</td>
	</tr>
	<tr>
		
		<c:if test="${gogo =='1' && finish =='2'}">
		<td>6000</td>
		<td>5000</td>
		<td>5500</td>
		<td>5000</td>
		<td>4000</td>
		<td>4500</td>
		</c:if>
		<c:if test="${gogo =='1' && finish =='3'}">
		<td>10000</td>
		<td>9000</td>
		<td>9500</td>
		<td>9000</td>
		<td>8000</td>
		<td>8500</td>
		</c:if>
		<c:if test="${gogo =='1' && finish =='4'}">
		<td>20000</td>
		<td>19000</td>
		<td>19500</td>
		<td>19000</td>
		<td>18000</td>
		<td>18500</td>
		</c:if>
		<c:if test="${gogo =='2' && finish =='1'}">
		<td>6000</td>
		<td>5000</td>
		<td>5500</td>
		<td>5000</td>
		<td>4000</td>
		<td>4500</td>
		</c:if>
		<c:if test="${gogo =='2' && finish =='3'}">
		<td>5000</td>
		<td>4000</td>
		<td>4500</td>
		<td>4000</td>
		<td>3000</td>
		<td>3500</td>
		</c:if>
		<c:if test="${gogo =='2' && finish =='4'}">
		<td>18000</td>
		<td>17000</td>
		<td>17500</td>
		<td>17000</td>
		<td>16000</td>
		<td>16500</td>
		</c:if>
		<c:if test="${gogo =='3' && finish =='1'}">
		<td>10000</td>
		<td>9000</td>
		<td>9500</td>
		<td>9000</td>
		<td>8000</td>
		<td>8500</td>
		</c:if>
		<c:if test="${gogo =='3' && finish =='2'}">
		<td>5000</td>
		<td>4000</td>
		<td>4500</td>
		<td>4000</td>
		<td>3000</td>
		<td>3500</td>
		</c:if>
		<c:if test="${gogo =='3' && finish =='4'}">
		<td>16000</td>
		<td>15000</td>
		<td>15500</td>
		<td>15000</td>
		<td>14000</td>
		<td>14500</td>
		</c:if>
		<c:if test="${gogo =='4' && finish =='1'}">
		<td>20000</td>
		<td>19000</td>
		<td>19500</td>
		<td>19000</td>
		<td>18000</td>
		<td>18500</td>
		</c:if>
		<c:if test="${gogo =='4' && finish =='2'}">
		<td>18000</td>
		<td>17000</td>
		<td>17500</td>
		<td>17000</td>
		<td>16000</td>
		<td>16500</td>
		</c:if>
		<c:if test="${gogo =='4' && finish =='3'}">
		<td>16000</td>
		<td>15000</td>
		<td>15500</td>
		<td>15000</td>
		<td>14000</td>
		<td>14500</td>
		</c:if>
	</tr>
	</table>
	<form class="login-container"  action="checkMenu.do">
				<p><input color="color4" type="submit" value="뒤로가기"/></p>
		</form>
	</div>
	</div>
</body>
</html>