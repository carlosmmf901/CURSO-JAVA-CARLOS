package controladores;

import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.ArrayList;
import java.sql.PreparedStatement;

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


import java.util.Objects;

public class AutorTO {
    private int id;
    private String nome;
    private String paisOrigem;
    private String dataNascimento;

    public AutorTO() {
        // Construtor padrão
    }

    public AutorTO(int id, String nome, String paisOrigem, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.paisOrigem = paisOrigem;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPaisOrigem() { return paisOrigem; }
    public void setPaisOrigem(String paisOrigem) { this.paisOrigem = paisOrigem; }

    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }

    // toString
    @Override
    public String toString() {
        return "AutorTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", paisOrigem='" + paisOrigem + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutorTO)) return false;
        AutorTO autorTO = (AutorTO) o;
        return id == autorTO.id &&
                Objects.equals(nome, autorTO.nome) &&
                Objects.equals(paisOrigem, autorTO.paisOrigem) &&
                Objects.equals(dataNascimento, autorTO.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, paisOrigem, dataNascimento);
    }
}

--confactory

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class ConFactory {  
     
   public static final int MYSQL = 0;  
   private static final String MySQLDriver = "com.mysql.jdbc.Driver";  
   public static final int ORACLE = 1;  
   private static final String OracleDriver = "com.oracle.jdbc.Driver";  
   public static Connection conexao(String url, String nome, String senha,  
         int banco) throws ClassNotFoundException, SQLException {  
      switch (banco) {        
      case MYSQL:           
         Class.forName(MySQLDriver);  
         break;  
      case ORACLE:           
             Class.forName(OracleDriver);  
             break;  
          } 
      return DriverManager.getConnection(url, nome, senha);  
   }  
}  

public class DAO {
	   public static final String URL = "jdbc:mysql://localhost:3306/impacta?autoReconnect=true&useSSL=false",  
		         NOME = "root", SENHA = "Impacta";  
}

import java.util.Objects;

public class LivroTO {
    private int id;
    private String titulo;
    private AutorTO autor = new AutorTO(); // Simplificação para manter o foco na estrutura
    private int anoPublicacao;
    private String categoria;
    private int quantidade;

    public LivroTO() {
        // Construtor padrão
    }

    public LivroTO(int id, String titulo, AutorTO autor, int anoPublicacao, String categoria, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    
    public LivroTO(int id, String titulo, int idAutor, int anoPublicacao, String categoria, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor.setId(idAutor);
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    public LivroTO(int id, String titulo, int idAutor,String nome, int anoPublicacao, String categoria, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor.setId(idAutor);
        this.autor.setNome(nome);
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    public LivroTO(int id, String titulo, int idAutor,String nome, String paisOrigem, int anoPublicacao, String categoria, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor.setId(idAutor);
        this.autor.setNome(nome);
        this.autor.setPaisOrigem(paisOrigem);
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAutorId() { return autor.getId(); }
    public void setAutorId(int autorId) { this.autor.setId(autorId); }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    
    
    //metodos chamados na classe de AutorTO
    
    public int getIdAutor() { return autor.getId(); }
    public void setIdAutor(int id) { this.autor.setId(id); }

    public String getNomeAutor() { return autor.getNome(); }
    public void setNomeAutor(String nome) { this.autor.setNome(nome); }

    public String getPaisOrigem() { return autor.getPaisOrigem(); }
    public void setPaisOrigem(String paisOrigem) { this.autor.setPaisOrigem(paisOrigem);  }

    public String getDataNascimento() { return autor.getDataNascimento(); }
    public void setDataNascimento(String dataNascimento) { this.autor.setDataNascimento(dataNascimento);  }

    

    // toString
    @Override
    public String toString() {
        return "LivroTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", categoria='" + categoria + '\'' +
                ", quantidade=" + quantidade +
                '}' + "\n"  + autor.toString();
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivroTO)) return false;
        LivroTO livroTO = (LivroTO) o;
        return id == livroTO.id &&
                anoPublicacao == livroTO.anoPublicacao &&
                quantidade == livroTO.quantidade &&
                Objects.equals(titulo, livroTO.titulo) &&
                Objects.equals(categoria, livroTO.categoria) &&
                autor.getId() == livroTO.getIdAutor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor.getId(), anoPublicacao, categoria, quantidade);
    }
}


package dados;

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




