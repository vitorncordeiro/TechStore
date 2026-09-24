package com.techstore.main;

import com.techstore.decorator.*;
import com.techstore.pagamento.*;
import com.techstore.pedido.Calculavel;
import com.techstore.pedido.ItemPedido;
import com.techstore.pedido.Pedido;

public class SimuladorDeCompra {

    public static void main(String[] args) {
        System.out.println("=== CENÁRIO 1: Pedido simples pago via Pix ===");
        cenario1();

        System.out.println("\n=== CENÁRIO 2: Pedido com Frete e Seguro no Cartão ===");
        cenario2();

        System.out.println("\n=== CENÁRIO 3: Pedido com Entrega Expressa e Cupom no Boleto ===");
        cenario3();

        System.out.println("\n=== DEMONSTRAÇÃO STRATEGY: Troca em tempo de execução ===");
        demonstrarTrocaDeStrategy();

        System.out.println("\n=== DEMONSTRAÇÃO DECORATOR: Impacto da ordem dos decoradores ===");
        demonstrarOrdemDecorators();
    }

    private static void cenario1() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido("Teclado", 150.0, 1));
        pedido.adicionarItem(new ItemPedido("Mouse", 80.0, 1));

        FormaPagamento pagamento = new PagamentoPix();
        double valorFinal = pagamento.aplicar(pedido.calcularValor());

        System.out.println("Itens: " + pedido.getDescricao());
        System.out.println("Forma de Pagamento: " + pagamento.getDescricao());
        System.out.printf("Valor final: R$ %.2f%n", valorFinal);
    }

    private static void cenario2() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido("Monitor", 900.0, 1));
        pedido.adicionarItem(new ItemPedido("Cabo HDMI", 50.0, 2));

        Calculavel pedidoDecorado = new TaxaSeguro(new TaxaFrete(pedido));

        FormaPagamento pagamento = new PagamentoCartaoCredito();
        double valorFinal = pagamento.aplicar(pedidoDecorado.calcularValor());

        System.out.println("Pedido decorado: " + pedidoDecorado.getDescricao());
        System.out.println("Forma de Pagamento: " + pagamento.getDescricao());
        System.out.printf("Valor final: R$ %.2f%n", valorFinal);
    }

    private static void cenario3() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido("Notebook", 3500.0, 1));

        Calculavel pedidoDecorado = new DescontoCupom(new TaxaEntregaExpressa(pedido), 200.0);

        FormaPagamento pagamento = new PagamentoBoleto();
        double valorFinal = pagamento.aplicar(pedidoDecorado.calcularValor());

        System.out.println("Pedido decorado: " + pedidoDecorado.getDescricao());
        System.out.println("Forma de Pagamento: " + pagamento.getDescricao());
        System.out.printf("Valor final: R$ %.2f%n", valorFinal);
    }


    private static void demonstrarTrocaDeStrategy() {
        Pedido pedido = new Pedido();
        pedido.adicionarItem(new ItemPedido("Headset Gamer", 400.0, 1));

        double subtotal = pedido.calcularValor();
        System.out.printf("Subtotal do pedido: R$ %.2f%n", subtotal);


        FormaPagamento pagamento = new PagamentoCartaoCredito();
        System.out.printf("Com %s: R$ %.2f%n", pagamento.getDescricao(), pagamento.aplicar(subtotal));


        pagamento = new PagamentoPix();
        System.out.printf("Trocando para %s: R$ %.2f%n", pagamento.getDescricao(), pagamento.aplicar(subtotal));
    }

    private static void demonstrarOrdemDecorators() {
        Pedido pedidoBase = new Pedido();
        pedidoBase.adicionarItem(new ItemPedido("Placa de Vídeo", 2000.0, 1));


        Calculavel ordemA = new TaxaSeguro(new DescontoCupom(pedidoBase, 500.0));


        Calculavel ordemB = new DescontoCupom(new TaxaSeguro(pedidoBase), 500.0);

        System.out.printf("Ordem A (Cupom e depois Seguro 2%%): R$ %.2f (%s)%n",
                ordemA.calcularValor(), ordemA.getDescricao());
        System.out.printf("Ordem B (Seguro 2%% e depois Cupom): R$ %.2f (%s)%n",
                ordemB.calcularValor(), ordemB.getDescricao());
    }
}