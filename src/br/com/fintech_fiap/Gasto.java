package br.com.fintech_fiap;

import java.time.LocalDate;

public class Gasto {

    private Integer idGasto;
    private Usuario usuario;
    private Categoria categoria;
    private String descricao;
    private Double valor;
    private LocalDate dataGasto;

    // Construtor padrao
    public Gasto() {
    }

    // Construtor com parametros
    public Gasto(Integer idGasto, Usuario usuario, Categoria categoria,
            String descricao, Double valor, LocalDate dataGasto) {
        this.idGasto = idGasto;
        this.usuario = usuario;
        this.categoria = categoria;
        this.descricao = descricao;
        this.valor = valor;
        this.dataGasto = dataGasto;
    }

    // Metodos

    public void adicionar() {
        System.out.println("Registrando o gasto '" + descricao + "' no valor de R$ " + valor + ".");
    }

    public void editar() {
        System.out.println("Alterando os dados do gasto '" + descricao + "'.");
    }

    public void remover() {
        System.out.println("Excluindo o gasto '" + descricao + "' do sistema.");
    }

    public void listar() {
        System.out.println("Listando todos os gastos do usuario, do mais recente para o mais antigo.");
    }

    public void classificarPorCategoria() {
        System.out.println("Vinculando o gasto '" + descricao + "' a uma categoria para o relatorio financeiro.");
    }

    // Getters e Setters

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(LocalDate dataGasto) {
        this.dataGasto = dataGasto;
    }
}