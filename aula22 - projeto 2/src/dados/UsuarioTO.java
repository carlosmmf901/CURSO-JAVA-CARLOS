package dados;

import java.util.Objects;

public class UsuarioTO {
	private int id;
	private String nome;
	private String email;
	
	public UsuarioTO() {
		
	}
	
	public UsuarioTO(int id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public int hashCode() {
		return Objects.hash(email, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioTO other = (UsuarioTO) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Usuario {id=" + id + ", nome=" + nome + ", email=" + email + "}";
	}
	
}
