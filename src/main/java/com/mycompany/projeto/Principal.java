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
        Assunto = new javax.swing.JTextField();
        Reclamação = new javax.swing.JTextField();
        Enviar = new javax.swing.JButton();
        Menu = new javax.swing.JMenuBar();
        sair = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel2.setText("Assunto");

        jLabel3.setText("Reclamação");

        Assunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssuntoActionPerformed(evt);
            }
        });

        Reclamação.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });

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
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Reclamação, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Assunto, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(Enviar)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(Assunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
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
    	Assunto.setText("");
    	Reclamação.setText("");
    }

    private void AssuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AssuntoActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        String assunto = Assunto.getText();
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
    private javax.swing.JTextField Assunto;
    private javax.swing.JButton Enviar;
    private javax.swing.JMenuBar Menu;
    private javax.swing.JTextField Reclamação;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu sair;
    // End of variables declaration//GEN-END:variables
}
