/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.utilidades;

import CloudRestaurant.Conexao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Debug
 */
public class Metodos {
    
    public void somenteNumeros(java.awt.event.KeyEvent evt){
        String caracteres="0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        
    }
    public void somenteNumerosTelefone(java.awt.event.KeyEvent evt){
        String caracteres="0987654321-";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        
    }
    public void somenteNumerosData(java.awt.event.KeyEvent evt){
        String caracteres="0987654321/";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        
    }

    public void somenteAlfabetos(java.awt.event.KeyEvent evt){
        String caracteres="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUWXYZ ";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        
    }
    
    public void preencheBarraData(JTextField campo){
        if(campo.getText().length() == 2){
//        !caracteres.contains(evt.getKeyChar()+""
            campo.setText(campo.getText() + "/");
        }
        if(campo.getText().length() == 5){
            campo.setText(campo.getText() + "/");
        }
                   
    }
    public void preenchePontosHora(JTextField campo){
        if(campo.getText().length() == 2){
//        !caracteres.contains(evt.getKeyChar()+""
            campo.setText(campo.getText() + ":");
        }
//        if(campo.getText().length() == 5){
//            campo.setText(campo.getText() + ":");
//        }
                   
    }

    public void limpaTabela(JTable tabela){
            DefaultTableModel dtm = (DefaultTableModel) tabela.getModel();
            dtm.setNumRows(0);
    }    
    public String limitaQuantTelefone(String valor){
        String caracteres = "";    
        if(valor.length() > 9){  
            caracteres = valor.substring(0,8);  
                valor = caracteres;  
        }  
        return valor;  
    }

    public void limpaCampos(JTextField campo){
        campo.setText("");
    }
    public void limpaCamposTextArea(JTextArea campo){
        campo.setText("");
    }
    
    public void fechaPainel(JPanel painel){
        painel.setVisible(false);
    }
    
    public String alteraFormatoDataPadrao(String data){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat f = DateFormat.getDateInstance(); 
        java.util.Date dataConvert;
        
        try {
            dataConvert = f.parse(data);
            String dataFormatada = formato.format(dataConvert);
            return dataFormatada;
        } catch (ParseException ex) {
            return "";
        }        
    }
    
    public String alteraFormatoHoraPadrao(String hora){
        
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        java.util.Date data;
        
        try {
            data = formato.parse(hora);
            Time time = new Time(data.getTime());
            String dataFormatada = formato.format(time);
            return dataFormatada;
//            return dataFormatada;
        } catch (ParseException ex) {
            return "";
        }        
    }
    
    public void bloqueiaBotao(JButton botao){
        botao.setEnabled(false);
    }
    public void ativaBotao(JButton botao){
        botao.setEnabled(true);
    }
    
    public void botaoInvisivel(JButton botao){
        botao.setVisible(false);
    }
    
    public void botaoVisivel(JButton botao){
        botao.setVisible(true);
    }
    
    public void somenteDouble(java.awt.event.KeyEvent evt){
        String caracteres="0987654321,.";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }        
        
    }
    
    public void salvarTexto(String dados, String nome, String sistema){
        Date data = new Date();
        Timer hora = new Timer();
        
        try{
            
            FileOutputStream out = new FileOutputStream(nome + ".log");  
//            FileOutputStream out = new FileOutputStream("c:\\Erro.txt");  
            PrintStream p = new PrintStream(out);
            p.append("=========== HISTÓRICO DE ERRO ===========");
            p.append(System.getProperty("line.separator"));
            p.append("Sistema: " + sistema); 
            p.append(System.getProperty("line.separator"));
            p.append("Arquivo origem: " + nome); 
            p.append(System.getProperty("line.separator"));
            p.append("Data: " + data + "  |  Hora: " + hora); 
            p.append(System.getProperty("line.separator"));
            p.append(dados); 
            p.append(System.getProperty("line.separator"));
            p.append("=========== FIM DO HISTÓRICO ===========");  
            p.close();            
            
            
            JOptionPane.showMessageDialog(null, "\nArquivo gravado com sucesso em \"" + nome + ".log\".\n"); 
//            JOptionPane.showMessageDialog(null, "\nArquivo gravada com sucesso em \"c:\\erro.txt\".\n"); 
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null, "\nArquivo não foi gravado. Erro: " + ex.getMessage()); 
        }
//            FileWriter arq = new FileWriter("c:\\erro.txt"); 
//            PrintWriter gravarArq = new PrintWriter(arq);
//            gravarArq.append("=========== HISTÓRICO DE ERRO ===========");
//            gravarArq.append('\n');
//            gravarArq.append(dados);
//            gravarArq.append('\n');
//            gravarArq.append("=========================================");
//            gravarArq.append('\n');
//            arq.close(); 
    }
    
    public void geraRelatorio(String tipoRelatorio, String sql){
        //JOptionPane.showMessageDialog(null, tipoRelatorio);
        if(tipoRelatorio.equals("funcionario")){ // Verifica se o relatório é de funcionários
            try{
                Conexao con = new Conexao();
                Connection conn = con.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                rs.next();

            Map Map = new HashMap();
            String arquivo = null;
            arquivo = System.getProperty("user.dir") + "\\src\\br\\com\\scpe\\relatorios\\reportFuncionarios.jasper";
//            arquivo = System.getProperty("user.dir") + "\\src\\br\\com\\scpe\\relatorios\\reportFuncionarios.jasper";
            JasperPrint jp = JasperFillManager.fillReport(arquivo, Map, conn);
            JasperViewer view = new JasperViewer(jp, false);
            view.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            view.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            view.setVisible(true);

            }catch(JRException | SQLException | IOException ex){
                JOptionPane.showMessageDialog(null, "Houve um problema. Erro: " + ex.getMessage());
            }        
        }
/*        
try {    
           URL arquivo = getClass().getResource("Aqui dentro você adiciona o caminho do seu relatorio");             
           Map<String, Object> map = new HashMap<String, Object>();  
           map.put("Se vc tiver criado algum paramentro no seu ireport vc adicionara aqui", ); //Filtro  
           JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);    
           JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, Conexao.getConnection());   
           JasperViewer jrviewer = new JasperViewer(jasperPrint, false);    
           jrviewer.setVisible(true);   
           jrviewer.toFront();  
         }catch (Exception ex) {    
            JOptionPane.showMessageDialog(null, ex);   
        }        
==========================================================================
public void relatorio() throws JRException{  
    try {  
     Connection con = CriaConexao.getConexao();  
     HashMap parametros = new HashMap();  
     parametros.put("ID",1);  
     JasperPrint jp = JasperFillManager.fillReport("./jasper/subcliente.jasper", parametros, con);  
     JasperViewer jv = new JasperViewer(jp);  
     jv.setVisible(true);  
      
    } catch (SQLException ex) {  
        Logger.getLogger(novo.class.getName()).log(Level.SEVERE, null, ex);  
    }  
  
}        
        
*/        
    }
    
}
