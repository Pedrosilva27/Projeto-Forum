package com.mycompany.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoBanco {
    // Configurações do banco
    private static final String URL = "jdbc:mysql://localhost:3306/meu_banco"; // Substitua "meu_banco" pelo nome do seu banco
    private static final String USER = "root"; // Usuário do banco
    private static final String PASSWORD = ""; // Senha do banco (padrão do XAMPP geralmente é vazio)

    // Método para obter a conexão
    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para inserir dados
    public static void inserirDados(String nome, String email, String senha) throws SQLException {
        String sql = "INSERT INTO tabela_cadastro (nome, email, senha) VALUES (?, ?, ?)";
        try (Connection conexao = getConexao(); 
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.executeUpdate();
        }
    }
}
