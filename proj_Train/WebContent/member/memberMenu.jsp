<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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

.login input[color="color1"]:hover {
  background: #F5A9F2;
}
.login input[color="color3"]:hover {
  background: #F781BE;
}
.login input[color="color4"]:hover {
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
	<h2 class="login-header">MemberMenu</h2>
	<form class="login-container" action="updateMember.do">
		<p><input color="color1" type="submit" value="회원정보수정"/></p>
	</form>
	<form class="login-container"  action="delMemberProc.do">
		<p><input color="color3" type="submit" value="회원탈퇴"/></p>
	</form>	
	
	<form class="login-container"  action="myMenu.do">
		<p><input color="color4" type="submit" value="myMenu로가기"/></p>
	</form>
	</div>
	</div>
	
</body>
</html>