/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import com.projeto.database.ConexaoBanco;
import java.sql.SQLException;

/**
 *
 * @author nicol
 */
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    
    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }
    
     public Usuario(String nome, String email, String senha){
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
    
    public boolean login(){
        try{
            boolean hasLogged = ConexaoBanco.loginUser(this.email, this.senha);
            if(hasLogged){
                return true;
                
            }
            return false;
        }
        catch(SQLException e){
            return false;
        }
    }
    
    public boolean cadastrar(){
        try{
            ConexaoBanco.cadastrarUser(this.nome, this.email, this.senha);
            return true;
        }
        catch(SQLException e){
            return false;
        }
    }
    
}
