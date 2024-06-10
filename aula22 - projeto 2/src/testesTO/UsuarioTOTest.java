package testesTO;
import dados.UsuarioTO;

public class UsuarioTOTest {
	
	public static void main (String[] args) {
		testeConstrutorEGetters();
	    testeSetters();
	    testeEqualsEHashCode();
	    testeToString();
	
	}
	
	private static void testeConstrutorEGetters() {
		System.out.println("Testando construtor e getters...");
		UsuarioTO usuario = new UsuarioTO(1, "carlos", "carlos@email.com");
		boolean sucesso = usuario.getId() == 1 && 
				"carlos".equals(usuario.getNome()) &&
				"carlos@email.com".equals(usuario.getEmail());
		System.out.println(sucesso ? "Sucesso" : "Falha");
		
	}
	
	public static void testeSetters() {
		System.out.println("Testando setters");
		UsuarioTO usuario = new UsuarioTO();
		usuario.setId(2);
		usuario.setNome("henrique");
		usuario.setEmail("henrique@email.com");
		boolean sucesso = usuario.getId() == 2 &&
				"henrique".equals(usuario.getNome()) &&
				"henrique@email.com".equals(usuario.getEmail());
		System.out.println(sucesso ? "Sucesso" : "Falha");
	}
	
	public static void testeEqualsEHashCode() {
		System.out.println("Testando equals e hashbode...");
		UsuarioTO usuario1 = new UsuarioTO(1, "carlos", "carlos@email.com");
		UsuarioTO usuario2 = new UsuarioTO(1, "carlos", "carlos@email.com");
		boolean sucesso = usuario1.equals(usuario2) && usuario1.hashCode() == usuario2.hashCode();
		System.out.println(sucesso ? "Sucesso" : "falha");
	}
	
	public static void testeToString() {
		System.out.println("Testando toString...");
		UsuarioTO usuario = new UsuarioTO(1, "carlos", "carlos@email.com");
		String esperado = "UsuarioTO{id=1, nome = 'carlos', email='carlos@email.com'}";
		boolean sucesso = usuario.toString().equals(esperado);
		System.out.println(sucesso ? "Sucesso" : "falha");
	}
	
	
	
}
