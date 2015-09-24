/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.FuncionarioUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Debug
 */
public class Funcionario implements FuncionarioUI {

    private int idFuncionario;
    private String nome;
    private Time horaEntrada;
    private Time horaSaida;
    private String endereco;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private int codEstado;
    private Date dataNascimento;
    private Date dataAdmissao;
    private Date dataSaida;
    private Date dataAlteracao;
    private Date dataCadastro;
    private int codTipoTrabalho;
    private int codCargo;
    private double valorPagamento;
    private int codTipoPagamento;
    private String observacoes;
    private int codFuncionario;
    
    Constantes constante;
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public int getCodTipoPagamento() {
        return codTipoPagamento;
    }

    public void setCodTipoPagamento(int codTipoPagamento) {
        this.codTipoPagamento = codTipoPagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Time horaSaida) {
        this.horaSaida = horaSaida;
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

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }
    
    public Date getDataAlteracao(){
        return dataAlteracao;
    }
    
    public void setDataAlteracao(Date dataAlteracao){
        this.dataAlteracao = dataAlteracao;
    }

    public int getCodTipoTrabalho() {
        return codTipoTrabalho;
    }

    public void setCodTipoTrabalho(int codTipoTrabalho) {
        this.codTipoTrabalho = codTipoTrabalho;
    }
    
    public void pesquisaUltimoRegistro() {
            constante = new Constantes();
        try{
        
        String consultaUltimoId = "SELECT MAX(idFuncionario) AS idFuncionario FROM funcionario";
        Conexao con2 = new Conexao();
        Connection conn2 = con2.getConnection();
        
        Statement stmt2 = conn2.createStatement();
        ResultSet rs2 = stmt2.executeQuery(consultaUltimoId);
        rs2.next();
        
        int numeroIndicador = rs2.getInt("idFuncionario");
        
        int soma = numeroIndicador + 1;
        
        this.setIdFuncionario(soma);
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não possível inserir os dados. Erro: " + ex.getMessage(), "ATENÇÃO", constante.ERROR);
            
        }
    }
    
    @Override
    public void cadastraFuncionario(){

        pesquisaUltimoRegistro();

        try{
        String sql = "INSERT INTO funcionario (idFuncionario, nome, endereco, numero, complemento, bairro, cidade, dataNascimento, dataAdmissao, dataSaida, dataCadastro, dataAlteracao, horaEntrada, horaSaida, valorPagamento, observacoes, codFuncionario, codTipoPagamento, codEstado, codCargo)"
                + " VALUES (" + this.idFuncionario + ", '" + this.nome + "', '" + this.endereco + "', " + this.numero + ", '" + this.complemento + "', '" + this.bairro + "', '" + this.cidade + "', '" + this.dataNascimento + "', '" + this.dataAdmissao + "', '" + this.dataSaida + "', '" + this.dataCadastro + "', '" + this.dataAlteracao + "', '" + this.horaEntrada + "', '" + this.horaSaida + "', " + this.valorPagamento + ", '" + this.observacoes + "', " + this.idFuncionario + ", " + this.codTipoPagamento + ", " + this.codEstado + ", " + this.codCargo + ")";
        
        
        con = new Conexao();
        
        conn = con.getConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        
        JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", constante.SUCESSO);
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível inserir os dados. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    @Override
    public void alteraFuncionario(){
        
        
/*    
, , endereco, numero, complemento, bairro, cidade, dataNascimento, dataAdmissao, dataSaida, dataCadastro, dataAlteracao, horaEntrada, horaSaida, valorPagamento, observacoes, codTipoPagamento, codEstado, codCargo
*/        
        try{
            
            String sql = "UPDATE funcionario "
                    + "SET nome = '" + this.nome + "', "
                    + "endereco = '" + this.endereco + "', "
                    + "numero = " + this.numero + ", "
                    + "complemento = '" + this.complemento + "', "
                    + "bairro = '" + this.bairro + "', "
                    + "cidade = '" + this.cidade + "', "
                    + "dataNascimento = '" + this.dataNascimento + "', "
                    + "dataAdmissao = '" + this.dataAdmissao + "', "
                    + "dataSaida = '" + this.dataSaida + "', "
                    + "dataAlteracao = '" + this.dataAlteracao + "', "
                    + "horaEntrada = '" + this.horaEntrada + "', "
                    + "horaSaida = '" + this.horaSaida + "', "
                    + "valorPagamento = " + this.valorPagamento + ", "
                    + "observacoes = '" + this.observacoes + "', "
                    + "codTipoPagamento = " + this.codTipoPagamento + ", "
                    + "codEstado = " + this.codEstado + ", "
                    + "codCargo = " + this.codCargo + " "
                    + "WHERE idFuncionario = " + this.idFuncionario;
            
            if (JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, Constantes.SUCSAL, "SUCESSO", constante.SUCESSO);
     
            stmt.close();
            conn.close();
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível alterar os dados. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    @Override
    public void excluiFuncionario(){
        
        try{
            
            if (JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            String sql = "DELETE FROM funcionario WHERE idFuncionario = " + this.idFuncionario;
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(null, Constantes.SUCEXC, "SUCESSO", constante.SUCESSO);
            
            stmt.close();
            conn.close();
            }
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível efetuar a exclusão. Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    
    @Override
    public String consultaFuncionario(){
        String sql = "SELECT f.*, c.nomeCargo, "
                + "          DATE_FORMAT(f.dataNascimento, '%d/%m/%Y') as 'dataNascFormat',"
                + "          DATE_FORMAT(f.dataCadastro, '%d/%m/%Y') as 'dataCadFormat',"
                + "          DATE_FORMAT(f.dataAlteracao, '%d/%m/%Y') as 'dataAlterFormat',"
                + "          DATE_FORMAT(f.dataAdmissao, '%d/%m/%Y') as dataAdmFormat, "
                + "          DATE_FORMAT(f.dataSaida, '%d/%m/%Y') as dataSaidaFormat "
                + "          TIME_FORMAT(f.horaEntrada, '%H:%m') as horaEntradaFormatada, "
                + "          TIME_FORMAT(f.horaSaida, '%H:%m') as horaSaidaFormatada "
                + "FROM funcionario f "
                + "INNER JOIN cargos c ON e.codCargo = c.idCargo ";
        return sql;
        
    }

    /*
SELECT  f.*, c.nomeCargo,           
				   DATE_FORMAT(f.dataNascimento, '%d/%m/%Y') as 'dataNascFormat',
                   DATE_FORMAT(f.dataCadastro, '%d/%m/%Y') as 'dataCadFormat',
                   DATE_FORMAT(f.dataAlteracao, '%d/%m/%Y') as 'dataAlterFormat',
                   DATE_FORMAT(f.dataAdmissao, '%d/%m/%Y') as dataAdmFormat,
                   DATE_FORMAT(f.dataSaida, '%d/%m/%Y') as dataSaidaFormat,
                   TIME_FORMAT(f.horaEntrada, '%H:%m') as horaEntradaFormatada,
                   TIME_FORMAT(f.horaSaida, '%H:%m') as horaSaidaFormatada
				   FROM funcionario f
                   LEFT JOIN cargos c ON f.codCargo = c.idCargos
                   LEFT JOIN telefones tel ON f.idFuncionario = tel.codProprietario
                   AND tel.tipoProprietario = 'funcionario'
GROUP BY idFuncionario*/
    
    
    
    public String consultaFuncionarioCargo(){
        String sql = "SELECT DISTINCT f.*, c.nomeCargo, "
                   + "          DATE_FORMAT(f.dataNascimento, '%d/%m/%Y') as 'dataNascFormat',"
                   + "          DATE_FORMAT(f.dataCadastro, '%d/%m/%Y') as 'dataCadFormat',"
                   + "          DATE_FORMAT(f.dataAlteracao, '%d/%m/%Y') as 'dataAlterFormat',"
                   + "          DATE_FORMAT(f.dataAdmissao, '%d/%m/%Y') as dataAdmFormat, "
                   + "          DATE_FORMAT(f.dataSaida, '%d/%m/%Y') as dataSaidaFormat, "
                   + "          TIME_FORMAT(f.horaEntrada, '%H:%m') as horaEntradaFormatada, "
                   + "          TIME_FORMAT(f.horaSaida, '%H:%m') as horaSaidaFormatada "
                   + "FROM funcionario f "
                   + "LEFT JOIN cargos c ON f.codCargo = c.idCargos "
                   + "LEFT JOIN telefones tel ON f.idFuncionario = tel.codProprietario "
                   + "AND tel.tipoProprietario = 'funcionario' "
                   + "GROUP BY idFuncionario";
        return sql;
        
    }
    
    public String buscaFuncionario(String dado){
        
        String sql = "SELECT f.*, c.*, es.*, t.*,  "
                + "          DATE_FORMAT(f.dataNascimento, '%d/%m/%Y') as 'dataNascFormat',"
                + "          DATE_FORMAT(f.dataCadastro, '%d/%m/%Y') as 'dataCadFormat',"
                + "          DATE_FORMAT(f.dataAlteracao, '%d/%m/%Y') as 'dataAlterFormat',"
                + "          DATE_FORMAT(f.dataAdmissao, '%d/%m/%Y') as dataAdmFormat, "
                + "          DATE_FORMAT(f.dataSaida, '%d/%m/%Y') as dataSaidaFormat, "
                + "          TIME_FORMAT(f.horaEntrada, '%H:%m') as horaEntradaFormatada, "
                + "          TIME_FORMAT(f.horaSaida, '%H:%m') as horaSaidaFormatada "
                + "FROM funcionario f "
                + "INNER JOIN estados es ON es.idEstado = f.codEstado "
                + "INNER JOIN tipopagamento t ON f.codTipoPagamento = t.idTipoPagamento "
                + "INNER JOIN cargos c ON f.codCargo = c.idCargos "
                + "WHERE f.idFuncionario = " + dado;
//INNER JOIN telefones tel ON f.idFuncionario = tel.codProprietario tel.*,
//AND tel.tipoProprietario = 'funcionario'        
//f.idFuncionario = tel.codProprietario AND 
        return sql;
        
    }
    
    public int buscaIdFuncionario(String dado){
        try{
            String sql = "SELECT * FROM funcionario WHERE nome = '" + dado + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            return rs.getInt("idFuncionario");
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Houve um erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return 0;
        }    
    }
    
    public int pesquisaUltimoCodFuncionario(){
        try{
            String sql = "SELECT MAX(idFuncionario) AS idFuncionario FROM funcionario";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            int codAnterior = rs.getInt("idFuncionario");
            int novoCodigo = codAnterior + 1;
            
            return novoCodigo;
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Houve um erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return 0;
        }
        
        
    }
    
    public void preencheComboFuncionario(JComboBox combo){
        String nome = null;
        try{
            String sql = "SELECT nome FROM funcionario";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
//            rs.first();
            
            while(rs.next()){
                nome = rs.getString("nome");
                combo.addItem(nome);
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROEXC + " Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
    }
    
}
