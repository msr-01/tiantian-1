<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-购物车</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript">
	
	
		//改变文本框数字
		function changeNum(type,pid){
			if(type == 0){
				//文本框
				alert("文本框");
				var input_num = document.getElementById('input_num');
				location.href = "CartServlet?method=updateCart&pid="+pid+"&num="+input_num.value;
			}else if(type == 1){
				//减
				alert("减");
				alert(obj.previousSibling);
				//location.href = "CartServlet?method=updateCart&pid="+pid+"&num="+obj.value-1;
			}else if(type == 2){
				//加
				alert("加");
				location.href = "CartServlet?method=updateCart&pid="+pid+"&num="+obj.value+1;
			}
		} 
	</script>
</head>
<body>
	<!--  引入header.jsp页面 -->
	<jsp:include page="header.jsp"/>
	

	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="images/logo.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;购物车</div>
		<div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>		
	</div>

	<div class="total_count">全部商品<em>2</em>件</div>	
	<ul class="cart_list_th clearfix">
		<li class="col01">商品图片</li>
		<li class="col02">商品名称</li>
		<li class="col03">商品价格</li>
		<li class="col04">数量</li>
		<li class="col05">小计</li>
		<li class="col06">操作</li>
	</ul>
	
	
	
	<c:forEach items="${cart.map}" var="map">
		<ul class="cart_list_td clearfix">
			<li class="col01"><input type="checkbox" name="" checked></li>
			<li class="col02" ><img src="${map.value.product.pimage }"></li>
			<li class="col03"></li>
			<li class="col04">${map.value.product.pname }</li>
			<li class="col05">${map.value.product.shopPrice }元</li>
			<li class="col06">
				<div class="num_add">
					<a href="javascript:changeNum(2,${map.value.product.pid}b);" id="num_add" class="add fl">+</a>
					<input type="text" onchange="changeNum(0,${map.value.product.pid})" id="input_num" class="num_show fl" value="${map.value.num }">	
					<a href="javascript:changeNum(1,${map.value.product.pid}a);"  id="num_minus" class="minus fl">-</a>	
				</div>
			</li>
			<li class="col07">${map.value.subTotal }元</li>
			<li class="col08"><a href="CartServlet?method=delCart&pid=${map.value.product.pid}">删除</a></li>
		</ul>
	</c:forEach>

	
	

	<ul class="settlements">
		<li class="col01"><input type="checkbox" name="" checked=""></li>
		<li class="col02">全选</li>
		<li class="col03">合计(不含运费)：<span>¥</span><em>${cart.total}</em><br>共计<b>2</b>件商品</li>
		<li class="col04"><a href="place_order.jsp">去结算</a></li>
	</ul>

	<!-- 引入footer.jsp页面 -->
	<jsp:include page="footer.jsp"/>
	
</body>
</html>