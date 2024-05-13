package programas;
import dados.*;

public class Calculadora {
    
	 public static int memoriaInt;
	 public static float memoriaFloat;
	 private static long memoriaLong;
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		setMemoriaLong(somar(56, 76));
		memoriaFloat = somar(56.0F, 76.0F);
		System.out.println (getMemoriaLong());
		System.out.println (somar(56L, 76L));
		System.out.println (memoriaFloat);
		System.out.println (ConversorMetrico.METRO_PARA_CENTIMETRO);
	}
	
	public static long somar (int valor1, int valor2) {
		return (long)valor1 + (long)valor2;
	}
	
	public static float somar (float valor1, float valor2) {
		return valor1 + valor2;
	}
	
	public static long somar (long valor1, long valor2) {
		return valor1 + valor2;
	}
	public static long multiplicar (int valor1, int valor2) {
		return ((long) valor1 * (long) valor2);
	}
	public static long subtrair (int valor1, int valor2) {
		return (long)valor1 + (long)valor2;
	}
	public static long dividir (int valor1, int valor2) {
		return (long)valor1 + (long)valor2;
	}
	public static void setMemoriaLong (long valor1) {
		memoriaLong = valor1;
	}
	public static long getMemoriaLong () {
		return memoriaLong;
	}
	
	
	

}
