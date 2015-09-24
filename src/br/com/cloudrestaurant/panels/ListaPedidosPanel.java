/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.panels;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.classes.Pedidos;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.utilidades.Metodos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Debug
 */
public class ListaPedidosPanel extends javax.swing.JPanel {

    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    Metodos metodo;
    Constantes constante;
    Pedidos pedido = new Pedidos();
    
    
    public ListaPedidosPanel() {
        initComponents();
        preencheTotais();
        preencheLabels();
        preencheTabelaRegistro(pedido.consultaSinteticaPedidos());
        preencheTabelaAnalitica(pedido.consultaAnaliticaPedidos());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        panelTabela = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAnalitica = new javax.swing.JTable();
        panelSintetico = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaRegistros = new javax.swing.JTable();
        labelTitVendasDia = new javax.swing.JLabel();
        labelQuantTotalDia = new javax.swing.JLabel();
        labelTotalVendasDia = new javax.swing.JLabel();
        labelTotalDia = new javax.swing.JLabel();
        panelBotoes = new javax.swing.JPanel();
        btFechar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btAtualizar = new javax.swing.JButton();

        panelTabela.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabelaAnalitica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tabelaAnalitica);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("   Lista Analítica   ", jPanel1);

        tabelaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data Registro", "Código Registro", "Itens - Quantidade", "Valor Total"
            }
        ));
        jScrollPane2.setViewportView(tabelaRegistros);

        labelTitVendasDia.setForeground(new java.awt.Color(255, 0, 0));
        labelTitVendasDia.setText("Total de Vendas no dia:");

        labelQuantTotalDia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelQuantTotalDia.setForeground(new java.awt.Color(255, 0, 0));
        labelQuantTotalDia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelQuantTotalDia.setText("quantidade");
        labelQuantTotalDia.setToolTipText("");
        labelQuantTotalDia.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelTotalVendasDia.setForeground(new java.awt.Color(255, 0, 0));
        labelTotalVendasDia.setText("Total de Vendas do dia:");

        labelTotalDia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelTotalDia.setForeground(new java.awt.Color(255, 0, 0));
        labelTotalDia.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalDia.setText("valor");
        labelTotalDia.setToolTipText("");
        labelTotalDia.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout panelSinteticoLayout = new javax.swing.GroupLayout(panelSintetico);
        panelSintetico.setLayout(panelSinteticoLayout);
        panelSinteticoLayout.setHorizontalGroup(
            panelSinteticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSinteticoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSinteticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelSinteticoLayout.createSequentialGroup()
                        .addComponent(labelTitVendasDia)
                        .addGap(18, 18, 18)
                        .addComponent(labelQuantTotalDia, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(labelTotalVendasDia)
                        .addGap(39, 39, 39)
                        .addComponent(labelTotalDia, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelSinteticoLayout.setVerticalGroup(
            panelSinteticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSinteticoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelSinteticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotalDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTotalVendasDia)
                    .addComponent(labelTitVendasDia)
                    .addComponent(labelQuantTotalDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("   Lista Sintética   ", panelSintetico);

        javax.swing.GroupLayout panelTabelaLayout = new javax.swing.GroupLayout(panelTabela);
        panelTabela.setLayout(panelTabelaLayout);
        panelTabelaLayout.setHorizontalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        panelTabelaLayout.setVerticalGroup(
            panelTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotoes.setBackground(new java.awt.Color(153, 153, 255));
        panelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btSairCloud.png"))); // NOI18N
        btFechar.setText("Sair");
        btFechar.setToolTipText("Sair do formulário");
        btFechar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFechar.setMaximumSize(new java.awt.Dimension(55, 35));
        btFechar.setMinimumSize(new java.awt.Dimension(55, 35));
        btFechar.setPreferredSize(new java.awt.Dimension(55, 35));
        btFechar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFecharActionPerformed(evt);
            }
        });

        btCancelar.setBackground(new java.awt.Color(153, 153, 255));
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btCancelarCloud.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.setToolTipText("Cancelar as Operações");
        btCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCancelar.setMargin(new java.awt.Insets(2, 7, 2, 7));
        btCancelar.setMaximumSize(new java.awt.Dimension(55, 35));
        btCancelar.setMinimumSize(new java.awt.Dimension(55, 35));
        btCancelar.setPreferredSize(new java.awt.Dimension(55, 35));
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btAtualizar.png"))); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.setToolTipText("Atualizar o Registro");
        btAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAtualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(72, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.fechar();

        // TODO add your handling code here:
    }//GEN-LAST:event_btFecharActionPerformed

    public void fechar(){
        this.setVisible(false);
    }
    
    public void preencheLabels(){
//        labelQuantTotalMes.setVisible(false);
//        labelTitQuantVendasMes.setVisible(false);
//        labelTitVendaMes.setVisible(false);
//        labelTotalMes.setVisible(false);
//        labelMesEscolha.setVisible(false);
    }
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed


    }//GEN-LAST:event_btAtualizarActionPerformed

    public void preencheTabelaAnalitica(String sql){
        pedido = new Pedidos();
        
        ArrayList dados = new ArrayList();
        String[] nomeColunas = new String[]{"DATA REGISTRO","ITEM","QUANTIDADE","TIPO VENDA"};
        
        try{
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.first();
            
            do{
                dados.add(new Object[]{rs.getString("dataFormatada"), rs.getString("nome"), rs.getString("qtdeTotal"), rs.getString("nomeTipoVenda")});
                //labelTotalDia.setText(rs.getString("totalGeral"));
            }while(rs.next());
            
        ModeloTabela modelo = new ModeloTabela(dados, nomeColunas);
        tabelaAnalitica.setModel(modelo);
        tabelaAnalitica.getColumnModel().getColumn(0).setPreferredWidth(150); // define o tamanho da coluna.
        tabelaAnalitica.getColumnModel().getColumn(0).setResizable(false);// Não poderá alterar o tamanho.
        tabelaAnalitica.getColumnModel().getColumn(1).setPreferredWidth(150); // define o tamanho da coluna.
        tabelaAnalitica.getColumnModel().getColumn(1).setResizable(false);// Não poderá alterar o tamanho.
        tabelaAnalitica.getColumnModel().getColumn(2).setPreferredWidth(150); // define o tamanho da coluna.
        tabelaAnalitica.getColumnModel().getColumn(2).setResizable(false);// Não poderá alterar o tamanho.
        tabelaAnalitica.getColumnModel().getColumn(3).setPreferredWidth(150); // define o tamanho da coluna.
        tabelaAnalitica.getColumnModel().getColumn(3).setResizable(false);// Não poderá alterar o tamanho.
        
        tabelaAnalitica.getTableHeader().setReorderingAllowed(false);
        tabelaAnalitica.setAutoResizeMode(tabelaAnalitica.AUTO_RESIZE_OFF);
        
        tabelaAnalitica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não registro na tabela. Inclua um novo. Erro: " + ex.getMessage(), "ATENÇÃO", Constantes.INTERROGACAO);
//            labelMensagem.setVisible(true);
//            labelMensagem.setText("Não há registro na tabela. Inclua um novo.");
        }
    }
    
    public void preencheTotais(){
        pedido = new Pedidos();
        try{
            String sql = pedido.consultaTotalPedidos();
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            labelQuantTotalDia.setText(rs.getString("totalProdutos"));
            labelTotalDia.setText(rs.getString("totalPedidos"));
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possível consultar os valores. Verifique sob o erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
    }
    
    public void preencheTabelaRegistro(String sql){
        ArrayList dados = new ArrayList();
        String[] nomeColunas = new String[]{"TIPO VENDA", "QUANTIDADE ITENS","VALOR TOTAL"};
        
        try{
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.first();
            
            do{
                dados.add(new Object[]{rs.getString("nomeTipoVenda"), rs.getString("quantidadeTotal"), rs.getString("valorTotalGeral")});
                //labelTotalDia.setText(rs.getString("totalGeral"));
            }while(rs.next());
            
        ModeloTabela modelo = new ModeloTabela(dados, nomeColunas);
        tabelaRegistros.setModel(modelo);
        tabelaRegistros.getColumnModel().getColumn(0).setPreferredWidth(150); // define o tamanho da coluna.
        tabelaRegistros.getColumnModel().getColumn(0).setResizable(false);// Não poderá alterar o tamanho.
        tabelaRegistros.getColumnModel().getColumn(1).setPreferredWidth(150); // define o tamanho da coluna.
        tabelaRegistros.getColumnModel().getColumn(1).setResizable(false);// Não poderá alterar o tamanho.
        tabelaRegistros.getColumnModel().getColumn(2).setPreferredWidth(150); // define o tamanho da coluna.
        tabelaRegistros.getColumnModel().getColumn(2).setResizable(false);// Não poderá alterar o tamanho.
        
        tabelaRegistros.getTableHeader().setReorderingAllowed(false);
        tabelaRegistros.setAutoResizeMode(tabelaRegistros.AUTO_RESIZE_OFF);
        
        tabelaRegistros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Não registro na tabela. Inclua um novo. Erro: " + ex.getMessage(), "ATENÇÃO", Constantes.INTERROGACAO);
//            labelMensagem.setVisible(true);
//            labelMensagem.setText("Não há registro na tabela. Inclua um novo.");
        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFechar;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelQuantTotalDia;
    private javax.swing.JLabel labelTitVendasDia;
    private javax.swing.JLabel labelTotalDia;
    private javax.swing.JLabel labelTotalVendasDia;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelSintetico;
    private javax.swing.JPanel panelTabela;
    private javax.swing.JTable tabelaAnalitica;
    private javax.swing.JTable tabelaRegistros;
    // End of variables declaration//GEN-END:variables
}
