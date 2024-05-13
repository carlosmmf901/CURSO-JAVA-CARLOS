package programas;
import java.util.ArrayList;
import java.util.List;

public class ExemploArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> paises = new ArrayList<>();
		
		paises.add("Brasil");
		paises.add("Portugal");
		paises.add("Estados Unidos");
		paises.add("França");
		paises.add("Inglaterra");
		paises.add(2, "Itália");
		
		
		System.out.println("Países na ordem original:");
		paises.forEach(a -> System.out.println(" - " + a));
		
		System.out.println("============================");
		
		System.out.println(paises.contains("Estados Unidos"));
		
		System.out.println(paises.get(2));
		
		System.out.println(paises.size());
		
		System.out.println(paises.indexOf("França"));
		
		paises.replaceAll(s -> s.toUpperCase());
		
		paises.sort((x, y) -> x.compareTo(y));
		
		System.out.println("============================");
		
		System.out.println("Paises ordenados e em maiúsculo");
		
		paises.forEach(curso -> System.out.println(" - " + curso));
		
	}

}
