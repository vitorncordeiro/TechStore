package com.techstore.decorator;

import com.techstore.pedido.Calculavel;

public abstract class PedidoDecorator implements Calculavel {

    protected Calculavel envolvido;

    public PedidoDecorator(Calculavel envolvido) {
        this.envolvido = envolvido;
    }
}
