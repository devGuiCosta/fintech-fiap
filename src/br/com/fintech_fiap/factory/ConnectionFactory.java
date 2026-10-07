package br.com.fintech_fiap.factory;

import br.com.fintech_fiap.exception.DBException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    private static final String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private static final String USUARIO = "RM573919";
    private static final String SENHA = "000000";

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws DBException {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException e) {
            throw new DBException("Driver JDBC da Oracle nao encontrado. Adicione o ojdbc11 ao projeto.", e);
        } catch (SQLException e) {
            throw new DBException(DBException.traduzir(e), e);
        }
    }
}