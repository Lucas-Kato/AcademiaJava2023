<%@ page import="br.com.crud.crudservlet.DAO.ProdutoDAO" %>
<%@ page import="javax.swing.*" %>
<%@ page import="br.com.crud.crudservlet.entities.Produto" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: a864652
  Date: 5/13/2023
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Produto</title>
</head>
<body>
<h1>Edite seu produto</h1>
<form action="update">
  <div class="editar">
    <label for="codigo">Informe o código: </label>
    <input type="number" name="codigo" id="codigo" value="<%System.out.print(request.getAttribute("codigo"));%>">
  </div>
  
</form>
<%
    ProdutoDAO dao = new ProdutoDAO();
    Produto produto = new Produto();

    produto.setCodigo(Integer.parseInt(request.getParameter("codigo")));
    produto.setNome(request.getParameter("nome"));
    produto.setCategoria(request.getParameter("categoria"));
    produto.setValor(Float.parseFloat(request.getParameter("valor")));
    produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

    try {
        dao.atualizaProduto(produto);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

    response.sendRedirect("http://localhost:8080/CRUD_Servlet/");

%>

</body>
</html>


<%--int id = Integer.parseInt(request.getParameter("id"));--%>
<%--int codigo = Integer.parseInt(request.getParameter("codigo"));--%>
<%--String nome = request.getParameter("nome");--%>
<%--String categoria = request.getParameter("categoria");--%>
<%--float valor = Float.parseFloat(request.getParameter("valor"));--%>
<%--int quantidade = Integer.parseInt(request.getParameter("quantidade"));--%>


<%--new ProdutoDAO().atualizaProduto(codigo, nome, categoria, valor, quantidade);--%>
<%--request.getRequestDispatcher("./selecionar-produto-form.jsp?id="+id).forward(request, response)--%>