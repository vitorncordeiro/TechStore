package com.techstore.pagamento;

public class PagamentoCartaoCredito implements FormaPagamento {

    @Override
    public double aplicar(double valor) {
        return valor * 1.2;
    }

    @Override
    public void getDescricao() {
        System.out.println("Forma de pagamento: Cartão de Crédito");
    }
}