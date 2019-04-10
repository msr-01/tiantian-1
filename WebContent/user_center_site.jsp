<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-用户中心</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	
	<script type="text/javascript">
		//北京市 海淀区 东北旺西路8号中关村软件园 （李思 收） 182****7528
		$(function(){
			//当页面加载的时候，去获取localStorage数据
			var addr = localStorage.getItem("addr");   // 
			//把数据填充到 dd 标签中去
			$("dd").html(addr);  //
			
			
			$("#btn").click(function(){
				//获取表单控制元素的值
				var username = $("#username").val();
				var address = $("#address").val();
				var telephone = $("#telephone").val();
				
				var addrStr = address + "（"+username+" 收）" + telephone;
				//获取dd的区域
				$("dd").html(addrStr);
				
				//把提交过来的数据存储到本地localStorage中去
				localStorage.setItem("addr",addrStr);
			});
		})
	</script>
</head>
<body>
	<!--  引入header.jsp页面 -->
	<jsp:include page="header.jsp"/>

	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="images/logo.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
		<div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>		
	</div>

	<div class="main_con clearfix">
		<div class="left_menu_con clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="user_center_info.jsp">· 个人信息</a></li>
				<li><a href="user_center_order.jsp">· 全部订单</a></li>
				<li><a href="user_center_site.jsp" class="active">· 收货地址</a></li>
			</ul>
		</div>
		<div class="right_content clearfix">
				<h3 class="common_title2">收货地址</h3>
				<div class="site_con">
					<dl>
						<dt>当前地址：</dt>
						<dd></dd>
					</dl>					
				</div>
				<h3 class="common_title2">编辑地址</h3>
				<div class="site_con">
					<form action="place_order.jsp" method="post">
						<div class="form_group">
							<label>收件人：</label>
							<input type="text" id="username" name="username">
						</div>
						<div class="form_group form_group2">
							<label>详细地址：</label>
							<textarea class="site_area" id="address" name="address"></textarea>
						</div>
						<div class="form_group">
							<label>手机：</label>
							<input type="text" id="telephone" name="telephone">
						</div>

						<input type="submit" id="btn" value="提交" class="info_submit">
					</form>
				</div>
		</div>
	</div>



	<!-- 引入footer.jsp页面 -->
	<jsp:include page="footer.jsp"/>
	
</body>
</html>