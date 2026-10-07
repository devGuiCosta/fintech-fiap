package br.com.fintech_fiap.dao;

import br.com.fintech_fiap.Receita;
import br.com.fintech_fiap.Usuario;
import br.com.fintech_fiap.exception.DBException;
import br.com.fintech_fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReceitaDAO {

    public void insert(Receita receita) throws DBException {
        String sql = "INSERT INTO T_FIN_RECEITA "
                + "(id_receita, id_usuario, valor, descricao, data_recebimento) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, receita.getIdReceita());
            stmt.setInt(2, receita.getUsuario().getIdUsuario());
            stmt.setDouble(3, receita.getValor());
            stmt.setString(4, receita.getDescricao());
            stmt.setDate(5, DaoUtil.toSqlDate(receita.getDataRecebimento()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBException("Erro ao cadastrar receita: " + DBException.traduzir(e), e);
        }
    }

    public List<Receita> getAll() throws DBException {
        String sql = "SELECT r.id_receita, r.valor, r.descricao, r.data_recebimento, "
                + "       u.id_usuario, u.nome "
                + "  FROM T_FIN_RECEITA r "
                + " INNER JOIN T_FIN_USUARIO u ON u.id_usuario = r.id_usuario "
                + " ORDER BY r.data_recebimento DESC, r.id_receita DESC";
        List<Receita> lista = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));

                Receita r = new Receita();
                r.setIdReceita(rs.getInt("id_receita"));
                r.setUsuario(u);
                r.setValor(rs.getDouble("valor"));
                r.setDescricao(rs.getString("descricao"));
                r.setDataRecebimento(DaoUtil.toLocalDate(rs.getDate("data_recebimento")));
                lista.add(r);
            }

        } catch (SQLException e) {
            throw new DBException("Erro ao consultar receitas: " + DBException.traduzir(e), e);
        }
        return lista;
    }

    public int proximoId() throws DBException {
        return DaoUtil.proximoId("T_FIN_RECEITA", "id_receita");
    }
}