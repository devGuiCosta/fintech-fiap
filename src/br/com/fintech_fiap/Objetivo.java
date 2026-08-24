package br.com.fintech_fiap;

import java.time.LocalDate;

/**
 * Representa uma meta financeira definida pelo usuario.
 * Baseado na entidade T_FIN_OBJETIVO do modelo de dados (Fase 3).
 */
public class Objetivo {

    private Integer idObjetivo;
    private Usuario usuario;
    private String nome;
    private String descricao;
    private Double valorAlvo;
    private LocalDate dataObjetivo;

    // Construtor padrao
    public Objetivo() {
    }

    // Construtor com parametros
    public Objetivo(Integer idObjetivo, Usuario usuario, String nome, String descricao,
            Double valorAlvo, LocalDate dataObjetivo) {
        this.idObjetivo = idObjetivo;
        this.usuario = usuario;
        this.nome = nome;
        this.descricao = descricao;
        this.valorAlvo = valorAlvo;
        this.dataObjetivo = dataObjetivo;
    }

    // Metodos

    public void adicionar() {
        System.out.println("Criando o objetivo '" + nome + "' com meta de R$ " + valorAlvo + ".");
    }

    public void editar() {
        System.out.println("Alterando os dados do objetivo '" + nome + "'.");
    }

    public void remover() {
        System.out.println("Excluindo o objetivo '" + nome + "' do sistema.");
    }

    public void listar() {
        System.out.println("Listando todos os objetivos financeiros do usuario.");
    }

    public void verificarProgresso() {
        System.out.println("Comparando o valor ja acumulado com a meta de R$ " + valorAlvo
                + " do objetivo '" + nome + "'.");
    }

    // Getters e Setters

    public Integer getIdObjetivo() {
        return idObjetivo;
    }

    public void setIdObjetivo(Integer idObjetivo) {
        this.idObjetivo = idObjetivo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorAlvo() {
        return valorAlvo;
    }

    public void setValorAlvo(Double valorAlvo) {
        this.valorAlvo = valorAlvo;
    }

    public LocalDate getDataObjetivo() {
        return dataObjetivo;
    }

    public void setDataObjetivo(LocalDate dataObjetivo) {
        this.dataObjetivo = dataObjetivo;
    }
}