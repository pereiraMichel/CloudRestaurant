/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CloudRestaurant;

import br.com.cloudrestaurant.classes.Funcionario;
import br.com.cloudrestaurant.classes.RegistroAtividade;
import br.com.cloudrestaurant.constante.Constantes;
import br.com.cloudrestaurant.panels.BalancetePanel;
import br.com.cloudrestaurant.panels.Cadastro;
import br.com.cloudrestaurant.panels.CargosPanel;
import br.com.cloudrestaurant.panels.ClientesPanel;
import br.com.cloudrestaurant.panels.EstadosPanel;
import br.com.cloudrestaurant.panels.FornecedoresPanel;
import br.com.cloudrestaurant.panels.FramePadrao;
import br.com.cloudrestaurant.panels.FretePanel;
import br.com.cloudrestaurant.panels.FuncionarioPanel;
import br.com.cloudrestaurant.panels.ItensPanel;
import br.com.cloudrestaurant.panels.ListaPedidosPanel;
import br.com.cloudrestaurant.panels.PedidoCliente;
import br.com.cloudrestaurant.panels.PedidoFornecedor;
import br.com.cloudrestaurant.panels.Sobre;
import br.com.cloudrestaurant.panels.TelaRelVendas;
import br.com.cloudrestaurant.panels.TipoVendaPanel;
import br.com.cloudrestaurant.utilidades.Metodos;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Debug
 */
public class Principal extends javax.swing.JFrame {
    
    TipoVendaPanel indicador;
    FuncionarioPanel entregador;
    PedidoCliente pedidoCliente;
    PedidoFornecedor pedidoFornecedor;
    ListaPedidosPanel listaRegistro;
    
    RegistroAtividade registro;
    
    Conexao con;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    

    public Principal() {
        initComponents();
        bloqueiaSistema();
        iconeWindow();
        preencheDataHoraHoje();
        desativaMenus();
    }
    
    public void desativaMenus(){
        //Ferramentas
        subMenuEstados.setVisible(false);
        subMenuFrete.setVisible(false);
        subTipoProduto.setVisible(false);
        //Sistemas
        subMenuFornecedores.setVisible(false);
        //Relatórios
        subMenuRelClientes.setVisible(false);
        subMenuRelFaturamento.setVisible(false);
        subMenuRelFornecedores.setVisible(false);
        subMenuRelProdutos.setVisible(false);
        subMenuRelTelefones.setVisible(false);
        subMenuRelFuncionarios.setVisible(false);
        //Produtos
        subMenuEstoque.setVisible(false);
        //Venda
        subMenuPedFornecedores.setVisible(false);
        
        //Botões
        btBalancete.setVisible(false);
        btLogoff.setVisible(false);
    }
    
    public void iconeWindow(){
        URL url = this.getClass().getResource("/br/com/cloudrestaurant/images/cloudRestaurante.png");  
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);  
        this.setIconImage(imagemTitulo);
        labelImageOn.setVisible(false);
        labelImageOff.setVisible(true);
        //labelImage.setIcon(new ImageIcon(getClass().getResource("/images/database_green.png")));

    }
    
    public void preencheDataHoraHoje(){
        Date dataHoje = new Date(System.currentTimeMillis());
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        String formatoDataPadrao = formatoData.format(dataHoje);
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        String formatoHoraPadrao = formatoHora.format(dataHoje);
        
        labelData.setText(String.valueOf(formatoDataPadrao));        
        labelHora.setText(String.valueOf(formatoHoraPadrao));
        
        subImpressao.setEnabled(false);
        btSair.setContentAreaFilled(false);
        btMapTi.setContentAreaFilled(false);
    }
    
    public void preencheLabels(){
        labelAtividades.setText("Registro de Atividades");
        labelUsuario.setVisible(false);
        labelSenha.setVisible(false);
        textUsuario.setVisible(false);
        textSenha.setVisible(false);
        labelUsuarioLogado.setVisible(false);
        textHistorico.setVisible(false);
        labelEsqueciSenha.setVisible(false);
    }
    
    public void autorizaSistema(){
        
        menuSistema.setEnabled(true);
        menuPedido.setEnabled(true);
        menuProdutos.setEnabled(true);
        menuRelatorios.setEnabled(true);
        menuFerramentas.setEnabled(true);
        menuFinanceiro.setEnabled(true);
//        btCadastros.setEnabled(true);
        btClientes.setEnabled(true);
        btBalancete.setEnabled(true);
        btPedidoCliente.setEnabled(true);
        preencheLabels();
        labelAtividades.setVisible(true);
        labelUsuarioLogado.setVisible(true);
        labelUsuarioLogado.setText("Usuário logado: " + textUsuario.getText());
        btEnviar.setVisible(false);
        
        textHistorico.setVisible(true);
        textHistorico.setEnabled(false);
        
        btLogoff.setEnabled(true);
        
        registro = new RegistroAtividade();
        
        registro.registraTabelaAtividade(textHistorico, labelData.getText(), 1);
        registro.registraTabelaAtividade(textHistorico, textUsuario.getText(), 6);
        
//        DefaultTableModel dtm = (DefaultTableModel) textHistorico.getModel();//Fazer uma classe
//        dtm.addRow(new Object[]{"Abertura do sistema."});
//        dtm.addRow(new Object[]{"Usuário " + textUsuario.getText()});
        
    }
    
    public void bloqueiaSistema(){
        menuSistema.setEnabled(false);
        menuPedido.setEnabled(false);
        menuProdutos.setEnabled(false);
        menuRelatorios.setEnabled(false);
        menuFerramentas.setEnabled(false);
        menuFinanceiro.setEnabled(false);
        labelAtividades.setVisible(false);
//        btCadastros.setEnabled(false);
        btClientes.setEnabled(false);
        btBalancete.setEnabled(false);
        btPedidoCliente.setEnabled(false);
        textUsuario.requestFocus();
        labelUsuarioLogado.setVisible(false);
        btLogoff.setEnabled(false);
    }

    public void verificaUsuario(){
        
        try{
            String sql = "SELECT nomeUsuario, senha FROM usuario "
                    + "WHERE nomeUsuario = '" + textUsuario.getText() + "' "
                    + "AND senha = '" + textSenha.getText() + "'";
            con = new Conexao();
            conn = con.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            if(rs.absolute(1)){
                autorizaSistema();
            }else{
                JOptionPane.showMessageDialog(null, Constantes.ERROUSER, "ERRO", Constantes.ERROR);
                textSenha.setText("");
                textUsuario.setText("");
                textUsuario.requestFocus();
                bloqueiaSistema();
            }
            
        }catch(IOException | SQLException ex){
            JOptionPane.showMessageDialog(null, "Ocorreu um problema. Erro: " + ex.getMessage(), "ERRO", Constantes.ERROR);
        }
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paineis = new javax.swing.JScrollPane();
        panelTopo = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();
        btMapTi = new javax.swing.JButton();
        panelDown = new javax.swing.JPanel();
        jLabelSituacaoBanco = new javax.swing.JLabel();
        labelVersao = new javax.swing.JLabel();
        labelData = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        tools = new javax.swing.JToolBar();
        labelAcesso = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btPedidoCliente = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        btClientes = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        btBalancete = new javax.swing.JButton();
        panelLateral = new javax.swing.JPanel();
        labelAtividades = new javax.swing.JLabel();
        labelLogoMapTi = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        textSenha = new javax.swing.JPasswordField();
        labelImageOn = new javax.swing.JLabel();
        labelUsuarioLogado = new javax.swing.JLabel();
        textHistorico = new javax.swing.JTable();
        labelEsqueciSenha = new javax.swing.JLabel();
        btLogoff = new javax.swing.JButton();
        labelImageOff = new javax.swing.JLabel();
        btEnviar = new javax.swing.JButton();
        menu = new javax.swing.JMenuBar();
        menuSistema = new javax.swing.JMenu();
        subMenuClientes = new javax.swing.JMenuItem();
        subMenuFuncionario = new javax.swing.JMenuItem();
        subMenuFornecedores = new javax.swing.JMenuItem();
        separador = new javax.swing.JPopupMenu.Separator();
        subMenuSair = new javax.swing.JMenuItem();
        menuPedido = new javax.swing.JMenu();
        subMenuPedClientes = new javax.swing.JMenuItem();
        subMenuPedFornecedores = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        subMenuEstoque = new javax.swing.JMenuItem();
        subMenuItens = new javax.swing.JMenuItem();
        menuFinanceiro = new javax.swing.JMenu();
        subMenuBalancete = new javax.swing.JMenuItem();
        subMenuFaturamento = new javax.swing.JMenuItem();
        menuFerramentas = new javax.swing.JMenu();
        subMenuEstados = new javax.swing.JMenuItem();
        subMenuFrete = new javax.swing.JMenuItem();
        subMenuCargos = new javax.swing.JMenuItem();
        subTipoProduto = new javax.swing.JMenuItem();
        subMenuIndFinanceiro = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        subMenuRelClientes = new javax.swing.JMenuItem();
        subMenuRelFaturamento = new javax.swing.JMenuItem();
        subMenuRelFornecedores = new javax.swing.JMenuItem();
        subMenuRelFuncionarios = new javax.swing.JMenuItem();
        subMenuRelProdutos = new javax.swing.JMenuItem();
        subMenuRelTelefones = new javax.swing.JMenuItem();
        subMenuRelVendas = new javax.swing.JMenu();
        subConsultaTela = new javax.swing.JMenuItem();
        subImpressao = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenu();
        subMenuAutor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.black);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        paineis.setBackground(new java.awt.Color(255, 255, 255));
        paineis.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.red));
        paineis.setAutoscrolls(true);

        panelTopo.setBackground(new java.awt.Color(255, 51, 51));
        panelTopo.setPreferredSize(new java.awt.Dimension(0, 80));

        btSair.setBackground(new java.awt.Color(255, 51, 51));
        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/botaoSair24x24.png"))); // NOI18N
        btSair.setToolTipText("Sair");
        btSair.setBorder(null);
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btMapTi.setBackground(new java.awt.Color(255, 51, 51));
        btMapTi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/logoMapTi100x50.png"))); // NOI18N
        btMapTi.setToolTipText("Sobre");
        btMapTi.setBorder(null);
        btMapTi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMapTiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTopoLayout = new javax.swing.GroupLayout(panelTopo);
        panelTopo.setLayout(panelTopoLayout);
        panelTopoLayout.setHorizontalGroup(
            panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btMapTi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTopoLayout.setVerticalGroup(
            panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopoLayout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(panelTopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btMapTi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelDown.setBackground(new java.awt.Color(102, 102, 255));

        jLabelSituacaoBanco.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSituacaoBanco.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelSituacaoBanco.setText("Consultando banco...");
        jLabelSituacaoBanco.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabelSituacaoBanco.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        labelVersao.setForeground(new java.awt.Color(255, 255, 255));
        labelVersao.setText("Versão Beta - em fase de Teste");

        labelData.setForeground(new java.awt.Color(255, 255, 255));
        labelData.setText("jLabel1");

        labelHora.setForeground(new java.awt.Color(255, 255, 255));
        labelHora.setText("jLabel1");

        javax.swing.GroupLayout panelDownLayout = new javax.swing.GroupLayout(panelDown);
        panelDown.setLayout(panelDownLayout);
        panelDownLayout.setHorizontalGroup(
            panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDownLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelSituacaoBanco)
                .addGap(89, 89, 89)
                .addComponent(labelData)
                .addGap(80, 80, 80)
                .addComponent(labelHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelVersao)
                .addContainerGap())
        );
        panelDownLayout.setVerticalGroup(
            panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDownLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSituacaoBanco, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDownLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelVersao)
                        .addComponent(labelData)
                        .addComponent(labelHora))))
        );

        jLabelSituacaoBanco.getAccessibleContext().setAccessibleName("jLabelSituacaoBanco");

        tools.setBackground(new java.awt.Color(255, 51, 51));
        tools.setFloatable(false);
        tools.setForeground(new java.awt.Color(255, 51, 51));
        tools.setAutoscrolls(true);

        labelAcesso.setToolTipText("Acesso Rápido");
        tools.add(labelAcesso);
        tools.add(jSeparator1);

        btPedidoCliente.setBackground(new java.awt.Color(255, 255, 102));
        btPedidoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/icone_sac_pedido.png"))); // NOI18N
        btPedidoCliente.setText("   Vendas   ");
        btPedidoCliente.setToolTipText("Venda a clientes");
        btPedidoCliente.setFocusable(false);
        btPedidoCliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btPedidoCliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btPedidoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPedidoClienteActionPerformed(evt);
            }
        });
        tools.add(btPedidoCliente);
        btPedidoCliente.getAccessibleContext().setAccessibleDescription("");

        tools.add(jSeparator2);

        btClientes.setBackground(new java.awt.Color(255, 255, 102));
        btClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/icone-cadastro.png"))); // NOI18N
        btClientes.setText("   Clientes   ");
        btClientes.setToolTipText("Consulta / Alteração / Exclusão de Clientes");
        btClientes.setFocusable(false);
        btClientes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btClientes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClientesActionPerformed(evt);
            }
        });
        tools.add(btClientes);
        tools.add(jSeparator6);

        btBalancete.setBackground(new java.awt.Color(255, 255, 102));
        btBalancete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/icon_faturamento.png"))); // NOI18N
        btBalancete.setText("  Balancete  ");
        btBalancete.setToolTipText("Lançamentos Financeiros");
        btBalancete.setFocusable(false);
        btBalancete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btBalancete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tools.add(btBalancete);

        panelLateral.setBackground(new java.awt.Color(255, 255, 102));
        panelLateral.setMaximumSize(new java.awt.Dimension(200, 296));
        panelLateral.setMinimumSize(new java.awt.Dimension(200, 296));

        labelAtividades.setText("jLabel1");

        labelLogoMapTi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/cloudRestaurante.png"))); // NOI18N
        labelLogoMapTi.setToolTipText("CLOUD RESTAURANTE");

        labelUsuario.setText("Usuário:");

        textUsuario.setToolTipText("Insira o usuário");

        labelSenha.setText("Senha:");

        textSenha.setToolTipText("Insira sua senha");
        textSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSenhaActionPerformed(evt);
            }
        });

        labelImageOn.setBackground(new java.awt.Color(255, 51, 51));
        labelImageOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/database_green.png"))); // NOI18N
        labelImageOn.setToolTipText("");

        labelUsuarioLogado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelUsuarioLogado.setForeground(new java.awt.Color(255, 0, 0));
        labelUsuarioLogado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelUsuarioLogado.setText("jLabel1");

        textHistorico.setBackground(new java.awt.Color(255, 255, 102));
        textHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título 1"
            }
        ));

        labelEsqueciSenha.setForeground(new java.awt.Color(255, 0, 0));
        labelEsqueciSenha.setText("Esqueci minha senha");
        labelEsqueciSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btLogoff.setBackground(new java.awt.Color(255, 255, 102));
        btLogoff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btCancelarCloud.png"))); // NOI18N
        btLogoff.setText("Logoff");
        btLogoff.setToolTipText("Logoff");
        btLogoff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogoffActionPerformed(evt);
            }
        });

        labelImageOff.setBackground(new java.awt.Color(255, 51, 51));
        labelImageOff.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/database-delete-icon.PNG"))); // NOI18N
        labelImageOff.setToolTipText("");

        btEnviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/btCheckOk.png"))); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLateralLayout = new javax.swing.GroupLayout(panelLateral);
        panelLateral.setLayout(panelLateralLayout);
        panelLateralLayout.setHorizontalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLateralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelLogoMapTi)
                            .addComponent(labelUsuarioLogado, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btEnviar)
                                .addGroup(panelLateralLayout.createSequentialGroup()
                                    .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelUsuario)
                                        .addComponent(labelSenha))
                                    .addGap(29, 29, 29)
                                    .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLateralLayout.createSequentialGroup()
                        .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelAtividades, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLateralLayout.createSequentialGroup()
                                .addComponent(labelImageOff, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelImageOn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btLogoff)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(14, 14, 14))
            .addGroup(panelLateralLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(labelEsqueciSenha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLateralLayout.setVerticalGroup(
            panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLogoMapTi)
                .addGap(20, 20, 20)
                .addComponent(labelAtividades)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSenha))
                .addGap(19, 19, 19)
                .addComponent(btEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEsqueciSenha)
                .addGap(18, 18, 18)
                .addComponent(textHistorico, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelUsuarioLogado)
                .addGap(18, 18, 18)
                .addGroup(panelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelImageOn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLogoff, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelImageOff, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        menuSistema.setText("Sistema");
        menuSistema.setPreferredSize(new java.awt.Dimension(75, 19));

        subMenuClientes.setText("Clientes");
        subMenuClientes.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuClientesActionPerformed(evt);
            }
        });
        menuSistema.add(subMenuClientes);

        subMenuFuncionario.setText("Funcionários");
        subMenuFuncionario.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuFuncionarioActionPerformed(evt);
            }
        });
        menuSistema.add(subMenuFuncionario);

        subMenuFornecedores.setText("Fornecedores");
        subMenuFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuFornecedoresActionPerformed(evt);
            }
        });
        menuSistema.add(subMenuFornecedores);
        menuSistema.add(separador);

        subMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        subMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/botaoSair16x16.png"))); // NOI18N
        subMenuSair.setText("Sair");
        subMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSairActionPerformed(evt);
            }
        });
        menuSistema.add(subMenuSair);

        menu.add(menuSistema);

        menuPedido.setText("Venda");
        menuPedido.setPreferredSize(new java.awt.Dimension(75, 19));

        subMenuPedClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        subMenuPedClientes.setText("Clientes");
        subMenuPedClientes.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuPedClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPedClientesActionPerformed(evt);
            }
        });
        menuPedido.add(subMenuPedClientes);

        subMenuPedFornecedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        subMenuPedFornecedores.setText("Fornecedores");
        subMenuPedFornecedores.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuPedFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuPedFornecedoresActionPerformed(evt);
            }
        });
        menuPedido.add(subMenuPedFornecedores);

        menu.add(menuPedido);

        menuProdutos.setText("Produtos");
        menuProdutos.setPreferredSize(new java.awt.Dimension(75, 19));

        subMenuEstoque.setText("Estoque");
        subMenuEstoque.setPreferredSize(new java.awt.Dimension(200, 22));
        menuProdutos.add(subMenuEstoque);

        subMenuItens.setText("Itens");
        subMenuItens.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuItensActionPerformed(evt);
            }
        });
        menuProdutos.add(subMenuItens);

        menu.add(menuProdutos);

        menuFinanceiro.setText("Financeiro");
        menuFinanceiro.setPreferredSize(new java.awt.Dimension(75, 19));

        subMenuBalancete.setText("Entrada e Saída");
        subMenuBalancete.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuBalancete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuBalanceteActionPerformed(evt);
            }
        });
        menuFinanceiro.add(subMenuBalancete);

        subMenuFaturamento.setText("Faturamento");
        menuFinanceiro.add(subMenuFaturamento);

        menu.add(menuFinanceiro);

        menuFerramentas.setText("Ferramentas");
        menuFerramentas.setPreferredSize(new java.awt.Dimension(82, 19));

        subMenuEstados.setText("Estados");
        subMenuEstados.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuEstadosActionPerformed(evt);
            }
        });
        menuFerramentas.add(subMenuEstados);

        subMenuFrete.setText("Frete");
        subMenuFrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuFreteActionPerformed(evt);
            }
        });
        menuFerramentas.add(subMenuFrete);

        subMenuCargos.setText("Tabela de Cargos");
        subMenuCargos.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuCargosActionPerformed(evt);
            }
        });
        menuFerramentas.add(subMenuCargos);

        subTipoProduto.setText("Tipo de Produto");
        menuFerramentas.add(subTipoProduto);

        subMenuIndFinanceiro.setText("Tipo de Venda");
        subMenuIndFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuIndFinanceiroActionPerformed(evt);
            }
        });
        menuFerramentas.add(subMenuIndFinanceiro);

        menu.add(menuFerramentas);

        menuRelatorios.setText("Relatórios");
        menuRelatorios.setPreferredSize(new java.awt.Dimension(75, 19));

        subMenuRelClientes.setText("Clientes");
        subMenuRelClientes.setPreferredSize(new java.awt.Dimension(200, 22));
        menuRelatorios.add(subMenuRelClientes);

        subMenuRelFaturamento.setText("Faturamento");
        menuRelatorios.add(subMenuRelFaturamento);

        subMenuRelFornecedores.setText("Fornecedores");
        menuRelatorios.add(subMenuRelFornecedores);

        subMenuRelFuncionarios.setText("Funcionários");
        subMenuRelFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuRelFuncionariosActionPerformed(evt);
            }
        });
        menuRelatorios.add(subMenuRelFuncionarios);

        subMenuRelProdutos.setText("Produtos");
        menuRelatorios.add(subMenuRelProdutos);

        subMenuRelTelefones.setText("Telefones");
        menuRelatorios.add(subMenuRelTelefones);

        subMenuRelVendas.setText("Vendas");
        subMenuRelVendas.setPreferredSize(new java.awt.Dimension(200, 22));

        subConsultaTela.setText("Consulta em tela");
        subConsultaTela.setPreferredSize(new java.awt.Dimension(200, 22));
        subConsultaTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subConsultaTelaActionPerformed(evt);
            }
        });
        subMenuRelVendas.add(subConsultaTela);

        subImpressao.setText("Impressão");
        subMenuRelVendas.add(subImpressao);

        menuRelatorios.add(subMenuRelVendas);

        menu.add(menuRelatorios);

        menuSobre.setText("Sobre");
        menuSobre.setPreferredSize(new java.awt.Dimension(75, 19));

        subMenuAutor.setText("Autor");
        subMenuAutor.setPreferredSize(new java.awt.Dimension(200, 22));
        subMenuAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuAutorActionPerformed(evt);
            }
        });
        menuSobre.add(subMenuAutor);

        menu.add(menuSobre);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDown, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tools, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTopo, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paineis)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tools, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                    .addComponent(panelTopo, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paineis, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(panelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void subMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSairActionPerformed
        this.sair();
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuSairActionPerformed

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        Conexao con = new Conexao();
        try {
            con.getConnection();
            jLabelSituacaoBanco.setForeground(Color.white);
            jLabelSituacaoBanco.setText("Banco conectado.");
//            labelImageOn.setVisible(true);
//            labelImageOff.setVisible(false);
            labelImageOff.setIcon(new ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/database_green.png")));
            con.fechaConexao();
            
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
//            JOptionPane.showMessageDialog(null, "Banco não conectado !");
            jLabelSituacaoBanco.setForeground(Color.red);
            panelDown.setForeground(Color.white);
            jLabelSituacaoBanco.setText("Banco desconectado.");
            //this.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void subMenuAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuAutorActionPerformed

        Sobre sobre = new Sobre();
        
        sobre.setSize(633, 245);
        paineis.add(sobre);
        paineis.setViewportView(sobre);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuAutorActionPerformed

    private void subMenuEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuEstadosActionPerformed
        EstadosPanel estadoPanel = new EstadosPanel();
        paineis.add(estadoPanel);
        paineis.setViewportView(estadoPanel);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuEstadosActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        subMenuSairActionPerformed(evt);
        // TODO add your handling code here:
    }//GEN-LAST:event_btSairActionPerformed

    private void subMenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuClientesActionPerformed
        ClientesPanel cliente = new ClientesPanel();
        
        paineis.add(cliente);
        paineis.setViewportView(cliente);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuClientesActionPerformed

    private void btClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClientesActionPerformed
        subMenuClientesActionPerformed(evt);
        
// TODO add your handling code here:
    }//GEN-LAST:event_btClientesActionPerformed

    private void subMenuFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuFornecedoresActionPerformed
        FornecedoresPanel fornecedores = new FornecedoresPanel();
        
        paineis.add(fornecedores);
        paineis.setViewportView(fornecedores);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuFornecedoresActionPerformed

    private void btMapTiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMapTiActionPerformed

        this.subMenuAutorActionPerformed(evt);

// TODO add your handling code here:
    }//GEN-LAST:event_btMapTiActionPerformed

    private void subMenuItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuItensActionPerformed
        ItensPanel item = new ItensPanel();
        
        paineis.add(item);
        paineis.setViewportView(item);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuItensActionPerformed

    private void subMenuFreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuFreteActionPerformed
        FretePanel frete= new FretePanel();
        
        paineis.add(frete);
        
        paineis.setViewportView(frete);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuFreteActionPerformed

    private void subMenuIndFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuIndFinanceiroActionPerformed
        indicador = new TipoVendaPanel();
        
        paineis.add(indicador);
        paineis.setViewportView(indicador);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuIndFinanceiroActionPerformed

    private void subMenuFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuFuncionarioActionPerformed
        entregador = new FuncionarioPanel();
        
        paineis.add(entregador);
        paineis.setViewportView(entregador);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuFuncionarioActionPerformed

    private void subMenuPedClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPedClientesActionPerformed
        pedidoCliente = new PedidoCliente();
        
        paineis.add(pedidoCliente);
        paineis.setViewportView(pedidoCliente);
        
        registro = new RegistroAtividade();
        registro.registraTabelaAtividade(textHistorico, "Venda a clientes", 7);
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuPedClientesActionPerformed

    private void subMenuPedFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuPedFornecedoresActionPerformed
        pedidoFornecedor = new PedidoFornecedor();
        
        paineis.add(pedidoFornecedor);
        paineis.setViewportView(pedidoFornecedor);
        // TODO add your handling code here:
    }//GEN-LAST:event_subMenuPedFornecedoresActionPerformed

    private void subMenuCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuCargosActionPerformed
        CargosPanel cargo = new CargosPanel();
        paineis.add(cargo);
        paineis.setViewportView(cargo);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuCargosActionPerformed

    private void subMenuRelFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuRelFuncionariosActionPerformed
        Metodos metodo = new Metodos();
        Funcionario funcionario = new Funcionario();
        
        metodo.geraRelatorio("funcionario", funcionario.consultaFuncionarioCargo());
        
    }//GEN-LAST:event_subMenuRelFuncionariosActionPerformed

    private void btPedidoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPedidoClienteActionPerformed
        pedidoCliente = new PedidoCliente();
        
        paineis.add(pedidoCliente);
        paineis.setViewportView(pedidoCliente);
        
        registro = new RegistroAtividade();
        registro.registraTabelaAtividade(textHistorico, "Venda a clientes", 7);        // TODO add your handling code here:
    }//GEN-LAST:event_btPedidoClienteActionPerformed

    private void textSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSenhaActionPerformed
        verificaUsuario();
        
// TODO add your handling code here:
    }//GEN-LAST:event_textSenhaActionPerformed

    private void btLogoffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogoffActionPerformed
            bloqueiaSistema();
            textUsuario.requestFocus();
            // TODO add your handling code here:
    }//GEN-LAST:event_btLogoffActionPerformed

    private void subConsultaTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subConsultaTelaActionPerformed
        listaRegistro = new ListaPedidosPanel();
        
        paineis.add(listaRegistro);
        paineis.setViewportView(listaRegistro);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subConsultaTelaActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        textSenhaActionPerformed(evt);
        
// TODO add your handling code here:
    }//GEN-LAST:event_btEnviarActionPerformed

    private void subMenuBalanceteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuBalanceteActionPerformed
        BalancetePanel balancete = new BalancetePanel();
        
        paineis.add(balancete);
        paineis.setViewportView(balancete);
        
//        FramePadrao frame = new FramePadrao("balancete");
//        frame.setVisible(true);
        
// TODO add your handling code here:
    }//GEN-LAST:event_subMenuBalanceteActionPerformed
   
    public void fechar(){
        System.gc();
        System.exit(0);
        this.dispose();
    }
    
    public void sair(){
        if (JOptionPane.showConfirmDialog(null, "Deseja sair?", "ATENÇÃO", JOptionPane.YES_NO_OPTION) == 0){
            this.fechar();
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBalancete;
    private javax.swing.JButton btClientes;
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btLogoff;
    private javax.swing.JButton btMapTi;
    private javax.swing.JButton btPedidoCliente;
    private javax.swing.JButton btSair;
    private javax.swing.JLabel jLabelSituacaoBanco;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JLabel labelAcesso;
    private javax.swing.JLabel labelAtividades;
    private javax.swing.JLabel labelData;
    private javax.swing.JLabel labelEsqueciSenha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel labelImageOff;
    private javax.swing.JLabel labelImageOn;
    private javax.swing.JLabel labelLogoMapTi;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelUsuarioLogado;
    private javax.swing.JLabel labelVersao;
    private javax.swing.JMenuBar menu;
    private javax.swing.JMenu menuFerramentas;
    private javax.swing.JMenu menuFinanceiro;
    private javax.swing.JMenu menuPedido;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuSistema;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JScrollPane paineis;
    private javax.swing.JPanel panelDown;
    private javax.swing.JPanel panelLateral;
    private javax.swing.JPanel panelTopo;
    private javax.swing.JPopupMenu.Separator separador;
    private javax.swing.JMenuItem subConsultaTela;
    private javax.swing.JMenuItem subImpressao;
    private javax.swing.JMenuItem subMenuAutor;
    private javax.swing.JMenuItem subMenuBalancete;
    private javax.swing.JMenuItem subMenuCargos;
    private javax.swing.JMenuItem subMenuClientes;
    private javax.swing.JMenuItem subMenuEstados;
    private javax.swing.JMenuItem subMenuEstoque;
    private javax.swing.JMenuItem subMenuFaturamento;
    private javax.swing.JMenuItem subMenuFornecedores;
    private javax.swing.JMenuItem subMenuFrete;
    private javax.swing.JMenuItem subMenuFuncionario;
    private javax.swing.JMenuItem subMenuIndFinanceiro;
    private javax.swing.JMenuItem subMenuItens;
    private javax.swing.JMenuItem subMenuPedClientes;
    private javax.swing.JMenuItem subMenuPedFornecedores;
    private javax.swing.JMenuItem subMenuRelClientes;
    private javax.swing.JMenuItem subMenuRelFaturamento;
    private javax.swing.JMenuItem subMenuRelFornecedores;
    private javax.swing.JMenuItem subMenuRelFuncionarios;
    private javax.swing.JMenuItem subMenuRelProdutos;
    private javax.swing.JMenuItem subMenuRelTelefones;
    private javax.swing.JMenu subMenuRelVendas;
    private javax.swing.JMenuItem subMenuSair;
    private javax.swing.JMenuItem subTipoProduto;
    private javax.swing.JTable textHistorico;
    private javax.swing.JPasswordField textSenha;
    private javax.swing.JTextField textUsuario;
    private javax.swing.JToolBar tools;
    // End of variables declaration//GEN-END:variables
}
