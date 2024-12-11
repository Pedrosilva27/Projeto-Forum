/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Enums.Assuntos;
import com.projeto.database.ConexaoBanco;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class Reclamacao {
    private Assuntos assunto;
    private String texto;

    public Reclamacao(Assuntos assunto, String texto) {
        this.assunto = assunto;
        this.texto = texto;
    }
    
    
    
    public boolean adicionar(){
        
        try {
            ConexaoBanco.inserirForum(this.assunto, this.texto);
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static DefaultTableModel buscaReclamacoes(){
        try{
           DefaultTableModel reclamacoes = ConexaoBanco.carregaReclamacoes();
           return reclamacoes;
        } catch (Exception ex) {
            return null;
        }
}
    
}
