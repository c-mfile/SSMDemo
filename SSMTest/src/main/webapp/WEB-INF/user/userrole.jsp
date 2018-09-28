<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${ctx}/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${ctx}/js/jquery.js"></script>
<script type="text/javascript" src="${ctx}/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<title>用户信息</title>
</head>
<body>
<div class="container">
<div>
<h1>用户信息管理
<small>对用户角色进行修改后</small>
<a href="#" class="btn btn-warning"  role="button" onclick="saveUserRole()">用户权限提交</a>
</h1>
</div>
	<div class="row">
		<div class="col-md-8">
			<div class="panel panel-info">
		      <div class="panel-heading">
		        <h3 class="panel-title">用户信息</h3>
		      </div>
		      <div class="panel-body" id="userInfo">
		                  用户信息列表
		      </div>
		    </div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-info">
		      <div class="panel-heading">
		        <h3 class="panel-title">角色信息</h3>
		      </div>
		      <div class="panel-body" id="roleInfo">
		                  角色信息列表
		      </div>
		    </div>
		</div>
	</div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">修改用户</h4>
      </div>
      <div class="modal-body" id="userForm">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="saveUser()">保存</button>
      </div>
    </div>
  </div>
</div>
<!-- addModal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">添加用户</h4>
      </div>
      <div class="modal-body" id="addUserForm">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" onclick="saveUser()">保存</button>
      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript">
	$(function(){
		ajaxSearchUser();
	})
	
	function searchUser(){
		var flName=$("input[name='flName']").val();
		var username=$("input[name='username']").val();
		ajaxSearchUser({flName:flName,username:username});
	}
	
	function ajaxSearchUser(paramData){
		$.ajax({
			url:"${ctx}/user/list",
			method:"get",
			data:paramData,
			success:function(callbackData){
				$("#userInfo").html(callbackData);
			}
		})
	}
	var nowUserId;
	function showRoleOfUser(userId,tr){
		if(nowUserId==userId){
			return false;
		}
		nowUserId=userId;
		ajaxSearchRoleOfUser(userId);
		$("tr").css("background-color","white");
		$(tr).css("background-color","	#87CEEB");
	}
	
	function ajaxSearchRoleOfUser(userId){
		$.ajax({
			url:"${ctx}/user/roles",
			method:"post",
			data:{userId:userId},
			success:function(callbackData){
				$("#roleInfo").html(callbackData);
			}
			
		})
	}
	
	function saveUserRole(){
		if(nowUserId==null || nowUserId==""){
			alert("请先选中带操作的用户，再保存");
			return false;
		}
		var roleIds="";
		$("input:checked").each(function(item){
			roleIds+=$(this).val()+","
		});
		$.ajax({
			url:"${ctx}/user/saveRoles"
			,data:{userId:nowUserId,roleIds:roleIds}
			,method:"post"
			,success:function(result){
				alert(result);
			}
		});
		
		
	}
	
	function modifyUser(userId){
		$.ajax({
		url:"${ctx}/user/getUser"
		,data:{userId:userId}
		,method:"post"
		,success:function(result){
			$("#userForm").html(result);
		}
	});
	}
	function saveUser(){
		var userId = $("#usermodalForm").find("input[name='userId']").val();
		var flName = $("#usermodalForm").find("input[name='flName']").val();
		var phoneNo = $("#usermodalForm").find("input[name='phoneNo']").val();
		var username = $("#usermodalForm").find("input[name='username']").val();
		$.ajax({
			url:"${ctx}/user/saveUser"
			,method:"post"
			,data:{userId:userId,flName:flName,phoneNo:phoneNo,username:username}
			,success:function(result){
				alert(result);
				$("#myModal").modal('hide');
				$("#addModal").modal('hide');
				searchUser();
			}
		});
	}
	function deleteUser(userId){
		var c = confirm("确认删除？");
		if(c){
			$.ajax({
				url:"${ctx}/user/delUser",
				data:{userId:userId},
				method:"get",
				success:function(result){
					searchUser();
				}
			});
		}
	}
	function addUser(){
		$.ajax({
			url:"${ctx}/user/addUser"
			,method:"post"
			,success:function(result){
				$("#addUserForm").html(result);
			}
		});
	}
</script>
</html>