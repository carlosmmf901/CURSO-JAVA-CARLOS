package programa;
import excecoes.*;
import java.io.IOException;
import sql.exception;

public class TratamentoArrayMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 1) {
			System.out.println("Ola" + args[0]);
		}
		
		try {
			System.out.println("Ola" + args[0]);
		}
		
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println ("numero de parametros invalido");
			
		}
		
	}

}
