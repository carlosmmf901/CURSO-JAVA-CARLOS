package programas;
import interfaces.*;

public class Executando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperacaoAritmetica operacao = new Soma();
				
		double result = operacao.execute(15.8, 8.3);
		
		System.out.println(result); 
		
		
	}

}
