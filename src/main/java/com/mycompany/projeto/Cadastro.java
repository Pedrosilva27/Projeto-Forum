package com.mycompany.projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cadastro extends javax.swing.JFrame {

    public Cadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Cadastrar = new javax.swing.JButton();
        Nome = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        senha = new javax.swing.JPasswordField();
        confirmar = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel1.setText("Casdastro");

        jLabel2.setText("Nome:");

        jLabel3.setText("Email:");

        jLabel5.setText("Senha:");

        jLabel6.setText("Confirmar senha:");

        Cadastrar.setText("Cadastrar");
        Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarActionPerformed(evt);
            }
        });

        Nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeActionPerformed(evt);
            }
        });

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });

        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(286, 286, 286)
                            .addComponent(Cadastrar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(253, 253, 253)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(174, 174, 174)
                            .addComponent(jLabel2)
                            .addGap(6, 6, 6)
                            .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(confirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(Cadastrar)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
    String nome = Nome.getText();
    String email = Email.getText();
    String senhaTexto = new String(senha.getPassword());
    String confirmarSenhaTexto = new String(confirmar.getPassword());

    // Verifica se os campos estão preenchidos
    if (nome.isEmpty() || email.isEmpty() || senhaTexto.isEmpty() || confirmarSenhaTexto.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Verifica se as senhas coincidem
    if (!senhaTexto.equals(confirmarSenhaTexto)) {
        javax.swing.JOptionPane.showMessageDialog(this, "As senhas não coincidem!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Conexão com o banco
    String url = "jdbc:mysql://localhost:3306/meu_banco"; // Substitua pelo nome do seu banco
    String user = "root"; // Usuário do MySQL
    String password = ""; // Senha do MySQL

    try (Connection conexao = DriverManager.getConnection(url, user, password)) {
        
        // Verificar se o email já existe
        String sqlCheckEmail = "SELECT COUNT(*) FROM tabela_cadastro WHERE email = ?";
        PreparedStatement stmtCheck = conexao.prepareStatement(sqlCheckEmail);
        stmtCheck.setString(1, email);
        ResultSet rs = stmtCheck.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            // Se o email já existir, exibe uma mensagem e não realiza o cadastro
            javax.swing.JOptionPane.showMessageDialog(this, "Este email já está cadastrado!", "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Inserir dados na tabela
        String sqlInsert = "INSERT INTO tabela_cadastro (nome, email, senha) VALUES (?, ?, ?)";
        PreparedStatement stmtInsert = conexao.prepareStatement(sqlInsert);
        stmtInsert.setString(1, nome);
        stmtInsert.setString(2, email);
        stmtInsert.setString(3, senhaTexto); // Armazene a senha em texto simples apenas para aprendizado; na prática, use hashing.

        // Executa o comando SQL
        stmtInsert.executeUpdate();

        // Exibe mensagem de sucesso
        javax.swing.JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");

        // Fecha a janela de cadastro e abre a tela de login
        this.dispose();
        Main mainTela = new Main();
        mainTela.setVisible(true);

    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_CadastrarActionPerformed

    private void NomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JTextField Email;
    private javax.swing.JTextField Nome;
    private javax.swing.JPasswordField confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField senha;
    // End of variables declaration//GEN-END:variables
}
