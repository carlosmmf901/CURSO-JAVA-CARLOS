package dao;
import java.sql.Connection;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;
import java.sql.PreparedStatement;
import dados.*;
import dao.DAOConnection.*;

public class AvaliacaoDAO {

    public void insert(AvaliacaoTO avaliacao) {
        String sql = "INSERT INTO Avaliacao (idFilmeSerie, nota, comentario, tipo, idUsuario) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, avaliacao.getIdFilmeSerie());
            stmt.setDouble(2, avaliacao.getNota());
            stmt.setString(3, avaliacao.getComentario());
            stmt.setString(4, avaliacao.getTipo());
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Avaliacao WHERE id = ?";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(AvaliacaoTO avaliacao) {
        String sql = "UPDATE Avaliacao SET idFilmeSerie = ?, nota = ?, comentario = ?, tipo = ?, idUsuario = ? WHERE id = ?";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, avaliacao.getIdFilmeSerie());
            stmt.setDouble(2, avaliacao.getNota());
            stmt.setString(3, avaliacao.getComentario());
            stmt.setString(4, avaliacao.getTipo());
            stmt.setInt(6, avaliacao.getId());
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public AvaliacaoTO findById(int id) {
        AvaliacaoTO avaliacao = null;
        String sql = "SELECT * FROM Avaliacao WHERE id = ?";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                avaliacao = new AvaliacaoTO(rs.getInt("id"), rs.getInt("idFilmeSerie"), rs.getDouble("nota"), rs.getString("comentario"), rs.getString("tipo"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return avaliacao;
    }

    public ArrayList<AvaliacaoTO> findAll() {
    	ArrayList<AvaliacaoTO> avaliacoes = new ArrayList<>();
        String sql = "SELECT * FROM Avaliacao";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                avaliacoes.add(new AvaliacaoTO(rs.getInt("id"), rs.getInt("idFilmeSerie"), rs.getDouble("nota"), rs.getString("comentario"), rs.getString("tipo")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return avaliacoes;
    }
}