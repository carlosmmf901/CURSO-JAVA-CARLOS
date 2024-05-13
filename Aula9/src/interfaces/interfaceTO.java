package interfaces;

public interface interfaceTO {

	default void armazenar (Object obj) {
		System.out.println("Método a ser implementado");
	}
	
	default void imprimir (Object obj) {
		System.out.println(this.toString());
	}
	
}
