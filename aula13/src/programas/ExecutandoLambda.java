package programas;
import interfaces.*;

public class ExecutandoLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OperacaoAritmetica operacao = (a, b) -> a + b; 
		
		double result = operacao.execute(15.8, 8.3);
		
		System.out.println(result);
		
	}

}
