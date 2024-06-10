package negocio;

import dao.AvaliacaoDAO;
import java.util.List;
import dados.*;

public class AvaliacaoService {
    private AvaliacaoDAO avaliacaoDAO;

    public AvaliacaoService() {
        this.avaliacaoDAO = new AvaliacaoDAO();
    }

    public void cadastrarNovaAvaliacao(AvaliacaoTO avaliacao) {
        try {
            // Verificar se a avaliação já existe no banco de dados
            AvaliacaoTO avaliacaoExistente = avaliacaoDAO.findById(avaliacao.getId());
            if (avaliacaoExistente != null) {
                throw new IllegalArgumentException("A avaliação já existe no banco de dados.");
            }
            
            // Se todas as verificações passarem, inserir a avaliação
            avaliacaoDAO.insert(avaliacao);
            System.out.println("Avaliação cadastrada com sucesso!");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao cadastrar a avaliação: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        } catch (Exception e) {
            System.err.println("Erro inesperado ao cadastrar a avaliação: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        }
    }

    public void atualizarAvaliacao(AvaliacaoTO avaliacao) {
        try {
            // Verificar se a avaliação existe no banco de dados
            AvaliacaoTO avaliacaoExistente = avaliacaoDAO.findById(avaliacao.getId());
            if (avaliacaoExistente == null) {
                throw new IllegalArgumentException("A avaliação não existe no banco de dados.");
            }
            
            // Se todas as verificações passarem, atualizar a avaliação
            avaliacaoDAO.update(avaliacao);
            System.out.println("Avaliação atualizada com sucesso!");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao atualizar a avaliação: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        } catch (Exception e) {
            System.err.println("Erro inesperado ao atualizar a avaliação: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        }
    }

    public void deletarAvaliacao(int id) {
        try {
            // Verificar se a avaliação existe no banco de dados
            AvaliacaoTO avaliacaoExistente = avaliacaoDAO.findById(id);
            if (avaliacaoExistente == null) {
                throw new IllegalArgumentException("A avaliação não existe no banco de dados.");
            }
            
            // Se todas as verificações passarem, deletar a avaliação
            avaliacaoDAO.delete(id);
            System.out.println("Avaliação deletada com sucesso!");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao deletar a avaliação: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        } catch (Exception e) {
            System.err.println("Erro inesperado ao deletar a avaliação: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        }
    }

    public AvaliacaoTO buscarAvaliacaoPorId(int id) {
        return avaliacaoDAO.findById(id);
    }
    
    public List<AvaliacaoTO> listarTodasAsAvaliacoes() {
        return avaliacaoDAO.findAll();
    }
}
