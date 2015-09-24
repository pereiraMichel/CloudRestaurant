/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.TipoVendaUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author Debug
 */
public class TipoVenda implements TipoVendaUI{
    private int idIndicador;
    private String nome;
    private String natureza;
    private Date dataInclusao;
    private Date dataAlteracao;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Constantes constante;

    public int getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(int idIndicador) {
        this.idIndicador = idIndicador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNatureza() {
        return natureza;
    }

    public void setNatureza(String natureza) {
        this.natureza = natureza;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public void consultaUltimoId(){
            try{
            con = new Conexao();
            String consultaUltimoId = "SELECT MAX(idTipoVenda) as idTipoVenda FROM tipovenda";
            Connection con2 = con.getConnection();
            Statement stmt2 = con2.createStatement();
            ResultSet rs2 = stmt2.executeQuery(consultaUltimoId);
            rs2.next();

            
            int ultimoId = rs2.getInt("idTipoVenda");
//            JOptionPane.showMessageDialog(null, "Último Id: " + ultimoId);
            
            int soma = ultimoId + 1;
            
//            JOptionPane.showMessageDialog(null, soma);
            
            this.setIdIndicador(soma);
            
            rs2.close();
            stmt2.close();
            con2.close();    
            
            }
            catch(IOException | SQLException e){
                JOptionPane.showMessageDialog(null, "Problemas na consulta. Erro: " + e.getMessage());
            }        
    }
    
    @Override
    public void cadastraTipoVenda(){
        constante = new Constantes();
        con = new Conexao();

        consultaUltimoId();
        
        SimpleDateFormat formatado = new SimpleDateFormat("yyyy-MM-dd");
        
        String dataInclusaoFormatado = formatado.format(this.dataInclusao);
        String dataAlteracaoFormatado = formatado.format(this.dataAlteracao);
        
        //JOptionPane.showMessageDialog(null, dataInclusaoFormatado);
        
        //JOptionPane.showMessageDialog(null, "Novo Id: " + this.getIdIndicador());
       
        try{
        String sql = "INSERT INTO tipovenda (idTipoVenda, nomeTipoVenda, natureza, dataInclusao, dataAlteracao) VALUES (" + this.idIndicador + ", '" + this.nome + "', '" + this.natureza +"', '" + dataInclusaoFormatado + "', '" + dataAlteracaoFormatado + "')";

        //JOptionPane.showMessageDialog(null, sql);
        
        conn = con.getConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "SUCESSO", constante.SUCESSO);
        
        stmt.close();
        conn.close();
    
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas ao efetuar a consulta. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    @Override
    public void alteraTipoVenda(){
       
//        try{
        con = new Conexao();
            
            if (JOptionPane.showConfirmDialog(null, "Confirma as alterações?", "ATENÇÃO", JOptionPane.YES_NO_OPTION, constante.INTERROGACAO) == 0){
                try{
                String sql = "UPDATE tipovenda SET nomeTipoVenda = '" + this.nome + "',  natureza = '"  + this.natureza + "', dataAlteracao = '" + this.dataAlteracao + "' WHERE idTipoVenda = " + this.idIndicador;

//                JOptionPane.showMessageDialog(null, sql);

                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!", "SUCESSO", constante.SUCESSO);

                stmt.close();
                conn.close();
                
                }catch(IOException | SQLException e){
                    JOptionPane.showMessageDialog(null, "Problemas ao efetuar a alteração. Erro: " + e.getMessage(), "ERRO", constante.ERROR);
                }
            }
   
    }
    @Override
    public void excluiTipoVenda(){
        constante = new Constantes();
        try{
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o tipo da venda? As informações serão perdidas.", "ATENÇÃO", JOptionPane.YES_NO_OPTION, constante.INTERROGACAO) == 0){
                String sql = "DELETE FROM tipovenda WHERE idTipoVenda = " + this.idIndicador;
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Tipo da venda excluído com sucesso!", "SUCESSO", constante.SUCESSO);
                
                conn.close();
                stmt.close();
            }

        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas ao efetuar a alteração. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }  
    }
    
    @Override
    public String consultaTipoVenda(){
        String sql = "SELECT * FROM tipovenda i";
        return sql;
    }
    
    public String buscaIdentificador(String nomeIndicador){
            String sql =  "     SELECT "
                        + "     i.*, "
                        + "     DATE_FORMAT(i.dataInclusao, '%d/%m/%Y') as 'dataIncFormat',"
                        + "     DATE_FORMAT(i.dataAlteracao, '%d/%m/%Y') as 'dataAlterFormat' "
                        + "     FROM tipovenda i "
                        + "     WHERE "
                        + "         i.nomeTipoVenda = '" + nomeIndicador + "'";
            return sql;
    }
    
    public void preencheComboTipoVenda(JComboBox comboIndicador){
        try{
            String sql = consultaTipoVenda();
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                if(!rs.getString("nomeTipoVenda").equals("")){
                    String nomeIndicador = rs.getString("nomeTipoVenda");
                    comboIndicador.addItem(nomeIndicador);
                }else{
                    comboIndicador.addItem("Não há Promoção cadastrado.");
                }
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na consulta do tipo da venda. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    public int buscaIdTipoVenda(Object nomeTipoVenda){
        constante = new Constantes();
        
        try{
            String sql = "SELECT * FROM tipovenda WHERE nomeTipoVenda = '" + nomeTipoVenda + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            return rs.getInt("idTipoVenda");
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas ao efetuar a consulta. Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return 0;
        }
        
    }
    
}
