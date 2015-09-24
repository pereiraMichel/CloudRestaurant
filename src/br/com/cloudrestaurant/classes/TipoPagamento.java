/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.TipoPagamentoUI;
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
public class TipoPagamento implements TipoPagamentoUI {
    
    private int idTipoPagamento;
    private String nomePagamento;
    private Boolean autorizaMensagem;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public Boolean isAutorizaMensagem() {
        return autorizaMensagem;
    }

    public void setAutorizaMensagem(Boolean autorizaMensagem) {
        this.autorizaMensagem = autorizaMensagem;
    }
    
    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getNomePagamento() {
        return nomePagamento;
    }

    public void setNomePagamento(String nomePagamento) {
        this.nomePagamento = nomePagamento;
    }
    
    public void consultaUltimoId(){
        try{
            String sql = "SELECT MAX(idTipoPagamento) as idTipoPagamento FROM tipopagamento";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            this.idTipoPagamento = rs.getInt("idTipoPagamento");
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCONS + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
    }
    
    public int buscaIdTipoPagamento(String nome){
        try{
            String sql = "SELECT * FROM tipopagamento WHERE nomePagamento = '" + nome + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            if (rs.absolute(1)){
                return rs.getInt("idTipoPagamento");
            }else{
                conn.close();
                stmt.close();
                rs.close();
                return 0;
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCONS + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return -1;
        }
    }
    
    public void preencheComboPagamento(JComboBox combo){
        try{
            String sql = consultaTipoPagamento();
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            if(rs.absolute(1)){
                while(rs.next()){
                    String nome = rs.getString("nomePagamento");
                    combo.addItem(nome);
                }
            }else{
                String mensagem = "Não foi localizado tipo de pagamentos para consulta";
                combo.addItem(mensagem);
            }
            
            
        }catch(IOException | SQLException ex){
            String mensagemErro = "Erro. Houve um problema ao consultar. Erro: " + ex.getMessage();
            combo.addItem(mensagemErro);
        }
    }
    
    @Override
    public void cadastraTipoPagamento(){
        
        try{
            
            consultaUltimoId();
            
            String sql = "INSERT INTO tipopagamento (idTipoPagamento, nomePagamento) "
                    + "VALUES ( " + this.idTipoPagamento + ", '" + this.nomePagamento + "')";
            
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            
            stmt.executeUpdate(sql);
            
            if (autorizaMensagem){
                JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
            }
            
            stmt.close();
            conn.close();
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCAD + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
        
    }
    
    @Override
    public void alteraTipoPagamento(){
        
        if(JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
                String sql = "UPDATE tipopagamento "
                        + "SET nomePagamento = '" + this.nomePagamento + "' "
                        + "WHERE idTipoPagamento = " + this.idTipoPagamento;

                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                if(autorizaMensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);
                }

                stmt.close();
                conn.close();

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROSAL + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
        
    }
    
    @Override
    public void excluiTipoPagamento(){
        if(JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
                String sql = "DELETE FROM tipopagamento "
                        + "WHERE idTipoPagamento = " + this.idTipoPagamento;

                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                if(autorizaMensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);
                }

                stmt.close();
                conn.close();

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROSAL + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
    }
    
    @Override
    public String consultaTipoPagamento(){
        String sql = "SELECT * FROM tipopagamento";
        
        return sql;
    }
       
}
