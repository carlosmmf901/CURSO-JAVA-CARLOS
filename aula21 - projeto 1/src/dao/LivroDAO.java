package dao;
import dados.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDAO {
    private Connection con;  
    private PreparedStatement comando;  

	 public void delete(int codigo) {  
	    conectar();  
	    try {  
	          comando = con.prepareStatement("DELETE FROM Livros WHERE id = ?"); 
	  		comando.setInt(1, codigo);
	  		comando.execute();
	          System.out.println("Excluido!"); 
	          
	    } catch (SQLException e) {  
	       imprimeErro("Erro ao excluir livro", e.getMessage());  
	    } finally {  
	       fechar();  
	    }  
	 }  
	
	 public ArrayList<LivroTO> findAll() {  
	    conectar();  
	
	    ArrayList<LivroTO> resultados = new ArrayList<LivroTO>();  
	    ResultSet rs;  
	    try {  
	       comando = con.prepareStatement("SELECT * FROM livros"); 
	       rs = comando.executeQuery("SELECT * FROM livros");  
	       while (rs.next()) {  
	          LivroTO temp = new LivroTO();  
	
	          temp.setId(rs.getInt("id"));  
	          temp.setTitulo(rs.getString("titulo")); 
	          temp.setAnoPublicacao(rs.getInt("AnoPublicacao"));
	          temp.setCategoria(rs.getString("categoria") );
	          temp.setQuantidade(rs.getInt("quantidade"));
	          AutorDAO objAutorDAO = new AutorDAO();
	          AutorTO aut = objAutorDAO.findByID(rs.getInt("autorID"));
	          temp.setAutorId(aut.getId());
	          temp.setNomeAutor(aut.getNome());
	          temp.setPaisOrigem(aut.getPaisOrigem());
	          resultados.add(temp);  
	       }  
	       return resultados;  
	    } catch (SQLException e) {  
	       imprimeErro("Erro ao findByID livro", e.getMessage());  
	       return null;  
	    }  
	 }  
	
	 public void update(AutorTO obj) {  
	    conectar();  
	
	
	    try {  
	      comando = con.prepareStatement("update autores set nome = ? ,paisOrigem= ? where id = ? "); 
	
			comando.setInt(3, obj.getId());
			comando.setString(2, obj.getPaisOrigem()); 		
			comando.setString(1, obj.getNome());
			comando.execute();  
	      System.out.println("Atualizada!"); 
	    } catch (SQLException e) {  
	       e.printStackTrace();  
	    } finally {  
	       fechar();  
	    }  
	 }  
	
	 public LivroTO findByID(int codigo) {  
	    conectar();  
	    LivroTO resultados = new LivroTO();  
	    ResultSet rs;  
	    try {  
	  	  
	      comando = con.prepareStatement("SELECT * FROM LIVROS WHERE ID = ?"  );
	      comando.setInt(1, codigo);
	      rs = comando.executeQuery();
	       while (rs.next()) {  
	          LivroTO temp = new LivroTO();  
	          // pega todos os atributos da pessoa  
	          temp.setId(rs.getInt("id"));  
	          temp.setTitulo(rs.getString("titulo")); 
	          temp.setAnoPublicacao(rs.getInt("AnoPublicacao"));
	          temp.setCategoria(rs.getString("categoria") );
	          temp.setQuantidade(rs.getInt("quantidade"));
	          AutorDAO objAutorDAO = new AutorDAO();
	          AutorTO aut = objAutorDAO.findByID(rs.getInt("autorID"));
	          temp.setAutorId(aut.getId());
	          temp.setNomeAutor(aut.getNome());
	          temp.setPaisOrigem(aut.getPaisOrigem());
	          resultados = temp;  
	
	       }  
	       return resultados;  
	    } catch (SQLException e) {  
	       imprimeErro("Erro findByID livro", e.getMessage());  
	       return null;  
	    }  
	
	 }  
	
	 public void insert(LivroTO obj){  
	    conectar();  
	    try {  
	        comando = con.prepareStatement("insert into Livro (titulo,autorId,anoPublicacao,categoria,quantidade)" +
	                                       "values (?,?,?,?,?)");
	  		comando.setString(1, obj.getTitulo());
	  		comando.setInt(2, obj.getAutorId());
	  		comando.setInt(3, obj.getAnoPublicacao());
	  		comando.setString(4, obj.getCategoria());
	  		comando.setInt(5, obj.getQuantidade());  		
	  		comando.execute();  
	 	  
	  	  
	
	
	       System.out.println("Inserida!");  
	    } catch (SQLException e) {  
	       imprimeErro("Erro ao inserir livro", e.getMessage());  
	    } finally {  
	       fechar();  
	    }  
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
	
	
	
	
