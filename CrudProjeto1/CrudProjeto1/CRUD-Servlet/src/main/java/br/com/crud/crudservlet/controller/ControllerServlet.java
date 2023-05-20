package br.com.crud.crudservlet.controller;

import br.com.crud.crudservlet.DAO.ProdutoDAO;
import br.com.crud.crudservlet.connection.GetConnection;
import br.com.crud.crudservlet.entities.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"/novo", "/inserir", "/deletar", "/editar", "/listarProdutos"})
public class ControllerServlet extends HttpServlet {
    ProdutoDAO dao = new ProdutoDAO();
    public ControllerServlet(){}

    public void init () {
        GetConnection.getConnection();
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        if(method.equals("GET")) {
            System.out.println(" 1");
            doGet(request, response);
        }
        if(method.equals("POST")) {
            String path = request.getServletPath();

            if (path.equals("/novo")) {
                doPost(request, response);
            }
            if (path.equals("/editar")) {
                doPut(request, response);
            }
        }
        if(method.equals("DELETE")) {
            System.out.println("deletadooo");
            doDelete(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int codigo = Integer.parseInt(req.getParameter("codigo"));
        String nome = req.getParameter("nome");
        String categoria = req.getParameter("categoria");
        float valor = Float.parseFloat(req.getParameter("valor"));
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        dao.insereProduto(codigo, nome, categoria, valor, quantidade);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("")) {
            resp.sendRedirect("http://localhost:8080/CRUD_Servlet/");
        }
        if (path.equals("/home")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
        if (path.equals("/novo")) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("./inserir-produto-form.jsp");
            dispatcher.forward(req, resp);
        }


    }


//    protected void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
////        ProdutoDAO dao = new ProdutoDAO();
//        List<Produto> produtoLista = dao.todosProdutos();
//
//        request.setAttribute("listarProdutos", produtoLista);
//        RequestDispatcher rd = request.getRequestDispatcher("http://localhost:8080/CRUD_Servlet/listaProdutos.jsp");
//        rd.forward(request, response);
//    }


    private void listarProdutos(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        List<Produto> produtoLista = dao.todosProdutos();
        req.setAttribute("listarProdutos", produtoLista);
        RequestDispatcher dispatcher = req.getRequestDispatcher("http://localhost:8080/CRUD_Servlet/listaProdutos.jsp");
        dispatcher.forward(req,resp);
    }

    private void novoFormulario(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("http://localhost:8080/CRUD_Servlet/produtoForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void editarForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        Produto produtoExistente = dao.getProduto(id); //pega o produto existente pelo id

        RequestDispatcher dispatcher = req.getRequestDispatcher("produtoForm.jsp");
        req.setAttribute("produto", produtoExistente);
        dispatcher.forward(req, resp);
    }

    private void inserirProduto(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException{
        Integer codigo = Integer.parseInt(req.getParameter("codigo"));
        String nome = req.getParameter("nome");
        String categoria = req.getParameter("categoria");
        float valor = Float.parseFloat((req.getParameter("valor")));
        Integer quantidade = Integer.parseInt(req.getParameter("quantidade"));

        Produto novoProduto = new Produto(codigo, nome, categoria, valor, quantidade);
        dao.insereProduto(novoProduto);
        resp.sendRedirect("/novo");  //VERIFICAR
    }

    private void atualizarProduto(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException{
        Integer codigo = Integer.valueOf(req.getParameter("codigo"));
        String nome = req.getParameter("nome");
        String categoria = req.getParameter("categoria");
        float valor = Float.parseFloat((req.getParameter("valor")));
        int quantidade = Integer.parseInt(req.getParameter("quantidade"));

        Produto atualizadoProduto = new Produto(codigo, nome, categoria, valor, quantidade);
        dao.atualizaProduto(atualizadoProduto);
        resp.sendRedirect("listaProdutos");
    }

    private void deletarProduto(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        Produto produto = new Produto();
        dao.deletaProduto(produto);
        resp.sendRedirect("listaProdutos");
    }
}
