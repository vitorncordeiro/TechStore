package com.techstore.decorator;

import com.techstore.pedido.Calculavel;

public class TaxaSeguro extends PedidoDecorator {

    public TaxaSeguro(Calculavel envolvido) {
        super(envolvido);
    }

    @Override
    public double calcularValor() {
        return envolvido.calcularValor() + envolvido.calcularValor() * 0.02;
    }

    @Override
    public String getDescricao() {
        return envolvido.getDescricao() + " + Seguro de Transporte";
    }
}

