/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.panels;

import br.com.cloudrestaurant.classes.TipoVenda;
import br.com.cloudrestaurant.constante.Constantes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import CloudRestaurant.Conexao;


/**
 *
 * @author Debug
 */
public class TipoVendaPanel extends javax.swing.JPanel {
    Conexao con;
    Constantes constante;
    TipoVenda indicador;
    int selecao = 1;


    public TipoVendaPanel() {
        indicador = new TipoVenda();
        initComponents();
//        preencheSemanas();
        preencheLabels();
        bloqueiaBotoes();
        preencheTabelaIndicador(indicador.consultaTipoVenda());
        preencheDatas();
        ocultaCampos();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotao = new javax.swing.ButtonGroup();
        panelPrincipal = new javax.swing.JPanel();
        panelBotoes = new javax.swing.JPanel();
        btIncluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        labelBusca = new javax.swing.JLabel();
        textBusca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaIndicador = new javax.swing.JTable();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        labelNatureza = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textNatureza = new javax.swing.JTextArea();
        textData = new javax.swing.JTextField();
        labelMensagem = new javax.swing.JLabel();
        textIdIndicador = new javax.swing.JTextField();
        textDataAlteracao = new javax.swing.JTextField();
        labelData = new javax.swing.JLabel();
        labelDataAlteracao = new javax.swing.JLabel();
        textDataHoje = new javax.swing.JTextField();

        panelPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        panelBotoes.setBackground(new java.awt.Color(153, 153, 255));
        panelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btAdicionar.png"))); // NOI18N
        btIncluir.setText("Adicionar");
        btIncluir.setToolTipText("Salvar os dados");
        btIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btAlterarCloud.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setToolTipText("Alterar os dados");
        btAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btExcluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Excluir os dados");
        btExcluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotoesLayout.createSequentialGroup()
                        .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labelBusca.setText("jLabel1");

        textBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textBuscaActionPerformed(evt);
            }
        });

        tabelaIndicador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaIndicador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaIndicadorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaIndicador);

        labelNome.setText("Nome do Indicador: ");

        textNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textNomeKeyPressed(evt);
            }
        });

        labelNatureza.setText("jLabel1");

        textNatureza.setColumns(20);
        textNatureza.setRows(5);
        jScrollPane2.setViewportView(textNatureza);

        labelMensagem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelMensagem.setForeground(new java.awt.Color(255, 0, 0));
        labelMensagem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelMensagem.setText("jLabel1");

        labelData.setText("Data de Cadastro");

        labelDataAlteracao.setText("jLabel1");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(labelBusca)
                        .addGap(18, 18, 18)
                        .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addComponent(labelNatureza)
                                        .addGap(81, 81, 81))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPrincipalLayout.createSequentialGroup()
                                        .addComponent(labelNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                                        .addComponent(textIdIndicador, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(textDataHoje, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDataAlteracao)
                                    .addComponent(labelData))
                                .addGap(18, 18, 18)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textData, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                                    .addComponent(textDataAlteracao))))))
                .addGap(18, 18, 18)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBusca)
                            .addComponent(textBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(167, 167, 167)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelData)
                                    .addComponent(textData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textDataAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelDataAlteracao)
                                    .addComponent(textIdIndicador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textDataHoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelNome)
                                .addGap(21, 21, 21)
                                .addComponent(labelNatureza)))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelMensagem)
                        .addGap(43, 43, 43)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.fechar();

    }//GEN-LAST:event_btFecharActionPerformed

    
    public void ocultaCampos(){
        textIdIndicador.setVisible(false);
        textDataHoje.setVisible(false);
    }
    
    public void validaTexto(JTextField numero, java.awt.event.KeyEvent evt){
//        int k = evt.getKeyChar();  
//        if (textValor.getText().length() <= k - 1) {  
//                         //deixe passar  
//        } else {  
//            evt.setKeyChar((char) evt.VK_CLEAR);  
//        }  
    }
    
//    @SuppressWarnings("empty-statement")
    public void validaNumero(JTextField numero){
        double valor;
        if(numero.getText().length() != 0){
            try{
                valor = Double.parseDouble(numero.getText());
            }catch(NumberFormatException ex){

            }
        }
        
    }
    
    public Boolean verificaCampos(){
        if (textNome.getText().equals("")){
            labelMensagem.setText("Não é permitido campo(s) vazio(s)");
            textNome.requestFocus();
            return false;
        }
//        else if (textValor.getText().equals("")){
//            labelMensagem.setText("Não é permitido campo(s) vazio(s)");
//            textValor.requestFocus();
//            return false;
//        }
        else if (textNatureza.getText().equals("")){
            labelMensagem.setText("Não é permitido campo(s) vazio(s)");
            textNatureza.requestFocus();
            return false;
        }
        return true;
        
    }
    
    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed

       
    //    if(verificaCampos()){
            indicador = new TipoVenda();
            
//            int selecionado = consultaIdSemana(comboSemana.getSelectedItem()); //consultaIdSemana(comboSemana.getSelectedIndex());
            
//            String valorSemPonto = textValor.getText().replaceAll(",", ".");
            
//            JOptionPane.showMessageDialog(null, valorSemPonto);
//            indicador.setDataInclusao(Date.valueOf("2015-03-18"));
//            indicador.setDataAlteracao(Date.valueOf("2015-03-18"));
//            indicador.setValor(Double.parseDouble(textValor.getText()));
            
            indicador.setNome(textNome.getText());
//            indicador.setValor(Double.parseDouble(valorSemPonto));
            indicador.setNatureza(textNatureza.getText());
//            indicador.setCodSemana(selecionado);
            indicador.setDataInclusao(Date.valueOf(textDataHoje.getText()));
            indicador.setDataAlteracao(Date.valueOf(textDataHoje.getText()));
            
            indicador.cadastraTipoVenda();
            limpaCampos();
            preencheTabelaIndicador(indicador.consultaTipoVenda());

    //    }

// TODO add your handling code here:
    }//GEN-LAST:event_btIncluirActionPerformed

    public void preencheCodSemana(){
        
//        int idSemana = consultaIdSemana(textDiaSemana.getText());
//        textCodSemana.setText(String.valueOf(idSemana));        
    }
    
    private void tabelaIndicadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaIndicadorMouseClicked
        int linhaSelecionada = tabelaIndicador.getSelectedRow();
        
        this.btIncluir.setEnabled(false);
        this.btAlterar.setEnabled(true);
        this.btExcluir.setEnabled(true);
        
//        textIdIndicador.setText(tabelaIndicador.getValueAt(linhaSelecionada, 0).toString());
//        textNome.setText(tabelaIndicador.getValueAt(linhaSelecionada, 1).toString());
        
        resultadoBuscaIndicador(tabelaIndicador.getValueAt(linhaSelecionada, 0).toString());

    }//GEN-LAST:event_tabelaIndicadorMouseClicked

    public void resultadoBuscaIndicador(String nome){

        try{

        indicador = new TipoVenda();
        String sql = indicador.buscaIdentificador(nome);
            
        con = new Conexao();
        Connection conn = con.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        
        textNome.setText(rs.getString("nomeTipoVenda"));
//        textValor.setText(rs.getString("valorTributo"));
        textNatureza.setText(rs.getString("natureza"));
        textIdIndicador.setText(rs.getString("idTipoVenda"));
//        textDiaSemana.setText(rs.getString("semana"));
//        textCodSemana.setText(String.valueOf(rs.getInt("codSemana")));
        textData.setText(rs.getString("dataIncFormat"));
        textDataAlteracao.setText(rs.getString("dataAlterFormat"));
        
        
        }catch(IOException | SQLException ex){
            labelMensagem.setVisible(true);
            labelMensagem.setText("Problemas na consulta. Erro: " + ex.getMessage());
        }
        
    }
    
    public void preencheDatas(){
        Date data = new Date(System.currentTimeMillis());
        textDataHoje.setText(String.valueOf(data));
        
        SimpleDateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
        String novaData = formatado.format(data);
        textData.setText(novaData);
        textDataAlteracao.setText(novaData);
        textData.setEnabled(false);
        textDataAlteracao.setEnabled(false);
        
        /*
        switch (data.getDay()){
            case 1 : labelData.setText("Domingo");
                break;
            case 2 : labelData.setText("Segunda-feira");
                break;
            case 3 : labelData.setText("Terça-feira");
                break;
            case 4 : labelData.setText("Quarta-feira");
                break;
            case 5 : labelData.setText("Quinta-feira");
                break;
            case 6 : labelData.setText("Sexta-feira");
                break;
            case 7 : labelData.setText("Sábado");
                break;
        }
        
        */
    }
    
    private void textBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textBuscaActionPerformed

        indicador = new TipoVenda();
        
        if (textBusca.getText().equals("")){

            preencheTabelaIndicador(indicador.consultaTipoVenda());
            
        }else{
            if (selecao == 1){ // pesquisa por nome
                preencheTabelaIndicador(indicador.consultaTipoVenda()+ " WHERE i.nomeIndicador = '" + textBusca.getText() + "'");
            }else if (selecao == 2){ // pesquisa por valor
                preencheTabelaIndicador(indicador.consultaTipoVenda()+ " WHERE i.valorTributo = '" + textBusca.getText() + "'");
                
            }else if (selecao == 3){ // pesquisa por semana
                preencheTabelaIndicador(indicador.consultaTipoVenda()+ " "
                        + " INNER JOIN semana s ON i.codSemana = s.codigoSemana"
                        + " WHERE semana = '" + textBusca.getText() + "'");
            }
            
        }        

// TODO add your handling code here:
    }//GEN-LAST:event_textBuscaActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

            if (verificaCampos()){
            indicador = new TipoVenda();
            
//            String valorSemPonto = textValor.getText().replaceAll(",", ".");

            indicador.setIdIndicador(Integer.parseInt(textIdIndicador.getText()));
            indicador.setNome(textNome.getText());
//            indicador.setValor(Double.parseDouble(valorSemPonto));
            indicador.setNatureza(textNatureza.getText());
//            JOptionPane.showMessageDialog(null, textDataHoje.getText());
            indicador.setDataAlteracao(Date.valueOf(textDataHoje.getText()));
//            indicador.setCodSemana(Integer.parseInt(textCodSemana.getText()));//Parou aqui.
            
            indicador.alteraTipoVenda();
            limpaCampos();
            preencheTabelaIndicador(indicador.consultaTipoVenda());

            }

        
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        indicador = new TipoVenda();
        
        indicador.setIdIndicador(Integer.parseInt(textIdIndicador.getText()));
        indicador.excluiTipoVenda();
        limpaCampos();
        
        preencheTabelaIndicador(indicador.consultaTipoVenda());

// TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed

        textBusca.setText("");
        limpaCampos();
        btIncluir.setEnabled(true);
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
        textNome.requestFocus();
        preencheTabelaIndicador(indicador.consultaTipoVenda());
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void textNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNomeKeyPressed
        primeiraLetraMaiuscula(textNome.getText());
    }//GEN-LAST:event_textNomeKeyPressed

    public String primeiraLetraMaiuscula(String letra){
//        return letra.getText().substring(0,1).toUpperCase() + letra.getText().substring(1);
        letra = letra.substring(0,1).toUpperCase().concat(letra.substring(1));
        return letra;
    }
    
    public void limpaCampos(){
        textNome.setText("");
        textNatureza.setText("");
        preencheDatas();
        textIdIndicador.setText("");
        textNome.requestFocus();
    }
    public int consultaIdSemana(Object semana){
        try{
            String sql = "SELECT * FROM semana WHERE semana = '" + semana + "'";
            
        Connection conn = con.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
            int resultado = rs.getInt("codigoSemana");
            return resultado;

        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas pela localização da semana.", "ERRO", constante.ERROR);
            return 0;
        }
        
    }
    
//    public void preencheSemanas(){
//        constante = new Constantes();
//        try{
//        con = new Conexao();
//            
//        String sql = "SELECT * FROM semana";
//        String consultaUltimoId = "SELECT COUNT(idSemana) FROM semana";
//            
//        Connection conn = con.getConnection();
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//
//        Connection conn2 = con.getConnection();
//        Statement stmt2 = conn2.createStatement();
//        ResultSet rs2 = stmt2.executeQuery(consultaUltimoId);
            
//            if (rs2.absolute(1)){
//                while(rs.next()){
//                    String dados = rs.getString("semana");
//                    comboSemana.addItem(dados);
//                }
//            }else{
//                comboSemana.addItem("Não possui conteúdo no banco");
//            }
        
        
//        }catch(IOException | SQLException ex){
//            JOptionPane.showMessageDialog(null, "Houve um problema na consulta. Erro: " + ex.getMessage(), "ATENÇÃO", constante.ERROR);
//        }        
//    }
    
    public void fechar(){
        this.setVisible(false);
    }
    
    public void preencheLabels(){ // Preenche os labels no jpanel
        labelBusca.setText("Pesquisa: ");
        labelNome.setText("Nome do Tipo de Venda: ");
//        labelValor.setText("Valor: ");
        labelNatureza.setText("Natureza do Tipo de Venda: ");
//        labelSemana.setText("Semana: ");
        labelMensagem.setText("");
        labelData.setText("Data de Cadastro: ");
        labelDataAlteracao.setText("Última alteração: ");
//        radioNome.setText("Por Nome");
//        radioValor.setText("Por Valor");
//        radioSemana.setText("Por Semana");
    }
    
    public void bloqueiaBotoes(){ // bloqueia os botões alterar e excluir
        btAlterar.setEnabled(false);
        btExcluir.setEnabled(false);
    }
    
    public void preencheTabelaIndicador(String sql){
        ArrayList dados = new ArrayList();
        String[] nomeColunas = new String[]{"TIPO DE VENDA", "NATUREZA"};
        
        try{
            con = new Conexao();
            Connection conn = con.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.first();
            do{
                dados.add(new Object[]{rs.getString("nomeTipoVenda"), rs.getString("natureza")});
            }while(rs.next());
            
        ModeloTabela modelo = new ModeloTabela(dados, nomeColunas);
        tabelaIndicador.setModel(modelo);
        tabelaIndicador.getColumnModel().getColumn(0).setPreferredWidth(180); // define o tamanho da coluna.
        tabelaIndicador.getColumnModel().getColumn(0).setResizable(false);// Não poderá alterar o tamanho.
        tabelaIndicador.getColumnModel().getColumn(1).setPreferredWidth(300); // define o tamanho da coluna.
        tabelaIndicador.getColumnModel().getColumn(1).setResizable(false);// Não poderá alterar o tamanho.
        
        tabelaIndicador.getTableHeader().setReorderingAllowed(false);
        tabelaIndicador.setAutoResizeMode(tabelaIndicador.AUTO_RESIZE_OFF);
        
        tabelaIndicador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
        }catch(IOException | SQLException ex){
//                JOptionPane.showMessageDialog(null, "Não há registro na tabela. Inclua um novo!", "Registro vazio", 0);
            labelMensagem.setText("Não há registro na tabela. Inclua um novo.");

        }
        
        
    }

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btIncluir;
    private javax.swing.ButtonGroup grupoBotao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBusca;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDataAlteracao;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JLabel labelNatureza;
    private javax.swing.JLabel labelNome;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tabelaIndicador;
    private javax.swing.JTextField textBusca;
    private javax.swing.JTextField textData;
    private javax.swing.JTextField textDataAlteracao;
    private javax.swing.JTextField textDataHoje;
    private javax.swing.JTextField textIdIndicador;
    private javax.swing.JTextArea textNatureza;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables


}
