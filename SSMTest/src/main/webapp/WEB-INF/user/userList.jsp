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
<style>
	th{
		text-align: center;
	}
	td{
		text-align: center;
	}
</style>
<body>
<form class="form-inline" action="${ctx}/user/list" onsubmit="return false">
  <div class="form-group">
    <label for="exampleInputName2">姓名</label>
    <input type="text" class="form-control" name="flName" id="exampleInputName2" placeholder="Jane Doe" value="${tbUser.flName}">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail2">账号</label>
    <input type="email" class="form-control" name="username" id="exampleInputEmail2" placeholder="0001" value="${tbUser.username}">
  </div>
  <button type="submit" class="btn btn-success" onclick="searchUser()">查找用户</button>
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" onclick="addUser()">添加用户</button>
</form>
<br>
<table class="table table-striped table-bordered table-hover">
	<tr>
		<th>Id</th>
		<th>用户名</th>
		<th>姓名</th>
		<th>电话号码</th>
		<th colspan="2">操作</th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr onclick="showRoleOfUser('${user.userId}',this)">
			<td>${user.userId}</td>
			<td>${user.username}</td>
			<td>${user.flName}</td>
			<td>${user.phoneNo}</td>
			<td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal" onclick="modifyUser('${user.userId}')">修改</button></td>
			<td><button type="button" class="btn btn-info" data-dismiss="alert" onclick="deleteUser('${user.userId}')">删除</button></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>