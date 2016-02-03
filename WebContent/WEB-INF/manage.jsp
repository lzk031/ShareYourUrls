	 
<jsp:include page="template-top.jsp" />

<%@ page import="databeans.UserBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p>Favorites for ${user.firstName} ${user.lastName}</p>

<p style="font-size: medium">Add a new favorite URL:</p>

<jsp:include page="error-list.jsp" />

<p>
<form method="post" action="addFavorite.do">
	<table>
		<tr>
			<td style="font-size: large">URL:</td>
			<td> <input type="text" name="favoriteUrl"/>
			</td>
		</tr>
		<tr>
			<td style="font-size: large">Comment:</td>
			<td><input type="text" name="comment" /></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
				<input type="submit" name="button" value="Add Favorite" />
			</td>
		</tr>
	</table>
</form>
</p>
<hr />
<%@ page import="databeans.FavoriteBean"%>
<p>
<table>

<c:forEach var="bean" items="${favoriteList}">
	<tr>
		<td>
			<form method="POST" action="remove.do">
				<input type="hidden" name="id" value="${bean.favoriteId}" />
				<input type="submit" value="X" />
			</form>
		</td>
		<td><a href="updateCount.do?id=${bean.favoriteId}">${bean.favoriteUrl}</a></td>
		
	</tr>
	<tr>
		<td> ${bean.comment}</td>
	</tr>
	<tr>
		<td> ${bean.click}</td>
	</tr>
	
</c:forEach>

</table>
</p>

<jsp:include page="template-bottom.jsp" />
