package br.com.fintech_fiap.exception;

import java.sql.SQLException;


public class DBException extends Exception {

    public DBException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public static String traduzir(SQLException e) {
        return switch (e.getErrorCode()) {
            case 942 -> "Tabela ou view inexistente (ORA-00942). Verifique se a tabela foi criada.";
            case 1 -> "Registro duplicado: ja existe um registro com esta chave (ORA-00001).";
            case 2291 -> "Chave estrangeira invalida: o registro pai nao existe (ORA-02291).";
            case 1400 -> "Campo obrigatorio nao informado (ORA-01400).";
            case 1017 -> "Usuario ou senha do banco invalidos (ORA-01017).";
            case 12541, 12514, 12505, 17002 ->
                    "Banco de dados indisponivel ou inacessivel. Verifique a rede e o endereco do servidor.";
            default -> "Erro de banco de dados (codigo " + e.getErrorCode() + "): " + e.getMessage();
        };
    }
}