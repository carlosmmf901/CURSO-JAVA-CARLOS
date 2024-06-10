package dados;

import java.util.Objects;

public class FilmeTO {
	private int id;
	private String titulo;
	private String diretor;
	private int anoLancamento;
	private String genero;
	
	public FilmeTO() {
		
	}
	
	public FilmeTO(int id, String titulo, String diretor, int anoLancamento, String genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.diretor = diretor;
		this.anoLancamento = anoLancamento;
		this.genero = genero;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoLancamento, diretor, genero, id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmeTO other = (FilmeTO) obj;
		return anoLancamento == other.anoLancamento && Objects.equals(diretor, other.diretor)
				&& Objects.equals(genero, other.genero) && id == other.id && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "{id=" + id + ", titulo=" + titulo + ", diretor=" + diretor + ", anoLancamento=" + anoLancamento
				+ ", genero=" + genero + "}";
	}
	
}
