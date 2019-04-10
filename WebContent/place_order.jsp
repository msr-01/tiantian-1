<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-提交订单</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			//从本地存储中获取数据
			var addr = localStorage.getItem("addr");
			//addr = 北京123（小张  收）13888888888    
			//js:substr(开始下标索引,截取的长度)  
			//js:substring(开始下标索引,结束下标索引);
			//indexOf(hello)  返回下标索引    abc hello 123
			
			//截取“地址”
			var address = addr.substring(0,addr.indexOf('（'));
			//截取“姓名”
			var name = addr.substring(addr.indexOf('（')+1,addr.indexOf('收）'));
			//截取“电话”
			var telephone = addr.substring(addr.indexOf('）')+1,addr.length);
			
			//把本地存储的数据填充到  labAaddr上
			$("#labAddr").html(addr);
			
			//获取a标签，执行点击事件
			$("#order_btn").click(function(){
				location.href = "OrderServlet?method=saveOrder&name="+name+"&address="+address+"&telephone="+telephone;
			});
		})
		
		
	</script>
	
</head>
<body>
	<!--  引入header.jsp页面 -->
	<jsp:include page="header.jsp"/>

	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="images/logo.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;提交订单</div>
		<div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>		
	</div>
	
	<h3 class="common_title">确认收货地址</h3>

	<div class="common_list_con clearfix">
		<dl>
			<dt>寄送到：</dt>
			<dd><input type="radio" name="" checked=""><label id="labAddr">请先填写收货地址！！！</label></dd>
		</dl>
		<a href="user_center_site.jsp" class="edit_site">编辑收货地址</a>

	</div>
	
	<h3 class="common_title">支付方式</h3>	
	<div class="common_list_con clearfix">
		<div class="pay_style_con clearfix">
			<input type="radio" name="pay_style" checked>
			<label class="cash">货到付款</label>
			<input type="radio" name="pay_style">
			<label class="weixin">微信支付</label>
			<input type="radio" name="pay_style">
			<label class="zhifubao"></label>
			<input type="radio" name="pay_style">
			<label class="bank">银行卡支付</label>
		</div>
	</div>

	<h3 class="common_title">商品列表</h3>
	
	<div class="common_list_con clearfix">
		<ul class="goods_list_th clearfix">
			<li class="col01">商品名称</li>
			<li class="col03">商品价格</li>
			<li class="col04">数量</li>
			<li class="col05">小计</li>		
		</ul>
		
		<!-- 遍历购物车中的数据 -->
		<c:forEach items="${cart.map}" var="map">
			<ul class="goods_list_td clearfix">
				<li class="col01">1</li>			
				<li class="col02"><img src="${map.value.product.pimage }"></li>
				<li class="col03">${map.value.product.pname }</li>
				<li class="col05">${map.value.product.shopPrice }元</li>
				<li class="col06">${map.value.num}</li>
				<li class="col07">${map.value.subTotal}元</li>	
			</ul>
		</c:forEach>
		
		
		
	</div>

	<h3 class="common_title">总金额结算</h3>

	<div class="common_list_con clearfix">
		<div class="settle_con">
			<div class="total_goods_count">共<em>2</em>件商品，总金额<b>${cart.total}元</b></div>
		</div>
	</div>

	<div class="order_submit clearfix">
		<a href="#" id="order_btn">提交订单</a>
	</div>	

	<!-- 引入footer.jsp页面 -->
	<jsp:include page="footer.jsp"/>

	<div class="popup_con">
		<div class="popup">
			<p>订单提交成功！</p>
		</div>
		
		<div class="mask"></div>
	</div>
</body>
</html>