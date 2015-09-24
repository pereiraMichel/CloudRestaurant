/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CloudRestaurant;

import java.awt.Color;
import java.util.Properties;

/**
 *
 * @author Debug
 */
public class Propriedades extends javax.swing.JFrame {

    /**
     * Creates new form Propriedades
     */
    public Propriedades() {
        initComponents();
        preenchePropriedades();
    }
    
    public void preenchePropriedades(){

        listaPropriedades.append("Sistema Operacional: " + System.getProperty("os.name") + "\n");
        listaPropriedades.append("Versão do JVM: " + System.getProperty("java.vm.vendor") + "\n");
        listaPropriedades.append("Versão Java: " + System.getProperty("java.runtime.version") + "\n");
//        listaPropriedades.append("Propriedades: " + "\n" + System.getProperties() + "\n");//
        listaPropriedades.append("Sistema Operacional: " + System.getProperty("os.name") + "\n");
        listaPropriedades.append("Versão do Sistema Operacional: " + System.getProperty("os.version") + "\n");
        listaPropriedades.append("Codificação: " + System.getProperty("file.encoding") + "\n");
        listaPropriedades.append("Pasta de Instalação do Java: " + System.getProperty("java.home") + "\n");
        listaPropriedades.append("Ambiente de ClassPath: " + System.getProperty("java.class.path") + "\n");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLista = new javax.swing.JLabel();
        labelImagem = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        labelVersao = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPropriedades = new javax.swing.JTextArea();
        btContinuar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelLista.setText("Carregando... Aguarde!");

        labelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/cloudrestaurant/images/cloudRestaurante.png"))); // NOI18N

        labelTitulo.setText("Sistema para Restaurantes");

        labelVersao.setText("Versão: 1.0");

        listaPropriedades.setColumns(20);
        listaPropriedades.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        listaPropriedades.setRows(5);
        jScrollPane2.setViewportView(listaPropriedades);

        btContinuar.setText("Continuar");
        btContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btContinuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelImagem)
                            .addComponent(labelTitulo)
                            .addComponent(labelVersao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLista)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btContinuar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelImagem)
                        .addGap(18, 18, 18)
                        .addComponent(labelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelVersao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btContinuar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btContinuarActionPerformed
        Principal principal = new Principal();
        
        principal.setTitle("CLOUD Restaurantes - Sistema para Restaurantes");
        principal.setLocationRelativeTo(principal); //Coloca o jpanel em tamanho relativo.
        principal.setBackground(Color.white);
        principal.setExtendedState(principal.MAXIMIZED_BOTH); // Maximiza a tela.
        
        principal.setVisible(true);
        
        System.gc();
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btContinuarActionPerformed


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
            java.util.logging.Logger.getLogger(Propriedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Propriedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Propriedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Propriedades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Propriedades().setVisible(true);
            }
        });
        
    }


    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btContinuar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JLabel labelLista;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelVersao;
    private javax.swing.JTextArea listaPropriedades;
    // End of variables declaration//GEN-END:variables
}
