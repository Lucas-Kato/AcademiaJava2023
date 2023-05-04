
package br.com.academia.banco;

import br.com.academia.interfaceB.InterfaceBancoDados;
import br.com.academia.log.Log;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class bancoDeDados implements InterfaceBancoDados {
    public Connection conn;
    Log meuLog = new Log("Log.txt");

    public bancoDeDados() throws IOException {
    }
    public void conectar(String db_url, String db_user, String db_password) {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "kato" , "p13868741");
            this.meuLog.logger.info("\n Banco conectado!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }

    }
    public void desconectar() {
        try {
            if (this.conn != null) {
                this.conn.close();
                System.out.println("DB desconectado! ");
                this.meuLog.logger.info("\n Banco desconectado!");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao desconectar do banco de dados: " + ex.getMessage());
        }

    }

    public void consultar(String db_query) {
        try {
            PreparedStatement stmt = this.conn.prepareStatement(db_query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nome: " + rs.getString("nome"));
                System.out.println("Idade: " + rs.getInt("idade"));
            }
        } catch (SQLException exc) {
            System.out.println("Erro ao consultar o banco de dados: " + exc.getMessage());
        }

    }
    public int inserirAlterarExcluir(String db_query) {
        int result = 0;

        try {
            PreparedStatement stmt = this.conn.prepareStatement(db_query);
            result = stmt.executeUpdate();
        } catch (SQLException exce) {
            System.out.println("Erro ao inserir/alterar/excluir no banco de dados: " + exce.getMessage());
        }

        return result;
    }
    public void deletar(Integer id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            System.out.println("deletado");
            this.meuLog.logger.info("\n deletado!");
        } catch (SQLException excep) {
            throw new RuntimeException(excep);
        }
    }

    public void exibirDados() throws IOException {
        try {
            PreparedStatement stmt = this.conn.prepareStatement("SELECT * FROM pessoas");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                System.out.println("ID: " + id + ", Nome: " + nome + ", Idade: " + idade);
                this.meuLog.logger.info("ID: " + id + ", Nome: " + nome + ", Idade: " + idade);
            }
        } catch (SQLException except) {
            System.out.println("Erro ao exibir dados do banco de dados: " + except.getMessage());
        }
    }
}
