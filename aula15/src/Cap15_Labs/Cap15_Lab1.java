package Cap15_Labs;
import java.util.HashMap;
import java.util.Map;

public class Cap15_Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> pessoaMap = new HashMap<>();
		
		pessoaMap.put("Roberto" , 33);
		pessoaMap.put("Marcos" , 28);
		pessoaMap.put("Flávio" , 37);
		pessoaMap.put("Beto" , 25);
		
		pessoaMap.forEach((key, value) -> {
	            System.out.println("Nome: " + key + ", Idade: " + value);
	        });
		
	}

}
