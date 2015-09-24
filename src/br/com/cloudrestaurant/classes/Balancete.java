package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.BalanceteUI;
import br.com.cloudrestaurant.utilidades.Metodos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Michel Pereira
 */
public class Balancete implements BalanceteUI  {
    
    private int idBalancete;
    private int codLancamento;
    private int codHistorico;
    private double valor;
    private String descricao;
    private Date dataLancamento;
    private int codFuncionario;
    private int codProduto;
    private int tipoBalancete;
    private Boolean mensagem;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    Constantes constante;
    Metodos metodo;

    public Boolean isMensagem() {
        return mensagem;
    }

    public void setMensagem(Boolean mensagem) {
        this.mensagem = mensagem;
    }

    public int getIdBalancete() {
        return idBalancete;
    }

    public void setIdBalancete(int idBalancete) {
        this.idBalancete = idBalancete;
    }

    public int getCodLancamento() {
        return codLancamento;
    }

    public void setCodLancamento(int codLancamento) {
        this.codLancamento = codLancamento;
    }

    public int getCodHistorico() {
        return codHistorico;
    }

    public void setCodHistorico(int codHistorico) {
        this.codHistorico = codHistorico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getTipoBalancete() {
        return tipoBalancete;
    }

    public void setTipoBalancete(int tipoBalancete) {
        this.tipoBalancete = tipoBalancete;
    }
    
    public int consultaUltimoId(){
        String sql = null;
        String tabela = null;
        int soma;
        if(this.tipoBalancete == 1){ // CR
            sql = "SELECT MAX(idBalancetecr) as idBalancetecr FROM balancetecr";
            tabela = "idBalancetecr";
        }else if(this.tipoBalancete == 2){ // DB
            sql = "SELECT MAX(idBalancetedb) as idBalancetedb FROM balancetedb";
            tabela = "idBalancetedb";
        }
        
        try{
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            soma = rs.getInt(tabela) + 1;
            
            return soma;
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na consulta do último registro. Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return 0;
        }
    }
    
    @Override
    public void cadastraBalancete(){
        String sql = null;
        this.setIdBalancete(consultaUltimoId());
        
        if(this.tipoBalancete == 1){ //CR
            this.codLancamento = 1;
            sql = "INSERT INTO balancetecr ("
                + "idBalancetecr, "
                + "codHistorico, "
                + "valor, " 
                + "descricao, " 
                + "dataLancamento "
                + ") VALUES ( "
                + this.idBalancete
                + ", " + this.codHistorico
                + ", " + this.valor
                + ", '" + this.descricao + "' "
                + ", '" + this.dataLancamento + "' "    
                + ")";
        }else if(this.tipoBalancete == 2){ //DB
            this.codLancamento = 2;
            sql = "INSERT INTO balancetedb ("
                + "idBalancetedb, "
                + "codLancamento, "
                + "codHistorico, " 
                + "valor, " 
                + "descricao, "
                + "dataLancamento, "
                + "codFuncionario, "
                + "codProduto "
                + ") VALUES ( "
                + this.idBalancete
                + ", " + this.codLancamento
                + ", " + this.codHistorico
                + ", " + this.valor
                + ", '" + this.descricao + "' "
                + ", '" + this.dataLancamento + "' "
                + ", " + this.codFuncionario
                + ", " + this.codProduto
                + ")";
        }
        
        try{
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            
            if(this.mensagem){
                JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
            }
            
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCAD + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
        
    }
    @Override
    public void alteraBalancete(){
        if(JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION)==0){
            String sql = null;
            if(this.tipoBalancete == 1){ //CR
                sql = "UPDATE balancetecr SET "
                    + "codHistorico = " + this.codHistorico
                    + ", valor = " + this.valor
                    + ", descricao = '" + this.descricao + "' "
                    + ", dataLancamento = '" + this.dataLancamento + "' "    
                    + "WHERE idBalancetecr = " + this.idBalancete;
            }else if(this.tipoBalancete == 2){ //DB
                sql = "UPDATE balancetedb SET "
                    + "codLancamento = " + this.codLancamento
                    + ", codHistorico = " + this.codHistorico
                    + ", valor = " + this.valor
                    + ", descricao = '" + this.descricao + "' "
                    + ", dataLancamento = '" + this.dataLancamento + "' "
                    + ", codFuncionario = " + this.codFuncionario
                    + ", codProduto = " + this.codProduto
                    + "WHERE idBalancetedb = " + this.idBalancete;
            }

            try{
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                if(this.mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);
                }


            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROALT + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
        
    }
    @Override
    public void excluiBalancete(){
        if(JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION)==0){
            String sql = null;
            if(this.tipoBalancete == 1){ //CR
                sql = "DELETE FROM balancetecr "
                    + "WHERE idBalancetecr = " + this.idBalancete;
            }else if(this.tipoBalancete == 2){ //DB
                sql = "DELETE FROM balancetedb "
                    + "WHERE idBalancetedb = " + this.idBalancete;
            }

            try{
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);

                if(this.mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCEXC, "SUCESSO", Constantes.SUCESSO);
                }


            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROEXC + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
    }
    @Override
    public String consultaBalancete(){
        String sql = null;
        if(this.tipoBalancete == 1){//CR
            sql = "SELECT * FROM balancetecr";
        }else if(this.tipoBalancete == 2){//DB
            sql = "SELECT * FROM balancetedb";
        }
        
        return sql;
    }    
}
