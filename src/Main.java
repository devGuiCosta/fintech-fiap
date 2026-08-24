import java.time.LocalDate;

import br.com.fintech_fiap.Categoria;
import br.com.fintech_fiap.Dashboard;
import br.com.fintech_fiap.Gasto;
import br.com.fintech_fiap.Investimento;
import br.com.fintech_fiap.Objetivo;
import br.com.fintech_fiap.Receita;
import br.com.fintech_fiap.Usuario;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== SISTEMA FINTECH =====\n");

        // Usuario
        Usuario usuario = new Usuario(
                1,
                "Marcos Guilherme",
                "gui@email.com",
                "senhaSegura123",
                LocalDate.of(2004, 3, 15),
                LocalDate.now());

        System.out.println("--- Usuario ---");
        usuario.cadastrar();
        usuario.visualizarPerfil();
        usuario.atualizarDados();
        usuario.alterarSenha();

        // Categoria
        Categoria categoria = new Categoria(1, "Alimentacao", "GASTO");

        System.out.println("\n--- Categoria ---");
        categoria.cadastrar();
        categoria.editar();
        categoria.listarPorTipo();
        categoria.remover();

        // Receita
        Receita receita = new Receita(
                1,
                usuario,
                "Salario mensal",
                3500.00,
                LocalDate.of(2026, 8, 5));

        System.out.println("\n--- Receita ---");
        receita.adicionar();
        receita.listar();
        receita.editar();
        receita.remover();

        // Gasto
        Gasto gasto = new Gasto(
                1,
                usuario,
                categoria,
                "Supermercado",
                420.75,
                LocalDate.of(2026, 8, 12));

        System.out.println("\n--- Gasto ---");
        gasto.adicionar();
        gasto.classificarPorCategoria();
        gasto.listar();
        gasto.editar();
        gasto.remover();

        // Investimento
        Investimento investimento = new Investimento(
                1,
                usuario,
                "Renda Fixa",
                "CDB 110% CDI",
                "Banco XP",
                1000.00,
                LocalDate.of(2026, 8, 1),
                LocalDate.of(2027, 8, 1));

        System.out.println("\n--- Investimento ---");
        investimento.adicionar();
        investimento.calcularRendimento();
        investimento.listar();
        investimento.editar();
        investimento.remover();

        // Objetivo
        Objetivo objetivo = new Objetivo(
                1,
                usuario,
                "Viagem de ferias",
                "Juntar dinheiro para viajar em dezembro",
                5000.00,
                LocalDate.of(2026, 12, 20));

        System.out.println("\n--- Objetivo ---");
        objetivo.adicionar();
        objetivo.verificarProgresso();
        objetivo.listar();
        objetivo.editar();
        objetivo.remover();

        // Dashboard
        Dashboard dashboard = new Dashboard(
                usuario,
                3500.00,
                420.75,
                3079.25,
                1000.00,
                8,
                2026);

        System.out.println("\n--- Dashboard ---");
        dashboard.calcularTotalReceitas();
        dashboard.calcularTotalGastos();
        dashboard.calcularSaldo();
        dashboard.exibirUltimoGasto();
        dashboard.exibirResumo();

        System.out.println("\n===== FIM DA DEMONSTRACAO =====");
    }
}