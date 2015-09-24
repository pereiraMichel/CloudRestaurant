/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import br.com.cloudrestaurant.interfaces.FreteUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
/**
 *
 * @author Debug
 */
public class Frete implements FreteUI{
    
    Constantes constante = new Constantes();
    
    private int idFrete;
    private String nome;

    public int getIdFrete() {
        return idFrete;
    }

    public void setIdFrete(int idFrete) {
        this.idFrete = idFrete;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String pesquisaUltimoRegistro() {
        try{
        
        String consultaUltimoId = "SELECT MAX(idFrete) AS idFrete FROM frete";
        Conexao con2 = new Conexao();
        Connection conn2 = con2.getConnection();
        
        Statement stmt2 = conn2.createStatement();
        ResultSet rs2 = stmt2.executeQuery(consultaUltimoId);
        rs2.next();
        
        return rs2.getString("idFrete");
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não possível inserir os dados. Erro: " + ex.getMessage(), "ATENÇÃO", constante.ERROR);
            return null;
        }
    }    
    
    @Override
    public void cadastraFrete(){
        
        int consultaUltimoRegistro = Integer.parseInt(pesquisaUltimoRegistro());
        
        int somaRegistro = consultaUltimoRegistro + 1;
        
        try{
            Conexao con = new Conexao();
            Connection conn = con.getConnection();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO frete (idFrete, nome) VALUES (" + somaRegistro + ", '" + this.nome + "')");
            JOptionPane.showMessageDialog(null, "Registro incluso com sucesso!", "SUCESSO", constante.SUCESSO);
            conn.close();
            stmt.close();
            
        }catch (IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na inclusão do registro." + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    @Override
    public void alteraFrete(){
        
        try{
            Conexao con = new Conexao();
            Connection conn = con.getConnection();
            Statement stmt = conn.createStatement();
            
            if (JOptionPane.showConfirmDialog(null, "Confirma as alterações?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            
            stmt.executeUpdate("UPDATE frete SET nome = '" + this.nome + "' WHERE idFrete = " + this.idFrete);
            
            JOptionPane.showMessageDialog(null, "Alteração efetuada co sucesso!", "SUCESSO", constante.SUCESSO);
            }
            stmt.close();
            conn.close();
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na alteração do registro." + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    @Override
    public void excluiFrete(){
        
        try{
            Conexao con = new Conexao();
            Connection conn = con.getConnection();
            Statement stmt = conn.createStatement();
            
            if (JOptionPane.showConfirmDialog(null, "Tem certeza que quer excluir?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            
            stmt.executeUpdate("DELETE FROM frete WHERE idFrete = " + this.idFrete);
            
            JOptionPane.showMessageDialog(null, "Exclusão efetuada co sucesso!", "SUCESSO", constante.SUCESSO);
            }
            stmt.close();
            conn.close();
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na exclusão do registro." + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    @Override
    public String consultaFrete(){
        String sql = "SELECT * FROM frete";
        return sql;
    }
    
}
