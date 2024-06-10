package dados;
import negocios.*;

public class NotificacaoTO {
	public int id;
	public Usuario usuario;
	public String mensagem;
	public String dataNotificacao;
	public Boolean lida;
	
	public NotificacaoTO(int id, Usuario usuario, String mensagem, String dataNotificacao, Boolean lida) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.mensagem = mensagem;
		this.dataNotificacao = dataNotificacao;
		this.lida = lida;
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
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDataNotificacao() {
		return dataNotificacao;
	}
	public void setDataNotificacao(String dataNotificacao) {
		this.dataNotificacao = dataNotificacao;
	}
	public Boolean getLida() {
		return lida;
	}
	public void setLida(Boolean lida) {
		this.lida = lida;
	}

	@Override
	public String toString() {
		return "NotificacaoTO [id=" + id + ", usuario=" + usuario + ", mensagem=" + mensagem + ", dataNotificacao="
				+ dataNotificacao + ", lida=" + lida + "]";
	}
	
}
