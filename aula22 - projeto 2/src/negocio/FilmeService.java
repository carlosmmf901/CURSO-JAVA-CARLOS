package negocio;
import dao.FilmeDAO;
import dados.*;
import java.util.*;

public class FilmeService {

    private FilmeDAO filmeDAO;

    public FilmeService() {
    	this.filmeDAO = new FilmeDAO();
    }

    public void cadastrarNovoFilme(FilmeTO filme) {
    	
    	String filmeNome = filme.getTitulo();
    	FilmeTO filmeExistente = filmeDAO.findByTitulo(filmeNome);
    	FilmeTO filmeInserido = filmeDAO.findByTitulo(filme.getTitulo());
    	
    	try {
    	        // Verificar se o título do filme tem o número mínimo e máximo de caracteres
    	        if (filme.getTitulo() == null) {
    	            throw new IllegalArgumentException("O título do filme nao deve ser vazio.");
    	        }
    	        
    	        if (filme.getTitulo().length() < 2 || filme.getTitulo().length() > 100) {
    	            throw new IllegalArgumentException("O título do filme deve ter entre 3 e 100 caracteres.");
    	        }
    	        
    	        // Verificar se o filme já existe no banco de dados
    	        if (filmeExistente.getTitulo().equals(filmeNome)) {
    	            throw new IllegalArgumentException("O filme já existe no banco de dados.");
    	        }
    	        
    	        // Se todas as verificações passarem, inserir o filme
    	        filmeDAO.insert(filme);
    	        
    	        if (filmeInserido != null) {
    	        	
    	            System.out.println("Filme cadastrado com sucesso!");
    	            
    	        } else {	
    	            throw new IllegalStateException("Erro ao inserir o filme no banco de dados."); 
    	        }
    	        
    	    } catch (IllegalArgumentException e) {
    	        System.err.println("Erro ao cadastrar o filme: " + e.getMessage());
    	        // Aqui você pode adicionar outras ações de tratamento de erro, se necessário
    	    } catch (Exception e) {
    	        System.err.println("Erro inesperado ao cadastrar o filme: " + e.getMessage());
    	        // Aqui você pode adicionar outras ações de tratamento de erro, se necessário
    	    }   
    }

    public void atualizarFilme(FilmeTO filme) {
        // Lógicas de validação ou verificações específicas podem ser incluídas aqui
       String filmeNome = filme.getTitulo();
       FilmeTO filmeExistente = filmeDAO.findByTitulo(filmeNome);
    	
       try { 
    	   	if (filmeExistente == null) {
    	   		System.err.println("Filme não encontrado no banco de dados");
    	   	}
    	   
    	   
	        if (filme.getTitulo().isEmpty() || filme.getDiretor().isEmpty() || filme.getGenero().isEmpty()) {
	        	System.err.println("Preencha todos os dados para atualizar o filme");
	        }
	        
	        filmeDAO.update(filme);
	        
       } catch (Exception e) {
	        System.err.println("Não foi possivel excluir o item no banco de dados " + e.getMessage());
	        // Aqui você pode adicionar outras ações de tratamento de erro, se necessário
	   } 
        
        
    }

    public void deletarFilme(int id) {
        // Verificações antes de deletar um filme, se necessário
    	
    	FilmeTO filmeId = filmeDAO.findById(id);
    	
    	try {
    		
    		if(filmeId == null) {
    			System.out.println("O id selecionado não existe no banco de dados");
    		}
    		
    		filmeDAO.delete(id);
    		
    		
    	} catch (Exception e) {
	        System.err.println("Não foi possivel excluir o item no banco de dados " + e.getMessage());
	        // Aqui você pode adicionar outras ações de tratamento de erro, se necessário
	    } 
    	
    	
    }

    public FilmeTO buscarFilmePorId(int id) {
        return filmeDAO.findById(id);
    }
    
    public List<FilmeTO> listarTodosOsFilmes() {
        return filmeDAO.findAll();
    }
    
}