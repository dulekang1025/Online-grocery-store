<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manager page</title>
</head>
<body>
	<form>
		<table width="100%" border=1>
			<tr>
				<td>manager.name</td>
				<td> ${manager.username} </td>
			</tr>
			<tr>
				<td>manager.email</td>
				<td> ${manager.email } </td>
			</tr>
			<tr>
				<td>manager.password</td>
				<td> ${manager.password }</td>
<%--				<td> <fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>--%>
			</tr>
		</table>
	</form>
</body>
</html>