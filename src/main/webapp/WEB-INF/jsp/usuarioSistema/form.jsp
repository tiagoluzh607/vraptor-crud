<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="salvaForm" method="post">
	
		<!-- Id escondido -->
		<input name="usuario.id" type="number" value="${usuario.id}"/>
	
		<label>Email: </label>
		<input name="usuario.email" type="email" required value="${usuario.id}"/>
		
		<label>Senha: </label>
		<input name="usuario.senha"  type="password" required minlength="3" maxlength="12" value="${usuario.senha}"/>
		
		<label>Data Nascimento: </label>
		<input name="usuario.dataNascimento" type="date" value="${usuario.dataNascimentoFormatada}"/>
		
		<button type="submit">Salvar</button>
	</form>
</body>
</html>