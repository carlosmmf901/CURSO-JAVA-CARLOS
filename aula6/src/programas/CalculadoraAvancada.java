package programas;

public class CalculadoraAvancada {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
	 Calculadora.setMemoriaLong(323);
	 Calculadora.setMemoriaLong(Calculadora.somar( Calculadora.getMemoriaLong(), 789));
	 System.out.println(Calculadora.getMemoriaLong());   
	 System.out.println(raizQuadrada(4));   
	}	
	
	public static double raizQuadrada(double valor) {
		return(Math.sqrt(valor));
	}
	

	public static long somar (long valor1, long valor2) {
		return(Calculadora.somar(valor1, valor2));
	}
	
}
