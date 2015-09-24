/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.interfaces.ItensUI;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Debug
 */
public class Itens implements ItensUI{
    
    private int idItens;
    private String nome;
    private double valorCusto;
    private double valorVenda;
    private int quantidade;
    private int codFornecedor;
    private double desconto;
    private double acrescimo;
    
    private Boolean mensagem;
    
    private JTable tabelaItens;
    
    Constantes constante;
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public Boolean isMensagem() {
        return mensagem;
    }

    public void setMensagem(Boolean mensagem) {
        this.mensagem = mensagem;
    }

    public JTable getTabelaItens() {
        return tabelaItens;
    }

    public void setTabelaItens(JTable tabelaItens) {
        this.tabelaItens = tabelaItens;
    }

    public int getIdItens() {
        return idItens;
    }

    public void setIdItens(int idItens) {
        this.idItens = idItens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
    
    public void consultaUltimoId(){
        
        try{
            String sql = "SELECT MAX(idItem) as idItem FROM itens";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            int idItem = rs.getInt("idItem");
            
            int novoId = idItem + 1;
            
            this.idItens = novoId;
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, Constantes.ERROCONS + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
        
    }
    
    @Override
    public void cadastraItem(){
        
        consultaUltimoId();
        
        try{
            String sql = "INSERT INTO itens (idItem, nome, valorCusto, valorVenda, quantidade, desconto, acrescimo, codFornecedor) "
                    + "VALUES ( " + this.idItens + ", "
                    + "'" + this.nome + "', "
                    + this.valorCusto + ", "
                    + this.valorVenda + ", "
                    + this.quantidade + ", "
                    + this.desconto + ", "
                    + this.acrescimo + ", "
                    + this.codFornecedor + " "
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
    public void alteraItem(){
        
        if (JOptionPane.showConfirmDialog(null, Constantes.ALTERACAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
        
            try{
                String sql = "UPDATE itens "
                        + "SET "
                        + "nome = '" + this.nome + "', "
                        + "valorCusto = " + this.valorCusto + ", "
                        + "valorVenda = " + this.valorVenda + ", "
                        + "quantidade = " + this.quantidade + ", "
                        + "desconto = " + this.desconto + ", "
                        + "acrescimo = " + this.acrescimo + ", "
                        + "codFornecedor = " + this.codFornecedor + " "
                        + "WHERE idItem = " + this.idItens;
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
//                JOptionPane.showMessageDialog(null, sql);

                if (this.mensagem){
                    JOptionPane.showMessageDialog(null, Constantes.SUCALT, "SUCESSO", Constantes.SUCESSO);
                }

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, Constantes.ERROALT + "Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
    }
    @Override
    public void excluiItem(){
        if (JOptionPane.showConfirmDialog(null, Constantes.EXCLUSAO, "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
        
            try{
                String sql = "DELETE FROM itens "
                        + "WHERE idItem = " + this.idItens;
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
    public void cancelaItem(){
        
    }
    @Override
    public String consultaItem(){
        String sql = "SELECT * FROM itens";
        return sql;
    }
    
    public void preencheComboItem(JComboBox combo){
    
        constante = new Constantes();
        
        try{
            String sql = consultaItem();
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            
            while (rs.next()){

                    String nomeItem = rs.getString("nome");
                    combo.addItem(nomeItem);
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas na consulta do item. Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
        
    }
    
    public void preencheItem(int codigo, JLabel nome){
        String sql = "SELECT * FROM itens WHERE idItem = " + codigo;
        try{
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            nome.setVisible(true);
            nome.setText(rs.getString("nome"));
            
        }catch(IOException | SQLException ex){
            
        }
    }
    
    public int retornaCodItem(Object nomeItem){
        constante = new Constantes();
        try{
          
                String sql = "SELECT * FROM itens WHERE nome = '" + nomeItem + "'";
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                rs.next();

                int id = rs.getInt("idItem");
                return id;

        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas ao consultar o item. Erro: " + ex, "ERRO", constante.ERROR);
            return 0;
        }
    }
    
    public void retiraItensTabela(int item, JTable tabela, JLabel valor){
        constante = new Constantes();
       
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();

        dtm.removeRow(item);
        double somaValores = 0;
        for (int i=0; i<=tabela.getRowCount()-1;i++) {  
//                count+=Double.parseDouble(table.getValueAt(i, 4).toString());
            somaValores+= Double.parseDouble(tabela.getValueAt(i, 4).toString());
            valor.setText(String.valueOf(somaValores));
        }
        if (dtm.getRowCount() == -1){
            valor.setText("0.00");
        }else{
            valor.setText(String.valueOf(somaValores));
        }
        
    }
    
    public void preencheTabela(JTable tabela){
        DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
        
        try{
            String sql = this.consultaItem();
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                String item = rs.getString("nome");
                int codItem = rs.getInt("idItem");
                dtm.addRow(new Object[]{codItem, item});            }
            
        }catch(IOException | SQLException ex){
            
        }
        
    }
    
    public void limpaTabela(JTable tabela){
            DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
            dtm.setNumRows(0);
    }
    
    public void preencheTabelaItens(Object nomeItem, int quantidade, Object status, JTable tabela, JLabel valor, JTextField desconto, JTextField acrescimo){
        constante = new Constantes();
        
        try{
            String sql = "SELECT i.* FROM itens i WHERE i.nome = '" + nomeItem + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();

            int codItem = rs.getInt("i.idItem");
            String item = rs.getString("i.nome");
            double valorUnitario = rs.getDouble("i.valorVenda");
            
            double valorPorQuantidade = valorUnitario * quantidade;
            double valorDesconto = Double.valueOf(desconto.getText());
            double valorAcrescimo = Double.valueOf(acrescimo.getText());

            DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();

            dtm.addRow(new Object[]{codItem, item, valorUnitario, quantidade, valorPorQuantidade, status});
        
            double somaValores = 0;
            for (int i=0; i<=tabela.getRowCount()-1;i++) {  
//                count+=Double.parseDouble(table.getValueAt(i, 4).toString());
                somaValores+= Double.parseDouble(tabela.getValueAt(i, 4).toString());
                
                double somaValorDescontoAcrescimo = (somaValores - valorDesconto) + valorAcrescimo;
                valor.setText(String.valueOf(somaValorDescontoAcrescimo));
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas ao preencher a tabela. Erro: " + ex, "ERRO", Constantes.ERROR);
        }
    }
    
    public void margemTabela(){
            tabelaItens.getColumnModel().getColumn(0).setPreferredWidth(90); // define o tamanho da coluna.
            tabelaItens.getColumnModel().getColumn(0).setResizable(false);// Não poderá alterar o tamanho.
            tabelaItens.getColumnModel().getColumn(1).setPreferredWidth(150); // define o tamanho da coluna.
            tabelaItens.getColumnModel().getColumn(1).setResizable(false);// Não poderá alterar o tamanho.
            tabelaItens.getColumnModel().getColumn(2).setPreferredWidth(50); // define o tamanho da coluna.
            tabelaItens.getColumnModel().getColumn(2).setResizable(false);// Não poderá alterar o tamanho.
            tabelaItens.getColumnModel().getColumn(3).setPreferredWidth(100); // define o tamanho da coluna.
            tabelaItens.getColumnModel().getColumn(3).setResizable(false);// Não poderá alterar o tamanho.
            tabelaItens.getColumnModel().getColumn(4).setPreferredWidth(100); // define o tamanho da coluna.
            tabelaItens.getColumnModel().getColumn(4).setResizable(false);// Não poderá alterar o tamanho.
            tabelaItens.getColumnModel().getColumn(5).setPreferredWidth(100); // define o tamanho da coluna.
            tabelaItens.getColumnModel().getColumn(5).setResizable(false);// Não poderá alterar o tamanho.

            tabelaItens.getTableHeader().setReorderingAllowed(false);
            tabelaItens.setAutoResizeMode(tabelaItens.AUTO_RESIZE_OFF);

            tabelaItens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    public void margemTabelaBanco(JTable tabela){
            tabela.getColumnModel().getColumn(0).setPreferredWidth(100); // define o tamanho da coluna.
            tabela.getColumnModel().getColumn(0).setResizable(false);// Não poderá alterar o tamanho.
            tabela.getColumnModel().getColumn(1).setPreferredWidth(250); // define o tamanho da coluna.
            tabela.getColumnModel().getColumn(1).setResizable(false);// Não poderá alterar o tamanho.

            tabela.getTableHeader().setReorderingAllowed(false);
            tabela.setAutoResizeMode(tabela.AUTO_RESIZE_OFF);

            tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
}
