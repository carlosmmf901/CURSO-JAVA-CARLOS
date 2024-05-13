package exercicios;
import java.util.function.DoubleUnaryOperator;
import java.util.Arrays;
import java.util.function.Predicate;

public class DescontoSalarial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] salariosBrutos = {1.350,00, 4.320,15, 8.235,25, 2.500,55, 1.830,00, 850,26, 3.614,29, 12.500,00};
		double[] salariosLiquidos = DoubleArrayUtils.transformaValores(salariosBrutos,
                (double salario) -> salario * 0.9);

        System.out.println(Arrays.toString(salariosLiquidos));
	}

}
