<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<title>七角星 白金密码箱-开发版--登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->

<link rel="stylesheet" href="Login/assets/css/reset.css">
<link rel="stylesheet" href="Login/assets/css/supersized.css">
<link rel="stylesheet" href="Login/assets/css/style.css">
</head>


</head>

<body>

	<div class="page-container">
		<h1>帐号登录</h1>
		<c:if test="${not empty msg}">
			<div id="msg">${msg}</div>
		</c:if>
		<form name='loginForm'
			action="<c:url value='./login_check?targetUrl=${targetUrl}' />" method='POST'>
			<input type="text" name="username" class="username" placeholder="用户名">
			<input type="password" name="password" class="password"
				placeholder="密码">
				<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
				<div id="reb">
				<c:if test="${empty loginUpdate}">
					两周内自动登录: <input type="checkbox" name="remember-me" />
				</c:if>
				</div>
				<c:if test="${not empty error}">
			<div id="errorMsg">${error}</div>
		</c:if>
		
			<button type="submit">登 录</button>
			<button type="button" onClick="window.location.href='./toRegister'" >注册</button>
			<button type="button" onClick="window.location.href='./'" >返回</button>
			<div class="error">
				<span>+</span>
			</div>
		</form>
	</div>

	<!-- Javascript -->
	<script src="Login/assets/js/jquery-1.8.2.min.js"></script>
	<script src="Login/assets/js/supersized.3.2.7.min.js"></script>
	<script src="Login/assets/js/supersized-init.js"></script>
	<script src="Login/assets/js/scripts.js"></script>

</body>

</html>

