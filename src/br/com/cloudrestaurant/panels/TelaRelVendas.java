/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.panels;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.classes.Pedidos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Debug
 */
public class TelaRelVendas extends javax.swing.JPanel {
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    Pedidos pedido;
    
    int selecaoTipoVenda;
    int selecaoClientes;


    public TelaRelVendas() {
        initComponents();
        limpaCampos();
        fechaTextField();
        preencheDataHoraHoje();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoesData = new javax.swing.ButtonGroup();
        grupoBotoesTipoVenda = new javax.swing.ButtonGroup();
        grupoBotoesClientes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        panelData = new javax.swing.JPanel();
        labelData = new javax.swing.JLabel();
        radioDataHoje = new javax.swing.JRadioButton();
        radioOutraData = new javax.swing.JRadioButton();
        textOutraData = new javax.swing.JTextField();
        panelTipoVenda = new javax.swing.JPanel();
        labelTipoVenda = new javax.swing.JLabel();
        radioVendaDireta = new javax.swing.JRadioButton();
        radioVendaEntrega = new javax.swing.JRadioButton();
        radioTodos = new javax.swing.JRadioButton();
        panelBotoes = new javax.swing.JPanel();
        btFechar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btVisualizar = new javax.swing.JButton();
        panelClientes = new javax.swing.JPanel();
        labelSelClientes = new javax.swing.JLabel();
        radioTodosClientes = new javax.swing.JRadioButton();
        radioEspecifico = new javax.swing.JRadioButton();
        textTelefone = new javax.swing.JTextField();
        textNome = new javax.swing.JTextField();
        labelOu = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTitulo.setText("Selecione o tipo de relatório:");

        panelData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelData.setText("Data do movimento:");

        grupoBotoesData.add(radioDataHoje);
        radioDataHoje.setSelected(true);
        radioDataHoje.setText("Hoje");
        radioDataHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDataHojeActionPerformed(evt);
            }
        });

        grupoBotoesData.add(radioOutraData);
        radioOutraData.setText("Outra data");
        radioOutraData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioOutraDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDataLayout = new javax.swing.GroupLayout(panelData);
        panelData.setLayout(panelDataLayout);
        panelDataLayout.setHorizontalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelData)
                .addGap(18, 18, 18)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDataLayout.createSequentialGroup()
                        .addComponent(radioOutraData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textOutraData, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(radioDataHoje))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDataLayout.setVerticalGroup(
            panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelData)
                    .addComponent(radioDataHoje))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioOutraData)
                    .addComponent(textOutraData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelTipoVenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTipoVenda.setText("Tipo de Venda:");

        grupoBotoesTipoVenda.add(radioVendaDireta);
        radioVendaDireta.setSelected(true);
        radioVendaDireta.setText("Venda Direta");
        radioVendaDireta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioVendaDiretaActionPerformed(evt);
            }
        });

        grupoBotoesTipoVenda.add(radioVendaEntrega);
        radioVendaEntrega.setText("Pedido - Entrega");
        radioVendaEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioVendaEntregaActionPerformed(evt);
            }
        });

        grupoBotoesTipoVenda.add(radioTodos);
        radioTodos.setText("Todos");
        radioTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTipoVendaLayout = new javax.swing.GroupLayout(panelTipoVenda);
        panelTipoVenda.setLayout(panelTipoVendaLayout);
        panelTipoVendaLayout.setHorizontalGroup(
            panelTipoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTipoVenda)
                .addGap(44, 44, 44)
                .addGroup(panelTipoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioTodos)
                    .addComponent(radioVendaEntrega)
                    .addComponent(radioVendaDireta))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        panelTipoVendaLayout.setVerticalGroup(
            panelTipoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipoVendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTipoVendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoVenda)
                    .addComponent(radioVendaDireta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioVendaEntrega)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioTodos)
                .addContainerGap(14, Short.MAX_VALUE))
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

        btVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/icone_imprimir.png"))); // NOI18N
        btVisualizar.setText("Visualizar");
        btVisualizar.setToolTipText("Visualizar");
        btVisualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btVisualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVisualizarActionPerformed(evt);
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
                    .addComponent(btVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btVisualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelClientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelSelClientes.setText("Informe o cliente:");

        grupoBotoesClientes.add(radioTodosClientes);
        radioTodosClientes.setSelected(true);
        radioTodosClientes.setText("Todos os clientes");
        radioTodosClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTodosClientesActionPerformed(evt);
            }
        });

        grupoBotoesClientes.add(radioEspecifico);
        radioEspecifico.setText("Cliente específico");
        radioEspecifico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEspecificoActionPerformed(evt);
            }
        });

        textTelefone.setText("Telefone");
        textTelefone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textTelefoneMouseClicked(evt);
            }
        });

        textNome.setText("Nome");
        textNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textNomeMouseClicked(evt);
            }
        });

        labelOu.setText("OU");

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textTelefone)
                    .addComponent(labelSelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioEspecifico)
                            .addComponent(radioTodosClientes)))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelOu)
                        .addGap(6, 6, 6)
                        .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSelClientes)
                    .addComponent(radioTodosClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioEspecifico)
                .addGap(18, 18, 18)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTipoVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelTipoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void fechar(){
        this.setVisible(false);
    }
    
    public void preencheDataHoraHoje(){
        Date dataHoje = new Date(System.currentTimeMillis());
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String formatoDataPadrao = formatoData.format(dataHoje);
        
//        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
//        String formatoHoraPadrao = formatoHora.format(dataHoje);
        
//        labelData.setText(String.valueOf(formatoDataPadrao));        
        textOutraData.setText(String.valueOf(formatoDataPadrao));        
    }
    
    public void fechaTextField(){
//        textOutraData.setVisible(false);
        panelClientes.setVisible(false);
//        textNome.setVisible(false);
//        textTelefone.setVisible(false);
//        labelOu.setVisible(false);
    }
    
    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.fechar();

        // TODO add your handling code here:
    }//GEN-LAST:event_btFecharActionPerformed

    public void limpaCampos(){
        radioDataHoje.setSelected(true);
        textOutraData.setText("");
        textNome.setText("");
        textTelefone.setText("");
        radioVendaDireta.setSelected(true);
        radioTodosClientes.setSelected(true);
        textOutraData.setEnabled(false);
    }
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        limpaCampos();
        
// TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVisualizarActionPerformed
        String tipoVenda = null;
        
        if(radioVendaDireta.isSelected()){
            tipoVenda = "Venda Direta";
        }else if(radioVendaEntrega.isSelected()){
            tipoVenda = "Pedido - Entrega";
        }else if(radioTodos.isSelected()){
            tipoVenda = "Todos";
        }
        
        pedido = new Pedidos();
        
        try {
            
            HashMap parametro = new HashMap();
            parametro.put("tipoVenda", tipoVenda);
            parametro.put("dataMovimento", textOutraData.getText());
            parametro.put("cliente", "Michel Pereira");

            String arquivo = null;
            arquivo = System.getProperty("user.dir") + "\\src\\br\\com\\scpe\\relatorios\\reportVendas.jasper";

            String sql = pedido.consultaRelatorio(textOutraData.getText(), 2, 1);
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            JRResultSetDataSource data = new JRResultSetDataSource( rs );
            
//            while(rs.next()){
//                int codRegistro = rs.getInt("codRegistro");
//                String item = rs.getString("item");
//                int quantidade = rs.getInt("quantidade");
//                double valorQuantidade = rs.getDouble("valorQuantidade");
//                double valorTotal = rs.getDouble("valorTotal");
//                
//                
//                
//            }

            JasperPrint jp = JasperFillManager.fillReport(arquivo, parametro, data);
            JasperViewer view = new JasperViewer(jp, false);
            view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            view.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            view.setVisible(true);

            }catch(JRException | SQLException | IOException ex){
                JOptionPane.showMessageDialog(null, "Houve um problema. Erro: " + ex.getMessage());
            }        
        //Preparar código para impressão. Chamada na classe método.
        
    }//GEN-LAST:event_btVisualizarActionPerformed

    private void radioOutraDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioOutraDataActionPerformed
        textOutraData.setEnabled(true);
        textOutraData.setText("");
        textOutraData.requestFocus();
        
// TODO add your handling code here:
    }//GEN-LAST:event_radioOutraDataActionPerformed

    private void textTelefoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textTelefoneMouseClicked
        textTelefone.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefoneMouseClicked

    private void textNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNomeMouseClicked
        textNome.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeMouseClicked

    private void radioDataHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDataHojeActionPerformed
        textOutraData.setEnabled(false);
        preencheDataHoraHoje();
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDataHojeActionPerformed

    private void radioTodosClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTodosClientesActionPerformed
        textNome.setText("");
        textTelefone.setText("");
        textNome.setVisible(false);
        textTelefone.setVisible(false);
        labelOu.setVisible(false);
        
// TODO add your handling code here:
    }//GEN-LAST:event_radioTodosClientesActionPerformed

    private void radioVendaEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioVendaEntregaActionPerformed
        panelClientes.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_radioVendaEntregaActionPerformed

    private void radioEspecificoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEspecificoActionPerformed
        textNome.setVisible(true);
        textTelefone.setVisible(true);
        labelOu.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_radioEspecificoActionPerformed

    private void radioTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTodosActionPerformed
        panelClientes.setVisible(false);
        
// TODO add your handling code here:
    }//GEN-LAST:event_radioTodosActionPerformed

    private void radioVendaDiretaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioVendaDiretaActionPerformed
        panelClientes.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_radioVendaDiretaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btVisualizar;
    private javax.swing.ButtonGroup grupoBotoesClientes;
    private javax.swing.ButtonGroup grupoBotoesData;
    private javax.swing.ButtonGroup grupoBotoesTipoVenda;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelOu;
    private javax.swing.JLabel labelSelClientes;
    private javax.swing.JLabel labelTipoVenda;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelData;
    private javax.swing.JPanel panelTipoVenda;
    private javax.swing.JRadioButton radioDataHoje;
    private javax.swing.JRadioButton radioEspecifico;
    private javax.swing.JRadioButton radioOutraData;
    private javax.swing.JRadioButton radioTodos;
    private javax.swing.JRadioButton radioTodosClientes;
    private javax.swing.JRadioButton radioVendaDireta;
    private javax.swing.JRadioButton radioVendaEntrega;
    private javax.swing.JTextField textNome;
    private javax.swing.JTextField textOutraData;
    private javax.swing.JTextField textTelefone;
    // End of variables declaration//GEN-END:variables
}
