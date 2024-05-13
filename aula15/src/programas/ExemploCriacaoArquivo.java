package programas;
import java.io.*;

public class ExemploCriacaoArquivo {
	
	static String texto = new String("JAVA");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			FileOutputStream arquivo = new FileOutputStream("GerarArquivo.txt");
			DataOutputStream dados = new DataOutputStream(arquivo);
			dados.writeChars(texto);
		}
		
		catch(IOException e) {
			System.out.print((e.getMessage()));
		}
		
		
		
	}

}
