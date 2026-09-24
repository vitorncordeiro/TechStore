package com.techstore.decorator;

import com.techstore.pedido.Calculavel;

public class TaxaEntregaExpressa extends PedidoDecorator {

    public TaxaEntregaExpressa(Calculavel envolvido) {
        super(envolvido);
    }

    @Override
    public double calcularValor() {
        return envolvido.calcularValor() + 35.0;
    }

    @Override
    public String getDescricao() {
        return envolvido.getDescricao() + " + Entrega Expressa";
    }
}

