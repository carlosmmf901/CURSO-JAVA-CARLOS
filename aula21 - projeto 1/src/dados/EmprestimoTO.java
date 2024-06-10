package dados;
import java.util.Date;
import negocios.*;

public class EmprestimoTO {
	public int id;
	public Usuario usuario;
	public Livro livro;
	public Date dataEmprestimo;
	public String dataDevolucaoPrevista;
	public String dataDevolucaoReal;
	
	public EmprestimoTO(int id, Usuario usuario, Livro livro, Date dataEmprestimo, String dataDevolucaoPrevista,
			String dataDevolucaoReal) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.livro = livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.dataDevolucaoReal = dataDevolucaoReal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	public void setDataDevolucaoPrevista(String dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	public String getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}

	public void setDataDevolucaoReal(String dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}

	@Override
	public String toString() {
		return "EmprestimoTO [id=" + id + ", usuario=" + usuario + ", livro=" + livro + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucaoPrevista=" + dataDevolucaoPrevista + ", dataDevolucaoReal="
				+ dataDevolucaoReal + "]";
	}
	
	
	
	
}
