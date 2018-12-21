<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#info{
	width:250px;
	border-style:solid; 
	border-width:1px;
	border-color:#000;
}

#page{
	width:250px;
	border-style:solid; 
	border-width:1px;
	border-color:#000;
	margin-top: 10px;
}

.page-a{
	margin-left: 15px;
	text-decoration:none
}

#font{
	width:250px;
	border-style:solid; 
	border-width:1px;
	border-color:#000;
	margin-top: 20px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="info">
		<c:forEach items="${pageBean.books }" var="book" begin="0" end="5">
			ID<c:out value="${book.id }"></c:out>
			书名:<c:out value="${book.name }"></c:out><br>
		</c:forEach>
	</div><br>
	
	<div id="page">
		<a class="page-a" href="page.spring?page=1">首页</a>
		<a class="page-a" href="page.spring?page=${page-1 }">上一页</a>
		<a class="page-a" href="page.spring?page=${page+1 }">下一页</a>
		<a class="page-a" href="page.spring?page=${pageBean.sumPages }">尾页</a><br>
	</div>

	
	<div id="font">共<b>${pageBean.allRowCounts }</b>条记录,共<b>${pageBean.sumPages }</b>页,当前第<b>${pageBean.curPage }</b>页</div>
	
</body>
</html>