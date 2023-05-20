package br.com.crud.crudservlet.DAO;

import br.com.crud.crudservlet.connection.GetConnection;
import br.com.crud.crudservlet.entities.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void conectar() throws SQLException {
        GetConnection.getConnection();
    }
    public boolean insereProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (codigo, nome, categoria, valor, quantidade) VALUES (?,?,?,?,?)";

        PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);

        ps.setInt(1, produto.getCodigo());
        ps.setString(2, produto.getNome());
        ps.setString(3, produto.getCategoria());
        ps.setFloat(4, produto.getValor());
        ps.setInt(5, produto.getQuantidade());

        boolean colunas = ps.executeUpdate() > 0;
        ps.close();

        return colunas;
    }

    public List<Produto> todosProdutos() throws SQLException {
        List<Produto> listaProdutos = new ArrayList();
        try {
            String sql = "SELECT * FROM produto";
            PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setCodigo(rs.getInt("codigo"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setValor(rs.getFloat("valor"));
                produto.setQuantidade(rs.getInt("quantidade"));

                listaProdutos.add(produto);
            }

        } catch (SQLException ex) {
            System.out.println("Deu erro no listar: " + ex.getMessage());
        }
        return listaProdutos;
    }

    public boolean deletaProduto(Produto produto) throws SQLException {
        String sql = "DELETE FROM produto WHERE id =?";

        PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, produto.getId());

        boolean colunaDeletada = ps.executeUpdate() > 0;
        ps.close();

        return colunaDeletada;
    }

    public boolean atualizaProduto(Produto produto) throws SQLException {
        String sql = "UPDATE produto SET codigo = ?, nome = ?, categoria = ?, valor = ?, quantidade = ? WHERE id = ?";

        PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);

        ps.setInt(1, produto.getCodigo());
        ps.setString(2, produto.getNome());
        ps.setString(3, produto.getCategoria());
        ps.setFloat(4, produto.getValor());
        ps.setInt(5, produto.getQuantidade());

        boolean colunaAtualizada = ps.executeUpdate() > 0;
        ps.close();

        return colunaAtualizada;
    }

    public Produto getProduto(int id) throws SQLException {
        Produto produto = null;
        String sql = "SELECT * FROM produto WHERE id = ?";

        PreparedStatement ps = GetConnection.getConnection().prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Integer codigo = rs.getInt("codigo");
            String nome = rs.getString("nome");
            String categoria = rs.getString("categoria");
            float valor = rs.getFloat("valor");
            Integer quatidade = rs.getInt("quantidade");

            produto = new Produto(codigo, nome, categoria, valor, quatidade);
        }
        rs.close();
        ps.close();

        return produto;
    }

    public void insereProduto(int codigo, String nome, String categoria, float valor, int quantidade) {

    }
}










