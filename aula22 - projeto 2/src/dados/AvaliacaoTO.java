package dados;

import java.util.Objects;

public class AvaliacaoTO {
	private int id;
	private int idFilmeSerie;
	private Double nota;
	private String comentario;
	private String tipo;
	
	public AvaliacaoTO() {
		
	}
	
	public AvaliacaoTO(int id, int idFIlmeSerie, Double nota, String comentario, String tipo) {
		super();
		this.id = id;
		this.idFilmeSerie = idFIlmeSerie;
		this.nota = nota;
		this.comentario = comentario;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdFilmeSerie() {
		return idFilmeSerie;
	}

	public void setIdFilmeSerie(int idFIlmeSerie) {
		this.idFilmeSerie = idFIlmeSerie;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comentario, id, idFilmeSerie, nota, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoTO other = (AvaliacaoTO) obj;
		return Objects.equals(comentario, other.comentario) && id == other.id && idFilmeSerie == other.idFilmeSerie
				&& Objects.equals(nota, other.nota) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", idFIlmeSerie=" + idFilmeSerie + ", nota=" + nota + ", comentario="
				+ comentario + ", tipo=" + tipo + "]";
	}
	
	
	
	
	
	
}
