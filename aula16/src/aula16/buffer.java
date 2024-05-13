package aula16;
import java.nio.CharBuffer;

public class buffer {

	public static void main (String [] args) {
	
		CharBuffer buffer = CharBuffer.allocate(8);

		String text = "apple";
		System.out.println("Insira o texto: " + text);

		for (int i = 0; i < text.length(); i++) {

			char c = text.charAt(i);
			buffer.put(c);
		}

		int buffPos = buffer.position();	
		System.out.println("posição dos dados depois de gravar no buffer: " + buffPos);
		
		buffer.flip();
		
		System.out.println("lendo o conteudo do buffer: ");
		
		while (buffer.hasRemaining()) {

			System.out.println(buffer.get());                   
		}
	}

}
