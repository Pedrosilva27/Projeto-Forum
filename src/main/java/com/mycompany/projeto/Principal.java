package com.mycompany.projeto;

import com.projeto.database.ConexaoBanco;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Reclamação = new javax.swing.JTextField();
        Enviar = new javax.swing.JButton();
        Home1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Assunto = new javax.swing.JComboBox<>();
        Menu = new javax.swing.JMenuBar();
        sair = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Assunto");

        jLabel3.setText("Reclamação");

        Reclamação.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

        Home1.setText("Voltar");
        Home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Home1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        jLabel4.setText("Adicionar Reclamação");

        Assunto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atendimento", "Produto", "Entrega", " " }));

        Menu.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Menu.setBorderPainted(false);

        sair.setText("Sair");
        Menu.add(sair);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(Enviar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Reclamação, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(Assunto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(Home1)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel4)))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(Home1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel4)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Assunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(Reclamação, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Enviar)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void setFieldsBlank() {
    	Assunto.setSelectedIndex(0);
    	Reclamação.setText("");
    }

    private void Home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Home1ActionPerformed
        Reclamacoes screen = new Reclamacoes();
        screen.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Home1ActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        String assunto = Assunto.getItemAt(Assunto.getSelectedIndex());
        String reclamacao = Reclamação.getText(); 
        if(assunto.isEmpty() || reclamacao.isEmpty()) { 
        	javax.swing.JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
	        return;
        }
   
        try {
	        ConexaoBanco.inserirForum(assunto, reclamacao);
	        javax.swing.JOptionPane.showMessageDialog(this, "Reclamação realizada com sucesso!");
	        setFieldsBlank();
	        
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        javax.swing.JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
	    }
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Assunto;
    private javax.swing.JButton Enviar;
    private javax.swing.JButton Home1;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JTextField Reclamação;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu sair;
    // End of variables declaration//GEN-END:variables
}
