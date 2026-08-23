package br.com.fintech_fiap;

public class Cliente {
    private String nome;
    private int cpf;
    private int idade;
    private String email;
    private int telefone;


    //Construtor sem parâmetro
    public Cliente(){

    }

    //Construtor com parâmetro
    public Cliente(String nome,int cpf, int idade, String email, int telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.email = email;
        this.telefone = telefone;
    }

    //Métodos
    public void consultarDados(){
        System.out.println("Exibindo dados do "+nome);
    }

    public void atualizarCadastro(){
        System.out.println("Atualizando os dados de cadastro do "+ nome);
    }

    public void consultarConta(){
        System.out.println("Consultando os dado da conta do "+ nome);
    }
}
