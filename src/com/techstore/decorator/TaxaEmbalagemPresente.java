package com.techstore.decorator;

import com.techstore.pedido.Calculavel;

public class TaxaEmbalagemPresente extends PedidoDecorator {

    public TaxaEmbalagemPresente(Calculavel envolvido) {
        super(envolvido);
    }

    @Override
    public double calcularValor() {
        return envolvido.calcularValor() + 10.0;
    }

    @Override
    public String getDescricao() {
        return envolvido.getDescricao() + " + Embalagem para Presente";
    }
}

