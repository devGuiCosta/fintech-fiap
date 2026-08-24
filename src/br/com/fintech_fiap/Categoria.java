package br.com.fintech_fiap;

/**
 * Representa a categoria usada para classificar os gastos do usuario.
 * Baseado na entidade T_FIN_CATEGORIA do modelo de dados (Fase 3).
 */
public class Categoria {

    private Integer idCategoria;
    private String nome;
    private String tipo;

    // Construtor padrao
    public Categoria() {
    }

    // Construtor com parametros
    public Categoria(Integer idCategoria, String nome, String tipo) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.tipo = tipo;
    }

    // Metodos

    public void cadastrar() {
        System.out.println("Cadastrando a categoria " + nome + " do tipo " + tipo + ".");
    }

    public void editar() {
        System.out.println("Alterando os dados da categoria " + nome + ".");
    }

    public void remover() {
        System.out.println("Removendo a categoria " + nome + " do sistema.");
    }

    public void listarPorTipo() {
        System.out.println("Listando todas as categorias do tipo " + tipo + ".");
    }

    // Getters e Setters

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}