package br.com.fintech_fiap;

public class Transacao {

    private Integer id;
    private String tipo;
    private Double valor;
    private String data;
    private String descricao;

    // Construtor sem parâmetro
    public Transacao() {

    }

    // Construtor com parâmetros
    public Transacao(Integer id, String tipo, Double valor, String data, String descricao) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    // Métodos
    public void realizarPix() {
        System.out.println("Método realizarPix() executado.");
    }

    public void realizarPagamento() {
        System.out.println("Método realizarPagamento() executado.");
    }

    public void realizarTransferencia() {
        System.out.println("Método realizarTransferencia() executado.");
    }
}