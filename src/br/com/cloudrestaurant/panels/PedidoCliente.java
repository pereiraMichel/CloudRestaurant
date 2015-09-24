/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.panels;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.classes.Clientes;
import br.com.cloudrestaurant.classes.Itens;
import br.com.cloudrestaurant.classes.Pedidos;
import br.com.cloudrestaurant.classes.Status;
import br.com.cloudrestaurant.classes.TipoVenda;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.utilidades.Metodos;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Debug
 */
public final class PedidoCliente extends javax.swing.JPanel {
    
    Metodos metodo = new Metodos();
    
    String nomeClienteSelecionado;
    int idClienteSelecionado;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    Constantes constante;
    TipoVenda tipoVenda;
    Status status;
    Itens item;
    Pedidos pedido;
    
    int estado = 18; //Código estado RJ.
    Boolean procede = true;

    public PedidoCliente() {
        initComponents();
        preencheComboItem();
        preencheLabels();
        bloqueiaBotoes();
        margemTabelaItens();
        preencheDataHora();
        preencheComboIndicador();
        preencheComboStatus();
        preencheTableItens();
    }
//    public PedidoCliente(String nomeClienteNovo) {
//        textNomeCliente.setText(nomeClienteNovo); // Não preenche
//        this.add(textNomeCliente);
//        this.setVisible(true);
//    }
    
    public void preencheDataHora(){
        Date dataHoje = new Date(System.currentTimeMillis());
        
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        
        SimpleDateFormat formatoSql = new SimpleDateFormat("yyyy-MM-dd");
        
        String dataFormatada = formatoData.format(dataHoje);
        String horaFormatada = formatoHora.format(dataHoje);
        
        String formatoInsereSql = formatoSql.format(dataHoje);
        
        textDataPedido.setText(String.valueOf(dataFormatada));
        textHoraPedido.setText(String.valueOf(horaFormatada));
        textDataPedidoSql.setText(String.valueOf(formatoInsereSql));
    }

    public void preencheLabels(){
        pedido = new Pedidos();
        labelData.setText("Data Registro: ");
        labelHora.setText("Hora Registro: ");
        labelItem.setText("Código do Item: ");
        labelStatus.setText("Status: ");
        labelTipoVenda.setText("Tipo Venda: ");
        labelValorTotal.setText("Valor Total: ");
        labelValor.setText("0,00");
        textDataPedido.setEnabled(false);
        textHoraPedido.setEnabled(false);
        textDataPedidoSql.setVisible(false);
        labelDesconto.setText("Desconto: ");
        labelAcrescimo.setText("Acréscimo: ");
        labelSubTotal.setText("Sub-Total: ");
        textDesconto.setText("0.00");
        textAcrescimo.setText("0.00");
        textEntrega.setText("0.00");
        textCodPedido.setText(String.valueOf(pedido.calculaCodPedido()));
        textCodPedido.setEnabled(false);
        panelClientes.setVisible(false);
        textIdPedido.setVisible(false);
        textIdCliente.setVisible(false);
        labelItemSelecionado.setVisible(false);
//        labelNomeCliente.setText("Nome do cliente");
        
    }
    
    public void limpaCampos(){
        item = new Itens();
        textDesconto.setText("0.00");
        textAcrescimo.setText("0.00");
        labelValor.setText("0.00");
        preencheComboItem();
        item.limpaTabela(tabelaItens);
    }
    
    public void bloqueiaBotoes(){
        metodo.botaoInvisivel(btSelecionaCliente);
        metodo.ativaBotao(btIncluir);
        metodo.bloqueiaBotao(btMenos);
//        textIdCliente.setVisible(false);
//        textIdPedido.setVisible(false);
        metodo.bloqueiaBotao(btAtualizar);
        comboItem.setVisible(false);
    }

    public void preencheTableItens(){
        item = new Itens();
        
        item.preencheTabela(tabelaItensBanco);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        panelPedidos = new javax.swing.JPanel();
        labelData = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItens = new javax.swing.JTable();
        textDataPedido = new javax.swing.JTextField();
        textHoraPedido = new javax.swing.JTextField();
        btMais = new javax.swing.JButton();
        btMenos = new javax.swing.JButton();
        panelItens = new javax.swing.JPanel();
        labelItem = new javax.swing.JLabel();
        comboItem = new javax.swing.JComboBox();
        labelQuantidade = new javax.swing.JLabel();
        textQuantidade = new javax.swing.JTextField();
        labelStatus = new javax.swing.JLabel();
        comboStatus = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaItensBanco = new javax.swing.JTable();
        textCodItem = new javax.swing.JTextField();
        labelItemSelecionado = new javax.swing.JLabel();
        textIdCliente = new javax.swing.JTextField();
        textIdPedido = new javax.swing.JTextField();
        textDataPedidoSql = new javax.swing.JTextField();
        labelDesconto = new javax.swing.JLabel();
        labelAcrescimo = new javax.swing.JLabel();
        textDesconto = new javax.swing.JTextField();
        textAcrescimo = new javax.swing.JTextField();
        btAtualizar = new javax.swing.JButton();
        labelEntrega = new javax.swing.JLabel();
        textEntrega = new javax.swing.JTextField();
        panelConta = new javax.swing.JPanel();
        labelSubTotal = new javax.swing.JLabel();
        textTotalAdicionais = new javax.swing.JTextField();
        labelValorTotal = new javax.swing.JLabel();
        labelValor = new javax.swing.JLabel();
        btDesbloqueio = new javax.swing.JButton();
        labelCodPedido = new javax.swing.JLabel();
        textCodPedido = new javax.swing.JTextField();
        btSelecionaCliente = new javax.swing.JButton();
        labelTipoVenda = new javax.swing.JLabel();
        comboTipoVenda = new javax.swing.JComboBox();
        panelBotoes = new javax.swing.JPanel();
        btFechar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btIncluir = new javax.swing.JButton();
        panelClientes = new javax.swing.JPanel();
        labelNomeCliente = new javax.swing.JLabel();
        textNomeCliente = new javax.swing.JTextField();
        labelTelefone = new javax.swing.JLabel();
        textTelefone = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        textReferencia = new javax.swing.JTextArea();
        labelReferencia = new javax.swing.JLabel();
        textEndereco = new javax.swing.JTextField();
        textNumero = new javax.swing.JTextField();
        textComplemento = new javax.swing.JTextField();
        textBairro = new javax.swing.JTextField();

        panelPedidos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelData.setText("jLabel1");

        labelHora.setText("jLabel1");

        tabelaItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓD ITEM", "ITEM", "VALOR", "QUANTIDADE", "VALOR TOTAL", "STATUS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaItens);

        btMais.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/mais.gif"))); // NOI18N
        btMais.setToolTipText("Adiciona");
        btMais.setMaximumSize(new java.awt.Dimension(47, 21));
        btMais.setMinimumSize(new java.awt.Dimension(47, 21));
        btMais.setPreferredSize(new java.awt.Dimension(47, 21));
        btMais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMaisActionPerformed(evt);
            }
        });

        btMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/menos_1.png"))); // NOI18N
        btMenos.setToolTipText("Retira");
        btMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMenosActionPerformed(evt);
            }
        });

        panelItens.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelItem.setText("jLabel1");

        comboItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboItemActionPerformed(evt);
            }
        });

        labelQuantidade.setText("Quantidade: ");

        textQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textQuantidadeActionPerformed(evt);
            }
        });
        textQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textQuantidadeKeyTyped(evt);
            }
        });

        labelStatus.setText("jLabel1");

        comboStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboStatusActionPerformed(evt);
            }
        });

        tabelaItensBanco.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓD ITEM", "NOME"
            }
        ));
        jScrollPane3.setViewportView(tabelaItensBanco);
        if (tabelaItensBanco.getColumnModel().getColumnCount() > 0) {
            tabelaItensBanco.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabelaItensBanco.getColumnModel().getColumn(0).setMaxWidth(100);
            tabelaItensBanco.getColumnModel().getColumn(1).setPreferredWidth(250);
            tabelaItensBanco.getColumnModel().getColumn(1).setMaxWidth(250);
        }

        textCodItem.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textCodItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCodItemActionPerformed(evt);
            }
        });

        labelItemSelecionado.setText("jLabel1");

        javax.swing.GroupLayout panelItensLayout = new javax.swing.GroupLayout(panelItens);
        panelItens.setLayout(panelItensLayout);
        panelItensLayout.setHorizontalGroup(
            panelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelQuantidade)
                    .addComponent(labelItem))
                .addGap(18, 18, 18)
                .addGroup(panelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelItensLayout.createSequentialGroup()
                            .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(labelStatus)
                            .addGap(18, 18, 18)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelItensLayout.createSequentialGroup()
                        .addComponent(textCodItem, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelItemSelecionado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelItensLayout.setVerticalGroup(
            panelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelItensLayout.createSequentialGroup()
                        .addGroup(panelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelItem)
                            .addComponent(textCodItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelItemSelecionado))
                        .addGap(13, 13, 13)
                        .addGroup(panelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelQuantidade)
                            .addComponent(textQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelStatus)
                            .addComponent(comboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        textIdCliente.setToolTipText("ID CLIENTE");

        textIdPedido.setToolTipText("ID PEDIDO");

        labelDesconto.setText("jLabel1");

        labelAcrescimo.setText("Acrescimo: ");

        textDesconto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textDescontoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDescontoKeyTyped(evt);
            }
        });

        textAcrescimo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textAcrescimo.setToolTipText("Digite o valor do desconto");
        textAcrescimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textAcrescimoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAcrescimoKeyTyped(evt);
            }
        });

        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/atualizar16x16.png"))); // NOI18N
        btAtualizar.setToolTipText("Atualizar Desconto, Acréscimo e Entrega");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

        labelEntrega.setText("Entrega: ");

        textEntrega.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textEntrega.setToolTipText("Digite o valor da Entrega");
        textEntrega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textEntregaKeyReleased(evt);
            }
        });

        panelConta.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelSubTotal.setText("jLabel1");

        textTotalAdicionais.setEditable(false);
        textTotalAdicionais.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        labelValorTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValorTotal.setForeground(new java.awt.Color(102, 102, 255));
        labelValorTotal.setText("jLabel1");

        labelValor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelValor.setForeground(new java.awt.Color(102, 102, 255));
        labelValor.setText("jLabel1");

        javax.swing.GroupLayout panelContaLayout = new javax.swing.GroupLayout(panelConta);
        panelConta.setLayout(panelContaLayout);
        panelContaLayout.setHorizontalGroup(
            panelContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelContaLayout.createSequentialGroup()
                        .addComponent(labelSubTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addComponent(textTotalAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelContaLayout.createSequentialGroup()
                        .addComponent(labelValorTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelValor)))
                .addContainerGap())
        );
        panelContaLayout.setVerticalGroup(
            panelContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTotalAdicionais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSubTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValorTotal)
                    .addComponent(labelValor))
                .addGap(25, 25, 25))
        );

        btDesbloqueio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/icon-key1.png"))); // NOI18N
        btDesbloqueio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesbloqueioActionPerformed(evt);
            }
        });

        labelCodPedido.setText("Código do Registro:");

        textCodPedido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        textCodPedido.setForeground(new java.awt.Color(255, 0, 0));
        textCodPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btSelecionaCliente.setText("...");
        btSelecionaCliente.setToolTipText("Selecionar o cliente");
        btSelecionaCliente.setMaximumSize(new java.awt.Dimension(47, 21));
        btSelecionaCliente.setMinimumSize(new java.awt.Dimension(47, 21));
        btSelecionaCliente.setPreferredSize(new java.awt.Dimension(47, 21));
        btSelecionaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionaClienteActionPerformed(evt);
            }
        });

        labelTipoVenda.setText("jLabel1");

        comboTipoVenda.setLightWeightPopupEnabled(false);
        comboTipoVenda.setMaximumSize(new java.awt.Dimension(28, 20));
        comboTipoVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboTipoVendaMouseClicked(evt);
            }
        });
        comboTipoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPedidosLayout = new javax.swing.GroupLayout(panelPedidos);
        panelPedidos.setLayout(panelPedidosLayout);
        panelPedidosLayout.setHorizontalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelItens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPedidosLayout.createSequentialGroup()
                                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPedidosLayout.createSequentialGroup()
                                        .addComponent(labelTipoVenda)
                                        .addGap(76, 76, 76)
                                        .addComponent(comboTipoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btSelecionaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPedidosLayout.createSequentialGroup()
                                        .addComponent(labelData)
                                        .addGap(18, 18, 18)
                                        .addComponent(textDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(labelHora)
                                        .addGap(18, 18, 18)
                                        .addComponent(textHoraPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(labelCodPedido)
                                .addGap(18, 18, 18)
                                .addComponent(textCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelPedidosLayout.createSequentialGroup()
                                    .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelPedidosLayout.createSequentialGroup()
                                            .addGap(116, 116, 116)
                                            .addComponent(textIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(textIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelPedidosLayout.createSequentialGroup()
                                            .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelPedidosLayout.createSequentialGroup()
                                                    .addGap(90, 90, 90)
                                                    .addComponent(textDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(labelDesconto))
                                            .addGap(18, 18, 18)
                                            .addComponent(textDataPedidoSql, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(panelPedidosLayout.createSequentialGroup()
                                            .addComponent(labelEntrega)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(textEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(panelPedidosLayout.createSequentialGroup()
                                            .addComponent(labelAcrescimo)
                                            .addGap(18, 18, 18)
                                            .addComponent(textAcrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btDesbloqueio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(panelConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btMais, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        panelPedidosLayout.setVerticalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelData)
                    .addComponent(labelHora)
                    .addComponent(textDataPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textHoraPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodPedido)
                    .addComponent(textCodPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTipoVenda)
                    .addComponent(comboTipoVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSelecionaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelItens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMais, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMenos)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelDesconto)
                                .addComponent(textDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textDataPedidoSql, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPedidosLayout.createSequentialGroup()
                                .addComponent(btDesbloqueio, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))))
                    .addGroup(panelPedidosLayout.createSequentialGroup()
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelAcrescimo)
                            .addComponent(textAcrescimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEntrega)
                            .addComponent(textEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
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

        btIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btSalvar.png"))); // NOI18N
        btIncluir.setText("Salvar");
        btIncluir.setToolTipText("Salvar o Pedido");
        btIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBotoesLayout = new javax.swing.GroupLayout(panelBotoes);
        panelBotoes.setLayout(panelBotoesLayout);
        panelBotoesLayout.setHorizontalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(btFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBotoesLayout.setVerticalGroup(
            panelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotoesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelClientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelNomeCliente.setText("Nome:");

        textNomeCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textNomeClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNomeClienteKeyTyped(evt);
            }
        });

        labelTelefone.setText("Telefone:");

        textTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textTelefoneKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTelefoneKeyTyped(evt);
            }
        });

        textReferencia.setColumns(20);
        textReferencia.setRows(5);
        jScrollPane2.setViewportView(textReferencia);

        labelReferencia.setText("Referência:");

        textEndereco.setText("Endereço");
        textEndereco.setBorder(null);
        textEndereco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textEnderecoMouseClicked(evt);
            }
        });
        textEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textEnderecoKeyTyped(evt);
            }
        });

        textNumero.setText("Número");
        textNumero.setBorder(null);
        textNumero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textNumeroMouseClicked(evt);
            }
        });

        textComplemento.setText("Complemento");
        textComplemento.setBorder(null);

        textBairro.setText("Bairro");
        textBairro.setBorder(null);

        javax.swing.GroupLayout panelClientesLayout = new javax.swing.GroupLayout(panelClientes);
        panelClientes.setLayout(panelClientesLayout);
        panelClientesLayout.setHorizontalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textEndereco)
                            .addGroup(panelClientesLayout.createSequentialGroup()
                                .addComponent(textComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(textBairro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(labelReferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addComponent(labelTelefone)
                        .addGap(18, 18, 18)
                        .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelNomeCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelClientesLayout.setVerticalGroup(
            panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTelefone)
                    .addComponent(textTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNomeCliente))
                .addGap(18, 18, 18)
                .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientesLayout.createSequentialGroup()
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelReferencia)
                            .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(textEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
        
        pedido = new Pedidos();
        metodo = new Metodos();
        status = new Status();
        item = new Itens();
        tipoVenda = new TipoVenda();
        
        for(int i = 0; i < tabelaItens.getRowCount(); i ++){
            
            String codProduto = String.valueOf(tabelaItens.getValueAt(i, 0)); //Pega o código do item
            String quantidade = String.valueOf(tabelaItens.getValueAt(i, 3)); // Pega a quantidade
            String valorQuantidade = String.valueOf(tabelaItens.getValueAt(i, 4)); // Pega o valor com quantidade
            
        
            //int converteItem = item.retornaCodItem(comboItem.getSelectedItem());
            pedido.setCodPedido(textCodPedido.getText());
            pedido.setDataPedido(Date.valueOf(metodo.alteraFormatoDataPadrao(textDataPedido.getText())));
            pedido.setHoraPedido(Time.valueOf(textHoraPedido.getText()));

        try {
            Double valorEntrega = NumberFormat.getInstance().parse(textEntrega.getText()).doubleValue();
            Double valorDesconto = NumberFormat.getInstance().parse(textDesconto.getText()).doubleValue();
            Double valorAcrescimo = NumberFormat.getInstance().parse(textAcrescimo.getText()).doubleValue();
            
            pedido.setDesconto(valorDesconto);
            pedido.setAcrescimo(valorAcrescimo);
            pedido.setEntrega(valorEntrega);
            
        } catch (ParseException ex) {
            Logger.getLogger(ItensPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            pedido.setValorTotal(Double.valueOf(labelValor.getText()));
            pedido.setQuantidade(Integer.parseInt(quantidade));
            
            pedido.setValorQuantidade(Double.valueOf(valorQuantidade));
            pedido.setCodStatus(status.buscaCodStatus(comboStatus.getSelectedItem()));

            pedido.setCodItem(Integer.parseInt(codProduto));
            pedido.setCodTipoVenda(tipoVenda.buscaIdTipoVenda(comboTipoVenda.getSelectedItem()));
            pedido.setMensagem(true);
            
            if (comboTipoVenda.getSelectedItem().equals("Pedido - Entrega")){
                pedido.setCodCliente(Integer.parseInt(textIdCliente.getText()));//insiro cliente na classe pedidos.
            }else{//Não é entrega
                pedido.setCodCliente(0); // mantenho o 0
            }
//            if (procede){
                pedido.cadastraPedido();
//                pedido.setMensagem(false);
//            }else{
//                JOptionPane.showMessageDialog(null, "Não é autorizado o procedimento da venda com o cliente vazio.", "ERRO", Constantes.ERROR);
//            }
            
        }//fecha comando for
                JOptionPane.showMessageDialog(null, Constantes.SUCCAD, "SUCESSO", Constantes.SUCESSO);
                limpaCampos();
                int valorCodPedido = Integer.parseInt(textCodPedido.getText());
                int somaCodPedido = valorCodPedido + 1;
                textCodPedido.setText(String.valueOf(somaCodPedido));

    }//GEN-LAST:event_btIncluirActionPerformed
    
    public void preencheComboItem(){
        item = new Itens();
        item.preencheComboItem(comboItem);
        
    }
    
    public void preencheComboStatus(){
        status = new Status();
        status.preencheComboStatus(comboStatus);
        
    }
    
    public void preencheComboIndicador(){
        tipoVenda = new TipoVenda();
        tipoVenda.preencheComboTipoVenda(comboTipoVenda);
    }
    
   
    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.fechar();

        // TODO add your handling code here:
    }//GEN-LAST:event_btFecharActionPerformed

    public void fechar(){
        metodo.fechaPainel(this);
    }
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        item = new Itens();
        limpaCampos();
        bloqueiaBotoes();
        item.limpaTabela(tabelaItens);
//        textTelefone.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void comboItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboItemActionPerformed
//        preencheComboStatus();
        // TODO add your handling code here:
    }//GEN-LAST:event_comboItemActionPerformed

    private void comboStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboStatusActionPerformed
//        preencheComboIndicador();
        // TODO add your handling code here:
    }//GEN-LAST:event_comboStatusActionPerformed

    private void btMaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMaisActionPerformed
        preencheTabela();
        textQuantidade.setText("");
// TODO add your handling code here:
    }//GEN-LAST:event_btMaisActionPerformed

    private void tabelaItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaItensMouseClicked
        btMenos.setEnabled(true);
    }//GEN-LAST:event_tabelaItensMouseClicked

    private void btMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMenosActionPerformed
        item = new Itens();
        item.retiraItensTabela(tabelaItens.getSelectedRow(), tabelaItens, labelValor);
        preencheValores();
        
// TODO add your handling code here:
    }//GEN-LAST:event_btMenosActionPerformed

//    public void preencheClientes(String nome, int idCliente){
//        labelNomeCliente.setText(nome);
//        this.repaint();
//    }
    
    public double preencheValores(){
        double somaValores = 0.0; // jogo o valor padrão.
        for (int i=0; i<=tabelaItens.getRowCount()-1;i++) {  
            somaValores+= Double.parseDouble(tabelaItens.getValueAt(i, 4).toString());
        }// Esse comando desconsidera os valores de desconto, acrescimo e entrega já preenchidos.
        
        if (somaValores == 0.0){
            return 0.0;
        }else{
            return somaValores;
        }
    }
    
    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
            double valorDesconto = Double.valueOf(textDesconto.getText()); // pego o valor do desconto
            double valorAcrescimo = Double.valueOf(textAcrescimo.getText());//pego o valor do acrescimo
            double valorEntrega = Double.valueOf(textEntrega.getText()); // Pego o valor da entrega
//            double valorCalculado = Double.valueOf(labelValor.getText()); // pego o valor total
//            double totalCalculo = Double.valueOf(textTotalAdicionais.getText());
            
            double somaValores = preencheValores();
            
            double somaTributos = (valorAcrescimo + valorEntrega) - valorDesconto;
            textTotalAdicionais.setText(String.valueOf(somaTributos));
            
            somaValores = somaValores + (somaTributos);
            
            labelValor.setText(String.valueOf(somaValores));
            
//            labelValor.setText(String.valueOf(somaValores));
            btAtualizar.setEnabled(false);
            
            // Bloqueio os textfield's
            textDesconto.setEnabled(false);
            textAcrescimo.setEnabled(false);
            textEntrega.setEnabled(false);
            
            btDesbloqueio.setEnabled(true);
            
//            if (valorDesconto == 0.0 || valorAcrescimo == 0.0 || valorEntrega == 0.0){
//                somaValores = preencheValores();
//            }

//            labelValor.setText(String.valueOf(somaValores));
            
//            else{
//                somaValores = 0.0;
//                for (int i=0; i<=tabelaItens.getRowCount()-1;i++) {  
//                    somaValores+= Double.parseDouble(tabelaItens.getValueAt(i, 4).toString());
//                    labelValor.setText(String.valueOf(somaValores));
//                }  
//            }

            //JOptionPane.showMessageDialog(null, "Valor Calculado: " + somaValores);
            
    }//GEN-LAST:event_btAtualizarActionPerformed

    private void textQuantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textQuantidadeKeyTyped
        metodo = new Metodos();
        metodo.somenteNumeros(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_textQuantidadeKeyTyped

    private void textDescontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDescontoKeyTyped
        metodo = new Metodos();
        metodo.somenteDouble(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_textDescontoKeyTyped

    private void textAcrescimoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAcrescimoKeyTyped
        metodo = new Metodos();
        metodo.somenteDouble(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_textAcrescimoKeyTyped

    private void textDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDescontoKeyReleased
        desbloqueiaBotaoAtualizar();
// TODO add your handling code here:
    }//GEN-LAST:event_textDescontoKeyReleased

    private void textAcrescimoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAcrescimoKeyReleased
        desbloqueiaBotaoAtualizar();
        // TODO add your handling code here:
    }//GEN-LAST:event_textAcrescimoKeyReleased

    private void textEntregaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEntregaKeyReleased
        desbloqueiaBotaoAtualizar();
        // TODO add your handling code here:
    }//GEN-LAST:event_textEntregaKeyReleased

    private void btDesbloqueioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesbloqueioActionPerformed
        textDesconto.setEnabled(true);
        textAcrescimo.setEnabled(true);
        textEntrega.setEnabled(true);
        
        textDesconto.setText("0.00");
        textAcrescimo.setText("0.00");
        textEntrega.setText("0.00");
        textTotalAdicionais.setText("0.00");
        
        labelValor.setText(String.valueOf(preencheValores()));
        
        btAtualizar.setEnabled(false);
        
        
        
// TODO add your handling code here:
    }//GEN-LAST:event_btDesbloqueioActionPerformed

    private void btSelecionaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionaClienteActionPerformed
//        SelecionaCliente seleciona = new SelecionaCliente();
//        SelecionaClienteNovo seleciona = new SelecionaClienteNovo(selecao, true);
//        
//        seleciona.setModal(true);
//        seleciona.setTitle("Busca de clientes");
//        seleciona.setResizable(false);
//        seleciona.setLocationRelativeTo(null);
//        seleciona.setVisible(true);
        panelClientes.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_btSelecionaClienteActionPerformed

    private void comboTipoVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboTipoVendaMouseClicked
// TODO add your handling code here:
    }//GEN-LAST:event_comboTipoVendaMouseClicked

//    public void preencheClientes(){
//        selecao = new SelecionaCliente();
//        textNomeCliente.setText(selecao.pegaNomeCliente());
//        
//    }
//    public void preencheClientes(String nomeClienteSelecionado){
//        JTextField textNomeClienteNovo = new JTextField();  
//        textNomeClienteNovo.setText("");  
//        textNomeClienteNovo.setBounds(new Rectangle(17, 10, 10, 17));    //Ele recebe mais não preenche os dados.    
////        JOptionPane.showMessageDialog(null, nomeClienteSelecionado);
//        textNomeClienteNovo.setText(nomeClienteSelecionado); // Não preenche
////        this.repaint(); // não atualiza
//        this.add(textNomeClienteNovo);
//        this.setVisible(true);
//        
////        selecao = new SelecionaCliente();
//
//        
//    }
    
    
    private void comboTipoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoVendaActionPerformed
        metodo = new Metodos();
        
        if(comboTipoVenda.getSelectedItem().equals("Pedido - Entrega")){
//            metodo.botaoVisivel(btSelecionaCliente);
            panelClientes.setVisible(true);
//            desbloqueiaTipoVenda();
        }else{
            metodo.botaoInvisivel(btSelecionaCliente);
            panelClientes.setVisible(false);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_comboTipoVendaActionPerformed

    private void textTelefoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelefoneKeyTyped
        metodo = new Metodos();
        metodo.somenteNumeros(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefoneKeyTyped
    public Boolean verificaCampos(){
        
        if(textTelefone.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Telefone está vazio. Favor preencher.", "ERRO", Constantes.ERROR);
            return false;
        }else if(textNomeCliente.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Nome está vazio. Favor preencher.", "ERRO", Constantes.ERROR);
            return false;
        }else if(textEndereco.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Endereço está vazio. Favor preencher.", "ERRO", Constantes.ERROR);
            return false;
        }else if(textBairro.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Bairro está vazio. Favor preencher.", "ERRO", Constantes.ERROR);
            return false;
        }else if(textReferencia.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O campo Referência está vazio. Favor preencher.", "ERRO", Constantes.ERROR);
            return false;
        }
        
        return true;
    }
    
    
    private void textNomeClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNomeClienteKeyTyped
        metodo = new Metodos();
        metodo.somenteAlfabetos(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_textNomeClienteKeyTyped

    private void textEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textEnderecoKeyTyped
        metodo = new Metodos();
        metodo.somenteAlfabetos(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_textEnderecoKeyTyped

    private void textEnderecoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textEnderecoMouseClicked
        textEndereco.setText("");
        
        // TODO add your handling code here:
    }//GEN-LAST:event_textEnderecoMouseClicked

    private void textNumeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textNumeroMouseClicked
        textNumero.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_textNumeroMouseClicked

    private void textTelefoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelefoneKeyReleased
        if (textTelefone.getText().length() >= 8){

            Clientes cliente = new Clientes();
            try{
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(cliente.buscaTelefoneCliente(textTelefone.getText()));
                rs.next();
                //JOptionPane.showMessageDialog(null, cliente.buscaTelefoneCliente(textTelefone.getText()));

                if (rs.absolute(1)){ //Caso tiver algum conteúdo, preencha os campos.
                    textIdCliente.setText(String.valueOf(rs.getInt("idCliente")));
                    textNomeCliente.setText(rs.getString("nome"));
                    textEndereco.setText(rs.getString("endereco"));
                    textNumero.setText(String.valueOf(rs.getInt("numero")));
                    textComplemento.setText(rs.getString("complemento"));
                    textBairro.setText(rs.getString("bairro"));
//                    textCidade.setText(rs.getString("cidade"));
                    textReferencia.setText(rs.getString("referencia"));
//                    textEstado.setText("RJ");
                }else{ //Caso não tiver algum conteúdo,  grava no banco.

                    if(JOptionPane.showConfirmDialog(null, "O Cliente não existe. Deseja Cadastrá-lo?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
                    
                    
                    cliente.setTelefone(textTelefone.getText());
                    cliente.setNome(textNomeCliente.getText());
                    cliente.setEndereco(textEndereco.getText());
                    if (textNumero.getText().equals("Número") || textNumero.getText().equals("")){
                        cliente.setNumero(0);
                    }else{
                        cliente.setNumero(Integer.parseInt(textNumero.getText()));
                    }
                    cliente.setDataNascimento(Date.valueOf("1901-01-01"));
                    cliente.setDataCadastro(Date.valueOf(textDataPedidoSql.getText()));
                    cliente.setDataAlteracao(Date.valueOf(textDataPedidoSql.getText()));
                    cliente.setComplemento(textComplemento.getText());
                    cliente.setBairro(textBairro.getText());
                    cliente.setCidade("Rio de Janeiro");
                    cliente.setCodEstado(estado);
                    cliente.setReferencia(textReferencia.getText());

                        if(verificaCampos()){
                            cliente.cadastraCliente();
                            limpaCampos();

                        }
                    }
                }

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, "Problemas ao verificar o cliente. Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefoneKeyReleased

    private void textNomeClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNomeClienteKeyReleased
//        if (textNomeCliente.getText().length() >= 8){
/*
            Clientes cliente = new Clientes();
            try{
                con = new Conexao();
                conn = con.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery(cliente.buscaNomeCliente(textNomeCliente.getText()));
                rs.next();
                //JOptionPane.showMessageDialog(null, cliente.buscaTelefoneCliente(textTelefone.getText()));

                if (rs.absolute(1)){ //Caso tiver algum conteúdo, preencha os campos.
                    textIdCliente.setText(String.valueOf(rs.getInt("idCliente")));
                    textTelefone.setText(String.valueOf(rs.getInt("telefone")));
                    //                    textNome.setText(rs.getString("nome"));
                    textEndereco.setText(rs.getString("endereco"));
                    textNumero.setText(String.valueOf(rs.getInt("numero")));
                    textComplemento.setText(rs.getString("complemento"));
                    textBairro.setText(rs.getString("bairro"));
                    //textCidade.setText(rs.getString("cidade"));
                    //textEstado.setText("RJ");
                }else{ //Caso não tiver algum conteúdo, grava no banco.
                    
                    if(verificaCampos()){
                        cliente.setTelefone(textTelefone.getText());
                        cliente.setNome(textNomeCliente.getText());
                        cliente.setEndereco(textEndereco.getText());
                        if (textNumero.getText().equals("Número") || textNumero.getText().equals("")){
                            cliente.setNumero(0);
                        }else{
                            cliente.setNumero(Integer.parseInt(textNumero.getText()));
                        }
                        cliente.setComplemento(textComplemento.getText());
                        cliente.setBairro(textBairro.getText());
                        cliente.setCidade("Rio de Janeiro");
                        cliente.setCodEstado(estado);

                        cliente.cadastraCliente();
                        limpaCampos();
                    }

                }

            }catch(IOException | SQLException ex){
                JOptionPane.showMessageDialog(null, "Problemas ao verificar o cliente. Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
            }
//        }
        // TODO add your handling code here:*/
    }//GEN-LAST:event_textNomeClienteKeyReleased

    private void textQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textQuantidadeActionPerformed
        btMaisActionPerformed(evt);
// TODO add your handling code here:
    }//GEN-LAST:event_textQuantidadeActionPerformed

    private void textCodItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCodItemActionPerformed
        item = new Itens();
        int codigo = Integer.parseInt(textCodItem.getText());
        item.preencheItem(codigo, labelItemSelecionado);
        
// TODO add your handling code here:
    }//GEN-LAST:event_textCodItemActionPerformed
    
    public void desbloqueiaBotaoAtualizar(){
        btAtualizar.setEnabled(true);
    }
    
    public void margemTabelaItens(){
        item = new Itens();
        item.setTabelaItens(tabelaItens);
        item.margemTabela();
        item.margemTabelaBanco(tabelaItensBanco);
    }
    
    public void preencheTabela(){
        
        Object itemSelecionado = comboItem.getSelectedItem();
        Object itemStatusSelecionado = comboStatus.getSelectedItem();

        item = new Itens();
        item.preencheTabelaItens(itemSelecionado, Integer.parseInt(textQuantidade.getText()), itemStatusSelecionado, tabelaItens, labelValor, textDesconto, textAcrescimo);

        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btDesbloqueio;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btMais;
    private javax.swing.JButton btMenos;
    private javax.swing.JButton btSelecionaCliente;
    private javax.swing.JComboBox comboItem;
    private javax.swing.JComboBox comboStatus;
    private javax.swing.JComboBox comboTipoVenda;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelAcrescimo;
    private javax.swing.JLabel labelCodPedido;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelDesconto;
    private javax.swing.JLabel labelEntrega;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel labelItem;
    private javax.swing.JLabel labelItemSelecionado;
    private javax.swing.JLabel labelNomeCliente;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JLabel labelReferencia;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelSubTotal;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JLabel labelTipoVenda;
    private javax.swing.JLabel labelValor;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelConta;
    private javax.swing.JPanel panelItens;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JTable tabelaItens;
    private javax.swing.JTable tabelaItensBanco;
    private javax.swing.JTextField textAcrescimo;
    private javax.swing.JTextField textBairro;
    private javax.swing.JTextField textCodItem;
    private javax.swing.JTextField textCodPedido;
    private javax.swing.JTextField textComplemento;
    private javax.swing.JTextField textDataPedido;
    private javax.swing.JTextField textDataPedidoSql;
    private javax.swing.JTextField textDesconto;
    private javax.swing.JTextField textEndereco;
    private javax.swing.JTextField textEntrega;
    private javax.swing.JTextField textHoraPedido;
    private javax.swing.JTextField textIdCliente;
    private javax.swing.JTextField textIdPedido;
    private javax.swing.JTextField textNomeCliente;
    private javax.swing.JTextField textNumero;
    private javax.swing.JTextField textQuantidade;
    private javax.swing.JTextArea textReferencia;
    private javax.swing.JTextField textTelefone;
    private javax.swing.JTextField textTotalAdicionais;
    // End of variables declaration//GEN-END:variables


}
