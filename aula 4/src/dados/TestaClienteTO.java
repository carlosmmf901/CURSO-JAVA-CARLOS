package dados;
import dados.*;

public class TestaClienteTO {
	
	public static void main(String[] args) {
		ClienteTO objClienteTO = new ClienteTO ();
		objClienteTO.setCodigo (1);
		objClienteTO.setNome ("Zé");
		System.out.println(objClienteTO.getCodigo() + " " + objClienteTO.getNome()); 
		
	}
}
