package interfaces;

public interface Eletrodomestico {
	public String estadoInicial = "Desligado";
	public String mensagemLigar = "Ligando";

	public void ligar();
	public void desligar();
	
	static void ligarTudo(Eletrodomestico... eletroArray) {
		for (Eletromodestico eletro : eletroArray) {
			eletro.ligar();
		}
	}
	
	
	
}
