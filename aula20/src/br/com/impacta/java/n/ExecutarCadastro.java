package br.com.impacta.java.n;
import br.com.impacta.java.dao.*;
import br.com.impacta.java.model.*;
import java.util.Scanner;


public class ExecutarCadastro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite os dados:");
		
		String nome = scanner.nextLine();
		double salario = scanner.nextDouble();
		int codigo = scanner.nextInt();

		Funcionario Funcionario = new Funcionario();
		
		Funcionario.setNome(nome);
		Funcionario.setSalario(salario);
		Funcionario.setCargoid(codigo);
		
		FuncionarioDAO FuncionarioDAO = new FuncionarioDAO();
		
		try {
			FuncionarioDAO.persist(Funcionario);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
