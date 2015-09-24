/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.panels;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.classes.Cargos;
import br.com.cloudrestaurant.constante.Constantes;
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
public class CargosPanel extends javax.swing.JPanel {
    
    Cargos cargo;
    int selecao = 1;

    /**
     * Creates new form CargosPanel
     */
    public CargosPanel() {
        cargo = new Cargos();
        initComponents();
        bloqueiaBotoes();
        preencheLabels();
        preencheTabelaCargos(cargo.consultaCargo());
    }

    public void bloqueiaBotoes(){
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }
    
    public void preencheLabels(){
        labelCodCargo.setText("Código do cargo: ");
        labelNomeCargo.setText("Nome do cargo: ");
        labelPesquisa.setText("Busca: ");
        radioPorCodigo.setText("Por código");
        radioPorNome.setText("Por nome");
        labelMensagem.setVisible(false);
        textIdCargo.setVisible(false);
        textCodCargo.setVisible(false);
        labelCodCargo.setVisible(false);
        radioPorNome.setVisible(false);
        radioPorCodigo.setVisible(false);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        panelBotoes = new javax.swing.JPanel();
        btIncluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        panelCampos = new javax.swing.JPanel();
        labelNomeCargo = new javax.swing.JLabel();
        labelCodCargo = new javax.swing.JLabel();
        textNomeCargo = new javax.swing.JTextField();
        textCodCargo = new javax.swing.JTextField();
        labelPesquisa = new javax.swing.JLabel();
        textPesquisa = new javax.swing.JTextField();
        radioPorNome = new javax.swing.JRadioButton();
        radioPorCodigo = new javax.swing.JRadioButton();
        textIdCargo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCargos = new javax.swing.JTable();
        labelMensagem = new javax.swing.JLabel();

        panelBotoes.setBackground(new java.awt.Color(153, 153, 255));
        panelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btSalvar.png"))); // NOI18N
        btIncluir.setText("Salvar");
        btIncluir.setToolTipText("Salvar o Cargo");
        btIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btAlterarCloud.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setToolTipText("Alterar");
        btAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btExcluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Excluir");
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btExcluir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btExcluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btSairCloud.png"))); // NOI18N
        btFechar.setText("Sair");
        btFechar.setToolTipText("Sair da tela");
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
        btCancelar.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btCancelar.setMaximumSize(new java.awt.Dimension(55, 35));
        btCancelar.setMinimumSize(new java.awt.Dimension(55, 35));
        btCancelar.setPreferredSize(new java.awt.Dimension(55, 35));
        btCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelNomeCargo.setText("Nome do Cargo: ");

        labelCodCargo.setText("Código do Cargo: ");

        labelPesquisa.setText("Busca: ");

        textPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPesquisaActionPerformed(evt);
            }
        });

        grupoRadio.add(radioPorNome);
        radioPorNome.setSelected(true);
        radioPorNome.setText("jRadioButton1");
        radioPorNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPorNomeActionPerformed(evt);
            }
        });

        grupoRadio.add(radioPorCodigo);
        radioPorCodigo.setText("jRadioButton2");
        radioPorCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioPorCodigoActionPerformed(evt);
            }
        });

        tabelaCargos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaCargos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCargosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaCargos);

        labelMensagem.setForeground(new java.awt.Color(255, 0, 0));
        labelMensagem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelMensagem.setText("labelMensagem");

        javax.swing.GroupLayout panelCamposLayout = new javax.swing.GroupLayout(panelCampos);
        panelCampos.setLayout(panelCamposLayout);
        panelCamposLayout.setHorizontalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCamposLayout.createSequentialGroup()
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelNomeCargo)
                            .addComponent(labelCodCargo))
                        .addGap(18, 18, 18)
                        .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCamposLayout.createSequentialGroup()
                                .addComponent(textCodCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(textIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textNomeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCamposLayout.createSequentialGroup()
                            .addComponent(labelPesquisa)
                            .addGap(18, 18, 18)
                            .addComponent(textPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(radioPorNome)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(radioPorCodigo))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelCamposLayout.setVerticalGroup(
            panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPesquisa)
                    .addComponent(textPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioPorNome)
                    .addComponent(radioPorCodigo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNomeCargo)
                    .addComponent(textNomeCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodCargo)
                    .addComponent(textCodCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textIdCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed

        cargo = new Cargos();
        cargo.setNomeCargo(textNomeCargo.getText());
        cargo.setCodigoCargo(textCodCargo.getText());
        cargo.cadastraCargo();
        limpaCampos();
        preencheTabelaCargos(cargo.consultaCargo());

    }//GEN-LAST:event_btIncluirActionPerformed

    public void limpaCampos(){
        textPesquisa.setText("");
        textNomeCargo.setText("");
        textCodCargo.setText("");
        textIdCargo.setText("");
        textNomeCargo.requestFocus();
    }
    
    public Boolean verificaCampos(){
        if(textNomeCargo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Não é permitido campo vazio. Verifique o campo 'Nome'!", "ATENÇÃO", Constantes.ALERTA);
            labelMensagem.setVisible(true);
            labelMensagem.setText("Não é permitido campo vazio. Verifique o campo 'Nome'!");
            textNomeCargo.requestFocus();
            return false;
        }else{
            return true;
        }
    }
    
    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        
        if (verificaCampos()){
            cargo = new Cargos();
            cargo.setNomeCargo(textNomeCargo.getText());
            cargo.setIdCargo(Integer.parseInt(textIdCargo.getText()));
            cargo.alteraCargo();
            limpaCampos();
            preencheTabelaCargos(cargo.consultaCargo());
            bloqueiaBotoes();
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    public void preencheTabelaCargos(String sql){
        ArrayList dados = new ArrayList();
        String[] nomeColunas = new String[]{"NOME CARGO"};
        
        try{
            Conexao con = new Conexao();
            Connection conn = con.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.first();
            do{
                dados.add(new Object[]{rs.getString("nomeCargo")});
            }while(rs.next());
            
        ModeloTabela modelo = new ModeloTabela(dados, nomeColunas);
        tabelaCargos.setModel(modelo);
        tabelaCargos.getColumnModel().getColumn(0).setPreferredWidth(180); // define o tamanho da coluna.
        tabelaCargos.getColumnModel().getColumn(0).setResizable(false);// Não poderá alterar o tamanho.
        
        tabelaCargos.getTableHeader().setReorderingAllowed(false);
        tabelaCargos.setAutoResizeMode(tabelaCargos.AUTO_RESIZE_OFF);
        
        tabelaCargos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
        }catch(IOException | SQLException ex){
            //JOptionPane.showMessageDialog(null, "Problmeas. Erro: " + ex.getMessage());
            labelMensagem.setVisible(true);
            labelMensagem.setText("Não há registro na tabela. Inclua um novo.");
        }
    }
    
    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        cargo = new Cargos();
        cargo.setIdCargo(Integer.parseInt(textIdCargo.getText()));
        cargo.excluiCargo();
        limpaCampos();
        preencheTabelaCargos(cargo.consultaCargo());
        bloqueiaBotoes();

        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.fechar();
    }//GEN-LAST:event_btFecharActionPerformed

    public void fechar(){
        this.setVisible(false);
    }
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        cargo = new Cargos();
        
        limpaCampos();
        btIncluir.setEnabled(true);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        preencheTabelaCargos(cargo.consultaCargo());
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void radioPorNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPorNomeActionPerformed
        selecao = 1;
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPorNomeActionPerformed

    private void radioPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioPorCodigoActionPerformed
        selecao = 2;
        // TODO add your handling code here:
    }//GEN-LAST:event_radioPorCodigoActionPerformed

    private void textPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPesquisaActionPerformed
        labelMensagem.setVisible(false);
        cargo = new Cargos();
        
        if (selecao == 1){ // Por nome
            String sql = cargo.consultaCargo() + " WHERE nomeCargo LIKE '%" + textPesquisa.getText() + "%'";
            preencheTabelaCargos(sql);
        }else if (selecao == 2){ // Por código
            String sql = cargo.consultaCargo() + " WHERE codigoCargo LIKE '%" + textPesquisa.getText() + "%'";
            preencheTabelaCargos(sql);
        }else{
            preencheTabelaCargos(cargo.consultaCargo());
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_textPesquisaActionPerformed

    private void tabelaCargosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCargosMouseClicked
        
        cargo = new Cargos();
        
        btAlterar.setEnabled(true);
        btExcluir.setEnabled(true);
        
        int selecionado = tabelaCargos.getSelectedRow();
        
        textNomeCargo.setText(tabelaCargos.getValueAt(selecionado, 0).toString());
//        textCodCargo.setText(tabelaCargos.getValueAt(selecionado, 1).toString());

        int pegaCodigo = cargo.consultaCargoNome(textNomeCargo.getText());
        
        textIdCargo.setText(String.valueOf(pegaCodigo));
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_tabelaCargosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btIncluir;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodCargo;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JLabel labelNomeCargo;
    private javax.swing.JLabel labelPesquisa;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCampos;
    private javax.swing.JRadioButton radioPorCodigo;
    private javax.swing.JRadioButton radioPorNome;
    private javax.swing.JTable tabelaCargos;
    private javax.swing.JTextField textCodCargo;
    private javax.swing.JTextField textIdCargo;
    private javax.swing.JTextField textNomeCargo;
    private javax.swing.JTextField textPesquisa;
    // End of variables declaration//GEN-END:variables
}
