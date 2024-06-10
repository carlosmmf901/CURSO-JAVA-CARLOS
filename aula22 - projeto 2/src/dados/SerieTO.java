package dados;

import java.util.Objects;

public class SerieTO {
	private int id;
	private String titulo;
	private String criador;
	private int anoInicio;
	private String genero;
	
	public SerieTO() {
		
	}
	
	
	public SerieTO(int id, String titulo, String criador, int anoInicio, String genero) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.criador = criador;
		this.anoInicio = anoInicio;
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


	public String getCriador() {
		return criador;
	}


	public void setCriador(String criador) {
		this.criador = criador;
	}


	public int getAnoInicio() {
		return anoInicio;
	}


	public void setAnoInicio(int anoInicio) {
		this.anoInicio = anoInicio;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public int hashCode() {
		return Objects.hash(anoInicio, criador, genero, id, titulo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SerieTO other = (SerieTO) obj;
		return anoInicio == other.anoInicio && Objects.equals(criador, other.criador)
				&& Objects.equals(genero, other.genero) && id == other.id && titulo == other.titulo;
	}


	@Override
	public String toString() {
		return "Serie [id=" + id + ", titulo=" + titulo + ", criador=" + criador + ", anoInicio=" + anoInicio
				+ ", genero=" + genero + "]";
	}
	
	
}
