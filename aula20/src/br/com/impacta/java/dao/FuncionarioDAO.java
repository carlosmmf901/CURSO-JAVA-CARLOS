package br.com.impacta.java.dao;
import br.com.impacta.java.model.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/impacta";
    private static final String USER = "aluno";
    private static final String PASSWORD = "java";
    private Connection connection;

    private Connection getConnection() throws DAOException {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            throw new DAOException("Erro ao obter conexão com o banco de dados", e);
        }
    }
    
    public void persist(Funcionario func) throws DAOException {
        String sql = "INSERT INTO TAB_FUNC (func_nome, func_rmnt_val, role_code) VALUES (?, ?, ?)";
        PreparedStatement statement = null;
        
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            
            // Preenchendo os parâmetros do PreparedStatement com os atributos do funcionário
            statement.setString(1, func.getNome());
            statement.setDouble(2, func.getSalario());
            statement.setInt(3, func.getCargoid());
            
            // Executando o comando SQL para inserção
            statement.executeUpdate();
        } catch (SQLException e) {
            // Tratamento de exceção, caso ocorra algum erro na inserção
            throw new DAOException("Falha ao salvar dados do funcionário", e);
        } finally {
            // Fechamento da conexão e do PreparedStatement
            closeResources(connection, statement, null);
        }
    }
    

    private void closeResources(Connection cn, Statement st, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> buscarPorParteDoNome(String parteDoNome) throws DAOException {
        List<Funcionario> funcionariosEncontrados = new ArrayList<>();
        String sql = "SELECT func_code, func_name, func_rmnt_val, role_code FROM TAB_FUNC WHERE func_name LIKE ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + parteDoNome + "%");
            rs = ps.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("func_code"));
                funcionario.setNome(rs.getString("func_name"));
                funcionario.setSalario(rs.getDouble("func_rmnt_val"));
                funcionario.setCargoid(rs.getInt("role_code"));
                funcionariosEncontrados.add(funcionario);
            }
        } catch (SQLException e) {
            throw new DAOException("Falha ao realizar consulta", e);
        } finally {
            closeResources(connection, ps, rs);
        }

        return funcionariosEncontrados;
    }
}
