<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="css/font-awesome.min.css">
	<link rel="stylesheet" href="css/login.css">
	<style>

	</style>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <div><a class="navbar-brand" href="index.html" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
      </div>
    </nav>

    <div class="container">
     <%--  <h1 style="color:red">${param.msg}</h1> --%>
      <form id="loginForm"  action="dologin" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-user"></i> 用户登录</h2>
		  <div class="form-group has-success has-feedback">
			<input type="text" class="form-control" id="loginacct" name="loginacct" placeholder="请输入登录账号"  autofocus>
			<span class="glyphicon glyphicon-user form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<input type="password" class="form-control" id="upsd" name="password" placeholder="请输入登录密码" style="margin-top:10px;">
			<span class="glyphicon glyphicon-lock form-control-feedback"></span>
		  </div>
		  <div class="form-group has-success has-feedback">
			<select class="form-control" >
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
		  </div>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住我
          </label>
          <br>
          <label>
            忘记密码
          </label>
          <label style="float:right">
            <a href="reg.html">我要注册</a>
          </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()" > 登录</a>
      </form>
    </div>
    <script src="jquery/jquery-2.1.1.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="layer/layer.js"></script>
    <script>
    /* function dologin() {
        var type = $(":selected").val();
        if ( type == "user" ) {
            window.location.href = "main.html";
        } else {
            window.location.href = "member.html";
        }
    } */
    function dologin() {
    	//非空校验
    	 var username = $("#loginacct").val(); 
    	//表单元素的value取值不会为null,取值是空字符串
     	if(username == ""){
    		//alert("用户登陆的账号不能为空,请输入");
    		layer.msg("用户登陆的账号不能为空,请输入", {time:1000, icon:5, shift:6}, function(){
    			 //alert("回调方法");
    		});
		
    		return ;
    	}
    	var pwd = $("#upsd").val();
    	if(pwd == ""){
    		//alert("用户登陆的密码不能为空");
    		layer.msg("用户登陆的密码不能为空,请输入", {time:1000, icon:5, shift:6}, function(){
    			//alert("回调方法");
   		});
    		return ;
    	}
    	//表单提交
    	//$("#loginForm").submit();
    	//使用ajax
    	var loadingIndex;
    	$.ajax({
    		type:"post",//请求形式
    		url:"doAjaxLogin",//发送的地址
    		data:{//发送的数据
    			loginacct:username,
    			password:pwd
    		},
    		beforeSend:function(){//代表发送数据前怎么怎么做
    			 loadingIndex = layer.msg('数据处理中', {icon: 16});
    		},
    	    success:function(result){
    	    	//关闭组件
    	    	layer.close(loadingIndex);
    	    	//
    	    	//alert(result);
    	    	if(result.success == true){
    	    		//alert("登陆成功");
    	    		window.location.href="main";
    	    	}else{
    	    		layer.msg("用户登陆的账号或密码错误,请重新输入", {time:1000, icon:5, shift:6}, function(){
    	    			//alert("回调方法");
    	   		     });
    	    	}
    	    }
    	});
    }
    </script>
  </body>
</html>