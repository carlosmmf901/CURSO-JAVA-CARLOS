package dados;

import java.util.Objects;

public class UsuarioTO {
	public int id;
	public String nome; 
	public String email;
	public String telefone; 
	public String dataCadastro;
	
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataCadastro, email, id, nome, telefone);
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
		return Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}
	@Override
	public String toString() {
		return "UsuarioTO [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", dataCadastro=" + dataCadastro + "]";
	}
	
	
}
