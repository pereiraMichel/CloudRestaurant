/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import br.com.cloudrestaurant.interfaces.PedidoFornecedorUI;

/**
 *
 * @author Debug
 */
public class pedidoFornecedores implements PedidoFornecedorUI {

    private int idPedidoFornecedor;
    private int quantidade;
    private double valorTotal;
    private int codFrete;
    private int codFornecedor;
    private int codTipoProduto;

    public int getIdPedidoFornecedor() {
        return idPedidoFornecedor;
    }

    public void setIdPedidoFornecedor(int idPedidoFornecedor) {
        this.idPedidoFornecedor = idPedidoFornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getCodFrete() {
        return codFrete;
    }

    public void setCodFrete(int codFrete) {
        this.codFrete = codFrete;
    }

    public int getCodFornecedor() {
        return codFornecedor;
    }

    public void setCodFornecedor(int codFornecedor) {
        this.codFornecedor = codFornecedor;
    }

    public int getCodTipoProduto() {
        return codTipoProduto;
    }

    public void setCodTipoProduto(int codTipoProduto) {
        this.codTipoProduto = codTipoProduto;
    }
    
    
    @Override
    public void cadastraPedidoFornecedor(){
        
    }
    
    @Override
    public void alteraPedidoFornecedor(){
        
    }
    
    @Override
    public void excluiPedidoFornecedor(){
        
    }
    
    @Override
    public void consultaPedidoFornecedor(){
        
    }
    
    @Override
    public void cancelaPedidoFornecedor(){
        
    }    
    
}
