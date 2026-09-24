package com.techstore.pagamento;

public class PagamentoBoleto implements FormaPagamento {
    @Override
    public double aplicar(double valor) {
        return valor * 0.95;
    }

    @Override
    public void getDescricao() {
        System.out.println("Forma de pagamento: Boleto Bancário");
    }
}