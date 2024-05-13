package exercicios;
import java.util.Scanner;
import java.io.*;

public class ExercicioGravacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Digite uma frase qualquer");
			String usuarioFrase = scanner.nextLine();
			
			PrintWriter writer = new PrintWriter("C:\\\\doc1.txt");
			writer.println(usuarioFrase);
			writer.close();
		} catch(IOException e) {
			System.out.println("Falha ao gravar as informações digitadas");
		}
		
		
	
		
	}

}
