package aplicacoes;
import interfaces.*;


public class Televisao implements Eletrodomestico {
	public void ligar() {
		System.out.println("Ligando a televisao");
	}
	
	public void desligar() {
		System.out.println("Desligando a televisao");
	}
}
