/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.ClienteUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Debug
 */
public class Clientes implements ClienteUI{

    private int idCliente;
    private String nome;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private int codEstado;
    private int codTelefone;
    private int codCelular;
    private Date dataNascimento;
    private Date dataCadastro;
    private Date dataAlteracao;
    private String referencia;
    private String telefone;
    private String celular;
    
    private Boolean cadastro;
    private Boolean alteracao;

    public Boolean isCadastro() {
        return cadastro;
    }

    public void setCadastro(Boolean cadastro) {
        this.cadastro = cadastro;
    }

    public Boolean isAlteracao() {
        return alteracao;
    }

    public void setAlteracao(Boolean alteracao) {
        this.alteracao = alteracao;
    }
    
    
   
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    Constantes constante;
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setIdCliente(int idCliente){
        this.idCliente = idCliente;
    }
    public int getIdCliente(){
        return idCliente;
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

    public void setCodEstado(int CodEstado) {
        this.codEstado = CodEstado;
    }

    public int getCodTelefone() {
        return codTelefone;
    }

    public void setCodTelefone(int codTelefone) {
        this.codTelefone = codTelefone;
    }

    public int getCodCelular() {
        return codCelular;
    }

    public void setCodCelular(int codCelular) {
        this.codCelular = codCelular;
    }

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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    
    
    public void consultaUltimoId(){
        constante = new Constantes();
        
        try{
            String sql = "SELECT MAX(idCliente) as idCliente FROM clientes";
            
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            
            rs = stmt.executeQuery(sql);
            rs.next();
            
            int resultado = rs.getInt("idCliente");
            int soma = resultado + 1;
            
            this.idCliente = soma;
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Houve um erro na consulta. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
        
    }
    
    public Boolean verificaTelefone(){
        constante = new Constantes();
        try{
            String sql = "SELECT telefone FROM clientes WHERE telefone = '" + this.telefone + "'";
            
            con = new Conexao();
            
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            if (rs.absolute(1)){
                JOptionPane.showMessageDialog(null, "O telefone já existe no nosso cadastro.", "ERRO TELEFONE", constante.ERROR);
                return false;
            }else{
                return true;
            }

        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Houve um erro na consulta. Erro: " + ex, "ERRO", constante.ERROR);
            return false;
        }
    }
    
    @Override
    public void cadastraCliente(){
        
        consultaUltimoId();
        
        if (verificaTelefone()){
        
        try{
        String sql = "INSERT INTO clientes (idCliente, nome, endereco, numero, complemento, bairro, cidade, referencia, dataNascimento, dataCadastro, dataAlteracao, telefone, celular, codEstado) "
                + "VALUES (" + this.idCliente + ", '" + this.nome + "', '" + this.endereco + "', " + this.numero + ", '" + this.complemento + "', '" + this.bairro + "', '" + this.cidade + "', '" + this.referencia + "', '" + this.dataNascimento + "', '" + this.dataCadastro + "', '" + this.dataAlteracao + "', '" + this.telefone + "', '" + this.celular + "', " + this.codEstado + ")";

        //JOptionPane.showMessageDialog(null, sql);
        
        con = new Conexao();
        conn = con.getConnection();
        stmt = conn.createStatement(); // insere o cliente
        stmt.executeUpdate(sql);

        
//        JOptionPane.showMessageDialog(null, constante.SUCCAD, "SUCESSO", constante.SUCESSO);
        
        conn.close();
        stmt.close();
        this.cadastro = true;
        
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, constante.ERROCAD + ".Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
            this.cadastro = false;
        }
        
        }// fecha if verificaTelefone()

    }
    
    @Override
    public void alteraCliente(){
        
        if (JOptionPane.showConfirmDialog(null, constante.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
        
            String sql = "UPDATE clientes "
                    + "SET nome = '" + this.nome + "', "
                    + "endereco = '" + this.endereco + "', "
                    + "numero = " + this.numero + ", "
                    + "complemento = '" + this.complemento + "', "
                    + "bairro = '" + this.bairro + "', "
                    + "cidade = '" + this.cidade + "', "
                    + "codEstado = " + this.codEstado + ", "
                    + "referencia = '" + this.referencia + "', "
                    + "dataNascimento = '" + this.dataNascimento + "', "
                    + "dataAlteracao = '" + this.dataAlteracao + "', "
                    + "telefone = '" + this.telefone + "', "
                    + "celular = '" + this.celular + "' "
                    + "WHERE idCliente = " + this.idCliente;

            try{
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, constante.SUCALT, "SUCESSO", constante.SUCESSO);

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, constante.ERROALT + ".Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
            }
        
        }
        
    }

    @Override
    public void excluiCliente() {
        if (JOptionPane.showConfirmDialog(null, constante.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
                String sql = "DELETE FROM clientes WHERE idCliente = " + this.idCliente;
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null, constante.SUCEXC, "SUCESSO", constante.SUCESSO);
                
            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, constante.ERROEXC + ".Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
            }
        }
    }

    @Override
    public String consultaCliente() {
        String sql = "SELECT *, "
                + "DATE_FORMAT(dataCadastro, '%d/%m/%Y') as 'dataCadFormat', "
                + "DATE_FORMAT(dataAlteracao, '%d/%m/%Y') as 'dataAlterFormat', "
                + "DATE_FORMAT(dataNascimento, '%d/%m/%Y') as 'dataNascFormat' "
                + "FROM clientes";
        return sql;
    }
    
    public String buscaTelefoneCliente(String telefone){
        String sql = "SELECT *, "
                + "DATE_FORMAT(dataCadastro, '%d/%m/%Y') as 'dataCadFormat', "
                + "DATE_FORMAT(dataAlteracao, '%d/%m/%Y') as 'dataAlterFormat', "
                + "DATE_FORMAT(dataNascimento, '%d/%m/%Y') as 'dataNascFormat' "
                + "FROM clientes "
                + "WHERE telefone LIKE '" + telefone + "%'";
        
        return sql;
    }
    public String buscaNomeCliente(String nome){
        String sql = "SELECT *, "
                + "DATE_FORMAT(dataCadastro, '%d/%m/%Y') as 'dataCadFormat', "
                + "DATE_FORMAT(dataAlteracao, '%d/%m/%Y') as 'dataAlterFormat', "
                + "DATE_FORMAT(dataNascimento, '%d/%m/%Y') as 'dataNascFormat' "
                + "FROM clientes"
                + "WHERE nome LIKE '" + nome + "%'";
        
        return sql;
    }

            
}
