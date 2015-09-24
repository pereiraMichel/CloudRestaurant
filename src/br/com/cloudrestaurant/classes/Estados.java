/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import br.com.cloudrestaurant.interfaces.EstadosUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import CloudRestaurant.Conexao;

/**
 *
 * @author Debug
 */
public class Estados implements EstadosUI{
    
    private int idEstado;
    private String nome;
    private String sigla;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    Conexao con = new Conexao();
    
    public String pesquisaUltimoRegistro() {
        try{
        
        String consultaUltimoId = "SELECT MAX(idEstado) AS idEstado FROM estados";
        Conexao con2 = new Conexao();
        Connection conn2 = con2.getConnection();
        
        Statement stmt2 = conn2.createStatement();
        ResultSet rs2 = stmt2.executeQuery(consultaUltimoId);
        rs2.next();
        
        return rs2.getString("idEstado");
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não possível inserir os dados. Erro: " + ex.getMessage(), "ATENÇÃO", 0);
            return null;
        }
    }
    
    @Override
    public void cadastraEstado(){
        
        try{
        String quantidade = pesquisaUltimoRegistro();
//        JOptionPane.showMessageDialog(null, "Quantidade: " + quantidade); // retorna a quantidade certa.
        
        int qtde = Integer.parseInt(quantidade); //converte o valor string para inteiro
        int soma = qtde + 1; //efetua a soma do último registro (+ 1)
        
        this.setIdEstado(soma); // Insere o valor no idEstado
//        JOptionPane.showMessageDialog(null, "Soma: " + this.getIdEstado()); // retorna a quantidade certa.
        
        //Processo de inserção
        String sql = "INSERT INTO estados (idEstado, estado, sigla) "
                + "VALUES ("+this.getIdEstado()+", '"+this.getNome()+"', '"+this.getSigla()+"')";
        
        //JOptionPane.showMessageDialog(null, "Query: " + sql); // retorna a quantidade certa.
        
        Connection conn = con.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        
        conn.close();
        stmt.close();
        //JOptionPane.showMessageDialog(null, "Estado inserido com sucesso !");
        
        }catch(IOException | SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possível inserir os dados. Erro: " + e.getMessage(), "ATENÇÃO", 0);
        }
        
        
    }
    
    @Override
    public void alteraEstado(){
        try{
        
        String sql = "UPDATE estados SET estado='" + this.nome + "', sigla='" + this.sigla + "' WHERE idEstado = " + this.idEstado;

        Connection conn = con.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        
        conn.close();
        stmt.close();
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados. Erro: " + ex.getMessage(), "ATENÇÃO", 0);
        }
        
    }
    
    @Override
    public void excluiEstado(){
        try{
        String sql = "DELETE FROM estados WHERE idEstado = " + this.idEstado;
        Connection conn = con.getConnection();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        
        conn.close();
        stmt.close();
        }
        catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o estado. Erro: " + ex.getMessage(), "ATENÇÃO", 0);
        }
        
    }
    
    @Override
    public void consultaEstado(){
        
        try{
        String sql = "SELECT * FROM estados";

        Conexao con = new Conexao();
        Connection conn = con.getConnection();
        
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "ATENÇÃO", "Não contém conteúdo no banco.", 0);
        }
        
    }
    
    public String consultaComboEstado(){
        String sql = "SELECT * FROM estados e";
        return sql;
    }
    
    public int buscaIdEstado(String estado){
        try{
            String sql = "SELECT * FROM estados WHERE estado = '" + estado + "'";
            con = new Conexao();
            Connection conn = con.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            return rs.getInt("idEstado");
        }catch(IOException | SQLException ex){
        
            return 0;
        }
    }
    
    public String retornaEstado(int idEstado){
        try{
            String sql = "SELECT * FROM estados WHERE idEstado = " + idEstado;
            con = new Conexao();
            Connection conn = con.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("sigla");
            
        }catch(IOException | SQLException ex){
            return "Não localizado.";
        }
    }
    
}
