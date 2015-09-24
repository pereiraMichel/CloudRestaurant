/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Debug
 */
public class Propriedades {
    private String nome;
    private double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
    
    private String caminhoArquivo = ".//src//br//com//satoru//xml//propriedades.xml";
    
    public void geraXml(){
        
        Element indicadorFinanceiro = new Element("propriedades");
        Document doc = new Document(indicadorFinanceiro);
        
        Element indicador = new Element("financeiro");
        
        Element orgao = new Element("orgao");
        orgao.setText(this.nome);
        
        Element tributo = new Element("tributo");
        tributo.setText(String.valueOf(this.valor));
        
        indicador.addContent(orgao);
        indicador.addContent(tributo);
        
        indicadorFinanceiro.addContent(indicador);
        
        XMLOutputter xout = new XMLOutputter();
        Format formatXML = Format.getPrettyFormat();        
        
        try{
            
            FileWriter file = new FileWriter(new File(caminhoArquivo));
//            FileWriter file = new FileWriter(new File(".//src//xml//" + nom.getText() + ".xml"));
            xout.setFormat(formatXML);
            xout.output(doc, file);
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");            
            
    } catch (IOException e) {
        System.out.println("O arquivo não pode ser lido.");
        e.printStackTrace();
    }
    }
    
    public void consultaIndicador(){
        
        //Carrega o xml

            File f = new File(caminhoArquivo); //Informa o nome do arquivo em xml
            SAXBuilder sb = new SAXBuilder(); //Criamos uma classe SAXBuilder que vai processar o xml4
            try {
                Document d = sb.build(f);//Este documento possui toda a estrutura do arquivo
                Element mural = d.getRootElement();//Recuperamos o elemento root

                List elements = mural.getChildren();//Recuperamos os elementos
                Iterator i = elements.iterator();   //filhos (children)
                while (i.hasNext()) {
                    Element element = (Element) i.next();
                    this.setNome(element.getChildText("orgao"));
                    this.setValor(Double.parseDouble(element.getChildText("tributo")));
                }
                //  JOptionPane.showMessageDialog(null, "Carregado com sucesso!");

            } catch (JDOMException ex) {
                Logger.getLogger(TipoVenda.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(TipoVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    
    
}
