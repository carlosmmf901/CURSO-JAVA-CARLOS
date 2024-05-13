public class ExemploArrayUniDimensional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.declaração e instanciamento do array
		int[] objArray = new int[10];
		//2.inicialização de cada elemento do array 
	    objArray = 	carregaArrayInt(objArray,10);
	    //3.manipulação do array
	    objArray[4] = 50;
	    objArray[9] = 100;
		//4.Consulta o Array (percorrer o array)
	    consultaArrayInt(objArray);
	    System.out.println("Percorrendo o array anonimo");
	    consultaArrayInt(new int[] {100, 200});
	}
	
	public static int[] carregaArrayInt(int[] obj, int valor) {
		for (int x = 0 ; x < obj.length; x++)
		{
			obj[x] = valor;
		}
		return obj;
	}
	public static void consultaArrayInt(int[] obj) {
		for (int x : obj)
		{
			System.out.println(x);
		}
	
	}
}