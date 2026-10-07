package br.com.fintech_fiap.dao;

import br.com.fintech_fiap.exception.DBException;
import br.com.fintech_fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


final class DaoUtil {

    private DaoUtil() {
    }

    static LocalDate toLocalDate(Date data) {
        return data == null ? null : data.toLocalDate();
    }

    static Date toSqlDate(LocalDate data) {
        return data == null ? null : Date.valueOf(data);
    }


    static int proximoId(String tabela, String colunaId) throws DBException {
        String sql = "SELECT NVL(MAX(" + colunaId + "), 0) + 1 FROM " + tabela;

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            throw new DBException("Erro ao obter proximo codigo de " + tabela + ": " + DBException.traduzir(e), e);
        }
    }
}