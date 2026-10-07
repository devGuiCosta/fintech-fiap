package br.com.fintech_fiap.dao;

import br.com.fintech_fiap.Usuario;
import br.com.fintech_fiap.exception.DBException;
import br.com.fintech_fiap.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {

    public void insert(Usuario usuario) throws DBException {
        String sql = "INSERT INTO T_FIN_USUARIO "
                + "(id_usuario, nome, email, dt_nascimento, senha, dt_criacao) "
                + "VALUES (?, ?, ?, ?, ?, SYSDATE)";

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, usuario.getIdUsuario());
            stmt.setString(2, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setDate(4, DaoUtil.toSqlDate(usuario.getDataNascimento()));
            stmt.setString(5, usuario.getSenha());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new DBException("Erro ao cadastrar usuario: " + DBException.traduzir(e), e);
        }
    }

    public List<Usuario> getAll() throws DBException {
        String sql = "SELECT id_usuario, nome, email, dt_nascimento, dt_criacao "
                + "FROM T_FIN_USUARIO ORDER BY id_usuario";
        List<Usuario> lista = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setDataNascimento(DaoUtil.toLocalDate(rs.getDate("dt_nascimento")));
                u.setDataCriacao(DaoUtil.toLocalDate(rs.getDate("dt_criacao")));
                lista.add(u);
            }

        } catch (SQLException e) {
            throw new DBException("Erro ao consultar usuarios: " + DBException.traduzir(e), e);
        }
        return lista;
    }

    public int proximoId() throws DBException {
        return DaoUtil.proximoId("T_FIN_USUARIO", "id_usuario");
    }
}