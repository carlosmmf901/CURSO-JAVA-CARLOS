package dados;
import negocios.*;

public class ClienteTO {
	private int codigo; 
	private String nome;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		if (ValidacaoGeralNegocio.validaCodigo(codigo)) {
			System.out.println("Codigo invalido");
		} 
		else {
		this.codigo = codigo; 
		}
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (ValidacaoGeralNegocio.validaNome(nome)) {
			this.nome = nome; 
		}
		
	} 
	
}
