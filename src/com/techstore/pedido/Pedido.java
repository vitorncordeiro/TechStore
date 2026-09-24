package com.techstore.pedido;
import java.util.ArrayList;
import java.util.List;


public class Pedido implements Calculavel {

    private List<ItemPedido> itens;

    public Pedido() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    @Override
    public double calcularValor() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    @Override
    public String getDescricao() {
        return "Pedido com " + itens.size() + " item(ns)";
    }
}

