<jsp:include page="template-top.jsp" />

<%@ page import="databeans.FavoriteBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="databeans.FavoriteBean" %>
<p>
	<table>
	<c:forEach var="bean" items="${favoriteList}">
		<tr>
			<a href="updateCount.do?id=${bean.favoriteId}">${bean.favoriteUrl}</a>
		</p>
		<tr>${bean.comment}</tr>
		<tr>${bean.click}</tr>
	</c:forEach>
	</table>
</p>

<jsp:include page="template-bottom.jsp" />
