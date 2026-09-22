package com.techstore.pagamento;

public class PagamentoDinheiro implements FormaPagamento {

    @Override
    public double aplicar(double valor) {
        return valor;
    }

    @Override
    public void getDescricao() {
        System.out.println("Forma de pagamento: Dinheiro");
    }
}