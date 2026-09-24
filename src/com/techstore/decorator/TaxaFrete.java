package com.techstore.decorator;

import com.techstore.pedido.Calculavel;

public class TaxaFrete extends PedidoDecorator {

    public TaxaFrete(Calculavel envolvido) {
        super(envolvido);
    }

    @Override
    public double calcularValor() {
        return envolvido.calcularValor() + 20.0;
    }

    @Override
    public String getDescricao() {
        return envolvido.getDescricao() + " + Frete";
    }
}

