/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CloudRestaurant;

//import java.io.FileInputStream;

import java.awt.Color;
import java.text.ParseException;

//import java.io.IOException;
//import java.util.Properties;


/**
 *
 * @author Debug
 */
public class CloudRestaurant {

//    public static Properties getProp() throws IOException {//br\com\satoru\bundles
//        Properties props = new Properties();
//        FileInputStream file = new FileInputStream("./banco.properties");
//        props.load(file);
//        return props;
//    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
//         String login; //Variavel que guardará o login do servidor. 
//         String host; //Variavel que guardará o host do servidor. 
//         String password; //Variável que guardará o password do usúario. 
//         System.out.println("************Lendo o arquivo de propriedades************"); 
//
//   Properties prop = getProp(); 
//   login = prop.getProperty("prop.server.usuario"); 
//   host = prop.getProperty("prop.server.servidor"); 
//   password = prop.getProperty("prop.server.senha");
//   
//   System.out.println("Usuário = " + login); 
//   System.out.println("Servidor = " + host); 
//   System.out.println("Senha = " + password);        

        
//        String dataNascimento = "14/11/1975";
//        
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//
//        DateFormat f = DateFormat.getDateInstance(); 
//        Date data = f.parse(dataNascimento); 
//        
//        System.out.println("Data Nascimento: " + dataNascimento);
//        System.out.println("Data de Nascimento formatada: " + formato.format(data));
//        System.out.println("Data de Nascimento completa: " + data);
//        System.out.println(System.getProperty ("user.timezone"));

//        Propriedades propriedade = new Propriedades();
//        propriedade.setTitle("Lista de Propriedades");
//        propriedade.setLocationRelativeTo(propriedade); //Coloca o jpanel em tamanho relativo.
//        propriedade.setBackground(Color.white);
//        
//        propriedade.setVisible(true);
        
        Principal principal = new Principal();
        
        principal.setTitle("CLOUD Restaurantes - Sistema para Restaurantes");
        principal.setLocationRelativeTo(principal); //Coloca o jpanel em tamanho relativo.
        principal.setBackground(Color.white);
        principal.setExtendedState(principal.MAXIMIZED_BOTH); // Maximiza a tela.
        
        principal.setVisible(true);
        
       
        
//        System.out.println("Sistema Operacional: " + System.getProperty("os.name") + "\n");
//        System.out.println("Java VM: " + System.getProperty("java.vm.vendor") + "\n");
//        System.out.println("País: " + System.getProperty("user.country") + "\n");
//        System.out.println("Codificação: " + System.getProperty("file.encoding") + "\n");
//        System.out.println("Versão Java: " + System.getProperty("java.runtime.version") + "\n");
        
//        System.out.println(System.getProperties());
        // TODO code application logic here
    }
   
    
    
}
