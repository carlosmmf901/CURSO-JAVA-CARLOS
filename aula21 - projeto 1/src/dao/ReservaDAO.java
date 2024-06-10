package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dados.*;


public class ReservaDAO {
    private Connection con;
    private PreparedStatement comando;

    public ReservaDAO(Connection connection) {
        this.con = connection;
    }

    public void insert(ReservaTO reserva) {
        String query = "INSERT INTO reservas (id_usuario, id_livro, data_reserva, status) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, reserva.getId());
            statement.setInt(2, reserva.getId());
            statement.setString(3, reserva.getDataReserva());
            statement.setString(4, reserva.getStatus());
            statement.executeUpdate();
            System.out.println("Reserva inserida com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao inserir reserva: " + e.getMessage());
        }
    }

    public void update(ReservaTO reserva) {
        String query = "UPDATE reservas SET id_usuario = ?, id_livro = ?, data_reserva = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, reserva.getId());
            statement.setInt(2, reserva.getId());
            statement.setString(3, reserva.getDataReserva());
            statement.setString(4, reserva.getStatus());
            statement.setInt(5, reserva.getId());
            statement.executeUpdate();
            System.out.println("Reserva atualizada com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao atualizar reserva: " + e.getMessage());
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM reservas WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Reserva excluída com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao excluir reserva: " + e.getMessage());
        }
    }

    public ArrayList<ReservaTO> findAll() {  
        conectar();  

        ArrayList<ReservaTO> resultados = new ArrayList<ReservaTO>();  
        ResultSet rs;  
        try {  
           comando = con.prepareStatement("SELECT * FROM livros"); 
           rs = comando.executeQuery("SELECT * FROM livros");  
           while (rs.next()) {  
              ReservaTO reserva = new ReservaTO();  
              reserva.setId(rs.getInt("id"));
              reserva.setUsuarioId(rs.getInt("Usuario")); 
              reserva.setLivro(rs.getInt("autor"));
              temp.setCategoria(rs.getString("categoria"));
              temp.setAnoPublicacao(rs.getInt("AnoPublicacao"));
              temp.setQuantidade(rs.getInt("quantidade"));
             
              resultados.add(temp);  
           }  
           return resultados;  
        } catch (SQLException e) {  
           imprimeErro("Erro ao findByID livro", e.getMessage());  
           return null;  
        }  
     }  

    public ReservaTO findById(int id) {
        String query = "SELECT * FROM reservas WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new ReservaTO(
                            resultSet.getInt("id"),
                            new UsuarioDAO(con).findById(resultSet.getInt("id_usuario")),
                            new LivroDAO(con).findByID(resultSet.getInt("id_livro")),
                            resultSet.getString("data_reserva"),
                            resultSet.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro ao buscar reserva por ID: " + e.getMessage());
        }
        return null;
    }
    
    private void conectar() {  
        try {  
           con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);  

           System.out.println("Conectado!");  
        } catch (ClassNotFoundException e) {  
           imprimeErro("Erro ao carregar o driver", e.getMessage());  
        } catch (SQLException e) {  
           imprimeErro("Erro ao conectar", e.getMessage());  
        }  
     }  

     private void fechar() {  
        try {  
           comando.close();  
           con.close();  
           System.out.println("Conexão Fechada");  
        } catch (SQLException e) {  
           imprimeErro("Erro ao fechar conexao", e.getMessage());  
        }  
     }  
     
     private void imprimeErro (String erro, String mensagem) {
    	   System.out.println (erro + "\n" + mensagem);
     }
}
