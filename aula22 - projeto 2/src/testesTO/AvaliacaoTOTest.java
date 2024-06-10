package testesTO;

import dados.AvaliacaoTO;

public class AvaliacaoTOTest {

    public static void main(String[] args) {
        testeConstrutorEGetters();
        testeSetters();
        testeEqualsEHashCode();
        testeToString();
    }

    private static void testeConstrutorEGetters() {
        System.out.println("Testando construtor e getters...");
        AvaliacaoTO avaliacao = new AvaliacaoTO(1, 2, 8.5, "Ótima avaliação", "Tipo");
        boolean sucesso = avaliacao.getId() == 1 &&
                          avaliacao.getIdFilmeSerie() == 2 &&
                          avaliacao.getNota() == 8.5 &&
                          "Ótima avaliação".equals(avaliacao.getComentario()) &&
                          "Tipo".equals(avaliacao.getTipo());
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeSetters() {
        System.out.println("Testando setters...");
        AvaliacaoTO avaliacao = new AvaliacaoTO();
        avaliacao.setId(2);
        avaliacao.setIdFilmeSerie(3);
        avaliacao.setNota(7.8);
        avaliacao.setComentario("Boa avaliação");
        avaliacao.setTipo("Outro tipo");
        boolean sucesso = avaliacao.getId() == 2 &&
                          avaliacao.getIdFilmeSerie() == 3 &&
                          avaliacao.getNota() == 7.8 &&
                          "Boa avaliação".equals(avaliacao.getComentario()) &&
                          "Outro tipo".equals(avaliacao.getTipo());
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeEqualsEHashCode() {
        System.out.println("Testando equals e hashCode...");
        AvaliacaoTO avaliacao1 = new AvaliacaoTO(1, 2, 8.5, "Ótima avaliação", "Tipo");
        AvaliacaoTO avaliacao2 = new AvaliacaoTO(1, 2, 8.5, "Ótima avaliação", "Tipo");
        boolean sucesso = avaliacao1.equals(avaliacao2) && avaliacao1.hashCode() == avaliacao2.hashCode();
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }

    private static void testeToString() {
        System.out.println("Testando toString...");
        AvaliacaoTO avaliacao = new AvaliacaoTO(1, 2, 8.5, "Ótima avaliação", "Tipo");
        String esperado = "AvaliacaoTO{id=1, idFilmeSerie=2, nota=8.5, comentario='Ótima avaliação', tipo='Tipo'}";
        boolean sucesso = avaliacao.toString().equals(esperado);
        System.out.println(sucesso ? "Sucesso" : "Falha");
    }
}
