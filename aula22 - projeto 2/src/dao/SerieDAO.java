package dao;
import java.sql.Connection;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;
import java.sql.PreparedStatement;
import dados.*;
import dao.DAOConnection.*;

public class SerieDAO {
	private Connection con;
	private PreparedStatement comando;
	
	public void update(SerieTO obj) {  
        conectar();  

        try {  
        comando = con.prepareStatement("update autores set "
        		+ "titulo = ? , criador = ?, "
        		+ "anoInicio = ?, genero = ? "); 

    	comando.setString(4, obj.getTitulo());
    	comando.setString(3, obj.getCriador());
    	comando.setInt(2, obj.getAnoInicio());
    	comando.setString(1, obj.getGenero());
   		comando.execute();  
          System.out.println("Atualizada!"); 
        } catch (SQLException e) {  
           e.printStackTrace();  
        } finally {  
           fechar();  
        }  
	}  

	public ArrayList<SerieTO> findAll() {  
	    conectar();  
	
	    ArrayList<SerieTO> resultados = new ArrayList<SerieTO>();  
	    ResultSet rs;  
	    try {  
	       comando = con.prepareStatement("SELECT * FROM Series"); 
	       rs = comando.executeQuery("SELECT * FROM Series");  
	       while (rs.next()) {  
	    	   SerieTO temp = new SerieTO();  
	
	          temp.setTitulo(rs.getString("titulo"));  
	          temp.setCriador(rs.getString("criador"));
	          temp.setAnoInicio(rs.getInt("anoInicio"));
	          temp.setGenero(rs.getString("genero"));
	          resultados.add(temp);  
	       }  
	       return resultados;  
	    } catch (SQLException e) {  
	       imprimeErro("Erro ao findByID autor", e.getMessage());  
	       return null;  
	    }  
	 }


	 public void insert(SerieTO obj) {
			conectar();
			
			try {
			comando = con.prepareStatement("insert into Usuario (titulo, criador, anoInicio, genero)" +
	                "values (?, ?, ?, ?)");
	
	    	comando.setString(4, obj.getTitulo());
	    	comando.setString(3, obj.getCriador());
	    	comando.setInt(2, obj.getAnoInicio());
	    	comando.setString(1, obj.getGenero());
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
			comando = con.prepareStatement("DELETE FROM Series WHERE id = ?");
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
