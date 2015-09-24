/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import br.com.cloudrestaurant.interfaces.TipoProdutoUI;

/**
 *
 * @author Debug
 */
public class TipoProduto implements TipoProdutoUI{
    
    private int idTipoProduto;
    private String nome;

    public int getIdTipoProduto() {
        return idTipoProduto;
    }

    public void setIdTipoProduto(int idTipoProduto) {
        this.idTipoProduto = idTipoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void cadastroTipoProduto(){
        
    }
    
    @Override
    public void alteraTipoProduto(){
        
    }
    
    @Override
    public void excluiTipoProduto(){
        
    }
    
    @Override
    public void consultaTipoProduto(){
        
    }    
    
    
}
