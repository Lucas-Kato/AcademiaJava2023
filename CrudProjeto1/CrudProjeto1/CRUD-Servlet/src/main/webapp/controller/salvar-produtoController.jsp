<%@ page import="br.com.crud.crudservlet.DAO.ProdutoDAO" %>
<%@ page import="br.com.crud.crudservlet.entities.Produto" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: a864652
  Date: 5/13/2023
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salvar</title>
</head>
<body>
<%
    ProdutoDAO dao = new ProdutoDAO();
    Produto produto = new Produto();

    produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
    produto.setNome(request.getParameter("nome"));
    produto.setCategoria(request.getParameter("categoria"));
    produto.setValor(Float.valueOf((request.getParameter("valor"))));
    produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

    try {
        dao.insereProduto(produto);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    response.sendRedirect("http://localhost:8080/CRUD-Servlet-1.0-SNAPSHOT/index.jsp");
%>
</body>
</html>
