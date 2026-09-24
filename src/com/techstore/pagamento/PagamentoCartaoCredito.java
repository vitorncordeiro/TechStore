package com.techstore.pagamento;

public class PagamentoCartaoCredito implements FormaPagamento {

    @Override
    public double aplicar(double valor) {
        return valor * 1.02;
    }

    @Override
    public String getDescricao() {
        return "Cartão de Crédito (2% de juros)";
    }
}