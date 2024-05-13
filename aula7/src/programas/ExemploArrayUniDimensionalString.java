public class ExemploArrayUniDimensionalString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.declaração e instanciamento do array
		String[] objArray = new String[10];
		//2.inicialização de cada elemento do array 
	    objArray = 	carregaArrayString(objArray,"Impacta");
	    //3.manipulação do array
	    objArray[4] = "joao da silva";
	    objArray[9] = "maria da silva";
		//4.Consulta o Array (percorrer o array)
	    consultaArrayString(objArray);
	}
	
	public static String[] carregaArrayString(String[] obj, 
			String valor) {
		for (int x = 0 ; x < obj.length; x++)
		{
			obj[x] = valor;
		}
		return obj;
	}
	public static void consultaArrayString(String[] obj) {
		for (String x : obj)
		{
			System.out.println(x);
		}
	
	}
}
