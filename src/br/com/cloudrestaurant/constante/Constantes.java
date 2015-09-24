/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.constante;

/**
 *
 * @author Debug
 */
public class Constantes {
    
    //Nome do sistema
    public static final String SISTEMA = "Cloud Restaurant";
    
    // Graphic for JOptionPane.showMessageDialog
    public static final int LIMPA = -1;
    public static final int ERROR = 0;
    public static final int SUCESSO = 1;
    public static final int ALERTA = 2;
    public static final int INTERROGACAO = 3;
    
    //Mensagens de confirmação
    public static final String EXCLUSAO = "Deseja excluir? Todas as informações serão perdidas!";
    public static final String ALTERACAO = "Confirma as alterações?";
    public static final String CONFIRMPEDIDO = "Deseja efetuar algum pedido?";
    
    //Mensagens de inclusão, alteração e exclusão
    
    public static final String SUCSAL = "Salvo com sucesso!";
    public static final String SUCCAD = "Gravado com sucesso!";
    public static final String SUCALT = "Alterado com sucesso!";
    public static final String SUCEXC = "Excluído com sucesso!";
    
    //Mensagens de erro
    
    public static final String ERROSAL = "Problemas ao Salvar. ";
    public static final String ERROCAD = "Problemas ao cadastrar. ";
    public static final String ERROALT = "Problemas ao alterar. ";
    public static final String ERROEXC = "Problemas ao excluir. ";
    public static final String ERROCONS = "Problemas na consulta. ";
    public static final String ERROUSER = "Usuário ou senha inválidos.";
    
    /*
    
PLAIN_MESSAGE (valor: -1): Mensagem limpa, sem nenhum ícone.
ERROR_MESSAGE (valor: 0): Mensagem de erro.
INFORMATION_MESSAGE (valor: 1): Mensagem informativa.
WARNING_MESSAGE (valor: 2): Mensagem de alerta.
QUESTION_MESSAGE (valor: 3): Mensagem de requisição ou pergunta. Esta é a opção padrão do método showInputDialog()    
    
    
    */
}
