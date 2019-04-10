<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-登录</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	
	<script type="text/javascript">
		window.onload=function(){
			//var reUser = document.getElementById('reUser');
			var reUser = document.forms[0].reUser;//获取复选框对象
			var btnObj = document.forms[0].btnLog;//获取按钮对象
			
			
			//当进入登录界面时，显示localStorage中的username的值
			var userValue = localStorage.getItem("username");
			//把userValue的值填充到username的控制上
			document.forms[0].username.value = userValue;
			
			//执行按钮的点击事件
			btnObj.onclick=function(){
				//获取“用户名”的数据
				var usernameValue = document.forms[0].username.value;//tom
				
				if(reUser.checked){
					//保存“用户名”数据
					localStorage.setItem("username",usernameValue);
				}
				document.forms[0].submit();//提交表单数据
			}
			
		}
	</script>
</head>
<body>
	<!--  引入header.jsp页面 -->
	<jsp:include page="header.jsp"/>

	<div class="login_top clearfix">
		<a href="index.jsp" class="login_logo"><img src="images/logo02.png"></a>	
	</div>

	<div class="login_form_bg">
		<div class="login_form_wrap clearfix">
			<div class="login_banner fl"></div>
			<div class="slogan fl">日夜兼程 · 急速送达</div>
			<div class="login_form fr">
				<div class="login_title clearfix">
					<h1>用户登录</h1>
					<a href="#">立即注册</a>
				</div>
				
				<div class="form_input">
					<form action="${pageContext.request.contextPath}/UserServlet?method=login" method="post">
						<input type="text" name="username" class="name_input" placeholder="请输入用户名">
						<div class="user_error">输入错误</div>
						<input type="password" name="pwd" class="pass_input" placeholder="请输入密码">
						<div class="pwd_error">输入错误</div>
						<div class="more_input clearfix">
							<input type="checkbox" id="reUser" name="reUser">
							<label>记住用户名</label>
							<a href="#">忘记密码</a>
						</div>
						<input type="button" id="btnLog" name="btnLog" value="登录" class="input_submit">
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 引入footer.jsp页面 -->
	<jsp:include page="footer.jsp"/>
	
</body>
</html>