<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edi��o de livros </title>
</head>
<body>

	<%@ page import="com.crudjspjava.bean.Livro, com.crudjspjava.dao.LivroDao"%>
	
	<%
		String codlivro = request.getParameter("codlivro");
		Livro livro = LivroDao.getRegisterById(Integer.parseInt(codlivro));
	%>
	
	<h1>Edi��o de livro</h1>
	
	<form action="editlivro.jsp" method="post">
		<input type="hidden" name="codlivro" value="<%=livro.getCodlivro()%>"/>
		
		<table>
			<tr>
				<td>Titulo: </td>
				<td><input type="text" name="titulo" value="<%=livro.getTitulo()%>"/></td>
			</tr>
			<tr>
				<td>Autor: </td>
				<td><input type="text" name="autor" value="<%=livro.getAutor()%>"/></td>
			</tr>
			<tr>
				<td>Categoria: </td>
				<td><input type="text" name="categoria" value="<%=livro.getCategoria()%>"/></td>
			</tr>
			<tr>
				<td>Valor: </td>
				<td><input type="number" name="valor" value="<%=livro.getValor()%>"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Editar livro"></td>
			</tr>
		</table>
	</form>

</body>
</html>