package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dados.*;

public class UsuarioDAO {
    private Connection con;
    private PreparedStatement comando;

    public UsuarioDAO(Connection con) {
        this.con = con;
    }
    
    public void insert(UsuarioTO usuario) {
        conectar();
        try {
            comando = con.prepareStatement("INSERT INTO usuarios (nome, email, telefone, data_cadastro) VALUES (?, ?, ?, ?)");
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getTelefone());
            comando.setString(4, usuario.getDataCadastro());
            comando.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");
        } catch (SQLException e) {
            imprimeErro("Erro ao inserir usuário", e.getMessage());
        } finally {
            fechar();
        }
    }

    public void update(UsuarioTO usuario) {
        conectar();
        try {
            comando = con.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, telefone = ?, data_cadastro = ? WHERE id = ?");
            comando.setString(1, usuario.getNome());
            comando.setString(2, usuario.getEmail());
            comando.setString(3, usuario.getTelefone());
            comando.setString(4, usuario.getDataCadastro());
            comando.setInt(5, usuario.getId());
            comando.executeUpdate();
            System.out.println("Usuário atualizado com sucesso!");
        } catch (SQLException e) {
            imprimeErro("Erro ao atualizar usuário", e.getMessage());
        } finally {
            fechar();
        }
    }
    
    public void delete(int id) {
        conectar();
        try {
            comando = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            comando.setInt(1, id);
            comando.executeUpdate();
            System.out.println("Usuário excluído com sucesso!");
        } catch (SQLException e) {
            imprimeErro("Erro ao excluir usuário", e.getMessage());
        } finally {
            fechar();
        }
    }
    
    public List<UsuarioTO> findAll() {
        conectar();
        List<UsuarioTO> usuarios = new ArrayList<>();
        ResultSet rs;
        try {
            comando = con.prepareStatement("SELECT * FROM usuarios");
            rs = comando.executeQuery();
            while (rs.next()) {
            	  UsuarioTO usuario = new UsuarioTO();
            	  usuario.setId(rs.getInt("id"));
            	  usuario.setNome(rs.getString("nome"));
            	  usuario.setEmail(rs.getString("email"));
            	  usuario.setTelefone(rs.getString("telefone"));
            	  usuario.setDataCadastro(rs.getString("dataCadastro"));
            	  usuarios.add(usuario);
              }
        } catch (SQLException e) {
            imprimeErro("Erro ao buscar usuários", e.getMessage());
        } finally {
            fechar();
        }
        return usuarios;
    }
    
    public UsuarioTO findById(int id) {
        conectar();
        UsuarioTO usuario = null;
        ResultSet rs;
        try {
            comando = con.prepareStatement("SELECT * FROM usuarios WHERE id = ?");
            comando.setInt(1, id);
            rs = comando.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioTO();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setDataCadastro(rs.getString("data_cadastro"));
            }
        } catch (SQLException e) {
            imprimeErro("Erro ao buscar usuário por ID", e.getMessage());
        } finally {
            fechar();
        }
        return usuario;
    }

    private void conectar() {
        try {
            con = ConFactory.conexao(DAO.URL, DAO.NOME, DAO.SENHA, ConFactory.MYSQL);  

            System.out.println("Conectado!");  
            // Conectar ao banco de dados aqui
        } catch (Exception e) {
            imprimeErro("Erro ao conectar ao banco de dados", e.getMessage());
        }
    }

    private void fechar() {
        try {
            if (comando != null) {
                comando.close();
            }
            // Fechar conexão com o banco de dados aqui
        } catch (SQLException e) {
            imprimeErro("Erro ao fechar conexão", e.getMessage());
        }
    }

    private void imprimeErro(String mensagem, String erro) {
        System.out.println(mensagem + ": " + erro);
    }
}
    
    
    
    
    
    
    
    
    

  





   

