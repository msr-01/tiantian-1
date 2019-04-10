<%@page import="com.msr.bean.Category"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>天天生鲜-首页</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/slide.js"></script>
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
			<div class="goods_count fl" id="show_count">1</div>
		</div>
	</div>

	<div class="navbar_con">
		<div class="navbar">
			<h1 class="fl">全部商品分类</h1>
			<ul class="navlist fl">
				<li><a href="">首页</a></li>
				<li class="interval">|</li>
				<li><a href="">手机生鲜</a></li>
				<li class="interval">|</li>
				<li><a href="">抽奖</a></li>
			</ul>
		</div>
	</div>

	<div class="center_con clearfix">
	
	
		<c:set var="strCss" value="${fn:split('fruit,seafood,meet,egg,vegetables,ice',',') }"></c:set>
		<c:set var="aHref" value="${fn:split('#model01,#model02,#model03,#model04,#model05,#model06',',') }"></c:set>
		<ul class="subnav fl">
			<c:choose>
				<c:when test="${empty cList}">
					数据为空！！！
				</c:when>
				
				<c:otherwise>
					<c:forEach var="c" items="${cList}" varStatus="i">
						<li><a href='${aHref[i.index]}' class='${strCss[i.index]}'>${c.cname }</a></li>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
		</ul>
		
		
		<div class="slide fl">
			<ul class="slide_pics">
				<li><img src="images/slide.jpg" alt="幻灯片"></li>
				<li><img src="images/slide02.jpg" alt="幻灯片"></li>
				<li><img src="images/slide03.jpg" alt="幻灯片"></li>
				<li><img src="images/slide04.jpg" alt="幻灯片"></li>
			</ul>
			<div class="prev"></div>
			<div class="next"></div>
			<ul class="points"></ul>
		</div>
		<div class="adv fl">
			<a href="#"><img src="images/adv01.jpg"></a>
			<a href="#"><img src="images/adv02.jpg"></a>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model01">新鲜水果</h3>
			<div class="subtitle fl">
				<span>|</span>
				<a href="#">鲜芒</a>
				<a href="#">加州提子</a>
				<a href="#">亚马逊牛油果</a>
			</div>
			<a href="ProductServlet?method=findByCidPage&cid=1&cname=新鲜水果&curPageSize=1" class="goods_more fr" id="fruit_more">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="images/banner01.jpg"></div>
			<ul class="goods_list fl">
				<c:choose>
					<c:when test="${empty pList1 }">
						数据为空
					</c:when>
					
					<c:otherwise>
						<c:forEach var="product" items="${pList1 }" begin="0" end="3">
							<li>
								<h4><a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}">${product.pname }</a></h4>
								<a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}"><img src="${product.pimage }"></a>
								<div class="prize">¥ ${product.shopPrice }</div>
							</li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
				
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model02">海鲜水产</h3>
			<div class="subtitle fl">
				<span>|</span>
				<a href="#">河虾</a>
				<a href="#">扇贝</a>				
			</div>
			<a href="ProductServlet?method=findByCidPage&cid=1&cname=海鲜水产&curPageSize=1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="images/banner02.jpg"></div>
			<ul class="goods_list fl">
				<c:choose>
					<c:when test="${empty pList2 }">
						数据为空
					</c:when>
					
					<c:otherwise>
						<c:forEach var="product" items="${pList2 }" begin="0" end="3">
							<li>
								<h4><a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}">${product.pname }</a></h4>
								<a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}"><img src="${product.pimage }"></a>
								<div class="prize">¥ ${product.shopPrice }</div>
							</li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model03">猪牛羊肉</h3>
			<div class="subtitle fl">
				<span>|</span>
				<a href="#">鲜芒</a>
				<a href="#">加州提子</a>
				<a href="#">亚马逊牛油果</a>
			</div>
			<a href="ProductServlet?method=findByCidPage&cid=1&cname=猪肉羊肉&curPageSize=1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="images/banner03.jpg"></div>
			<ul class="goods_list fl">
				<c:choose>
					<c:when test="${empty pList3 }">
						数据为空
					</c:when>
					
					<c:otherwise>
						<c:forEach var="product" items="${pList3 }" begin="0" end="3">
							<li>
								<h4><a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}">${product.pname }</a></h4>
								<a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}"><img src="${product.pimage }"></a>
								<div class="prize">¥ ${product.shopPrice }</div>
							</li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model04">禽类蛋品</h3>
			<div class="subtitle fl">
				<span>|</span>
				<a href="#">鲜芒</a>
				<a href="#">加州提子</a>
				<a href="#">亚马逊牛油果</a>
			</div>
			
			<a href="ProductServlet?method=findByCidPage&cid=1&cname=禽类蛋品&curPageSize=1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="images/banner04.jpg"></div>
			<ul class="goods_list fl">
				<c:choose>
					<c:when test="${empty pList4 }">
						数据为空
					</c:when>
					
					<c:otherwise>
						<c:forEach var="product" items="${pList4 }" begin="0" end="3">
							<li>
								<h4><a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}">${product.pname }</a></h4>
								<a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}"><img src="${product.pimage }"></a>
								<div class="prize">¥ ${product.shopPrice }</div>
							</li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model05">新鲜蔬菜</h3>
			<div class="subtitle fl">
				<span>|</span>
				<a href="#">鲜芒</a>
				<a href="#">加州提子</a>
				<a href="#">亚马逊牛油果</a>
			</div>
			<a href="ProductServlet?method=findByCidPage&cid=1&cname=新鲜蔬菜&curPageSize=1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="images/banner05.jpg"></div>
			<ul class="goods_list fl">
				<c:choose>
					<c:when test="${empty pList5 }">
						数据为空
					</c:when>
					
					<c:otherwise>
						<c:forEach var="product" items="${pList5 }" begin="0" end="3">
							<li>
								<h4><a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}">${product.pname }</a></h4>
								<a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}"><img src="${product.pimage }"></a>
								<div class="prize">¥ ${product.shopPrice }</div>
							</li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>

	<div class="list_model">
		<div class="list_title clearfix">
			<h3 class="fl" id="model06">速冻食品</h3>
			<div class="subtitle fl">
				<span>|</span>
				<a href="#">鲜芒</a>
				<a href="#">加州提子</a>
				<a href="#">亚马逊牛油果</a>
			</div>
			
			<a href="ProductServlet?method=findByCidPage&cid=6&cname=速冻食品&curPageSize=1" class="goods_more fr">查看更多 ></a>
		</div>

		<div class="goods_con clearfix">
			<div class="goods_banner fl"><img src="images/banner06.jpg"></div>
			<ul class="goods_list fl">
				<c:choose>
					<c:when test="${empty pList6 }">
						数据为空
					</c:when>
					
					<c:otherwise>
						<c:forEach var="product" items="${pList6 }" begin="0" end="3">
							<li>
								<h4><a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}">${product.pname }</a></h4>
								<a href="ProductServlet?method=findByPid&pid=${product.pid }&cname=${product.category.cname}"><img src="${product.pimage }"></a>
								<div class="prize">¥ ${product.shopPrice }</div>
							</li>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</div>

	<!-- 引入footer.jsp页面 -->
	<jsp:include page="footer.jsp"/>

	<script type="text/javascript">
		var oFruit = document.getElementById('fruit_more');
		var oShownum = document.getElementById('show_count');

		var hasorder = localStorage.getItem('order_finish');

		if(hasorder)
		{
			oShownum.innerHTML = '2';
		}

		oFruit.onclick = function(){
			window.location.href = 'list.jsp';
		}
	</script>
</body>
</html>