/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.AtividadeUI;
import br.com.cloudrestaurant.utilidades.Metodos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Debug
 */
public class Atividade implements AtividadeUI {
    
    private int idAtividade;
    private String atividade;
    private Boolean mensagem;
    
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

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }
    
    public int consultaUltimoId(){
        try{
            String sql = "SELECT MAX(idAtividade) as idAtividade FROM atividade";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            int pegaIdAtividade = rs.getInt("idAtividade");
            
            int soma = pegaIdAtividade + 1;
            
            return soma;
            
        }catch(IOException | SQLException ex){
            metodo = new Metodos();
            metodo.salvarTexto("Problemas na consulta. Erro: " + ex.getMessage(), "RegistroDeAtividade", Constantes.SISTEMA);
            JOptionPane.showMessageDialog(null, "Contém erro. Consulte o arquivo RegistroDeAtividade.log.", "ERRO", Constantes.ERROR);
            return 0;
        }
    }
    
    @Override
    public void cadastraAtividade(){
        try{
            this.idAtividade = consultaUltimoId();
            String sql = "INSERT INTO atividade (idAtividade, nome) "
                    + "VALUES (" + this.idAtividade + ", '" + this.atividade + "')";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            if(this.mensagem){
                JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
            }
            
        }catch(IOException | SQLException ex){
            metodo = new Metodos();
            metodo.salvarTexto(Constantes.ERROCAD + "Erro: " + ex.getMessage(), "Atividade", Constantes.SISTEMA);
            JOptionPane.showMessageDialog(null, "Contém erro. Consulte o arquivo Atividade.log.", "ERRO", Constantes.ERROR);
        }
    }
    
    @Override
    public void alteraAtividade(){
        
        if(JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
                String sql = "UPDATE atividade SET nome = '" + this.atividade + "' "
                        + "WHERE idAtividade = " + this.idAtividade;
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                if(this.mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);
                }

            }catch(IOException | SQLException ex){
                metodo = new Metodos();
                metodo.salvarTexto(Constantes.ERROALT + "Erro: " + ex.getMessage(), "RegistroDeAtividade", Constantes.SISTEMA);
                JOptionPane.showMessageDialog(null, "Contém erro. Consulte o arquivo RegistroDeAtividade.log.", "ERRO", Constantes.ERROR);
            }
        }
        
    }
    
    @Override
    public void excluiAtividade(){
        if(JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
                String sql = "DELETE FROM atividade "
                        + "WHERE idAtividade = " + this.idAtividade;
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                if(this.mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCEXC, "SUCESSO", Constantes.SUCESSO);
                }

            }catch(IOException | SQLException ex){
                metodo = new Metodos();
                metodo.salvarTexto(Constantes.ERROEXC + "Erro: " + ex.getMessage(), "RegistroDeAtividade", Constantes.SISTEMA);
                JOptionPane.showMessageDialog(null, "Contém erro. Consulte o arquivo RegistroDeAtividade.log.", "ERRO", Constantes.ERROR);
            }
        }
    }
    
    @Override
    public String consultaAtividade(){
        String sql = "SELECT * FROM atividade";
        return sql;
    }
}
