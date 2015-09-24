/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.HistoricoUI;
import br.com.cloudrestaurant.utilidades.Metodos;
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
public class Historico implements HistoricoUI {
    
    private int idHistorico;
    private String nomeHistorico;
    private String tipoLancamento;
    private Boolean mensagem;
    
    Constantes constante;
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Metodos metodo;

    public Boolean isMensagem() {
        return mensagem;
    }

    public void setMensagem(Boolean mensagem) {
        this.mensagem = mensagem;
    }
    
    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getNomeHistorico() {
        return nomeHistorico;
    }

    public void setNomeHistorico(String nomeHistorico) {
        this.nomeHistorico = nomeHistorico;
    }

    public String getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(String tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }
    
    public int consultaUltimoId(){
        try{
            String sql = "SELECT MAX(idHistorico) AS idHistorico FROM historico";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            return rs.getInt("idHistorico");
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na consulta de histórico. Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return 0;
        }
    }
    
    @Override
    public void cadastraHistorico(){
        int ultimoId = consultaUltimoId();
        this.idHistorico = ultimoId + 1;
        
        try{
            String sql = "INSERT INTO historico (idHistorico, nomeHistorico, tipoLancamento) "
                    + "VALUES ("
                    + this.idHistorico
                    + "'" + this.nomeHistorico + "'"
                    + "'" + this.tipoLancamento + "'"
                    + ")";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            if(mensagem){
                JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCAD + " Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
        
    }
    
    @Override
    public void alteraHistorico(){
        if(JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", Constantes.ALERTA) == 0){
            try{
                String sql = "UPDATE FROM historico SET "
                        + "nomeHistorico = '" + this.nomeHistorico + "', "
                        + "tipoLancamento = '" + this.tipoLancamento + "' "
                        + "WHERE idHistorico = " + this.idHistorico;
                
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                
                if(mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);
                }
                
            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROALT + " Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
            
        }
    }
    
    @Override
    public void excluiHistorico(){
        if(JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", Constantes.ALERTA) == 0){
            try{
                String sql = "DELETE FROM historico "
                        + "WHERE idHistorico = " + this.idHistorico;
                
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                
                if(mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCEXC, "SUCESSO", Constantes.SUCESSO);
                }
                
            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROEXC + " Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
            
        }
    }
    
    @Override
    public String consultaHistorico(){
        String sql = "SELECT * FROM historico";
        
        return sql;
    }
    
    public void preencheComboHistorico(JComboBox combo, String tipo){
        String nome = null;
        try{
            String sql = "SELECT nomeHistorico FROM historico WHERE tipoLancamento = '" + tipo + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            rs.first();
            
            while(rs.next()){
                nome = rs.getString("nomeHistorico");
                combo.addItem(nome);
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROEXC + " Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
    }
    
    public int buscaIdHistorico(String busca){
        
        try{
            String sql = "SELECT idHistorico FROM historico WHERE nomeHistorico = '" + busca + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();

            return rs.getInt("idHistorico");
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCAD + " Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return 0;
        }
    }
    
}
