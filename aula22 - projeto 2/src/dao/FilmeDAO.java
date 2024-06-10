package dao;
import java.sql.Connection;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;
import java.sql.PreparedStatement;
import dao.DAOConnection.*;
import dados.*;

public class FilmeDAO {
	private PreparedStatement comando;
	
    public void insert(FilmeTO filme) {
        String sql = "INSERT INTO Filme (titulo, diretor, anoLancamento, genero) VALUES (?, ?, ?, ?)";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDiretor());
            stmt.setInt(3, filme.getAnoLancamento());
            stmt.setString(4, filme.getGenero());
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Apenas para simplificação
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Filme WHERE id = ?";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(FilmeTO filme) {
        String sql = "UPDATE Filme SET titulo = ?, diretor = ?, anoLancamento = ?, genero = ? WHERE id = ?";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getDiretor());
            stmt.setInt(3, filme.getAnoLancamento());
            stmt.setString(4, filme.getGenero());
            stmt.setInt(5, filme.getId());
            stmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public FilmeTO findById(int id) {
        FilmeTO filme = null;
        String sql = "SELECT * FROM Filme WHERE id = ?";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                filme = new FilmeTO(rs.getInt("id"), rs.getString("titulo"), rs.getString("diretor"), rs.getInt("anoLancamento"), rs.getString("genero"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return filme;
    }

    public ArrayList<FilmeTO> findAll() {
        ArrayList<FilmeTO> filmes = new ArrayList<>();
        String sql = "SELECT * FROM Filme";
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                filmes.add(new FilmeTO(rs.getInt("id"), rs.getString("titulo"), rs.getString("diretor"), rs.getInt("anoLancamento"), rs.getString("genero")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return filmes;
    }
    
    public FilmeTO findByTitulo(String titulo) {    
        FilmeTO resultados = new FilmeTO();  
        String sql = "SELECT * FROM Filmes WHERE titulo = ?" ;
        try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {  
          comando.setString(1, titulo);
           while (rs.next()) {  
        	  FilmeTO temp = new FilmeTO();     
              temp.setTitulo(rs.getString("Titulo"));  
              resultados = temp;  

           }  
           return resultados;  
        } catch (ClassNotFoundException | SQLException e) {  
           imprimeErro("Erro findByName titulo", e.getMessage());  
           return null;  
        }  
    
    } 
    
    private void imprimeErro (String erro, String mensagem) {
		   System.out.println (erro + "\n" + mensagem);
	}
}

