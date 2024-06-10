package dao;
import java.sql.Connection;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;
import java.sql.PreparedStatement;
import dados.*;
import dao.DAOConnection.*;


public class UsuarioDAO {
	private Connection con;
	private PreparedStatement comando;
	
	public void update(UsuarioTO obj) {  
        conectar();  

        try {  
        comando = con.prepareStatement("update autores set nome = ? , email = ? "); 

    	comando.setString(2, obj.getNome());
    	comando.setString(1, obj.getEmail());
   		comando.execute();  
          System.out.println("Atualizada!"); 
        } catch (SQLException e) {  
           e.printStackTrace();  
        } finally {  
           fechar();  
        }  
	}  

	public ArrayList<UsuarioTO> findAll() {  
	    conectar();  
	
	    ArrayList<UsuarioTO> resultados = new ArrayList<UsuarioTO>();  
	    ResultSet rs;  
	    try {  
	       comando = con.prepareStatement("SELECT * FROM Usuario"); 
	       rs = comando.executeQuery("SELECT * FROM Usuario");  
	       while (rs.next()) {  
	    	   UsuarioTO temp = new UsuarioTO();  
	
	          temp.setNome(rs.getString("nome"));  
	          temp.setEmail(rs.getString("email"));
	          resultados.add(temp);  
	       }  
	       return resultados;  
	    } catch (SQLException e) {  
	       imprimeErro("Erro ao findByID autor", e.getMessage());  
	       return null;  
	    }  
	 }
	
	public UsuarioTO findByName(String nome) {
	UsuarioTO resultados = new UsuarioTO();
	String sql = "SELECT * FROM autores WHERE titulo = ?";
       try (Connection con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {  
          comando.setString(1, nome);
           while (rs.next()) {  
        	   UsuarioTO temp = new UsuarioTO();     
              temp.setNome(rs.getString("Nome"));  
              resultados = temp;  

           }  
           return resultados;  
        } catch (ClassNotFoundException | SQLException e) {  
           imprimeErro("Erro ao encontrar nome", e.getMessage());  
           return null;  
        }  
	    
	 } 


	 public void insert(UsuarioTO obj) {
			conectar();
			
			try {
			comando = con.prepareStatement("insert into Usuario (nome, email)" +
	                "values (?, ?)");
	
	    	comando.setString(2, obj.getNome());
	    	comando.setString(1, obj.getEmail());
	   		comando.execute();  
	          System.out.println("Atualizada!"); 
			} catch (SQLException e) {  
		           e.printStackTrace();  
	        } finally {  
	           fechar();  
	        }  
			
			
	}
	
	public void delete(int codigo) {
		conectar();
		try {
			comando = con.prepareStatement("DELETE FROM Usuario WHERE id = ?");
			comando.setInt(1, codigo);
	        System.out.println("Excluido!"); 
	        
	    } catch (SQLException e) {  
	       imprimeErro("Erro ao excluir produto", e.getMessage());  
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
