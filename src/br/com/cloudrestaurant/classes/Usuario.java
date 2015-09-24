/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.UsuarioUI;
import br.com.cloudrestaurant.utilidades.Metodos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Debug
 */
public class Usuario implements UsuarioUI {
    
    private int idUsuario;
    private String nomeUsuario;
    private String senha;
    private Date dataNascimento;
    private String email;
    private Date dataCadastro;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    Metodos metodos;
    Constantes constante;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    @Override
    public void cadastraUsuario(){
        
    }
    @Override
    public void alteraUsuario(){
        
    }
    @Override
    public void excluiUsuario(){
        
    }
    @Override
    public String consultaUsuario(){
    
        return null;
    }
    
    public Boolean validaUsuario(){
        
        try{
        
            String sql = "SELECT nomeUsuario, senha FROM usuario "
                    + "WHERE nomeUsuario = '" + this.nomeUsuario + "' "
                    + "AND senha = '" + this.senha + "'";
            
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            if(rs.absolute(1)){
                return true;
            }else{
                return false;
            }
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCONS + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return false;
        }
    }
    
}
