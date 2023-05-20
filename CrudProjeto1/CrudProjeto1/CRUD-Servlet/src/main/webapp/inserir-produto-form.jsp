<%--
  Created by IntelliJ IDEA.
  User: a864652
  Date: 5/13/2023
  Time: 1:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inserir</title>
    <link rel="stylesheet" href="formulario.css">
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
<h1>Form Inserir Produto</h1>
<form action="controller/salvar-produtoController.jsp">
   <main class="corpo_Escrita">
    <form name="frmProduto" action="update" class="form-comercial">
        <h2 class="titulo-form">Editar Produto</h2>
        <div class="form-group">
            <label for="codigo">Código:</label>
            <input type="number" name="codigo" id="codigo" class="form-control" value>
        </div>
        <div class="form-group">
            <label for="nome">Nome:</label>
            <input type="text" name="nome" id="nome" class="form-control" value>
        </div>
        <div class="form-group">
            <label for="categoria">Categoria:</label>
            <input type="text" name="categoria" id="categoria" class="form-control" value>
        </div>
        <div class="form-group">
            <label for="valor">Preço:</label>
            <input type="number" name="valor" id="valor" class="form-control" value=>
        </div>
        <div class="form-group">
            <label for="quantidade">Quantidade:</label>
            <input type="number" name="quantidade" id="quantidade" class="form-control" value=>
        </div>
        <div class="form-group">
            <input type="submit" value="Salvar" class="btn_salvar">
        </div>
    </form>
        <footer class="rodape">
            <p>©AtosProject</p>
        </footer>
</table>
</form>
</body>
</html>
