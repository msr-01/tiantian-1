<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-商品列表</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<!--  引入header.jsp页面 -->
	<jsp:include page="header.jsp"/>

	<div class="search_bar clearfix">
		<a href="index.jsp" class="logo fl"><img src="images/logo.png"></a>
		<div class="search_con fl">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>
		<div class="guest_cart fr">
			<a href="#" class="cart_name fl">我的购物车</a>
			<div class="goods_count fl">1</div>
		</div>
	</div>

	<div class="navbar_con">
		<div class="navbar clearfix">
			<div class="subnav_con fl">
				<h1>全部商品分类</h1>	
				<span></span>			
				<ul class="subnav">
					<li><a href="#" class="fruit">新鲜水果</a></li>
					<li><a href="#" class="seafood">海鲜水产</a></li>
					<li><a href="#" class="meet">猪牛羊肉</a></li>
					<li><a href="#" class="egg">禽类蛋品</a></li>
					<li><a href="#" class="vegetables">新鲜蔬菜</a></li>
					<li><a href="#" class="ice">速冻食品</a></li>
				</ul>
			</div>
			<ul class="navlist fl">
				<li><a href="index.jsp">首页</a></li>
				<li class="interval">|</li>
				<li><a href="">手机生鲜</a></li>
				<li class="interval">|</li>
				<li><a href="">抽奖</a></li>
			</ul>
		</div>
	</div>

	<div class="breadcrumb">
		<a href="#">全部分类</a>
		<span>></span>
		<a href="#">${cname }</a>
	</div>

	<div class="main_wrap clearfix">
		<div class="l_wrap fl clearfix">
			<div class="new_goods">
				<h3>新品推荐</h3>
				<ul>
					
						<c:forEach var="product" items="${pList}" begin="0" end="1">
							<li>
								<a href="ProductServlet?method=findByPid&pid=${product.pid }"><img src="${product.pimage }"></a>
								<h4><a href="ProductServlet?method=findByPid&pid=${product.pid }">${product.pname }</a></h4>
								<div class="operate">
									<span class="prize">￥${product.shopPrice }</span>
									<a href="#" class="add_goods" title="加入购物车"></a>
								</div>
							</li>
						</c:forEach>
					
				</ul>
			</div>
		</div>

		<div class="r_wrap fr clearfix">
			<div class="sort_bar">
				<a href="#" class="active">默认</a>
				<a href="#">价格</a>
				<a href="#">人气</a>
			</div>

			<ul class="goods_type_list clearfix">
				<c:choose>
					<c:when test="${empty pList}">
						数据为空！！！
					</c:when>
					
					<c:otherwise>
						<c:forEach var="product" items="${pList}">
							<li>
								<a href="ProductServlet?method=findByPid&pid=${product.pid }"><img src="${product.pimage }"></a>
								<h4><a href="ProductServlet?method=findByPid&pid=${product.pid }">${product.pname }</a></h4>
								<div class="operate">
									<span class="prize">￥${product.shopPrice }</span>
									<a href="#" class="add_goods" title="加入购物车"></a>
								</div>
							</li>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</ul>
			

			<!-- <div class="pagenation">
				<a href="#">上一页</a>
				<a href="#" class="active">1</a>
				<a href="#">2</a>
				<a href="#">3</a>
				<a href="#">4</a>
				<a href="#">5</a>
				<a href="#">下一页></a>
			</div> -->
			
			<div class="pagenation">
				<a href="ProductServlet?method=findByCidPage&cid=${pList[0].category.cid}&cname=${pList[0].category.cname}&curPageSize=1">首页</a>
				<a href="ProductServlet?method=findByCidPage&cid=${pList[0].category.cid}&cname=${pList[0].category.cname}&curPageSize=${curPageSize -1}">上一页</a>
				<a href="ProductServlet?method=findByCidPage&cid=${pList[0].category.cid}&cname=${pList[0].category.cname}&curPageSize=${curPageSize +1}">下一页</a>
				<a href="ProductServlet?method=findByCidPage&cid=${pList[0].category.cid}&cname=${pList[0].category.cname}&curPageSize=${totalPageSize}">尾页</a>
			</div>
			
		</div>
	</div>

	<!-- 引入footer.jsp页面 -->
	<jsp:include page="footer.jsp"/>
	
</body>
</html>