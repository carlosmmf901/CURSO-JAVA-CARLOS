package dados;
import java.util.Objects;

public class AutorTO {
	private int id;
	private String nome;
	private String paisOrigem;
	private String dataNascimento;
	
	public AutorTO() {
		
	}

	public AutorTO(int id, String nome, String paisOrigem, String dataNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.paisOrigem = paisOrigem;
		this.dataNascimento = dataNascimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
    public String toString() {
        return "AutorTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", paisOrigem='" + paisOrigem + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AutorTO)) return false;
        AutorTO autorTO = (AutorTO) o;
        return id == autorTO.id &&
                Objects.equals(nome, autorTO.nome) &&
                Objects.equals(paisOrigem, autorTO.paisOrigem) &&
                Objects.equals(dataNascimento, autorTO.dataNascimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, paisOrigem, dataNascimento);
    }	
	
	
}
