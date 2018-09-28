<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="table table-striped table-bordered">
	<tr>
		<th></th>
		<th>Id</th>
		<th>名称</th>
		<th>描述</th>
	</tr>
	<c:forEach items="${roles}" var="role">
		<tr>
			<td><input type="checkbox" name="hasRoles" value="${role.roleId}" <c:if test="${!empty role.haveThisRoleUserId}">checked="checked"</c:if>></td>
			<td>${role.roleId}</td>
			<td>${role.roleName}</td>
			<td>${role.description}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>