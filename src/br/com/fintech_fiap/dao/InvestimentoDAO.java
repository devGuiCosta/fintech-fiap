package br.com.fintech_fiap.dao;

import br.com.fintech_fiap.Investimento;
import br.com.fintech_fiap.Usuario;
import br.com.fintech_fiap.exception.DBException;
import br.com.fintech_fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


public class InvestimentoDAO {

    public void insert(Investimento inv) throws DBException {
        String sql = "INSERT INTO T_FIN_INVESTIMENTOS "
                + "(id_investimentos, id_usuario, tipo, nome_aplicacao, instituicao, "
                + " valor, dt_investimento, dt_vencimento) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, inv.getIdInvestimento());
            stmt.setInt(2, inv.getUsuario().getIdUsuario());
            stmt.setString(3, inv.getTipo());
            stmt.setString(4, inv.getNomeAplicacao());
            stmt.setString(5, inv.getInstituicao());
            stmt.setDouble(6, inv.getValor());
            stmt.setDate(7, DaoUtil.toSqlDate(inv.getDataInvestimento()));
            if (inv.getDataVencimento() != null) {
                stmt.setDate(8, DaoUtil.toSqlDate(inv.getDataVencimento()));
            } else {
                stmt.setNull(8, Types.DATE); // ex.: acoes nao tem vencimento
            }
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBException("Erro ao cadastrar investimento: " + DBException.traduzir(e), e);
        }
    }

    public List<Investimento> getAll() throws DBException {
        String sql = "SELECT i.id_investimentos, i.tipo, i.nome_aplicacao, i.instituicao, "
                + "       i.valor, i.dt_investimento, i.dt_vencimento, u.id_usuario, u.nome "
                + "  FROM T_FIN_INVESTIMENTOS i "
                + " INNER JOIN T_FIN_USUARIO u ON u.id_usuario = i.id_usuario "
                + " ORDER BY i.dt_investimento DESC, i.id_investimentos DESC";
        List<Investimento> lista = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));

                Investimento i = new Investimento();
                i.setIdInvestimento(rs.getInt("id_investimentos"));
                i.setUsuario(u);
                i.setTipo(rs.getString("tipo"));
                i.setNomeAplicacao(rs.getString("nome_aplicacao"));
                i.setInstituicao(rs.getString("instituicao"));
                i.setValor(rs.getDouble("valor"));
                i.setDataInvestimento(DaoUtil.toLocalDate(rs.getDate("dt_investimento")));
                i.setDataVencimento(DaoUtil.toLocalDate(rs.getDate("dt_vencimento")));
                lista.add(i);
            }

        } catch (SQLException e) {
            throw new DBException("Erro ao consultar investimentos: " + DBException.traduzir(e), e);
        }
        return lista;
    }

    public int proximoId() throws DBException {
        return DaoUtil.proximoId("T_FIN_INVESTIMENTOS", "id_investimentos");
    }
}