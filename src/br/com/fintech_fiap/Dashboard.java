package br.com.fintech_fiap;

/**
 * Consolida o resumo financeiro do usuario.
 * Baseado no caso de uso UC24 - Visualizar Dashboard (Fase 2).
 */
public class Dashboard {

    private Usuario usuario;
    private Double totalReceitas;
    private Double totalGastos;
    private Double saldoAtual;
    private Double totalInvestido;
    private Integer mesReferencia;
    private Integer anoReferencia;

    // Construtor padrao
    public Dashboard() {
    }

    // Construtor com parametros
    public Dashboard(Usuario usuario, Double totalReceitas, Double totalGastos, Double saldoAtual,
            Double totalInvestido, Integer mesReferencia, Integer anoReferencia) {
        this.usuario = usuario;
        this.totalReceitas = totalReceitas;
        this.totalGastos = totalGastos;
        this.saldoAtual = saldoAtual;
        this.totalInvestido = totalInvestido;
        this.mesReferencia = mesReferencia;
        this.anoReferencia = anoReferencia;
    }

    // Metodos

    public void calcularTotalReceitas() {
        System.out.println("Somando todas as receitas do mes " + mesReferencia + "/" + anoReferencia + ".");
    }

    public void calcularTotalGastos() {
        System.out.println("Somando todos os gastos do mes " + mesReferencia + "/" + anoReferencia + ".");
    }

    public void calcularSaldo() {
        System.out.println("Calculando o saldo do periodo pela diferenca entre receitas e gastos.");
    }

    public void exibirUltimoGasto() {
        System.out.println("Buscando o gasto mais recente registrado pelo usuario.");
    }

    public void exibirResumo() {
        System.out.println("Exibindo os cards e graficos com o resumo financeiro do usuario.");
    }

    // Getters e Setters

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getTotalReceitas() {
        return totalReceitas;
    }

    public void setTotalReceitas(Double totalReceitas) {
        this.totalReceitas = totalReceitas;
    }

    public Double getTotalGastos() {
        return totalGastos;
    }

    public void setTotalGastos(Double totalGastos) {
        this.totalGastos = totalGastos;
    }

    public Double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(Double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public Double getTotalInvestido() {
        return totalInvestido;
    }

    public void setTotalInvestido(Double totalInvestido) {
        this.totalInvestido = totalInvestido;
    }

    public Integer getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(Integer mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public Integer getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(Integer anoReferencia) {
        this.anoReferencia = anoReferencia;
    }
}