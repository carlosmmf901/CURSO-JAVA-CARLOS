package dados.copy;

import java.util.Objects;

public class ClientePJTO {

	protected String CNPJ;
	protected String razaoSocial;
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	@Override
	public int hashCode() {
		return Objects.hash(CNPJ, razaoSocial);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePJTO other = (ClientePJTO) obj;
		return Objects.equals(CNPJ, other.CNPJ) && Objects.equals(razaoSocial, other.razaoSocial);
	}
	@Override
	public String toString() {
		return "ClientePJTO [CNPJ=" + CNPJ + ", razaoSocial=" + razaoSocial + "]";
	}
	
	
	
}
