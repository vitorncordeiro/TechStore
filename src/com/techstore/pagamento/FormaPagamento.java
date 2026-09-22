package com.techstore.pagamento;

public interface FormaPagamento {
    double aplicar(double valor);
    void getDescricao();
}
