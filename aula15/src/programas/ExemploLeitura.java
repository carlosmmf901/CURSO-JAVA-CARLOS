package programas;
import java.io.*;

public class ExemploLeitura {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileInputStream arquivo = new FileInputStream("GerarArquivo.txt");
			DataInputStream dados = new DataInputStream(arquivo);
			while(true) {
				char c = dados.readChar();
				System.out.print(c);
			}
			}
			catch(IOException e) {
				System.out.print(e.getMessage());
			}
			
		}
}
