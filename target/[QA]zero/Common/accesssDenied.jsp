<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <h1>禁止访问,原因:</h1>

    <c:choose>
        <c:when test="${empty username}">
            <h2>拒绝访问:没有登录.</h2>
        </c:when>
        <c:otherwise>
            <h2>
               	 拒绝访问:用户 ${username} <br /> 没有相对应权限!
            </h2>
        </c:otherwise>
    </c:choose>

</body>
</html>
