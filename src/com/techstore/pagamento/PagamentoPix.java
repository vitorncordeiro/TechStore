package com.techstore.pagamento;

public class PagamentoPix implements FormaPagamento {

    @Override
    public double aplicar(double valor) {
        return valor * 0.90;
    }

    @Override
    public String getDescricao() {
        return "Pix (10% de desconto)";
    }
}