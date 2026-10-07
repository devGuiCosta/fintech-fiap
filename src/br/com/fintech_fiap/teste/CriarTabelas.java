package br.com.fintech_fiap.teste;

import br.com.fintech_fiap.exception.DBException;
import br.com.fintech_fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CriarTabelas {

    public static void main(String[] args) {
        String[] comandos = {
                "CREATE TABLE T_FIN_USUARIO ("
                        + " id_usuario NUMBER NOT NULL,"
                        + " nome VARCHAR2(100) NOT NULL,"
                        + " email VARCHAR2(100) NOT NULL,"
                        + " dt_nascimento DATE NOT NULL,"
                        + " senha VARCHAR2(100) NOT NULL,"
                        + " dt_criacao DATE DEFAULT SYSDATE NOT NULL,"
                        + " CONSTRAINT pk_usuario PRIMARY KEY (id_usuario),"
                        + " CONSTRAINT uk_usuario_email UNIQUE (email))",

                "CREATE TABLE T_FIN_CATEGORIA ("
                        + " id_categoria NUMBER NOT NULL,"
                        + " nome VARCHAR2(50) NOT NULL,"
                        + " tipo VARCHAR2(20) NOT NULL,"
                        + " CONSTRAINT pk_categoria PRIMARY KEY (id_categoria))",

                "CREATE TABLE T_FIN_CONTA ("
                        + " id_conta NUMBER NOT NULL,"
                        + " id_usuario NUMBER NOT NULL,"
                        + " banco VARCHAR2(100) NOT NULL,"
                        + " agencia VARCHAR2(10) NOT NULL,"
                        + " numero_conta VARCHAR2(20) NOT NULL,"
                        + " tipo_conta VARCHAR2(20) NOT NULL,"
                        + " saldo NUMBER(10,2) DEFAULT 0,"
                        + " dt_abertura DATE NOT NULL,"
                        + " CONSTRAINT pk_conta PRIMARY KEY (id_conta),"
                        + " CONSTRAINT fk_conta_usuario FOREIGN KEY (id_usuario) REFERENCES T_FIN_USUARIO (id_usuario))",

                "CREATE TABLE T_FIN_RECEITA ("
                        + " id_receita NUMBER NOT NULL,"
                        + " id_usuario NUMBER NOT NULL,"
                        + " valor NUMBER(10,2) NOT NULL,"
                        + " descricao VARCHAR2(200),"
                        + " data_recebimento DATE NOT NULL,"
                        + " CONSTRAINT pk_receita PRIMARY KEY (id_receita),"
                        + " CONSTRAINT fk_receita_usuario FOREIGN KEY (id_usuario) REFERENCES T_FIN_USUARIO (id_usuario))",

                "CREATE TABLE T_FIN_GASTOS ("
                        + " id_gasto NUMBER NOT NULL,"
                        + " id_usuario NUMBER NOT NULL,"
                        + " id_categoria NUMBER NOT NULL,"
                        + " descricao VARCHAR2(200),"
                        + " valor NUMBER(10,2) NOT NULL,"
                        + " data_gasto DATE NOT NULL,"
                        + " CONSTRAINT pk_gastos PRIMARY KEY (id_gasto),"
                        + " CONSTRAINT fk_gastos_usuario FOREIGN KEY (id_usuario) REFERENCES T_FIN_USUARIO (id_usuario),"
                        + " CONSTRAINT fk_gastos_categoria FOREIGN KEY (id_categoria) REFERENCES T_FIN_CATEGORIA (id_categoria))",

                "CREATE TABLE T_FIN_INVESTIMENTOS ("
                        + " id_investimentos NUMBER NOT NULL,"
                        + " id_usuario NUMBER NOT NULL,"
                        + " tipo VARCHAR2(50) NOT NULL,"
                        + " nome_aplicacao VARCHAR2(100) NOT NULL,"
                        + " instituicao VARCHAR2(100) NOT NULL,"
                        + " valor NUMBER(12,2) NOT NULL,"
                        + " dt_investimento DATE NOT NULL,"
                        + " dt_vencimento DATE,"
                        + " CONSTRAINT pk_investimentos PRIMARY KEY (id_investimentos),"
                        + " CONSTRAINT fk_invest_usuario FOREIGN KEY (id_usuario) REFERENCES T_FIN_USUARIO (id_usuario))"
        };

        try (Connection conexao = ConnectionFactory.getConnection();
             Statement stmt = conexao.createStatement()) {

            System.out.println("Conectado ao Oracle da FIAP.\n");

            for (String sql : comandos) {
                String nomeTabela = sql.split(" ")[2];
                try {
                    stmt.execute(sql);
                    System.out.println("Criada:    " + nomeTabela);
                } catch (SQLException e) {
                    if (e.getErrorCode() == 955) {
                        System.out.println("Ja existe: " + nomeTabela);
                    } else {
                        System.err.println("Erro em " + nomeTabela + ": " + DBException.traduzir(e));
                    }
                }
            }

        } catch (DBException e) {
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(DBException.traduzir(e));
        }
    }
}