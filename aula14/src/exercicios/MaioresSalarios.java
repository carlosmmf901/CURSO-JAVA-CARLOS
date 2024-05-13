package exercicios;

public class MaioresSalarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] salariosBrutos = {1.350,00, 4.320,15, 8.235,25, 2.500,55, 1.830,00, 
				850,26, 3.614,29, 12.500,00};
		double[] salariosTop;
		
		salariosTop = DoubleArrayUtils.filtraValores(salariosBrutos, salario -> salario >= 3000.00);
		
		for (double salario : salariosTop) {
	        System.out.println(salario);
	    }
	}

}


