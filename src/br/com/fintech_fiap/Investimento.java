package br.com.fintech_fiap;

public class Investimento {

    private Integer id;
    private String tipo;
    private Double valorInvestido;
    private Double rentabilidade;
    private String dataAplicacao;

    // Construtor sem parâmetro
    public Investimento() {

    }

    // Construtor com parâmetros
    public Investimento(Integer id, String tipo, Double valorInvestido, Double rentabilidade, String dataAplicacao) {
        this.id = id;
        this.tipo = tipo;
        this.valorInvestido = valorInvestido;
        this.rentabilidade = rentabilidade;
        this.dataAplicacao = dataAplicacao;
    }

    // Métodos
    public void realizarInvestimento() {
        System.out.println("Método realizarInvestimento() executado.");
    }

    public void consultarInvestimento() {
        System.out.println("Método consultarInvestimento() executado.");
    }

    public void resgatarInvestimento() {
        System.out.println("Método resgatarInvestimento() executado.");
    }
}