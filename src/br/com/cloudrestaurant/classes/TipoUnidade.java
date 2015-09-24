/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.cloudrestaurant.classes;

import br.com.cloudrestaurant.interfaces.TipoUnidadeUI;

/**
 *
 * @author Debug
 */
public class TipoUnidade implements TipoUnidadeUI{
    
    private int idTipoUnidade;
    private String nome;

    public int getIdTipoUnidade() {
        return idTipoUnidade;
    }

    public void setIdTipoUnidade(int idTipoUnidade) {
        this.idTipoUnidade = idTipoUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public void cadastraTipoUnidade(){
        
    }
    
    @Override
    public void alteraTipoUnidade(){
        
    }
    
    @Override
    public void excluiTipoUnidade(){
        
    }
    
    @Override
    public void consultaTipoUnidade(){
        
    }    
    
}
