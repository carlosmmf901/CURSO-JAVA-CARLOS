package dados.copy;

import java.util.Objects;

public class EnderecoTO {
	protected String logradouro;
	protected String complemento;
	protected String CEP; 
	protected String estado;
	protected String cidade;
	protected String numero;
	protected String bairro;
	
	public EnderecoTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CEP, bairro, cidade, complemento, estado, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoTO other = (EnderecoTO) obj;
		return Objects.equals(CEP, other.CEP) && Objects.equals(bairro, other.bairro)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(estado, other.estado) && Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero);
	}

	@Override
	public String toString() {
		return "EnderecoTO [logradouro=" + logradouro + ", complemento=" + complemento + ", CEP=" + CEP + ", estado="
				+ estado + ", cidade=" + cidade + ", numero=" + numero + ", bairro=" + bairro + "]";
	}
	

	
	
	
}
