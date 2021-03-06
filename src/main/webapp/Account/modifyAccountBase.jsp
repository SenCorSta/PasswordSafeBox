<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>七角星 白金密码箱-开发版--资料管理</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Protectly Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 




</script>
<link href="../css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="../css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" media="screen" href="../css/btnStyle.css" />
<link rel="stylesheet" type="text/css" media="screen" href="../css/css-table.css" />
<!-- Custom Theme files -->
<!--webfont-->
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<!--webfont-->
<!-- <link href='http://fonts.useso.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'> -->

<link rel="stylesheet" href="../css/Input.css" media="screen"
	type="text/css" />

<script type="text/javascript" src="../js/jquery-1.2.6.min.js"></script>
<script type="text/javascript" src="../js/style-table.js"></script>

<style type="text/css">
form.inputform input {
	max-height: 28px;
	max-width: 60px;
	
}

form.delform input {
	max-height: 28px;
	max-width: 60px;
	
}

form.inputform {
	float: left;
	max-width: 65px;
}

form.delform {
	float: left;
	max-width: 65px;
}
</style>
</head>
<body>
	<div class="price_header">
		<div class="container">
			<div class="header_top">
				<div class="header-left">
					<div class="logo">
						<a href="../"><img src="../images/logo/logo2.png" alt="" /></a>
					</div>
					<div class="menu">
						<a class="toggleMenu" href="#"><img src="../images/nav.png"
							alt="" /></a>
						<ul class="nav" id="nav">
							<li class="active"><a href="/zero">首页</a></li>
							<sec:authorize access="hasRole('Acc_AB')">
								<li><a href="/zero/AccountBase/index">账号管理</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('GOD')">
								<li><a href="/zero/devLog">开发日志</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('Acc_AD')">
								<li><a href="/zero/admin">账号管理</a></li>
							</sec:authorize>

							<div class="clearfix"></div>
						</ul>

						<script type="text/javascript" src="../js/responsive-nav.js"></script>
					</div>
				</div>
				<ul class="phone wow fadeInUpBig" data-wow-delay="0.4s">
					<li><p>
							开发版Ver 1.0
							<c:if test="${pageContext.request.userPrincipal.name != null}">
							欢迎你: ${pageContext.request.userPrincipal.name}!
							<a href="<c:url value="../logout" />">[登出]</a>
							</c:if>
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<a class="btn btn-primary btn-large theme-login"
									href="<c:url value="./login" />">登录</a>
							</c:if>
						</p></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>

	<div class="main">
		<div class="container">
			<div class="features">
			<form name="input" action="modifyByID" method="POST" id="thisform">
					修改资料: <br>
					<input type="hidden" value="${AccountBase.id }" name="ID">
					名称：<input type="text" value="${AccountBase.name }" name="name" placeholder="名称"/>
					类型：<input type="text" value="${AccountBase.kind }" name="kind" placeholder="类型"/>
					帐号：<input type="text" value="${AccountBase.account }" name="account" placeholder="帐号"/>
					密码：<input type="text" value="${AccountBase.password }" name="password" placeholder="密码"/>
					备注：<input type="text" value="${AccountBase.annotation }" name="annotation" placeholder="备注"/>
					<a class="btn btn-primary" href="javascript:document:thisform.submit();" type="submit">提交</a>
					<a href="/zero/AccountBase/index" class="btn btn-default">返回</a>				
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			
			</div>
		</div>
	</div>
	<div class="footer_icon">
		<i class="icon"><img src="../images/footer_icon.png"> </i>
	</div>
	<div class="footer">
		<div class="container">
			<div class="col-md-2 span_2">
				<h3>沉默者</h3>
				<ul class="list1">
					<li><a href="contact.html">介绍</a></li>
					<li><a href="#">企业文化</a></li>
					<li><a href="#">为什么选我们</a></li>
					<li><a href="#">解决方案</a></li>
					<li><a href="#">价格</a></li>
				</ul>
			</div>
			<div class="col-md-2 span_2">
				<h3>关于我们</h3>
				<ul class="list1">
					<li><a href="#">我们的故事</a></li>
					<li><a href="#">我们的领队</a></li>
					<li><a href="#">我们的顾文</a></li>
					<li><a href="#">加入我们</a></li>
				</ul>
			</div>
			<div class="col-md-2 span_2">
				<h3>技术支持</h3>
				<ul class="list1">
					<li><a href="#">帮助</a></li>
					<li><a href="#">隐私策略</a></li>
					<li><a href="#">使用条款</a></li>
					<li><a href="#">解决方案</a></li>
					<li><a href="#">定价</a></li>
				</ul>
			</div>
			<div class="col-md-6 span_3 wow fadeInRight" data-wow-delay="0.4s">
				<ul class="list2 list3">
					<i class="phone"> </i>
					<li class="phone_desc"><p>+(086)18516777825</p></li>
					<div class="clearfix"></div>
				</ul>
				<ul class="list2">
					<i class="msg"> </i>
					<li class="phone_desc"><p>
							<a href="mailto:icemaker@qq.com"> icemaker@qq.com</a>
						</p></li>
					<div class="clearfix"></div>
				</ul>
				<p class="copy">
					Copyright &copy; 2016. <br> SenCorSta All rights reserved.
				</p>
			</div>
		</div>
	</div>

</body>
</html>
