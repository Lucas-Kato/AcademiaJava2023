<%@ page import="br.com.crud.crudservlet.entities.Produto" %>
<%@ page import="br.com.crud.crudservlet.DAO.ProdutoDAO" %><%--
  Created by IntelliJ IDEA.
  User: a864652
  Date: 5/13/2023
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  Produto produto = new ProdutoDAO().getProduto(Integer.parseInt(request.getParameter("id")));
%>

</body>
</html>
