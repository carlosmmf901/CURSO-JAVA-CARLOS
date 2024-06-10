package testeService;

public class AvaliacaoServiceTest {

    public static void main(String[] args) {
        AvaliacaoService avaliacaoService = new AvaliacaoService();
        AvaliacaoTO avaliacao = new AvaliacaoTO(1, 1, 5.0, "Comentário Teste", "filme", 1);

        // Inserção
        System.out.println("Testando inserção de avaliação...");
        avaliacaoService.registrarAvaliacao(avaliacao);

        // Busca
        System.out.println("Testando busca de avaliação por ID...");
        AvaliacaoTO avaliacaoBuscada = avaliacaoService.buscarAvaliacaoPorId(1);
        System.out.println(avaliacaoBuscada);

        // Atualização
        System.out.println("Testando atualização de avaliação...");
        avaliacao.setNota(4.0); // Atualizando a nota
        avaliacaoService.atualizarAvaliacao(avaliacao);
        System.out.println(avaliacaoService.buscarAvaliacaoPorId(1));

        // Listagem
        System.out.println("Testando listagem de avaliações...");
        avaliacaoService.listarTodasAsAvaliacoes().forEach(System.out::println);

        // Deleção
        System.out.println("Testando deleção de avaliação...");
        avaliacaoService.deletarAvaliacao(1);
        if (avaliacaoService.buscarAvaliacaoPorId(1) == null) {
            System.out.println("Avaliação deletada com sucesso.");
        } else {
            System.out.println("Falha ao deletar avaliação.");
        }
    }
}
