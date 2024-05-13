package dados.copy;
import java.util.Objects;


public class ClientePFTO extends ClienteTO{
    protected String cpf;
    protected String rg;
    

	@Override
	public String toString() {
		return super.toString() + "ClientePFTO [cpf=" + cpf + ", rg=" + rg + "]";
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf, rg);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientePFTO other = (ClientePFTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(rg, other.rg);
	}
	

}
