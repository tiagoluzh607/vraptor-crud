<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
</head>
<body>
	<button onclick="window.location.href='<c:url value = "form"/>'">Adicionar Novo</button>
	<table id="example" class="display" style="width:50%; margin-top:30px;">
        <thead>
            <tr>
                <th>Email</th>
                <th>Data de Nascimento</th>
                <th>Acoes</th>

            </tr>
        </thead>
        <tbody>
	    <c:forEach var="usuario" items="${usuariosList}">
		    <tr>
		      <td>${usuario.email}</td>
		      <td>${usuario.dataNascimentoFormatada}</td>
		      <td> 
		      	   <button onclick="window.location.href='<c:url value = "form?usuario.id=${usuario.id}"/>'">Editar</button>
		      	   <button onclick="window.location.href='<c:url value = "deletaUsuario?usuario.id=${usuario.id}"/>'">Excluir</button>
		      <td>
		    </tr>
	    </c:forEach>
		</tbody>
	        <tfoot>
	            <tr>
	                <th>Email</th>
	                <th>Data de Nascimento</th>
					<th>Acoes</th>
	            </tr>
	        </tfoot>
	    </table>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
</html>