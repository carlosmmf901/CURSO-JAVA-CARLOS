package testesTO;
import dados.FilmeTO;

public class FilmeTOTest {

    public static void main(String[] args) {
        testeConstrutorEGetters();
        testeSetters();
        testeEqualsEHashCode();
        testeToString();
    }

    private static void testeConstrutorEGetters() {
        System.out.println("Testando construtor e getters...");
        FilmeTO filme = new FilmeTO(1, "Inception", "Christopher Nolan", 2010, "Ficção Científica");
        boolean sucesso = filme.getId() == 1 &&
                          "Inception".equals(filme.getTitulo()) &&
                          "Christopher Nolan".equals(filme.getDiretor()) &&
                          filme.getAnoLancamento() == 2010 &&
                          "Ficção Científica".equals(filme.getGenero());
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeSetters() {
        System.out.println("Testando setters...");
        FilmeTO filme = new FilmeTO();
        filme.setId(2);
        filme.setTitulo("The Dark Knight");
        filme.setDiretor("Christopher Nolan");
        filme.setAnoLancamento(2008);
        filme.setGenero("Ação");
        boolean sucesso = filme.getId() == 2 &&
                          "The Dark Knight".equals(filme.getTitulo()) &&
                          "Christopher Nolan".equals(filme.getDiretor()) &&
                          filme.getAnoLancamento() == 2008 &&
                           "Ação".equals(filme.getGenero());
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeEqualsEHashCode() {
        System.out.println("Testando equals e hashCode...");
        FilmeTO filme1 = new FilmeTO(1, "Inception", "Christopher Nolan", 2010, "Ficção Científica");
        FilmeTO filme2 = new FilmeTO(1, "Inception", "Christopher Nolan", 2010, "Ficção Científica");
        boolean sucesso = filme1.equals(filme2) && filme1.hashCode() == filme2.hashCode();
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeToString() {
        System.out.println("Testando toString...");
        FilmeTO filme = new FilmeTO(1, "Inception", "Christopher Nolan", 2010, "Ficção Científica");
        String esperado = "FilmeTO{id=1, titulo='Inception', diretor='Christopher Nolan', anoLancamento=2010, genero='Ficção Científica'}";
        boolean sucesso = filme.toString().equals(esperado);
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }
	
	
	
}
