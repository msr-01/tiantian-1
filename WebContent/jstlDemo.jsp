<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="sum" value="100"></c:set>
	
	
	<c:choose>
		<c:when test="${10 < 5 }">
			true
		</c:when>
		
		<c:otherwise>
			false
		</c:otherwise>
	</c:choose>
	
	<c:set var="str" value="${fn:split('a,b,c',',') }"></c:set>
	
	<c:set var="strCss" value="${fn:split('fruit,seafood,meet,egg,vegetables,ice',',') }"></c:set>
	<c:set var="aHref" value="${fn:split('#model01,#model02,#model03,#model04,#model05,#model06',',') }"></c:set>
	
	
	<c:forEach var="s" varStatus="i" items="${strCss }" >
		${s}<br/>
	</c:forEach>
	
	
	
	<c:out value="${sum}"></c:out>

</body>
</html>