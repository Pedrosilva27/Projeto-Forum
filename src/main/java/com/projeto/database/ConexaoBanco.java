package com.projeto.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class ConexaoBanco {

	// Configurações de credenciais com o MySQL via XAMP
	 private static final String URL = "jdbc:mysql://localhost:3306/meu_banco"; 
	    private static final String USER = "nickciuffi"; 
	    private static final String PASSWORD = "Niisaricris1"; 
	    
	    
	public static Connection getConexao() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	// Método auxiliar para a verificação da existencia do usuário
	public static boolean emailExiste(String email) throws SQLException {
		String sql = "SELECT 1 FROM tabela_cadastro where email = ?";
		try (Connection conexao = getConexao(); PreparedStatement st = conexao.prepareStatement(sql)) {
			st.setString(1, email);
			try (ResultSet rs = st.executeQuery()) {
				return rs.next();
			}
		}
	}
        
          public static DefaultTableModel carregaReclamacoes() throws Exception{
            DefaultTableModel modelo = new DefaultTableModel(new String[]{"Assunto", "Reclamação"}, 0);

            String sql = "SELECT assunto, reclamacao FROM tabela_forum";

            try (Connection conexao = getConexao(); PreparedStatement st = conexao.prepareStatement(sql)) {
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        // Adiciona as duas strings na tabela
                        String assunto = rs.getString("assunto");
                        String reclamacao = rs.getString("reclamacao");
                        modelo.addRow(new Object[]{assunto, reclamacao});
                    }
                }
            } catch (Exception e) {
                throw new Exception("Algo deu errado");
            }
            return modelo;
        }

	// Método para inserir dados
	public static void inserirDados(String nome, String email, String senha) throws SQLException {
		if (emailExiste(email)) {
			throw new SQLException("Email já existe no banco de dados");
		}
		String sql = "INSERT INTO tabela_cadastro (nome, email, senha) VALUES (?, ?, ?)";
		try (Connection conexao = getConexao(); PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setString(1, nome);
			stmt.setString(2, email);
			stmt.setString(3, senha);
			stmt.executeUpdate();
		}
	}

	// Método para buscar e autenticar usuário no banco de dados
	public static boolean findByEmail(String email, String senha) throws SQLException {
		String sql = "SELECT senha FROM tabela_cadastro WHERE email = ?";
		PreparedStatement st = null;
		try (Connection conexao = getConexao()) {
			st = conexao.prepareStatement(sql);
			st.setString(1, email);

			try (ResultSet rs = st.executeQuery()) {
				if (rs.next()) {
					String senhars = rs.getString("senha");
					if (senha.equals(senhars)) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			throw new SQLException("  NÃO FOI POSSÍVEL BUSCAR OS DADOS", e);
		}
	}
	
	// Método para inserir dados do forum 
	public static void inserirForum(String assunto, String reclamacao) throws SQLException {
		String sql = "INSERT INTO tabela_forum (assunto, reclamacao) VALUES (?, ?)";
		try (Connection conexao = getConexao(); PreparedStatement st = conexao.prepareStatement(sql)) {
			st.setString(1, assunto);
			st.setString(2, reclamacao);
			st.executeUpdate();
		}
	}

}
