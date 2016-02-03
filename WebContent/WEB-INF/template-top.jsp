<html>
<head>
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="pragma" content="no-cache">
	<title>Favorite URL</title>
	<style>
		.menu-head {font-size: 10pt; font-weight: bold; color: black; }
		.menu-item {font-size: 10pt;  color: black }
    </style>
</head>

<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import="databeans.UserBean" %>

<table cellpadding="4" cellspacing="0">
    <tr>
	    <!-- Banner row across the top -->
        <td width="130" bgcolor="#99FF99">
        <td bgcolor="#99FF99">&nbsp;  </td>
        <td width="500" bgcolor="#99FF99">
            <p align="center">
			<c:choose>
				<c:when test="${title==null}">
					<font size="5">Favorite URL Website</font>
				</c:when>
				<c:otherwise>
					<font size="5">${title}</font>
				</c:otherwise>
			</c:choose>
			</p>
		</td>
    </tr>
	
	<!-- Spacer row -->
	<tr>
		<td bgcolor="#99FF99" style="font-size:5px">&nbsp;</td>
		<td colspan="2" style="font-size:5px">&nbsp;</td>
	</tr>
	
	<tr>
		<td bgcolor="#99FF99" valign="top" height="500" width="100">
			<!-- Navigation bar is one table cell down the left side -->
            <p align="left">
	<c:choose>
		<c:when test="${user==null}">
			<span class="menu-item"><a href="login.do">Login</a></span><br/>
			<span class="menu-item"><a href="register.do">Register</a></span><br/>
		</c:when>
				
		<c:otherwise>
			<span class="menu-head">${user.firstName} ${user.lastName}</span><br/>
			<span class="menu-item"><a href="manage.do">Manage Favorite URL</a></span><br/>
			<br/>
			<span class="menu-item"><a href="change-pwd.do">Change Password</a></span><br/>
			<br/>
			<span class="menu-item"><a href="logout.do">Logout</a></span><br/>
			<br/>	
		</c:otherwise>	
	</c:choose>
	
			<span class="menu-item">&nbsp;</span><br/>
			<span class="menu-head">Favorite URL From:</span><br/>

		<c:forEach var='usr' items="${userList}">
				<span class="menu-item">
				<a href="list.do?email=${usr.email}">${usr.firstName} ${usr.lastName}</a>
				</span>
				<br/>
		</c:forEach>

			</p>
		</td>
		
		<td>
			<!-- Padding (blank space) between navbar and content -->
		</td>
		<td  valign="top">
