package programas;

public class TestandoGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CacheGenerico<String> cacheNome = new CacheGenerico<>();
		CacheGenerico<Integer> cachePortfolio = new CacheGenerico<>();
		
		cacheNome.setValue("Impacta");
		cachePortfolio.setValue(80);
		
		System.out.println("Nome " + cacheNome.getValue());
		System.out.println("Portfifolio: " + cachePortfolio.getValue());
		
		
	}

}
