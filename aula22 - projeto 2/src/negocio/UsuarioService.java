package negocio;

import dao.UsuarioDAO;
import dados.UsuarioTO;
import java.util.List;

public class UsuarioService {
    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarNovoUsuario(UsuarioTO usuario) {
        try {
            // Verificar se o usuário já existe no banco de dados
            UsuarioTO usuarioExistente = usuarioDAO.findByName(usuario.getEmail());
            if (usuarioExistente != null) {
                throw new IllegalArgumentException("O usuário já existe no banco de dados.");
            }
            
            // Se todas as verificações passarem, inserir o usuário
            usuarioDAO.insert(usuario);
            System.out.println("Usuário cadastrado com sucesso!");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao cadastrar o usuário: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        } catch (Exception e) {
            System.err.println("Erro inesperado ao cadastrar o usuário: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        }
    }

    public void atualizarUsuario(UsuarioTO usuario) {
        try {
            // Verificar se o usuário existe no banco de dados
            UsuarioTO usuarioExistente = usuarioDAO.findById(usuario.getId());
            if (usuarioExistente == null) {
                throw new IllegalArgumentException("O usuário não existe no banco de dados.");
            }
            
            // Se todas as verificações passarem, atualizar o usuário
            usuarioDAO.update(usuario);
            System.out.println("Usuário atualizado com sucesso!");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao atualizar o usuário: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        } catch (Exception e) {
            System.err.println("Erro inesperado ao atualizar o usuário: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        }
    }

    public void deletarUsuario(int id) {
        try {
            // Verificar se o usuário existe no banco de dados
            UsuarioTO usuarioExistente = usuarioDAO.findById(id);
            if (usuarioExistente == null) {
                throw new IllegalArgumentException("O usuário não existe no banco de dados.");
            }
            
            // Se todas as verificações passarem, deletar o usuário
            usuarioDAO.delete(id);
            System.out.println("Usuário deletado com sucesso!");
            
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao deletar o usuário: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        } catch (Exception e) {
            System.err.println("Erro inesperado ao deletar o usuário: " + e.getMessage());
            // Tratamento adicional de erro, se necessário
        }
    }

    public UsuarioTO buscarUsuarioPorId(int id) {
        return usuarioDAO.findById(id);
    }
    
    public List<UsuarioTO> listarTodosOsUsuarios() {
        return usuarioDAO.findAll();
    }
}
