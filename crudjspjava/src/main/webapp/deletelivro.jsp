<%@ page import="com.crudjspjava.dao.LivroDao" %>
<jsp:useBean id="l" class="com.crudjspjava.bean.Livro"></jsp:useBean>
<jsp:setProperty property="*" name="l"/>

<%
	LivroDao.deletarLivro(l);
	response.sendRedirect("viewlivros.jsp");
%>
