package br.com.fintech_fiap;

import java.time.LocalDate;

/**
 * Representa o usuario do sistema Fintech.
 * Baseado na entidade T_FIN_USUARIO do modelo de dados (Fase 3).
 */
public class Usuario {

    private Integer idUsuario;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private LocalDate dataCriacao;

    // Construtor padrao
    public Usuario() {
    }

    // Construtor com parametros
    public Usuario(Integer idUsuario, String nome, String email, String senha,
            LocalDate dataNascimento, LocalDate dataCriacao) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.dataCriacao = dataCriacao;
    }

    // Metodos

    public void cadastrar() {
        System.out.println("Cadastrando o usuario " + nome + " no sistema com o email " + email + ".");
    }

    public void visualizarPerfil() {
        System.out.println("Exibindo os dados cadastrais do usuario " + nome + ".");
    }

    public void atualizarDados() {
        System.out.println("Atualizando as informacoes de perfil do usuario " + nome + ".");
    }

    public void alterarSenha() {
        System.out.println("Alterando a senha de acesso do usuario " + nome + ".");
    }

    // Getters e Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}