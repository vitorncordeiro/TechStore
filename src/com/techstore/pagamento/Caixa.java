package com.techstore.pagamento;

import com.techstore.pedido.Calculavel;

public class Caixa {

    private FormaPagamento formaPagamento;

    public Caixa(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public double finalizar(Calculavel pedido) {
        return formaPagamento.aplicar(pedido.calcularValor());
    }
}
