package dados;

public class ProdutoTO {
	private Int id;
	private String nome;
	private Float preco;
	private Char status;
	
	public Int getId() {
		return id;
	}
	public void setId(Int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	} 
	
	@Override 
	public String toString() {
		System.out.println(super.toString());
		return "ProdutoTO ()"
	}
	
	
	
	
	
	
}
