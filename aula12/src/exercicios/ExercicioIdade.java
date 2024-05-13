package exercicios;
import java.util.Scanner;
import java.time.LocalDate;

public class ExercicioIdade {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scanner = new Scanner(System.in);
			LocalDate dataAtual = LocalDate.now();
			int anoAtual = dataAtual.getYear();
			
			
			System.out.println("Digite seu ano de nascimento:");
			String usuarioIdade = scanner.nextLine();
			
			int usuarioIdadeInt = Integer.parseInt(usuarioIdade);
			calculoUsuarioIdade(usuarioIdadeInt, anoAtual);
		} catch (NumberFormatException e) {
			System.out.println("Valor digitado invalido");
		}
		

	}
	
	public static int calculoUsuarioIdade(int anoNascimento, int anoAtual) {
		int calculoUsuarioIdade = anoAtual - anoNascimento;
		System.out.println("A idade do usuário é: " + calculoUsuarioIdade);
		return calculoUsuarioIdade;
	}
		

}
