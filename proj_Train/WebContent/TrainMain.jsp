<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

  background-image: url('images/korail.jpg');
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
*{ margin:0; padding: 0; }
#login-form{
         width:130px;
         margin:100px auto;
         border: 1px solid gray;
         border-radius: 5px;
         padding: 15px;
}

.login input[type="button"]:hover {
  background: #D8D8D8;
}

#login-form input, #login-form label{display:inline;}

#login-form label{margin-top: 10px;}
#login-form input{margin-top: 5px;}
#login-form input[type='image']{ margin: 10px auto;}
.mainBtn {}
</style>
<script>
	function moves(link){
		switch(link){
		case "login":
			location.href="./member/login.do";
		break;
		case "create":
			location.href="./member/createMember.do";
		break;
		}
		
	}
</script>
</head>
<body>
 	<div class="login">
  <div class="login-triangle"></div>
  
  <h2 class="login-header">Let's YongRail</h2>
 		<form class="login-container">
        <input type="button" class="mainBtn" value="로그인" onclick="moves('login');" />
        <br />
        <input type="button" class="mainBtn" value="회원가입" onclick="moves('create');"/>
		</form>
	</div>

</body>
</html>