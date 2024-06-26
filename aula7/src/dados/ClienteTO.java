import java.util.Objects;

public class ClienteTO {
     private int codigo;
     private String nome;
     private String email;
	public ClienteTO() {
		super();
	}
	public ClienteTO(int codigo) {
		super();
		this.codigo = codigo;
	}
	public ClienteTO(int codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
	}
	public ClienteTO(int codigo, String nome, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "ClienteTO [codigo=" + codigo + ", nome=" + nome + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codigo, email, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteTO other = (ClienteTO) obj;
		return codigo == other.codigo && Objects.equals(email, other.email) && Objects.equals(nome, other.nome);
	}
    
     
}