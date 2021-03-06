<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="UTF-8">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
	href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
<link rel="stylesheet" href="${APP_PATH}/css/main.css">
<style>
.tree li {
	list-style-type: none;
	cursor: pointer;
}

table tbody tr:nth-child(odd) {
	background: #F4F4F4;
}

table tbody td:nth-child(even) {
	color: #C00;
}
</style>
</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<div>
					<a class="navbar-brand" style="font-size: 32px;" href="#">众筹平台
						- 用户维护</a>
				</div>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li style="padding-top: 8px;">
						<div class="btn-group">
							<button type="button"
								class="btn btn-default btn-success dropdown-toggle"
								data-toggle="dropdown">
								<i class="glyphicon glyphicon-user"></i> ${loginUser.username} <span
									class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#"><i class="glyphicon glyphicon-cog"></i>
										个人设置</a></li>
								<li><a href="#"><i class="glyphicon glyphicon-comment"></i>
										消息</a></li>
								<li class="divider"></li>
								<li><a href="${APP_PATH}/logout"><i
										class="glyphicon glyphicon-off"></i> 退出系统</a></li>
							</ul>
						</div>
					</li>
					<li style="margin-left: 10px; padding-top: 8px;">
						<button type="button" class="btn btn-default btn-danger">
							<span class="glyphicon glyphicon-question-sign"></span> 帮助
						</button>
					</li>
				</ul>
				<form class="navbar-form navbar-right">
					<input type="text" class="form-control" placeholder="Search...">
				</form>
			</div>
		</div>
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<div class="tree">
					<%-- <ul style="padding-left: 0px;" class="list-group">
						<li class="list-group-item tree-closed"><a href="main.html"><i
								class="glyphicon glyphicon-dashboard"></i> 控制面板</a></li>
						<li class="list-group-item"><span><i
								class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span
								class="badge" style="float: right">3</span></span>
							<ul style="margin-top: 10px;">
								<li style="height: 30px;"><a href="${APP_PATH}/user/index"
									style="color: red;"><i class="glyphicon glyphicon-user"></i>
										用户维护</a></li>
								<li style="height: 30px;"><a href="${APP_PATH}/role/index"><i
										class="glyphicon glyphicon-king"></i> 角色维护</a></li>
								<li style="height: 30px;"><a href="${APP_PATH}/permission/index"><i
										class="glyphicon glyphicon-lock"></i> 许可维护</a></li>
							</ul></li>
						<li class="list-group-item tree-closed"><span><i
								class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge"
								style="float: right">3</span></span>
							<ul style="margin-top: 10px; display: none;">
								<li style="height: 30px;"><a href="auth_cert.html"><i
										class="glyphicon glyphicon-check"></i> 实名认证审核</a></li>
								<li style="height: 30px;"><a href="auth_adv.html"><i
										class="glyphicon glyphicon-check"></i> 广告审核</a></li>
								<li style="height: 30px;"><a href="auth_project.html"><i
										class="glyphicon glyphicon-check"></i> 项目审核</a></li>
							</ul></li>
						<li class="list-group-item tree-closed"><span><i
								class="glyphicon glyphicon-th-large"></i> 业务管理 <span
								class="badge" style="float: right">7</span></span>
							<ul style="margin-top: 10px; display: none;">
								<li style="height: 30px;"><a href="cert.html"><i
										class="glyphicon glyphicon-picture"></i> 资质维护</a></li>
								<li style="height: 30px;"><a href="type.html"><i
										class="glyphicon glyphicon-equalizer"></i> 分类管理</a></li>
								<li style="height: 30px;"><a href="process.html"><i
										class="glyphicon glyphicon-random"></i> 流程管理</a></li>
								<li style="height: 30px;"><a href="advertisement.html"><i
										class="glyphicon glyphicon-hdd"></i> 广告管理</a></li>
								<li style="height: 30px;"><a href="message.html"><i
										class="glyphicon glyphicon-comment"></i> 消息模板</a></li>
								<li style="height: 30px;"><a href="project_type.html"><i
										class="glyphicon glyphicon-list"></i> 项目分类</a></li>
								<li style="height: 30px;"><a href="tag.html"><i
										class="glyphicon glyphicon-tags"></i> 项目标签</a></li>
							</ul></li>
						<li class="list-group-item tree-closed"><a href="param.html"><i
								class="glyphicon glyphicon-list-alt"></i> 参数管理</a></li>
					</ul> --%>
					<%@include file="/WEB-INF/jsp/common/menue.jsp" %>
				</div>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<i class="glyphicon glyphicon-th"></i> 数据列表
						</h3>
					</div>
					<div class="panel-body">
						<form class="form-inline" role="form" style="float: left;">
							<div class="form-group has-feedback">
								<div class="input-group">
									<div class="input-group-addon">查询条件</div>
									<input class="form-control has-success" type="text" id="queryText"
										placeholder="请输入查询条件">
								</div>
							</div>
							<button id="queryBtn" type="button" class="btn btn-warning">
								<i class="glyphicon glyphicon-search"></i> 查询
							</button>
						</form>
						<button type="button" id="batchDelBtn" class="btn btn-danger"
							style="float: right; margin-left: 10px;">
							<i class=" glyphicon glyphicon-remove"></i> 删除
						</button>
						<button type="button" class="btn btn-primary"
							style="float: right;" onclick="window.location.href='${APP_PATH}/user/add'">
							<i class="glyphicon glyphicon-plus"></i> 新增
						</button>
						<br>
						<hr style="clear: both;">
						<div class="table-responsive">
						<form id="userForm">
							<table class="table  table-bordered">
								<thead>
									<tr>
										<th width="30">#</th>
										<th width="30"><input type="checkbox" id="BoxAll"></th>
										<th>账号</th>
										<th>名称</th>
										<th>邮箱地址</th>
										<th width="100">操作</th>
									</tr>
								</thead>
								
								<tbody id="userData">

								</tbody>
								
								<tfoot>
									<tr>
										<td colspan="6" align="center">
											<ul class="pagination">

											</ul>
										</td>
									</tr>

								</tfoot>
							</table>
							</frorm>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
	<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APP_PATH}/script/docs.min.js"></script>
	<script src="${APP_PATH}/layer/layer.js"></script>
	<script type="text/javascript">
	     var likeflag=true; 
		$(function() {
			
			$(".list-group-item").click(function() {
				if ($(this).find("ul")) {
					$(this).toggleClass("tree-closed");
					if ($(this).hasClass("tree-closed")) {
						$("ul", this).hide("fast");
					} else {
						$("ul", this).show("fast");
					}
				}
			});
			pageQuery(1);
			
			//模糊查询
	        $("#queryBtn").click(function(){
	        	var queryText = $("#queryText").val();
	        	if(queryText !=""){//说明有内容,likeflag=false
	        		likeflag = false;
	        	}
	        	pageQuery(1);
	        });
			
			
			//全选按钮
			$("#BoxAll").click(function(){
				var flag = this.checked;//获取选择状态
				
				$("#userData :checkbox").each(function(i,checkbox){
					this.checked=flag;
				});
			});
			
			//批量删除按钮
			$("#batchDelBtn").click(function(){
				var boxs = $("#userData :checked");
		        if(boxs.length==0){
		        	layer.msg("请选择需要删除的用户信息", {
						time : 1000,
						icon : 5,
						shift : 6
					}, function() {
					});
		        }else{
		        	var index;
					layer.confirm("删除选择的用户信息,是否继续",  {icon: 3, title:'提示'}, function(cindex){
						//第一个代表的是确定按钮
						$.ajax({
							type:"POST",
							url:"${APP_PATH}/user/deleteBoath",
							data:$("#userForm").serialize(),
							success:function(result){
								if (result.success == true) {
									window.location.href="${APP_PATH}/user/index";
								}else{
									layer.msg("用户信息删除失败", {
										time : 1000,
										icon : 5,
										shift : 6
									}, function() {
									});
								}
							}
						}); 
					}, function(cindex){
						//第二个代表的是取消按钮
					    layer.close(cindex);
					});
		        }
			});
		});
		$("tbody .btn-success").click(function() {
			window.location.href = "assignRole.html";
		});
		$("tbody .btn-primary").click(function() {
			window.location.href = "edit.html";
		});
		
		//内容加载
		function pageQuery(pageno) {
			var loadingIndex;
			var jsonData= {"pageno" : pageno,"pagesize" : 2};
			if(!likeflag){//说明有内容
				jsonData.queryText = $("#queryText").val();
			}
			$
					.ajax({
						type : "POST",
						url : "${APP_PATH}/user/pageQuery",
						data : jsonData,
						beforeSend : function() {//代表发送数据前怎么怎么做
							loadingIndex = layer.msg('数据处理中', {
								icon : 16
							});
						},
						success : function(result) {
							layer.close(loadingIndex);
							if (result.success == true) {
								//局部刷新数据
								var tableContext = "";
								var PageContext = "";

								var pageData = result.data;
								var userData = pageData.datas;
								//i当前索引,user 当前临时数据
								//shift + alt + a
								$.each(userData,function(i, user) {
									tableContext += '	 <tr>  ';
									tableContext += '    <td>'+(i+1)+'</td>';
									tableContext += '	  <td><input type="checkbox"  name="ids"  value="'+user.id+'" </td>';
									tableContext += '    <td>'+user.loginacct+'</td>';
									tableContext += '    <td>'+user.username+'</td>';
									tableContext += '    <td>'+user.email+'</td>';
									tableContext += '    <td>';
									tableContext += '	      <button type="button" onclick="goAssignRole('+user.id+')" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>';
									tableContext += '	      <button type="button" onclick="updateUser('+user.id+')" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>';
									tableContext += '		  <button type="button" onclick="deleteUser('+user.id+',\''+user.loginacct+'\')" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>';
									tableContext += '	  </td>';
									tableContext += '  </tr>';
								});
                                if(pageno>1){//上一页的判断
                                	PageContext+='<li><a href="#" onclick="pageQuery('+(pageno-1)+')">上一页</a></li>';
                                }
                                for(var i=1;i<=pageData.totalno;i++){
                                	if(i==pageno){
                                		PageContext+='<li class="active"><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
                                	}else{
                                		PageContext+='<li><a href="#" onclick="pageQuery('+i+')">'+i+'</a></li>';
                                	}
                                	
                                }
                                if(pageno<pageData.totalno){//下一页的判断
                                	PageContext+='<li><a href="#" onclick="pageQuery('+(pageno+1)+')">下一页</a></li>';
                                }
								$("#userData").html(tableContext);
								$(".pagination").html(PageContext);
							} else {
								layer.msg("用户分页查询失败", {
									time : 1000,
									icon : 5,
									shift : 6
								}, function() {
								});
							}
						}
					});
		}
		//修改
		function updateUser(uid){
			window.location.href="${APP_PATH}/user/edit?id="+ uid;
			
		}
		
		//删除
		function deleteUser(uid,loginacct){
			var index;
			layer.confirm("删除用户信息【"+loginacct+"】,是否继续",  {icon: 3, title:'提示'}, function(cindex){
				//第一个代表的是确定按钮
				$.ajax({
					type:"POST",
					url:"${APP_PATH}/user/delete",
					data:{
						"id":uid
					},
					success:function(result){
						if (result.success == true) {
							window.location.href="${APP_PATH}/user/index";
						}else{
							layer.msg("用户信息删除失败", {
								time : 1000,
								icon : 5,
								shift : 6
							}, function() {
							});
						}
					}
				});
			}, function(cindex){
				//第二个代表的是取消按钮
			    layer.close(cindex);
			});
		}
		function goAssignRole(uid){
			window.location.href="${APP_PATH}/user/assignRole?id="+ uid;
		}
	</script>
</body>
</html>
