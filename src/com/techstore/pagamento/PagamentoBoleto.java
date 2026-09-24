package com.techstore.pagamento;

public class PagamentoBoleto implements FormaPagamento {

    @Override
    public double aplicar(double valor) {
        return valor * 0.95;
    }

    @Override
    public String getDescricao() {
        return "Boleto Bancário (5% de desconto)";
    }
}