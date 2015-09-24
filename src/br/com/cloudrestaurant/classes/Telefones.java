/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.TelefonesUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Debug
 */
public class Telefones implements TelefonesUI{
//idTelefone, telefone, tipoProprietario, codProprietario    
    private int idTelefone;
    private String telefone;
    private String tipoProprietario;
    private int codProprietario;
    
    Conexao con;
    Statement stmt;
    Connection conn;
    Constantes constante;
    ResultSet rs;

    public String getTipoProprietario() {
        return tipoProprietario;
    }

    public void setTipoProprietario(String tipoProprietario) {
        this.tipoProprietario = tipoProprietario;
    }

    public int getCodProprietario() {
        return codProprietario;
    }

    public void setCodProprietario(int codProprietario) {
        this.codProprietario = codProprietario;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void consultaUltimoId(){
        constante = new Constantes();
        
        try{
            String sql = "SELECT MAX(idTelefone) as idTelefone FROM telefones";
            
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery(sql);
            rs.next();
            
            int idTelefone = rs.getInt("idTelefone");
            
            this.idTelefone = idTelefone + 1;
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Houve um erro na consulta. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
        
    }
    
    
    @Override
    public void cadastraTelefones(){
        
        constante = new Constantes();
        
        consultaUltimoId();
        
        try{
        String sql = "INSERT INTO telefones (idTelefone, telefone, tipoProprietario, codProprietario) "
                + "VALUES (" + this.idTelefone + ", '" + this.telefone + "', '" + this.tipoProprietario + "', " + this.codProprietario + ")";
        
        con = new Conexao();
        conn = con.getConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, constante.ERROCAD + " Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    @Override
    public void alteraTelefones(){
        
        if(JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
            String sql = "UPDATE telefones (idTelefone, telefone, tipoProprietario, codProprietario) "
                    + "SET "
                    + "telefone = '" + this.telefone + "', "
                    + "tipoProprietario = '" + tipoProprietario + "', "
                    + "codProprietario = " + this.codProprietario + "  "
                    + "WHERE idTelefone = " + this.idTelefone;

            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, constante.ERROCAD + " Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
            }
        }
    }
    
    @Override
    public void excluiTelefones(){
        if(JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
            String sql = "DELETE FROM telefones "
                    + "WHERE idTelefone = " + this.idTelefone;

            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, constante.ERROCAD + " Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
            }
        }
    }
    
    @Override
    public String consultaTelefones(){
        String sql = "SELECT * FROM telefones";
        return sql;
    }
    
    public void preencheTabelaTelefones(JTable tabela, JTextField campo){
            DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();

            dtm.addRow(new Object[]{campo.getText()});
        
    }
    
    public void retiraTelefoneTabela(JTable tabela, int item){
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        dtm.removeRow(item);
    }
    
    public void buscaProprietarioTelefone(int codProprietario, String tpProprietario, JTable tabela){
        String resultTelefone = null;
        try{
        
            String sql = "SELECT *, (SELECT MAX(idTelefone) FROM telefones) as quantTelefone "
                    + "FROM telefones "
                    + "WHERE codProprietario = " + codProprietario + " "
                    + "AND tipoProprietario = '" + tpProprietario + "'";
//            JOptionPane.showMessageDialog(null, sql);//normal
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            rs.first();
            
//            if(rs.absolute(1)){
                while(rs.next()){
                    resultTelefone = rs.getString("telefone");
                    DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
                    dtm.addRow(new Object[]{resultTelefone});

                }
//            }else{
//                JOptionPane.showMessageDialog(null, "O funcionário não possui telefone cadastrado");
//            }
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCONS + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
    }
    
    public void excluiAlteraTelefone(String proprietario, int codProprietario){
        
        try{
            String sqlExclui = "DELETE FROM telefones "
                    + "WHERE codProprietario = " + codProprietario + " "
                    + "AND tipoProprietario = '" + proprietario + "' ";
            
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlExclui);
            
            stmt.close();
            conn.close();

        }catch(IOException | SQLException ex){
            System.out.println("Problemas na exclusão parcial. Erro: " + ex.getMessage());
        }
        
        
    }
    
}
