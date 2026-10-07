package br.com.fintech_fiap.teste;

import br.com.fintech_fiap.Conta;
import br.com.fintech_fiap.Investimento;
import br.com.fintech_fiap.Receita;
import br.com.fintech_fiap.Usuario;
import br.com.fintech_fiap.dao.ContaDAO;
import br.com.fintech_fiap.dao.InvestimentoDAO;
import br.com.fintech_fiap.dao.ReceitaDAO;
import br.com.fintech_fiap.dao.UsuarioDAO;
import br.com.fintech_fiap.exception.DBException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Teste {

    public static void main(String[] args) {
        List<Usuario> usuarios = testarUsuarios();

        if (usuarios.isEmpty()) {
            System.out.println("\nNenhum usuario cadastrado. Testes das demais entidades interrompidos.");
            return;
        }

        testarContas(usuarios);
        testarReceitas(usuarios);
        testarInvestimentos(usuarios);
    }


    private static List<Usuario> testarUsuarios() {
        titulo("USUARIO");
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> cadastrados = new ArrayList<>();

        String[][] dados = {
                {"Ana Souza", "ana.souza@email.com", "15/03/1998"},
                {"Bruno Lima", "bruno.lima@email.com", "02/07/1995"},
                {"Carla Mendes", "carla.mendes@email.com", "21/11/2000"},
                {"Diego Ferreira", "diego.ferreira@email.com", "09/01/1993"},
                {"Elisa Rocha", "elisa.rocha@email.com", "30/05/2001"}
        };

        try {
            int id = dao.proximoId();
            for (String[] d : dados) {
                // id no e-mail para nao repetir se o teste rodar mais de uma vez
                String email = d[1].replace("@", "." + id + "@");
                Usuario u = new Usuario(id, d[0], email, "senha123", data(d[2]), LocalDate.now());
                try {
                    dao.insert(u);
                    cadastrados.add(u);
                    System.out.println("Cadastrado: " + u.getNome() + " (id " + id + ")");
                } catch (DBException e) {
                    System.err.println(e.getMessage());
                }
                id++;
            }
        } catch (DBException e) {
            System.err.println(e.getMessage());
        }

        try {
            List<Usuario> lista = dao.getAll();
            System.out.println("\nUsuarios no banco (" + lista.size() + "):");
            for (Usuario u : lista) {
                System.out.printf("  #%d | %s | %s | nascimento %s | criado em %s%n",
                        u.getIdUsuario(), u.getNome(), u.getEmail(),
                        u.getDataNascimento(), u.getDataCriacao());
            }
        } catch (DBException e) {
            System.err.println(e.getMessage());
        }
        return cadastrados;
    }


    private static void testarContas(List<Usuario> usuarios) {
        titulo("CONTA");
        ContaDAO dao = new ContaDAO();

        try {
            int id = dao.proximoId();
            Conta[] contas = {
                    new Conta(id, usuario(usuarios, 0), "Nubank", "0001", "12345678-9", "CORRENTE", 2500.00, data("10/01/2022")),
                    new Conta(id + 1, usuario(usuarios, 1), "Itau", "0745", "04512-3", "CORRENTE", 8320.50, data("05/06/2019")),
                    new Conta(id + 2, usuario(usuarios, 2), "Banco do Brasil", "3021", "00789-1", "POUPANCA", 1200.00, data("18/09/2023")),
                    new Conta(id + 3, usuario(usuarios, 3), "Bradesco", "0198", "0034521-7", "CORRENTE", 560.75, data("22/02/2021")),
                    new Conta(id + 4, usuario(usuarios, 4), "Caixa", "1450", "00023456-2", "POUPANCA", 15000.00, data("01/12/2020"))
            };
            for (Conta c : contas) {
                try {
                    dao.insert(c);
                    System.out.println("Cadastrada: conta " + c.getNumeroConta() + " - " + c.getBanco());
                } catch (DBException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (DBException e) {
            System.err.println(e.getMessage());
        }

        try {
            List<Conta> lista = dao.getAll();
            System.out.println("\nContas no banco (" + lista.size() + "):");
            for (Conta c : lista) {
                System.out.printf("  #%d | %s | %s ag %s cc %s | %s | R$ %.2f | aberta em %s%n",
                        c.getIdConta(), c.getUsuario().getNome(), c.getBanco(), c.getAgencia(),
                        c.getNumeroConta(), c.getTipoConta(), c.getSaldo(), c.getDataAbertura());
            }
        } catch (DBException e) {
            System.err.println(e.getMessage());
        }
    }


    private static void testarReceitas(List<Usuario> usuarios) {
        titulo("RECEITA");
        ReceitaDAO dao = new ReceitaDAO();

        try {
            int id = dao.proximoId();
            Receita[] receitas = {
                    new Receita(id, usuario(usuarios, 0), "Salario", 4500.00, data("05/09/2026")),
                    new Receita(id + 1, usuario(usuarios, 0), "Freelance de design", 800.00, data("12/09/2026")),
                    new Receita(id + 2, usuario(usuarios, 1), "Salario", 6200.00, data("05/09/2026")),
                    new Receita(id + 3, usuario(usuarios, 2), "Bolsa de estagio", 1500.00, data("10/09/2026")),
                    new Receita(id + 4, usuario(usuarios, 3), "Venda de usados", 350.00, data("20/09/2026"))
            };
            for (Receita r : receitas) {
                try {
                    dao.insert(r);
                    System.out.println("Cadastrada: " + r.getDescricao() + " - R$ " + r.getValor());
                } catch (DBException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (DBException e) {
            System.err.println(e.getMessage());
        }

        try {
            List<Receita> lista = dao.getAll();
            System.out.println("\nReceitas no banco (" + lista.size() + "):");
            for (Receita r : lista) {
                System.out.printf("  #%d | %s | %s | R$ %.2f | recebida em %s%n",
                        r.getIdReceita(), r.getUsuario().getNome(), r.getDescricao(),
                        r.getValor(), r.getDataRecebimento());
            }
        } catch (DBException e) {
            System.err.println(e.getMessage());
        }
    }


    private static void testarInvestimentos(List<Usuario> usuarios) {
        titulo("INVESTIMENTO");
        InvestimentoDAO dao = new InvestimentoDAO();

        try {
            int id = dao.proximoId();
            Investimento[] investimentos = {
                    new Investimento(id, usuario(usuarios, 0), "Renda Fixa", "CDB 110% CDI", "Nubank", 1000.00, data("15/09/2026"), data("15/09/2028")),
                    new Investimento(id + 1, usuario(usuarios, 1), "Tesouro Direto", "Tesouro Selic 2029", "Tesouro Nacional", 3000.00, data("08/08/2026"), data("01/03/2029")),
                    new Investimento(id + 2, usuario(usuarios, 1), "Renda Variavel", "Acoes ITSA4", "XP Investimentos", 1500.00, data("20/07/2026"), null),
                    new Investimento(id + 3, usuario(usuarios, 2), "Renda Fixa", "LCI 95% CDI", "Banco do Brasil", 2000.00, data("01/09/2026"), data("01/09/2027")),
                    new Investimento(id + 4, usuario(usuarios, 4), "Fundo", "FII HGLG11", "BTG Pactual", 5000.00, data("25/09/2026"), null)
            };
            for (Investimento i : investimentos) {
                try {
                    dao.insert(i);
                    System.out.println("Cadastrado: " + i.getNomeAplicacao() + " - R$ " + i.getValor());
                } catch (DBException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (DBException e) {
            System.err.println(e.getMessage());
        }

        try {
            List<Investimento> lista = dao.getAll();
            System.out.println("\nInvestimentos no banco (" + lista.size() + "):");
            for (Investimento i : lista) {
                System.out.printf("  #%d | %s | %s | %s (%s) | R$ %.2f | %s ate %s%n",
                        i.getIdInvestimento(), i.getUsuario().getNome(), i.getTipo(),
                        i.getNomeAplicacao(), i.getInstituicao(), i.getValor(),
                        i.getDataInvestimento(),
                        i.getDataVencimento() == null ? "sem vencimento" : i.getDataVencimento());
            }
        } catch (DBException e) {
            System.err.println(e.getMessage());
        }
    }


    private static Usuario usuario(List<Usuario> usuarios, int indice) {
        return usuarios.get(indice % usuarios.size());
    }

    private static LocalDate data(String ddMMyyyy) {
        String[] p = ddMMyyyy.split("/");
        return LocalDate.of(Integer.parseInt(p[2]), Integer.parseInt(p[1]), Integer.parseInt(p[0]));
    }

    private static void titulo(String texto) {
        System.out.println("\n========== " + texto + " ==========");
    }
}