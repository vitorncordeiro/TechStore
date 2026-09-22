package com.techstore.pagamento;

public class PagamentoPix implements FormaPagamento {

    @Override
    public double aplicar(double valor) {
        return valor * 0.9;
    }

    @Override
    public void getDescricao() {
        System.out.println("Forma de pagamento: Pix");
    }
}