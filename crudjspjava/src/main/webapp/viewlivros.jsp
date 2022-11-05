<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualiza��o de livros</title>
</head>
<body>
	<%@ page import="com.crudjspjava.dao.LivroDao, com.crudjspjava.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<h1>Listagem de livros</h1>
	
	<%
		List<Livro> list = LivroDao.getAllLivros();
		request.setAttribute("list", list);
	%>
	
	<table border="1">
		<tr><th>C�digo do livro</th><th>Titulo</th><th>Autor</th><th>Categoria</th><th>Valor</th><th>Editar</th><th>Excluir</th></tr>
		<c:forEach items="${list}" var="livro">
			<tr>
				<td>${livro.getCodlivro()}</td>
				<td>${livro.getTitulo()}</td>
				<td>${livro.getAutor()}</td>
				<td>${livro.getCategoria()}</td>
				<td>${livro.getValor()}</td>
				<td><a href="editform.jsp?codlivro=${livro.getCodlivro()}">Editar</a></td>
				<td><a href="deletelivro.jsp?codlivro=${livro.getCodlivro()}">Excluir</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>