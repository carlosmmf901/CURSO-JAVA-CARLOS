import dados.*;
public class ExemploArrayUnidimensionalClienteTO {


		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//1.declaração e instanciamento do array
			ClienteTO[] objArray = new ClienteTO[10];
			//2.inicialização de cada elemento do array 
		    objArray = 	carregaArrayClienteTO(objArray);
		    //3.manipulação do array
		    objArray[4] = new ClienteTO(5,"JOAO");
		    objArray[9] = new ClienteTO(10,"MARIA");
			//4.Consulta o Array (percorrer o array)
		    consultaArrayClienteTO(objArray);
		    ClienteTO [] objArray2 = { new ClienteTO(1), new ClienteTO(2)};
		    consultaArrayClienteTO(objArray2);
		}
		
		public static ClienteTO[] carregaArrayClienteTO
		(ClienteTO[] obj) {
			for (int x = 0 ; x < obj.length; x++)
			{
				obj[x] = new ClienteTO();
			}
			return obj;
		}
		public static void consultaArrayClienteTO(ClienteTO[] obj) {
			for (ClienteTO x : obj)
			{
				System.out.println(x.toString());
			}
		
		}

}
