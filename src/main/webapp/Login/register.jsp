<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>七角星 白金密码箱-开发版--注册</title>
<!-- CSS -->

<link rel="stylesheet" href="Login/assets/css/reset.css">
<link rel="stylesheet" href="Login/assets/css/supersized.css">
<link rel="stylesheet" href="Login/assets/css/style.css">
</head>

<body onload='document.loginForm.username.focus();'>
	<div class="page-container">
		<h1>帐号注册</h1>
		
		<c:if test="${not empty msg}">
			<div id="msg">${msg}</div>
		</c:if>
		<form name='loginForm'
			action="<c:url value='./register' />" method='POST'  >
			<input type="text" name="username" class="username" placeholder="用户名">
			<input type="password" name="password" class="password" placeholder="密码">
			<input type='password' name='password2' class="password2" placeholder="确认密码"/>
			<input type='password' name='darkPassword' class="darkPassword" placeholder="暗码"/>
			<input type='password' name='darkPassword2' class="darkPassword2" placeholder="确认暗码"/>
				<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				<c:if test="${not empty error}">
			<div id="errorMsg">${error}</div>
		</c:if>
			<button name="submit" type="submit">注册</button>
			<button name="cancel" type="button" onClick="window.location.href='./'" >返回</button>
			<div class="error">
				<span>+</span>
			</div>
			<div class="error2">
				<span>+</span>
			</div>

		</form>
	</div>

	<!-- Javascript -->
	<script src="Login/assets/js/jquery-1.8.2.min.js"></script>
	<script src="Login/assets/js/supersized.3.2.7.min.js"></script>
	<script src="Login/assets/js/supersized-init.js"></script>
	<script src="Login/assets/js/scripts2.js"></script>

</body>

</html>