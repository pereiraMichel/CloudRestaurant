/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.RegistroAtividadeUI;
import br.com.cloudrestaurant.utilidades.Metodos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Debug
 */
public class RegistroAtividade implements RegistroAtividadeUI {
    
    private int idRegistroAtividade;
    private String nomeAtividade;
    private int codAtividade;
    private Date dataAtividade;
    private Boolean mensagem;
    
    Metodos metodo;
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public String getNomeAtividade() {
        return nomeAtividade;
    }

    public void setNomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
    }

    public Boolean isMensagem() {
        return mensagem;
    }

    public void setMensagem(Boolean mensagem) {
        this.mensagem = mensagem;
    }

    public int getIdRegistroAtividade() {
        return idRegistroAtividade;
    }

    public void setIdRegistroAtividade(int idRegistroAtividade) {
        this.idRegistroAtividade = idRegistroAtividade;
    }

    public int getCodAtividade() {
        return codAtividade;
    }

    public void setCodAtividade(int codAtividade) {
        this.codAtividade = codAtividade;
    }

    public Date getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(Date dataAtividade) {
        this.dataAtividade = dataAtividade;
    }
    
    @Override
    public void cadastraRegistroAtividade(){
        try{
            String sql = "INSERT INTO registroatividade (idRegistroAtividade, atividade, dataAtividade, codAtividade) "
                    + "VALUES ("
                    + "" + this.idRegistroAtividade + ", "
                    + "'" + this.nomeAtividade + "', "
                    + "'" + this.dataAtividade + "', "
                    + "" + this.codAtividade + ""
                    + ")";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            if(this.mensagem){
                JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
            }
            
        }catch(IOException | SQLException ex){
            metodo = new Metodos();
            metodo.salvarTexto(Constantes.ERROCAD + "Erro: " + ex.getMessage(), "RegistroDeAtividade", Constantes.SISTEMA);
            JOptionPane.showMessageDialog(null, "Contém erro. Consulte o arquivo RegistroDeAtividade.log.", "ERRO", Constantes.ERROR);
            
        }
    }
    
    @Override
    public void excluiRegistroAtividade(){
        try{
            String sql = "DELETE FROM registroatividade WHERE idRegistroAtividade = " + this.idRegistroAtividade;
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            if(this.mensagem){
                JOptionPane.showMessageDialog(null, Constantes.SUCEXC, "SUCESSO", Constantes.SUCESSO);
            }
            
        }catch(IOException | SQLException ex){
            metodo = new Metodos();
            metodo.salvarTexto(Constantes.ERROCAD + "Erro: " + ex.getMessage(), "RegistroDeAtividade", Constantes.SISTEMA);
            JOptionPane.showMessageDialog(null, "Contém erro. Consulte o arquivo RegistroDeAtividade.log.", "ERRO", Constantes.ERROR);
            
        }
    }
    
    @Override
    public String consultaRegistroAtividade(){
        String sql = "SELECT * FROM registroatividade";
        return sql;
    }
    
    public void registraTabelaAtividade(JTable tabela, String tarefa, int codigoAtividade){
        String codAtividade = null;
        switch(codigoAtividade){
            case 1: codAtividade = "Abertura de Sistema"; break;
            case 2: codAtividade = "Cadastro/ Inclusão"; break;
            case 3: codAtividade = "Alteração"; break;
            case 4: codAtividade = "Exclusão"; break;
            case 5: codAtividade = "Fechamento de Sistema"; break;
            case 6: codAtividade = "Usuário Logado: "; break;
            case 7: codAtividade = "Tela "; break;
            case 8: codAtividade = "Usuário Logado: "; break;
        }
        
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();//Fazer uma classe
        dtm.addRow(new Object[]{codAtividade + " " + tarefa});

        
    }
    
    
}
