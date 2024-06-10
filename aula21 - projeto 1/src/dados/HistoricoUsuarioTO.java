package dados;
import negocios.*;

public class HistoricoUsuarioTO {
	public int id;
	public Usuario usuario;
	public Livro livro;
	public String dataAcesso;
	public String tipoAcesso;
	
	public HistoricoUsuarioTO(int id, Usuario usuario, Livro livro, String dataAcesso, String tipoAcesso) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.livro = livro;
		this.dataAcesso = dataAcesso;
		this.tipoAcesso = tipoAcesso;
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
	public String getDataAcesso() {
		return dataAcesso;
	}
	public void setDataAcesso(String dataAcesso) {
		this.dataAcesso = dataAcesso;
	}
	public String getTipoAcesso() {
		return tipoAcesso;
	}
	public void setTipoAcesso(String tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}

	@Override
	public String toString() {
		return "HistoricoUsuarioTO [id=" + id + ", usuario=" + usuario + ", livro=" + livro + ", dataAcesso="
				+ dataAcesso + ", tipoAcesso=" + tipoAcesso + "]";
	}
	
	
	
}
