<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar por código do livro</title>
</head>
<body>

	<%@ page import="com.crudjspjava.bean.Livro, com.crudjspjava.dao.LivroDao"%>
	
	<%
		String codlivro = request.getParameter("codlivro");
		
	%>
	
	<form method="get" action="mostrarlivrocod.jsp">
		<input type="number" name="codlivro">
		<input type="submit" value="Exibir">
	</form>

</body>
</html>