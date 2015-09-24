/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import br.com.cloudrestaurant.interfaces.EstoqueUI;

/**
 *
 * @author Debug
 */
public class Estoque implements EstoqueUI {
    
    private int idEstoque;
    private int quantidade;
    private int qtdeInicial;
    private String dataCompra;
    private int codPedido;

    public int getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(int idEstoque) {
        this.idEstoque = idEstoque;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQtdeInicial() {
        return qtdeInicial;
    }

    public void setQtdeInicial(int qtdeInicial) {
        this.qtdeInicial = qtdeInicial;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }
    
    @Override
    public void incluiEstoque(){
        
    }
    
    @Override
    public void alteraEstoque(){
        
    }
    
    @Override
    public void excluiEstoque(){
        
    }
    
    @Override
    public void consultaEstoque(){
        
    }    
    
    
}
