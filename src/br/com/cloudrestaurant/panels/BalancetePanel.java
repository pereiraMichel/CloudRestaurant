package br.com.cloudrestaurant.panels;

import CloudRestaurant.Conexao;
import br.com.cloudrestaurant.classes.Balancete;
import br.com.cloudrestaurant.classes.Funcionario;
import br.com.cloudrestaurant.classes.Historico;
import br.com.cloudrestaurant.classes.Itens;
import br.com.cloudrestaurant.utilidades.Metodos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;


public final class BalancetePanel extends javax.swing.JPanel {
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    Historico historico;
    Funcionario funcionario;
    Itens item;
    Balancete balancete;
    Metodos metodo;

    public BalancetePanel() {
        initComponents();
        preencheDataHoje();
        fechaPaineis();
        fechaBotoesCombos();
        preencheComboItens();
        preencheComboFuncionario();
    }

    public void fechar(){
        this.setVisible(false);
    }
    
    public void fechaBotoesCombos(){
        comboHistorico.setVisible(false);
        comboHistoricoCR.setVisible(false);
        comboProduto.setVisible(false);
        textCodProduto.setEnabled(false);
        textCodProduto.setVisible(false);
        textCodFuncionario.setVisible(false);
        textCodLancamento.setVisible(false);
        textCodHistoricos.setVisible(false);
    }
    
    public void fechaPaineis(){
        panelCR.setVisible(false);
        panelDB.setVisible(false);
//        panelvalores.setVisible(false);
    }
    
    public void preencheComboHistoricos(JComboBox combo, String tipo){
        historico = new Historico();
        historico.preencheComboHistorico(combo, tipo);
    }
    
    public void preencheComboFuncionario(){
        funcionario = new Funcionario();
        funcionario.preencheComboFuncionario(comboFuncionario);
    }
    
    public void preencheComboItens(){
        item = new Itens();
        item.preencheComboItem(comboProduto);
    }
    
    public void preencheDataHoje(){
        Date data = new Date(System.currentTimeMillis());
        
        SimpleDateFormat formatado = new SimpleDateFormat("dd/MM/yyyy");
        
        String novaData = formatado.format(data);
        textDataHoje.setText(novaData);        
    }
    
    public void limpaCampos(){
        textCodHistorico.setText("");
        textCodHistoricoCR.setText("");
        textProduto.setText("");
        textValor.setText("");
        textDescricao.setText("");
        comboFuncionario.addItem("");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotoes = new javax.swing.ButtonGroup();
        panelDB = new javax.swing.JPanel();
        labelHistoricoDB = new javax.swing.JLabel();
        textCodHistorico = new javax.swing.JTextField();
        btPesquisaHistorico = new javax.swing.JButton();
        comboHistorico = new javax.swing.JComboBox();
        labelCodFuncionario = new javax.swing.JLabel();
        comboFuncionario = new javax.swing.JComboBox();
        textCodFuncionario = new javax.swing.JTextField();
        labelProduto = new javax.swing.JLabel();
        textProduto = new javax.swing.JTextField();
        btPesquisaProduto = new javax.swing.JButton();
        comboProduto = new javax.swing.JComboBox();
        textCodProduto = new javax.swing.JTextField();
        radioEntrada = new javax.swing.JRadioButton();
        radioSaida = new javax.swing.JRadioButton();
        labelTipoTransacao = new javax.swing.JLabel();
        panelCR = new javax.swing.JPanel();
        labelHistoricoCR = new javax.swing.JLabel();
        textCodHistoricoCR = new javax.swing.JTextField();
        btPesquisaHistoricoCR = new javax.swing.JButton();
        comboHistoricoCR = new javax.swing.JComboBox();
        textDataHoje = new javax.swing.JTextField();
        panelvalores = new javax.swing.JPanel();
        labelValor = new javax.swing.JLabel();
        textValor = new javax.swing.JTextField();
        labelDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textDescricao = new javax.swing.JTextArea();
        textCodLancamento = new javax.swing.JTextField();
        textCodHistoricos = new javax.swing.JTextField();
        panelBotoes = new javax.swing.JPanel();
        btIncluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btFechar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        panelDB.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelDB.setMaximumSize(new java.awt.Dimension(610, 115));

        labelHistoricoDB.setText("Razão:");

        btPesquisaHistorico.setText("...");
        btPesquisaHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaHistoricoActionPerformed(evt);
            }
        });

        comboHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHistoricoActionPerformed(evt);
            }
        });

        labelCodFuncionario.setText("Funcionário: ");

        comboFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFuncionarioActionPerformed(evt);
            }
        });

        labelProduto.setText("Produto:");

        btPesquisaProduto.setText("...");
        btPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaProdutoActionPerformed(evt);
            }
        });

        comboProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProdutoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDBLayout = new javax.swing.GroupLayout(panelDB);
        panelDB.setLayout(panelDBLayout);
        panelDBLayout.setHorizontalGroup(
            panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCodFuncionario)
                    .addComponent(labelHistoricoDB)
                    .addComponent(labelProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDBLayout.createSequentialGroup()
                        .addComponent(textCodHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisaHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDBLayout.createSequentialGroup()
                        .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textCodFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(textCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDBLayout.createSequentialGroup()
                        .addComponent(textProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        panelDBLayout.setVerticalGroup(
            panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDBLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHistoricoDB)
                    .addComponent(textCodHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisaHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodFuncionario)
                    .addComponent(comboFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelDBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelProduto)
                        .addComponent(textProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        grupoBotoes.add(radioEntrada);
        radioEntrada.setText("Entrada");
        radioEntrada.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        radioEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioEntradaActionPerformed(evt);
            }
        });

        grupoBotoes.add(radioSaida);
        radioSaida.setText("Saída");
        radioSaida.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        radioSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioSaidaActionPerformed(evt);
            }
        });

        labelTipoTransacao.setText("Tipo de Transação:");
        labelTipoTransacao.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        panelCR.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelCR.setMaximumSize(new java.awt.Dimension(533, 57));

        labelHistoricoCR.setText("Razão:");

        btPesquisaHistoricoCR.setText("...");
        btPesquisaHistoricoCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisaHistoricoCRActionPerformed(evt);
            }
        });

        comboHistoricoCR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboHistoricoCRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCRLayout = new javax.swing.GroupLayout(panelCR);
        panelCR.setLayout(panelCRLayout);
        panelCRLayout.setHorizontalGroup(
            panelCRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCRLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHistoricoCR)
                .addGap(39, 39, 39)
                .addComponent(textCodHistoricoCR, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPesquisaHistoricoCR, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboHistoricoCR, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCRLayout.setVerticalGroup(
            panelCRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCRLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textCodHistoricoCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btPesquisaHistoricoCR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboHistoricoCR, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelHistoricoCR))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        textDataHoje.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textDataHoje.setText("DataHoje");
        textDataHoje.setMaximumSize(new java.awt.Dimension(6, 20));

        panelvalores.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelvalores.setMaximumSize(new java.awt.Dimension(562, 116));

        labelValor.setText("Valor:");

        textValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textValorKeyTyped(evt);
            }
        });

        labelDescricao.setText("Descrição:");

        textDescricao.setColumns(20);
        textDescricao.setRows(5);
        jScrollPane1.setViewportView(textDescricao);

        javax.swing.GroupLayout panelvaloresLayout = new javax.swing.GroupLayout(panelvalores);
        panelvalores.setLayout(panelvaloresLayout);
        panelvaloresLayout.setHorizontalGroup(
            panelvaloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelvaloresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelvaloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescricao)
                    .addComponent(labelValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelvaloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelvaloresLayout.createSequentialGroup()
                        .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(textCodLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textCodHistoricos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        panelvaloresLayout.setVerticalGroup(
            panelvaloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelvaloresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelvaloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValor)
                    .addComponent(textValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodLancamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textCodHistoricos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelvaloresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelBotoes.setBackground(new java.awt.Color(153, 153, 255));
        panelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btAdicionar.png"))); // NOI18N
        btIncluir.setText("Incluir");
        btIncluir.setToolTipText("Novo Cliente");
        btIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btAlterarCloud.png"))); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.setToolTipText("Alterar Cliente");
        btAlterar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAlterar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btExcluir.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setToolTipText("Excluir Cliente");
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
                            .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
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
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTipoTransacao)
                        .addGap(18, 18, 18)
                        .addComponent(radioEntrada)
                        .addGap(18, 18, 18)
                        .addComponent(radioSaida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textDataHoje, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelvalores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(labelTipoTransacao)
                                .addComponent(radioEntrada))
                            .addComponent(radioSaida)
                            .addComponent(textDataHoje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelvalores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(panelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(96, 96, 96))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisaHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaHistoricoActionPerformed
        comboHistorico.setVisible(true);
    }//GEN-LAST:event_btPesquisaHistoricoActionPerformed

    private void btPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaProdutoActionPerformed
        comboProduto.setVisible(true);
        comboProduto.setEnabled(true);
    }//GEN-LAST:event_btPesquisaProdutoActionPerformed

    private void btPesquisaHistoricoCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisaHistoricoCRActionPerformed
        comboHistoricoCR.setVisible(true);
    }//GEN-LAST:event_btPesquisaHistoricoCRActionPerformed

    private void radioEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioEntradaActionPerformed
        panelDB.setVisible(false);
        panelCR.setVisible(true);
        panelvalores.setVisible(true);
        textCodLancamento.setText("1");//Código de lançamento crédito
        preencheComboHistoricos(comboHistoricoCR, "CR");

    }//GEN-LAST:event_radioEntradaActionPerformed

    private void radioSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioSaidaActionPerformed
        panelCR.setVisible(false);
        panelDB.setVisible(true);
        panelvalores.setVisible(true);
        textCodLancamento.setText("2");//Código de lançamento débito
        preencheComboHistoricos(comboHistorico, "DB");
        
        comboFuncionario.setEnabled(false);
        labelCodFuncionario.setEnabled(false);
        labelProduto.setEnabled(false);
        btPesquisaProduto.setEnabled(false);
        comboProduto.setEnabled(false);
        textCodFuncionario.setEnabled(false);
        textProduto.setEnabled(false);
    }//GEN-LAST:event_radioSaidaActionPerformed

    private void comboHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHistoricoActionPerformed
        if(comboHistorico.getSelectedItem().equals("Funcionários - Adiantamentos") || comboHistorico.getSelectedItem().equals("Funcionários - Salário")){
            ativaComboFuncionario(true);
            ativaComboProduto(false);
        }else if (comboHistorico.getSelectedItem().equals("Produtos")){
            ativaComboFuncionario(false);
            ativaComboProduto(true);
        }else{
            fechaBotoesCombos();
            ativaComboFuncionario(false);
            ativaComboProduto(false);
        }
        
        textCodHistorico.setText(comboHistorico.getSelectedItem().toString());
        comboHistorico.setVisible(false);
// TODO add your handling code here:
    }//GEN-LAST:event_comboHistoricoActionPerformed

    private void comboFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFuncionarioActionPerformed
        funcionario = new Funcionario();
        int idFuncionarioSelecionado = funcionario.buscaIdFuncionario(comboFuncionario.getSelectedItem().toString());
        textCodFuncionario.setText(String.valueOf(idFuncionarioSelecionado));
        
    }//GEN-LAST:event_comboFuncionarioActionPerformed

    private void comboProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProdutoActionPerformed
        item = new Itens();
        int idCodigoProduto = item.retornaCodItem(comboProduto.getSelectedItem().toString());
        textCodProduto.setText(String.valueOf(idCodigoProduto));
        
        textProduto.setText(comboProduto.getSelectedItem().toString());
        comboProduto.setVisible(false);
        
    }//GEN-LAST:event_comboProdutoActionPerformed

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
        balancete = new Balancete();
        metodo = new Metodos();
        historico = new Historico();
        
        String dataHoje = metodo.alteraFormatoDataPadrao(textDataHoje.getText());//crio uma variável para obter o formato padrão do mysql yyyy-mm-dd.
        balancete.setTipoBalancete(Integer.parseInt(textCodLancamento.getText()));//pego o código do lançamento
        balancete.setMensagem(Boolean.TRUE);//autorizo a mensagem de sucesso ou erro
        balancete.setDataLancamento(Date.valueOf(dataHoje));//Insiro a data padrão na classe.
        balancete.setDescricao(textDescricao.getText());
        
        Double valor;
        try {
            valor = NumberFormat.getInstance().parse(textValor.getText()).doubleValue();
            balancete.setValor(valor);
        } catch (ParseException ex) {
            Logger.getLogger(BalancetePanel.class.getName()).log(Level.SEVERE, null, ex);
        }

        int idHistorico = 0;
        
        switch(textCodLancamento.getText()){
            case "1": //Entrada - Crédito
                balancete.setCodLancamento(1);
                idHistorico = historico.buscaIdHistorico(textCodHistoricoCR.getText());
                balancete.setCodHistorico(idHistorico);//pego o id do histórico e insiro na classe
                break;
            case "2": //Saída - Dédito
                balancete.setCodLancamento(2);
                historico.setMensagem(false);
                idHistorico = historico.buscaIdHistorico(textCodHistorico.getText());
                balancete.setCodHistorico(idHistorico);//pego o id do histórico e insiro na classe
                
                if(textCodHistorico.getText().equals("Funcionários - Adiantamentos") || textCodHistorico.getText().equals("Funcionários - Salário")){
                    balancete.setCodFuncionario(Integer.parseInt(textCodFuncionario.getText()));
                }else if(textCodHistorico.getText().equals("Produtos")){
                    balancete.setCodProduto(Integer.parseInt(textCodProduto.getText()));
                }else{
                    balancete.setCodFuncionario(0);
                    balancete.setCodProduto(0);
                }
                break;
        }
        balancete.cadastraBalancete();
        limpaCampos();
        textCodHistorico.requestFocus();

    }//GEN-LAST:event_btIncluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFecharActionPerformed
        this.fechar();
        // TODO add your handling code here:
    }//GEN-LAST:event_btFecharActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        limpaCampos();
        fechaBotoesCombos();
        fechaPaineis();
        
// TODO add your handling code here:
    }//GEN-LAST:event_btCancelarActionPerformed

    private void textValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textValorKeyTyped
        metodo = new Metodos();
        metodo.somenteDouble(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_textValorKeyTyped

    private void comboHistoricoCRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboHistoricoCRActionPerformed
        historico = new Historico();
        textCodHistoricoCR.setText(comboHistoricoCR.getSelectedItem().toString());
        
        int idHistorico = historico.buscaIdHistorico(textCodHistoricoCR.getText());
        textCodHistoricos.setText(String.valueOf(idHistorico));

    }//GEN-LAST:event_comboHistoricoCRActionPerformed

    public void ativaComboFuncionario(Boolean codigo){
        labelCodFuncionario.setEnabled(codigo);
//        textCodFuncionario.setEnabled(codigo);
        comboFuncionario.setEnabled(codigo);
    }
    
    public void ativaComboProduto(Boolean codigo){
        labelProduto.setEnabled(codigo);
        textProduto.setEnabled(codigo);
        btPesquisaProduto.setEnabled(codigo);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btFechar;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btPesquisaHistorico;
    private javax.swing.JButton btPesquisaHistoricoCR;
    private javax.swing.JButton btPesquisaProduto;
    private javax.swing.JComboBox comboFuncionario;
    private javax.swing.JComboBox comboHistorico;
    private javax.swing.JComboBox comboHistoricoCR;
    private javax.swing.JComboBox comboProduto;
    private javax.swing.ButtonGroup grupoBotoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodFuncionario;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelHistoricoCR;
    private javax.swing.JLabel labelHistoricoDB;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelTipoTransacao;
    private javax.swing.JLabel labelValor;
    private javax.swing.JPanel panelBotoes;
    private javax.swing.JPanel panelCR;
    private javax.swing.JPanel panelDB;
    private javax.swing.JPanel panelvalores;
    private javax.swing.JRadioButton radioEntrada;
    private javax.swing.JRadioButton radioSaida;
    private javax.swing.JTextField textCodFuncionario;
    private javax.swing.JTextField textCodHistorico;
    private javax.swing.JTextField textCodHistoricoCR;
    private javax.swing.JTextField textCodHistoricos;
    private javax.swing.JTextField textCodLancamento;
    private javax.swing.JTextField textCodProduto;
    private javax.swing.JTextField textDataHoje;
    private javax.swing.JTextArea textDescricao;
    private javax.swing.JTextField textProduto;
    private javax.swing.JTextField textValor;
    // End of variables declaration//GEN-END:variables
}
