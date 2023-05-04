

package br.com.academia.test;

import br.com.academia.banco.bancoDeDados;
import br.com.academia.log.Log;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;

public class test {
    public test() {
    }

    public static void main(String[] args) throws IOException {
        Log meuLog = new Log("Log.txt");

        try {
            meuLog.logger.setLevel(Level.FINE);
            meuLog.logger.info("Log de informação");
            meuLog.logger.warning("Log de aviso");
            meuLog.logger.severe("Log severo");
        } catch (Exception var11) {
            meuLog.logger.info("Exception: " + var11.getMessage());
            var11.printStackTrace();
        }

        meuLog.logger.info("\n Banco iniciado!");
        Scanner sc = new Scanner(System.in);
        bancoDeDados bd = new bancoDeDados();
        bd.conectar("jdbc:mysql://localhost:3306/", "kato", "p13868741");
        String query = "INSERT INTO pessoas (id, nome, idade) VALUES (?, ?, ?)";
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Idade: ");
        int idade = sc.nextInt();

        try {
            PreparedStatement stmt = bd.conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, nome);
            stmt.setInt(3, idade);
            stmt.executeUpdate();
            System.out.print("Registro inserido com sucesso! /n");
            System.out.println();
            System.out.println();
        } catch (SQLException var10) {
            System.out.print("Erro ao inserir registro no banco de dados: " + var10.getMessage());
        }

        String selectQuery = "SELECT * FROM pessoas";
        bd.consultar(selectQuery);
        System.out.println("Qual id deseja deletar?");
        int idDelete = sc.nextInt();
        bd.deletar(idDelete);
        meuLog.logger.info("\n id deletado: " + idDelete);
        bd.exibirDados();
        bd.desconectar();
    }
}
