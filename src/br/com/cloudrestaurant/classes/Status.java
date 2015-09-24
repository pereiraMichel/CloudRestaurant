/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.StatusUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Debug
 */
public class Status implements StatusUI{
    
    private int idStatus;
    private String nome;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Constantes constante;

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void cadastraStatus(){
        
    }
    @Override
    public void alteraStatus(){
        
    }
    @Override
    public void excluiStatus(){
        
    }
    @Override
    public String consultaStatus(){
        
        String sql = "SELECT * FROM status";
        return sql;
    }
    
    public void preencheComboStatus(JComboBox combo){
        constante = new Constantes();
        
        try{
            String sql = consultaStatus();
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                if(!rs.getString("nome").equals("")){
                    String nomeStatus = rs.getString("nome");
                    combo.addItem(nomeStatus);
                }else{
                    combo.addItem("Não há Status cadastrado.");
                }
            }
            
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na consulta do Status. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    public int buscaCodStatus(Object busca){
        constante = new Constantes();
        
        try{
            String sql = consultaStatus() + " WHERE nome = '" + busca + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            return rs.getInt("idStatus");
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na consulta do Status. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
            return 0;
        }
    }
    
}
