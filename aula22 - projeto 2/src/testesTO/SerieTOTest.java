package testesTO;

import dados.SerieTO;

public class SerieTOTest {

    public static void main(String[] args) {
        testeConstrutorEGetters();
        testeSetters();
        testeEqualsEHashCode();
        testeToString();
    }

    private static void testeConstrutorEGetters() {
        System.out.println("Testando construtor e getters...");
        SerieTO serie = new SerieTO(1, "Breaking Bad", "Vince Gilligan", 2008, "Drama");
        boolean sucesso = serie.getId() == 1 &&
                          "Breaking Bad".equals(serie.getTitulo()) &&
                          "Vince Gilligan".equals(serie.getCriador()) &&
                          serie.getAnoInicio() == 2008 &&
                          "Drama".equals(serie.getGenero());
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeSetters() {
        System.out.println("Testando setters...");
        SerieTO serie = new SerieTO();
        serie.setId(2);
        serie.setTitulo("Game of Thrones");
        serie.setCriador("David Benioff e D. B. Weiss");
        serie.setAnoInicio(2011);
        serie.setGenero("Fantasia");
        boolean sucesso = serie.getId() == 2 &&
                          "Game of Thrones".equals(serie.getTitulo()) &&
                          "David Benioff e D. B. Weiss".equals(serie.getCriador()) &&
                          serie.getAnoInicio() == 2011 &&
                          "Fantasia".equals(serie.getGenero());
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeEqualsEHashCode() {
        System.out.println("Testando equals e hashCode...");
        SerieTO serie1 = new SerieTO(1, "Breaking Bad", "Vince Gilligan", 2008, "Drama");
        SerieTO serie2 = new SerieTO(1, "Breaking Bad", "Vince Gilligan", 2008, "Drama");
        boolean sucesso = serie1.equals(serie2) && serie1.hashCode() == serie2.hashCode();
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeToString() {
        System.out.println("Testando toString...");
        SerieTO serie = new SerieTO(1, "Breaking Bad", "Vince Gilligan", 2008, "Drama");
        String esperado = "SerieTO{id=1, titulo='Breaking Bad', criador='Vince Gilligan', anoInicio=2008, genero='Drama'}";
        boolean sucesso = serie.toString().equals(esperado);
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }
}
