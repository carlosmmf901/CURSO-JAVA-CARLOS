package negocios;

public class ValidacaoGeralNegocio {
	public static boolean validaNome (String nome) {
		if (nome.length() > 0) {
			return true; 
		}
	return false;
	}
	public static boolean validaCodigo (int codigo) {
		if (codigo >= 1)  {
			return true;
		}
		return false;
	}
	
}

