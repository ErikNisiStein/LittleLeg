package com.example.projetolittleleg;

import java.util.ArrayList;

public class DAO {

    public DAO(){

    }

    public Produto criarProduto(Produto prod){
        // TODO - Criar item no BD
        return prod;
    }

    public void removerProduto(Produto prod){
        // TODO - Remover produto do BD
    }

    public void alterarProduto(Produto prod){
        // TODO - Alterar produto no BD
    }

    public ArrayList<Produto> obterListaProdutos(){
        ArrayList<Produto> produtos = new ArrayList<>();
        // TODO - Obter lista de produtos no BD
        return produtos;
    }
}
