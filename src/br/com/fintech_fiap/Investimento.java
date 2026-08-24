package br.com.fintech_fiap;

import java.time.LocalDate;

/**
 * Representa uma aplicacao financeira registrada pelo usuario.
 * Baseado na entidade T_FIN_INVESTIMENTOS do modelo de dados (Fase 3).
 */
public class Investimento {

    private Integer idInvestimento;
    private Usuario usuario;
    private String tipo;
    private String nomeAplicacao;
    private String instituicao;
    private Double valor;
    private LocalDate dataInvestimento;
    private LocalDate dataVencimento;

    // Construtor padrao
    public Investimento() {
    }

    // Construtor com parametros
    public Investimento(Integer idInvestimento, Usuario usuario, String tipo, String nomeAplicacao,
            String instituicao, Double valor, LocalDate dataInvestimento,
            LocalDate dataVencimento) {
        this.idInvestimento = idInvestimento;
        this.usuario = usuario;
        this.tipo = tipo;
        this.nomeAplicacao = nomeAplicacao;
        this.instituicao = instituicao;
        this.valor = valor;
        this.dataInvestimento = dataInvestimento;
        this.dataVencimento = dataVencimento;
    }

    // Metodos

    public void adicionar() {
        System.out.println("Registrando o investimento em " + nomeAplicacao + " no valor de R$ " + valor + ".");
    }

    public void editar() {
        System.out.println("Alterando os dados da aplicacao " + nomeAplicacao + ".");
    }

    public void remover() {
        System.out.println("Excluindo o investimento em " + nomeAplicacao + " do sistema.");
    }

    public void listar() {
        System.out.println("Listando todos os investimentos do usuario e suas instituicoes.");
    }

    public void calcularRendimento() {
        System.out.println("Calculando o rendimento previsto da aplicacao " + nomeAplicacao
                + " ate a data de vencimento.");
    }

    // Getters e Setters

    public Integer getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Integer idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeAplicacao() {
        return nomeAplicacao;
    }

    public void setNomeAplicacao(String nomeAplicacao) {
        this.nomeAplicacao = nomeAplicacao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataInvestimento() {
        return dataInvestimento;
    }

    public void setDataInvestimento(LocalDate dataInvestimento) {
        this.dataInvestimento = dataInvestimento;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
