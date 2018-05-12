<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>七角星 白金密码箱-开发版--首页</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Protectly Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/Login.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!--webfont-->
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!--webfont-->
<!-- <link href='http://fonts.useso.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'> -->
<!-- Add fancyBox main JS and CSS files -->
<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
<link href="css/popup.css" rel="stylesheet" type="text/css">
<script>
	$(document).ready(function() {
		$('.popup-with-zoom-anim').magnificPopup({
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});
	});
</script>
<!--Animation-->
<script src="js/wow.min.js"></script>
<link href="css/animate.css" rel='stylesheet' type='text/css' />
<script>
	new WOW().init();
</script>
</head>
<body>
	<div class="header">
		<div class="container">
			<div class="header_top">
				<div class="header-left">
					<div class="logo wow bounceInDown" data-wow-delay="0.4s">
						<a href="./"><img src="images/logo/logo2.png"  alt="" /></a>
					</div>
					<div class="menu">
						<a class="toggleMenu" href="#"><img src="images/nav.png"
							alt="" /></a>
						<ul class="nav" id="nav">
							<li class="active"><a href="./">首页</a></li>
							<sec:authorize access="hasRole('Acc_AB')">
							<li><a href="./AccountBase/index">账号管理</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('GOD')">
							<li><a href="./devLog">开发日志</a></li>
							</sec:authorize>
							<sec:authorize access="hasRole('Acc_AD')">
							<li><a href="./admin">账号管理</a></li>
							</sec:authorize>
							
							<div class="clearfix"></div>
						</ul>
						<script type="text/javascript" src="js/responsive-nav.js"></script>
					</div>
					<div class="clearfix"></div>
				</div>

				<ul class="phone wow fadeInUpBig" data-wow-delay="0.4s">
					<li><p>
							开发版Ver 1.0  
							<c:if test="${pageContext.request.userPrincipal.name != null}">
							欢迎你: ${pageContext.request.userPrincipal.name}!
							<a href="<c:url value="./logout" />">[登出]</a>
							</c:if>
							<c:if test="${pageContext.request.userPrincipal.name == null}">
								<a class="btn btn-primary btn-large theme-login" href="<c:url value="./login" />">登录</a>
							</c:if>
					</p></li>
				</ul>
				<div class="clearfix"></div>
			</div>
			<div class="header_bottom">
				<h1 class="m_head wow rollIn" data-wow-delay="0.4s">
					保存您的敏感资料<br> 使用最安全的解决方案.
				</h1>
				<div class="video_buttons">
					<div class="video_but">
						<a href="./AccountBase/index" class="fa-btn btn-1 btn-1e">马上开始!</a>
					</div>
					<div class="video_right">
						<a class="play-icon popup-with-zoom-anim" href="#small-dialog">
							<span> </span>
						<p class="video_desc">查看视频(彩蛋)</p>
						</a>
						<div id="small-dialog" class="mfp-hide">
						<iframe height=498 width=510 src="http://player.youku.com/embed/XNTg5NTg2NDU2" frameborder=0 allowfullscreen></iframe>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="copyrights">
		Collect from <a href="http://www.sencorsta.com/">七角星</a>
	</div>
	<div class="main">
		<div class="content_top">
			<div class="container">
				<ul class="clients wow fadeInUpBig" data-wow-delay="0.4s">
					<li><img src="images/logo/1.png" class="img-responsive" alt="" /></li>
					<li><img src="images/logo/2.png" class="img-responsive" alt="" /></li>
					<li><img src="images/logo/3.png" class="img-responsive" alt="" /></li>
					<li><img src="images/logo/4.png" class="img-responsive" alt="" /></li>
					<li><img src="images/logo/5.png" class="img-responsive" alt="" /></li>
					<div class="clearfix"></div>
				</ul>
				<div class="wmuSlider example1">
					<div class="wmuSliderWrapper">
						<article style="position: absolute; width: 100%; opacity: 0;">
						<div class="banner-wrap">
							<h2>因为账号密码太多而烦恼?</h2>
							<p>七角星产品[白金密码箱]为你带来完美解决方案,简单几步即可使用，使用云服务安全保存账号密码!</p>
							<h3>
								 <span class="m_1">安全...</span>
							</h3>
						</div>
						</article>
						<article style="position: relative; width: 100%; opacity: 1;">
						<div class="banner-wrap">
							<h2>为什么选择[白金密码箱]?</h2>
							<p>整合最新加密手段,即使知道算法,使用最快的计算机破解也要几万年,网页,传输,后台,数据库,多重加密,保证资料万无一失</p>
							<h3>
								<span class="m_1">坚固...</span>
							</h3>
						</div>
						</article>
						<article style="position: relative; width: 100%; opacity: 1;">
						<div class="banner-wrap">
							<h2>随时随地使用</h2>
							<p>兼容所有平台,多浏览器支持，实现随时随地使用</p>
							<h3>
								<span class="m_1">高效...</span>
							</h3>
						</div>
						</article>
					</div>
					<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
				</div>
				<script src="js/jquery.wmuSlider.js"></script>
				<script>
					$('.example1').wmuSlider();
				</script>
			</div>
		</div>
		<div class="content_bottom wow rollIn" data-wow-delay="0.4s">
			<div class="container">
				<h2>如何确保数据安全?</h2>
				<p>密码使用密文保存.暗码验证为不可逆设计,数据库密码全密文,即使账号被盗在不知道暗码的情况下也无法查看数据</p>
				<div class="grid_1 text-center">
					<div class="col-md-4 span_1">
						<img src="images/sharing.jpg" class="img-responsive" alt="" />
						<h3>多重加密方案</h3>
					</div>
					<div class="col-md-4 span_1">
						<img src="images/shield.jpg" class="img-responsive" alt="" />
						<h3>最安全的服务器环境</h3>
					</div>
					<div class="col-md-4 span_1">
						<img src="images/access.jpg" class="img-responsive" alt="" />
						<h3>完善的权限控制</h3>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer_icon">
		<i class="icon"><img src="images/footer_icon.png"> </i>
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
					Copyright &copy; 2016. <br>
					SenCorSta All rights reserved.
				</p>
			</div>
		</div>
	</div>
<div class="theme-popover-mask"></div>

</body>
</html>
