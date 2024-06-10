package dao;
import java.sql.Connection;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;
import java.sql.PreparedStatement;
import dados.*;

public class AutorDAO {
   private Connection con;  
   private PreparedStatement comando;  
  
   public void delete(int codigo) {  
      conectar();  
      try {  
            comando = con.prepareStatement("DELETE FROM autores WHERE id = ?"); 
    		comando.setInt(1, codigo);
    		comando.execute();
            System.out.println("Excluido!"); 
            
      } catch (SQLException e) {  
         imprimeErro("Erro ao excluir produto", e.getMessage());  
      } finally {  
         fechar();  
      }  
   }  
  
   public ArrayList<AutorTO> findAll() {  
      conectar();  
 
      ArrayList<AutorTO> resultados = new ArrayList<AutorTO>();  
      ResultSet rs;  
      try {  
         comando = con.prepareStatement("SELECT * FROM autores"); 
         rs = comando.executeQuery("SELECT * FROM autores");  
         while (rs.next()) {  
            AutorTO temp = new AutorTO();  

            temp.setId(rs.getInt("id"));  
            temp.setNome(rs.getString("nome")); 
            temp.setPaisOrigem(rs.getString("paisOrigem"));
            temp.setDataNascimento(rs.getDate("dataNascimento").toString() );
             resultados.add(temp);  
         }  
         return resultados;  
      } catch (SQLException e) {  
         imprimeErro("Erro ao findByID autor", e.getMessage());  
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
  
   public AutorTO findByID(int codigo) {  
      conectar();  
      AutorTO resultados = new AutorTO();  
      ResultSet rs;  
      try {  
    	  
        comando = con.prepareStatement("SELECT * FROM AUTORES WHERE ID = ?"  );
        comando.setInt(1, codigo);
        rs = comando.executeQuery();
         while (rs.next()) {  
            AutorTO temp = new AutorTO();  
            // pega todos os atributos da pessoa  
            temp.setId(rs.getInt("id"));  
            temp.setNome(rs.getString("nome"));  
            temp.setDataNascimento(rs.getDate("dataNascimento").toString());
            temp.setPaisOrigem(rs.getString("paisOrigem"));
            resultados = temp;  

         }  
         return resultados;  
      } catch (SQLException e) {  
         imprimeErro("Erro findByID autor", e.getMessage());  
         return null;  
      }  
  
   }  
  
   public void insert(AutorTO obj){  
      conectar();  
      try {  
          comando = con.prepareStatement("insert into Autor (nome,paisOrigem)" +
                                         "values (?,?)");
    		comando.setString(1, obj.getNome());
    		comando.setString(2, obj.getPaisOrigem());
    		comando.execute();  
   	  
    	  

 
         System.out.println("Inserida!");  
      } catch (SQLException e) {  
         imprimeErro("Erro ao inserir Autor", e.getMessage());  
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