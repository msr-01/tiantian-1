<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-用户中心</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
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
				<li><a href="user_center_order.jsp" class="active">· 全部订单</a></li>
				<li><a href="user_center_site.jsp">· 收货地址</a></li>
			</ul>
		</div>
		<div class="right_content clearfix">
				<h3 class="common_title2">全部订单</h3>
				
				<!-- ========================start============================= -->
				<c:forEach var="order" items="${orderList}">
						<ul class="order_list_th w978 clearfix">
							<li class="col01">${order.ordertime }</li>
							<li class="col02">订单号：${order.oid }</li>
							<li class="col02 stress">未支付</li>		
						</ul>
		
						<table class="order_list_table w980">
							<tbody>
								<tr>
									<td width="55%">
										<c:forEach var="orderItem" items="${order.orderItemList }">
											<ul class="order_goods_list clearfix">					
												<li class="col01"><img src="${orderItem.product.pimage }"></li>
												<li class="col02">${orderItem.product.pname }<em>${orderItem.product.shopPrice }元</em></li>	
												<li class="col03">${orderItem.quantity }</li>
												<li class="col04">${orderItem.total }元</li>	
											</ul>
										</c:forEach>
									</td>
									<td width="15%">${order.total}元</td>
									<td width="15%">待付款</td>
									<td width="15%"><a href="#" class="oper_btn">去付款</a></td>
								</tr>
							</tbody>
						</table>
				</c:forEach>
				
				<!-- ========================end============================= -->

				<div class="pagenation">
					<a href="#">上一页</a>
					<a href="#" class="active">1</a>
					<a href="#">2</a>
					<a href="#">3</a>
					<a href="#">4</a>
					<a href="#">5</a>
					<a href="#">下一页></a>
				</div>
		</div>
	</div>



	<!-- 引入footer.jsp页面 -->
	<jsp:include page="footer.jsp"/>
	
</body>
</html>