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
<!-- Custom Theme files -->
<!--webfont-->
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<!--webfont-->
<!-- <link href='http://fonts.useso.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'> -->

<link rel="stylesheet" href="../css/Input.css" media="screen"
	type="text/css" />
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
							<li class="active"><a href="../">首页</a></li>
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
				<div class="heading">
					<span>账号<em>管理</em></span>
				</div>
				<div class="span_5">
					<div class="feature_grid">

						<div class="col-md-6">
							<div class="h-features-grid">
								<i class="f_icon2"> </i>
								<div class="features-grid-right">
									<c:if test="${sessionScope.darkPassword == null}">
										<h4>使用前请核对暗码</h4>
										<form name="input" action="updateDark" method="POST">
											<div class="wrap">
												<input type="password" placeholder="请输入暗码"
													name="darkPassword" />
												<button type="submit">确认</button>
											</div>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
											<c:if test="${error != null}">
												<span>${error}</span>
											</c:if>
										</form>

									</c:if>

									<c:if test="${sessionScope.darkPassword != null}">
										<span>暗码已经确认!</span>
									</c:if>
									<p>请不要告诉任何人暗码,任何工作人员不会向你索取暗码.</p>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<c:if test="${sessionScope.darkPassword != null}">
						<div class="col-md-6">
						<div class="h-features-grid">
							<i class="f_icon1"> </i>
							<div class="features-grid-right">
								<h4>搜索:</h4>
								<form name="input" action="findByName" method="POST">
											<div class="wrap">
												<input type="text" placeholder="搜索..."
													name="name" />
												<button type="submit">确认</button>
											</div>
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
					</c:if>
					</div>
					<c:if test="${sessionScope.darkPassword != null}">
					<div class="feature_grid">
						<div class="col-md-6">
							<div class="h-features-grid">
								<i class="f_icon3"> </i>
								<div class="features-grid-right">
									<form name="input" action="toInsert" method="POST">
											<input type="submit"
												value="添加新资料" />
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="h-features-grid">
								<i class="f_icon4"> </i>
								<div class="features-grid-right">
									<form name="input" action="showAll" method="POST">
											<input type="submit"
												value="察看所有资料" />
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" />
										</form>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					</c:if>
					<div class="clearfix"></div>
				</div>
				<div class="feature_grid1">
					<div class="col-md-4">
						<ul class="service_box">
							<li class="service_box-left"><span class="num"><img
									src="../images/tick.png" alt="" /></span></li>
							<li class="service_box-right">
								<h3>每日备份数据</h3>
								<p>说明还没有想好...</p>
							</li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<div class="col-md-4">
						<ul class="service_box">
							<li class="service_box-left"><span class="num"><img
									src="../images/tick.png" alt="" /></span></li>
							<li class="service_box-right">
								<h3>7x24小时监控</h3>
								<p>说明还没有想好...</p>
							</li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<div class="col-md-4">
						<ul class="service_box">
							<li class="service_box-left"><span class="num"><img
									src="../images/tick.png" alt="" /></span></li>
							<li class="service_box-right">
								<h3>几乎无尽的空间</h3>
								<p>说明还没有想好...</p>
							</li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="feature_grid1 span_8">
					<div class="col-md-4">
						<ul class="service_box">
							<li class="service_box-left"><span class="num"><img
									src="../images/tick.png" alt="" /></span></li>
							<li class="service_box-right">
								<h3>全球无盲点访问</h3>
								<p>说明还没有想好...</p>
							</li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<div class="col-md-4">
						<ul class="service_box">
							<li class="service_box-left"><span class="num"><img
									src="../images/tick.png" alt="" /></span></li>
							<li class="service_box-right">
								<h3>99.5% 不间断服务</h3>
								<p>说明还没有想好...</p>
							</li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<div class="col-md-4">
						<ul class="service_box">
							<li class="service_box-left"><span class="num"><img
									src="../images/tick.png" alt="" /></span></li>
							<li class="service_box-right">
								<h3>无解的安全加密</h3>
								<p>说明还没有想好...</p>
							</li>
							<div class="clearfix"></div>
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
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
