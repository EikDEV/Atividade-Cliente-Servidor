<%@ page import="com.crudjspjava.dao.LivroDao" %>
<jsp:useBean id="l" class="com.crudjspjava.bean.Livro"></jsp:useBean>
<jsp:setProperty property="*" name="l"/>

<%
	int i = LivroDao.updateLivro(l);
	response.sendRedirect("viewlivros.jsp");
%>