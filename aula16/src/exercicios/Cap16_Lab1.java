package exercicios;
import java.io.*;


public class Cap16_Lab1 {
	public static void main(String[] args) {
		
	escrever("Capítulo 16\nLaboratório 1");
	ler();
	
	}
	
	public static void escrever(String texto) {
		
		try {
			FileOutputStream arquivo = new FileOutputStream("Cap16_Lab1.txt");
			DataOutputStream dados = new DataOutputStream(arquivo);
			
			dados.writeChars(texto);
			
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	public static void ler() {
		
		try {
			FileInputStream arquivo = new FileInputStream("Cap16_Lab1.txt");
			DataInputStream dados = new DataInputStream(arquivo);
			
			while (dados.available() > 0) {
				 
				char c = (char) dados.read();
				System.out.println(c);
			}
			
			
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}
	
	
}
	

