<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="w3-table">
	    <tr>
	      <th>Email</th>
	      <th>Data Nascimento</th>
	    </tr>
	    <c:forEach var="usuario" items="${usuariosList}">
		    <tr>
		      <td>${usuario.email}</td>
		      <td>${usuario.dataNascimentoFormatada}</td>
		    </tr>
	    </c:forEach>
	</table>
</body>
</html>