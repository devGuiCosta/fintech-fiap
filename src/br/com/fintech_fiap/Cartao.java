package br.com.fintech_fiap;

public class Cartao {

    private String numero;
    private String nomeTitular;
    private String validade;
    private Double limite;
    private String tipoCartao;

    // Construtor sem parâmetro
    public Cartao() {

    }

    // Construtor com parâmetros
    public Cartao(String numero, String nomeTitular, String validade, Double limite, String tipoCartao) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.validade = validade;
        this.limite = limite;
        this.tipoCartao = tipoCartao;
    }

    // Métodos
    public void consultarLimite() {
        System.out.println("Método consultarLimite() executado.");
    }

    public void realizarCompra() {
        System.out.println("Método realizarCompra() executado.");
    }

    public void bloquearCartao() {
        System.out.println("Método bloquearCartao() executado.");
    }
}