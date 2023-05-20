<%@ page import="java.util.List" %>
<%@ page import="br.com.crud.crudservlet.entities.Produto" %>
<%@ page import="br.com.crud.crudservlet.DAO.ProdutoDAO" %><%--
  Created by IntelliJ IDEA.
  User: a864652
  Date: 5/13/2023
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Seus produtos</title>
</head>
<body>
<h1>Todos Produtos</h1>
<h2>
    <a href="./selecionar-todosController.jsp"></a>
</h2>
    <table>
        <tr>
            <td>Código: </td>
            <td>Nome: </td>
            <td>Categoria: </td>
            <td>Valor: </td>
            <td>Quantidade: </td>
        </tr>

        <%
            List<Produto> lista = new ProdutoDAO().todosProdutos();

            for (Produto produto : lista) {
        %>
        <tr>
            <td><%=produto.getCodigo()%></td>
            <td><%=produto.getNome()%></td>
            <td><%=produto.getCategoria()%></td>
            <td><%=produto.getValor()%></td>
            <td><%=produto.getQuantidade()%></td>
        </tr>

        <%
            }
        %>
    </table>
</body>
</html>
