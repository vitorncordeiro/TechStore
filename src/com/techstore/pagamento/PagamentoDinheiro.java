package com.techstore.pagamento;

public class PagamentoDinheiro implements FormaPagamento {

    @Override
    public double aplicar(double valor) {
        return valor;
    }

    @Override
    public String getDescricao() {
        return "Dinheiro (sem alteração de valor)";
    }
}