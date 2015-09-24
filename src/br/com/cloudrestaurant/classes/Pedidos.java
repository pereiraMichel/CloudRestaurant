/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.PedidoUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Debug
 */
public class Pedidos implements PedidoUI{
    
    private int idPedido;
    private Date dataPedido;
    private Time horaPedido;
    private double valorTotal;
    private int codCliente;
    private int codItem;
    private int codStatus;
    private int codTipoVenda;
    private double desconto;
    private double acrescimo;
    private double entrega;
    private int quantidade;
    private double valorQuantidade;
    private boolean mensagem;
    private String codPedido;

    public boolean isMensagem() {
        return mensagem;
    }

    public void setMensagem(boolean mensagem) {
        this.mensagem = mensagem;
    }
    
    Constantes constante;
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorQuantidade() {
        return valorQuantidade;
    }

    public void setValorQuantidade(double valorQuantidade) {
        this.valorQuantidade = valorQuantidade;
    }
    
    public Double isEntrega() {
        return entrega;
    }

    public void setEntrega(Double entrega) {
        this.entrega = entrega;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(double acrescimo) {
        this.acrescimo = acrescimo;
    }
    
    public int getCodTipoVenda() {
        return codTipoVenda;
    }

    public void setCodTipoVenda(int codTipoVenda) {
        this.codTipoVenda = codTipoVenda;
    }

    public Time getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(Time horaPedido) {
        this.horaPedido = horaPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(int codStatus) {
        this.codStatus = codStatus;
    }
    
    public String calculaCodPedido(){
        try{
            String sql = "SELECT COUNT(codPedido) AS codPedido FROM pedidos";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            if (rs.absolute(1)){
                int numPedido = Integer.parseInt(rs.getString("codPedido"));
                int novoCodPedido = numPedido + 1;
                this.codPedido = String.valueOf(novoCodPedido);
            }else{
                this.codPedido = "001";
            }
                return codPedido;
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCONS + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            return "00000";
        }
    }
    
    public int consultaUltimoId(){
        constante = new Constantes();
        
        try{
            String sql = "SELECT MAX(idPedido) AS idPedido FROM pedidos";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
                int ultimoId = rs.getInt("idPedido");
                int soma = ultimoId + 1;
                return soma;
        
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na consulta do id. Erro: " + ex, "ERRO", constante.ERROR);
            return 0;
        }
    }
    
    @Override
    public void cadastraPedido(){
        
        try{
        
        this.idPedido = consultaUltimoId();
        calculaCodPedido();
        
        String sql = "INSERT INTO pedidos (idPedido, dataPedido, horaPedido, valorTotal, desconto, acrescimo, quantidade, valorQuantidade, entrega, codCliente, codPedido, codStatus, codTipoVenda, codItem) "
                + "VALUES (" + this.idPedido + ", '" + this.dataPedido + "', '" + this.horaPedido + "', " + this.valorTotal + ", " + this.desconto + ", " + this.acrescimo + ", " + this.quantidade + ", " + this.valorQuantidade + ", " + this.entrega + ", '" + this.codCliente + "', " + this.codPedido + ", " + this.codStatus + ", " + this.codTipoVenda + ", " + this.codItem + ")";
//        JOptionPane.showMessageDialog(null, sql);
        
        conn = con.getConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate(sql);
        
//        if (mensagem){
//            JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
//        }
        
        conn.close();
        stmt.close();
        
    }catch (IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCAD + "Erro: " + ex.getMessage(), "ERRO", constante.ERROR);
        }
        
    }
    @Override
    public void alteraPedido(){
        
//        idPedido, dataPedido, horaPedido, valorTotal, desconto, acrescimo, quantidade, valorQuantidade, entrega, codCliente, codStatus, codTipoVenda, codItem
        
        if (JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION) == 0){
        String sql = "UPDATE pedidos "
                + "SET dataPedido = '" + this.dataPedido + "',"
                + "horaPedido = '" + this.horaPedido + "',"
                + "valorTotal = " + this.valorTotal + ","
                + "desconto = " + this.desconto + ","
                + "acrescimo = " + this.acrescimo + ","
                + "quantidade = " + this.quantidade + "',"
                + "valorQuantidade = " + this.valorQuantidade + ","
                + "entrega = " + this.entrega + ","
                + "codCliente = " + this.codCliente + ","
                + "codStatus = " + this.codStatus + ","
                + "codTipoVenda = " + this.codTipoVenda + ","
                + "codItem = " + this.codItem + " "
                + "WHERE idPedido = " + this.idPedido;
            try{
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                
                if(mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);
                }
                
                conn.close();
                stmt.close();
                
            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROALT + "Erro: " + ex.getMessage(), "SUCESSO", Constantes.SUCESSO);
            }
        }
        
    }
    @Override
    public void excluiPedido(){
        String sql = "DELETE FROM pedidos WHERE idPedido = " + this.idPedido;
        
        if (JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "CONFIRMAÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            try{
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                
                if (mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCEXC, "SUCESSO", Constantes.SUCESSO);
                }
                
                conn.close();
                stmt.close();
                
            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROEXC + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
        
    }
    @Override
    public String consultaPedido(){
        String sql = "SELECT "
                + "* "
                + "FROM pedidos";
        
        return sql;
    }
    
    public String consultaRelatorio(String dataPedido, int tipoVenda, int codCliente){
        
        String sql = "SELECT p.*, i.* "
                + "FROM pedidos p "
                + "INNER JOIN itens i ON p.codItem = i.idItem "
                + "INNER JOIN clientes c ON p.codCliente = c.idCliente "
                + "WHERE "
                + "dataPedido = '" + dataPedido + "' ";
        
        if (tipoVenda == 1){//Se for venda direta
            sql = sql + "AND p.codTipoVenda = 1";
        }else if (tipoVenda == 2){ //Se for venda por encomenda
            sql = sql + "AND p.codTipoVenda = 2";
        }
        
        if(codCliente != 0){
            sql = sql + " AND p.codCliente = " + codCliente;
        }
        
        return sql;
    }
    
    public String consultaTotalPedidos(){
        String sql = "SELECT sum(valorQuantidade) totalPedidos, " +
                     "       sum(quantidade) totalProdutos " + 
                     "FROM pedidos ";
        return sql;
    }
    
    public String consultaSinteticaPedidos(){
        String sql = "SELECT DISTINCT p.*, t.*," +
                     "SUM(p.quantidade) quantidadeTotal, " +
                     "SUM(p.valorQuantidade) valorTotalGeral, " + 
                     "DATE_FORMAT(p.dataPedido, '%d/%m/%y') dataFormatada " + 
                     "FROM pedidos p " +
                     "INNER JOIN itens i ON p.codItem = i.idItem " +
                     "INNER JOIN tipovenda t ON p.codTipoVenda = idTipoVenda " +
                     "GROUP BY p.codTipoVenda";
        return sql;
    }
    
    public String consultaAnaliticaPedidos(){
        String sql =    "SELECT DISTINCT p.*, i.nome, " +
                        "		 sum(p.quantidade) qtdeTotal, " +
                        "                DATE_FORMAT(dataPedido, '%d/%m/%y') dataFormatada, " +
                        "		 t.nomeTipoVenda " +
                        "FROM pedidos p " +
                        "INNER JOIN itens i ON p.codItem = i.idItem " +
                        "INNER JOIN tipovenda t ON p.codTipoVenda = idTipoVenda " +
                        "GROUP BY i.nome";
        
        return sql;
    }
   
}
