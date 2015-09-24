/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.CargosUI;
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
public class Cargos implements CargosUI {
    
    private int idCargo;
    private String nomeCargo;
    private String codigoCargo;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
//    Constantes constante;

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(String codigoCargo) {
        this.codigoCargo = codigoCargo;
    }
    
    public void consultaUltimoId(){
        try{
            String sql = "SELECT MAX(idCargos) as idCargos FROM cargos";
            
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            int novoId = rs.getInt("idCargos");
            int somaId = novoId + 1;
            this.idCargo = somaId;
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCONS + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            this.idCargo = 0;
        }
    }
    

    @Override
    public void cadastraCargo(){
        
        consultaUltimoId();
        
        if (idCargo != 0){
            try{
                String sql = "INSERT INTO cargos (idCargos, nomeCargo) "
                        + "VALUES (" + this.idCargo + ", '" + this.nomeCargo + "')";
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
                
                conn.close();
                stmt.close();
                
            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROCAD + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
        
    }

    @Override
    public void alteraCargo(){
        
        if (JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
                String sql = "UPDATE cargos "
                        + "SET nomeCargo = '" + this.nomeCargo + "' "
                        + "WHERE idCargos = " + this.idCargo;
//                JOptionPane.showMessageDialog(null, sql);
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);

                conn.close();
                stmt.close();

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROALT + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
        
    }
    
    @Override
    public void excluiCargo(){

        if (JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
                String sql = "DELETE FROM cargos "
                        + "WHERE idCargos = " + this.idCargo;
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, Constantes.SUCEXC, "SUCESSO", Constantes.SUCESSO);

                conn.close();
                stmt.close();

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROALT + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
    }
    
    @Override
    public String consultaCargo(){
        String sql = "SELECT * FROM cargos";
        return sql;
    }
    
    public void preencheComboCargos(JComboBox combo){
        try{
            String sql = consultaCargo();
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
//            if(rs.absolute(1)){
                while(rs.next()){
                    String nome = rs.getString("nomeCargo");
                    combo.addItem(nome);
                }
//            }else{
//                String mensagem = "Não foi localizado cargos para consulta.";
//                combo.addItem(mensagem);
//            }
            
            
        }catch(IOException | SQLException ex){
            String mensagemErro = "Erro. Houve um problema ao consultar. Erro: " + ex.getMessage();
            combo.addItem(mensagemErro);
        }
    }
    
    public int consultaCargoNome(String nome){
        try{
            String sql = "SELECT * FROM cargos WHERE nomeCargo = '" + nome + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            return rs.getInt("idCargos");
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Houve um erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return 0;
        }
    }
}
