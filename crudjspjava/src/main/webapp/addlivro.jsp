<%@ page import="com.crudjspjava.dao.LivroDao" %>
<jsp:useBean id="l" class="com.crudjspjava.bean.Livro"></jsp:useBean>
<jsp:setProperty property="*" name="l"/>

<% 
	int i = LivroDao.salvarLivro(l);

	if(i > 0) {
		response.sendRedirect("addlivro-success.jsp");
	}else {
		response.sendRedirect("addlivro-error.jsp");
	}
%>