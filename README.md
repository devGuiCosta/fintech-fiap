# Projeto Fintech - Fase 5 (Programacao Orientada a Objetos)

Modelagem das classes do sistema Fintech em Java, alinhada ao modelo logico
e aos casos de uso definidos nas fases anteriores do projeto.

## Estrutura

```
src/br/com/fiap/fintech/
├── Usuario.java        - dados cadastrais e acesso do usuario
├── Categoria.java      - classificacao dos gastos
├── Receita.java        - entradas de dinheiro
├── Gasto.java          - saidas de dinheiro
├── Investimento.java   - aplicacoes financeiras
├── Objetivo.java       - metas financeiras
├── Dashboard.java      - resumo financeiro consolidado
└── Main.java           - demonstracao das classes
```

## Rastreabilidade com as fases anteriores

| Classe        | Entidade (Fase 3)   | Casos de uso (Fase 2)  |
|---------------|---------------------|------------------------|
| Usuario       | T_FIN_USUARIO       | UC01, UC04, UC06, UC07 |
| Categoria     | T_FIN_CATEGORIA     | UC09                   |
| Receita       | T_FIN_RECEITA       | UC12 a UC15            |
| Gasto         | T_FIN_GASTOS        | UC08 a UC11            |
| Investimento  | T_FIN_INVESTIMENTOS | UC16 a UC19            |
| Objetivo      | T_FIN_OBJETIVO      | UC20 a UC23            |
| Dashboard     | (agregacao)         | UC24                   |

## Integrantes

| Integrante                              | RM     |
|-----------------------------------------|--------|
| Marcos Guilherme de Freitas Costa        | 573771 |
| Yohana Amorim Costa                      | 573919 |
| Francisco André Pietro Lopes Bandeira    | 572044 |

## Como executar

```bash
javac -d out $(find src -name "*.java")
java -cp out br.com.fiap.fintech.Main
```

Requer JDK 17 ou superior.