package dao;
import java.util.ArrayList;

public class DAOConnection {
	
	public abstract class DAO {
		public static final String URL = "jdbc:mysql://localhost:3306/impacta?autoReconnect=true&useSSL=false",  
		         NOME = "root", SENHA = "Soad717933@"; 
		public abstract ArrayList<Object> findAll();
		public abstract void update (Object objectTO);
		public abstract void insert (Object objectTO);
		public abstract void delete (int codigo);
	}
	
}
