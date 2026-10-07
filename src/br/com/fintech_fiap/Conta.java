package br.com.fintech_fiap;

import java.time.LocalDate;


public class Conta {

    private Integer idConta;
    private Usuario usuario;
    private String banco;
    private String agencia;
    private String numeroConta;
    private String tipoConta;
    private Double saldo;
    private LocalDate dataAbertura;

    public Conta() {
    }

    public Conta(Integer idConta, Usuario usuario, String banco, String agencia,
                 String numeroConta, String tipoConta, Double saldo, LocalDate dataAbertura) {
        this.idConta = idConta;
        this.usuario = usuario;
        this.banco = banco;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
    }


    public void consultarSaldo() {
        System.out.println("Saldo da conta " + numeroConta + " (" + banco + "): R$ " + saldo + ".");
    }


    public Integer getIdConta() {
        return idConta;
    }

    public void setIdConta(Integer idConta) {
        this.idConta = idConta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
}