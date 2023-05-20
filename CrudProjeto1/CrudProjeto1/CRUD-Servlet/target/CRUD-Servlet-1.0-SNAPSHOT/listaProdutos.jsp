
<%@ page import="br.com.crud.crudservlet.entities.Produto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.crud.crudservlet.connection.GetConnection" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="br.com.crud.crudservlet.DAO.ProdutoDAO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a864652
  Date: 5/16/2023
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="insert.css">
</head>

<body>
    <header class="cabecalho">
        <nav class="cabecalho__menu">
            <a class="cabecalho__menu__link" href="index.jsp">
                <img class="botao_home" src="./front/Projeto1/Assets/home.png">
            </a>
            <a class="cabecalho__menu__link_2" href="inserir-produto-form.jsp">
                <img class="botao_adicionar" src="./front/Projeto1/Assets/plus.png">
            </a>
            <a class="cabecalho__menu__link_3" href="./listaProdutos.jsp">
                <img class="botao_consultarbanco" src="./Assets/caixa (1).png">
            </a>
        </nav>
    </header>
<%
    ProdutoDAO produtodao = new ProdutoDAO();
    @SuppressWarnings("unchecked")
    ArrayList<Produto> lista = (ArrayList<Produto>) produtodao.todosProdutos();


    try {
        GetConnection.getConnection();
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
    <h1>Lista de todos seus produtos :</h1>
<table class="tabela_inserir" border="2">
   
        <thead>
            <tr>
                <th>Id</th>
                <th>Código</th>
                <th>Nome</th>
                <th>Categoria</th>
                <th>Valor</th>
                <th>Quantidade</th>
            </tr>
            </thead>
            <tbody>
                 <% for (int i = 0; i < lista.size(); i++) {%>
        <tr>
            <td class="lista"><%=lista.get(i).getId()%>
            </td>
            <td class="lista"><%=lista.get(i).getCodigo()%>
            </td>
            <td class="lista"><%=lista.get(i).getNome()%>
            </td>
            <td class="lista"><%=lista.get(i).getCategoria()%>
            </td>
            <td class="lista"><%=lista.get(i).getValor()%>
            </td>
            <td class="lista"><%=lista.get(i).getQuantidade()%>
            </td>
        <%} %>
        </tbody>
    </table>


</body>
</html>
