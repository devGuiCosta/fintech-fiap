package br.com.fintech_fiap.dao;

import br.com.fintech_fiap.Conta;
import br.com.fintech_fiap.Usuario;
import br.com.fintech_fiap.exception.DBException;
import br.com.fintech_fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContaDAO {

    public void insert(Conta conta) throws DBException {
        String sql = "INSERT INTO T_FIN_CONTA "
                + "(id_conta, id_usuario, banco, agencia, numero_conta, tipo_conta, saldo, dt_abertura) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, conta.getIdConta());
            stmt.setInt(2, conta.getUsuario().getIdUsuario());
            stmt.setString(3, conta.getBanco());
            stmt.setString(4, conta.getAgencia());
            stmt.setString(5, conta.getNumeroConta());
            stmt.setString(6, conta.getTipoConta());
            stmt.setDouble(7, conta.getSaldo());
            stmt.setDate(8, DaoUtil.toSqlDate(conta.getDataAbertura()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBException("Erro ao cadastrar conta: " + DBException.traduzir(e), e);
        }
    }

    public List<Conta> getAll() throws DBException {
        // junta com T_FIN_USUARIO para trazer o nome do dono da conta
        String sql = "SELECT c.id_conta, c.banco, c.agencia, c.numero_conta, c.tipo_conta, "
                + "       c.saldo, c.dt_abertura, u.id_usuario, u.nome "
                + "  FROM T_FIN_CONTA c "
                + " INNER JOIN T_FIN_USUARIO u ON u.id_usuario = c.id_usuario "
                + " ORDER BY c.id_conta";
        List<Conta> lista = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));

                Conta c = new Conta();
                c.setIdConta(rs.getInt("id_conta"));
                c.setUsuario(u);
                c.setBanco(rs.getString("banco"));
                c.setAgencia(rs.getString("agencia"));
                c.setNumeroConta(rs.getString("numero_conta"));
                c.setTipoConta(rs.getString("tipo_conta"));
                c.setSaldo(rs.getDouble("saldo"));
                c.setDataAbertura(DaoUtil.toLocalDate(rs.getDate("dt_abertura")));
                lista.add(c);
            }

        } catch (SQLException e) {
            throw new DBException("Erro ao consultar contas: " + DBException.traduzir(e), e);
        }
        return lista;
    }

    public int proximoId() throws DBException {
        return DaoUtil.proximoId("T_FIN_CONTA", "id_conta");
    }
}