package br.com.fintech_fiap;

import java.time.LocalDate;

public class Receita {

    private Integer idReceita;
    private Usuario usuario;
    private String descricao;
    private Double valor;
    private LocalDate dataRecebimento;

    // Construtor padrao
    public Receita() {
    }

    // Construtor com parametros
    public Receita(Integer idReceita, Usuario usuario, String descricao,
            Double valor, LocalDate dataRecebimento) {
        this.idReceita = idReceita;
        this.usuario = usuario;
        this.descricao = descricao;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
    }

    // Metodos

    public void adicionar() {
        System.out.println("Registrando a receita '" + descricao + "' no valor de R$ " + valor + ".");
    }

    public void editar() {
        System.out.println("Alterando os dados da receita '" + descricao + "'.");
    }

    public void remover() {
        System.out.println("Excluindo a receita '" + descricao + "' do sistema.");
    }

    public void listar() {
        System.out.println("Listando todas as receitas do usuario, ordenadas pela data de recebimento.");
    }

    // Getters e Setters

    public Integer getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Integer idReceita) {
        this.idReceita = idReceita;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }
}
