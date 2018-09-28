<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="usermodalForm">
	  <input type="hidden" name="userId" value="${tbUser.userId}">
	  <div class="form-group">
	    <label for="exampleInputEmail1">姓名</label>
	    <input type="text" name="flName" class="form-control" value="${tbUser.flName}" id="exampleInputEmail1" placeholder="姓名">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">电话号码</label>
	    <input type="text" name="phoneNo" class="form-control" value="${tbUser.phoneNo}" id="exampleInputPassword1" placeholder="电话号码">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">用户名</label>
	    <input type="text" name="username" class="form-control" value="${tbUser.username}" id="exampleInputPassword1" placeholder="用户名">
	  </div>
	</form>
</body>
</html>