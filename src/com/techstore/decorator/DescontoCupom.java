package com.techstore.decorator;

import com.techstore.pedido.Calculavel;

public class DescontoCupom extends PedidoDecorator {

    private double desconto;

    public DescontoCupom(Calculavel envolvido, double desconto) {
        super(envolvido);
        this.desconto = desconto;
    }

    @Override
    public double calcularValor() {
        return envolvido.calcularValor() - desconto;
    }

    @Override
    public String getDescricao() {
        return envolvido.getDescricao() + " - Cupom de Desconto (R$ " + desconto + ")";
    }
}

