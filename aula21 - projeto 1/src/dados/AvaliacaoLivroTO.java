package dados;

import java.util.Objects;

public class AvaliacaoLivroTO {
	public int id;
	public LivroTO livro = new LivroTO();
	public UsuarioTO usuario = new UsuarioTO();
	public int nota;
	public String comentario;
		
	public AvaliacaoLivroTO() {
		
	}

	public AvaliacaoLivroTO(int id, int IdLivro, int IdUsuario, int nota, String comentario) {
		this.id = id;
		this.livro.setId(IdLivro);
		this.usuario.setId(IdUsuario);
		this.nota = nota;
		this.comentario = comentario;
	}
	
	public AvaliacaoLivroTO(int id, int IdLivro, String tituloLivro, String nomeUsuario, int IdUsuario, int nota, String comentario) {
		this.id = id;
		this.livro.setId(IdLivro);
		this.livro.setTitulo(tituloLivro);
		this.usuario.setId(IdUsuario);
		this.nota = nota;
		this.comentario = comentario;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LivroTO getLivroId() {
		return livro;
	}

	public void setLivro(LivroTO livro) {
		this.livro = livro;
	}

	public UsuarioTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioTO usuario) {
		this.usuario = usuario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	} 
	
	//metodos chamados na classe de LivroTO
	
	public int getIdLivro() { return livro.getId(); }
	public void setIdLivro(int id) { this.livro.setId(id); }
	
	public String getLivroTitulo() { return livro.getTitulo(); }
	public void setLivroTitulo(String nome) { this.livro.setNomeAutor(nome); }
	
	public int getIdUsuario() { return usuario.getId(); }
    public void setIdUsuario(int id) { this.usuario.setId(id); }

	
    @Override
	public String toString() {
		return "AvaliacaoLivroTO{" +
				"id=" + id +
				", livro=" + livro + '\'' +
				", usuario=" + '\'' + 
				usuario + '\'' +
				", nota=" + nota
				+ ", comentario=" + comentario + "}" +
				livro.toString() + 
				usuario.toString();
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoLivroTO other = (AvaliacaoLivroTO) obj;
		return Objects.equals(comentario, other.comentario) && id == other.id && Objects.equals(livro, other.livro)
				&& nota == other.nota && Objects.equals(usuario, other.usuario);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(comentario, id, livro.getId(), usuario.getId(), nota, usuario);
	}
    
    
	
}
