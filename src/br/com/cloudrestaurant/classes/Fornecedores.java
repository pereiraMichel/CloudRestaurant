/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.FornecedorUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Debug
 */
public class Fornecedores implements FornecedorUI{
    
    private int idFornecedor;
    private String nome;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private int codEstado;
    private Date dataCadastro;
    private Date dataAlteracao;
    private Boolean mensagem;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Boolean isMensagem() {
        return mensagem;
    }

    public void setMensagem(Boolean mensagem) {
        this.mensagem = mensagem;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(int codEstado) {
        this.codEstado = codEstado;
    }
    
    public int consultaUltimoId(){
        
        try{
            String sql = "SELECT MAX(idFornecedor) as idFornecedor FROM fornecedores";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            int idItem = rs.getInt("idFornecedor");
            
            int novoId = idItem + 1;
            
            return novoId;
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCONS + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return 0;
        }
        
    }

    @Override
    public void cadastraFornecedor(){
        this.idFornecedor = consultaUltimoId();
        
        try{
            String sql = "INSERT INTO fornecedores (idFornecedor, nome, endereco, numero, complemento, bairro, cidade, dataCadastro, dataAlteracao, codEstado) "
                    + "VALUES ( " + this.idFornecedor + ", "
                    + "'" + this.nome + "', "
                    + "'" + this.endereco + "', "
                    + "" + this.numero + ", "
                    + "'" + this.complemento + "', "
                    + "'" + this.bairro + "', "
                    + "'" + this.cidade + "', "
                    + "'" + this.dataCadastro + "', "
                    + "'" + this.dataAlteracao + "', "
                    + "" + this.codEstado + " "
                    + ")";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            
            if (this.mensagem){
                JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCAD + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
        
        
    }
    
    @Override
    public void alteraFornecedor(){
        if (JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
//idFornecedor, nome, endereco, numero, complemento, bairro, cidade, dataCadastro, dataAlteracao, codEstado        
            try{
                String sql = "UPDATE fornecedores "
                        + "SET "
                        + "nome = '" + this.nome + "', "
                        + "endereco = " + this.endereco + ", "
                        + "numero = " + this.numero + ", "
                        + "complemento = " + this.complemento + ", "
                        + "bairro = " + this.bairro + ", "
                        + "cidade = " + this.cidade + ", "
                        + "dataAlteracao = " + this.dataAlteracao + " "
                        + "WHERE idFornecedor = " + this.idFornecedor;
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                if (this.mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);
                }

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROALT + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
    }
    
    @Override
    public void excluiFornecedor(){
        if (JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
        
            try{
                String sql = "DELETE FROM fornecedores "
                        + "WHERE idFornecedor = " + this.idFornecedor;
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                if (this.mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCEXC, "SUCESSO", Constantes.SUCESSO);
                }

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROEXC + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
        
    }
    
    @Override
    public String consultaFornecedor(){
        String sql = "SELECT * FROM fornecedores";
        return sql;
    }
    
    public void preencheComboFornecedores(JComboBox combo){
        
        String sql = "SELECT idFornecedor, nome FROM fornecedores";
        
        try{
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.first();
            if (rs.absolute(1)){
                while(rs.next()){
                    String resultado = rs.getString("nome");
                    combo.addItem(resultado);
                }
            }else{
                combo.addItem("(vazio)");
            }
            
            
        }catch(IOException | SQLException ex){
            
        }
        
        
    }
    
}
