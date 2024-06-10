package dados;
import java.util.Objects;

public class LivroTO {
    private int id;
    private String titulo;
    private AutorTO autor = new AutorTO(); // Simplificação para manter o foco na estrutura
    private int anoPublicacao;
    private String categoria;
    private int quantidade;

    public LivroTO() {
        // Construtor padrão
    }

    public LivroTO(int id, String titulo, AutorTO autor, int anoPublicacao, String categoria, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    
    public LivroTO(int id, String titulo, int idAutor, int anoPublicacao, String categoria, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor.setId(idAutor);
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    
    public LivroTO(int id, String titulo, int idAutor,String nome, int anoPublicacao, String categoria, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor.setId(idAutor);
        this.autor.setNome(nome);
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }
    
    public LivroTO(int id, String titulo, int idAutor,String nome, String paisOrigem, int anoPublicacao, String categoria, int quantidade) {
        this.id = id;
        this.titulo = titulo;
        this.autor.setId(idAutor);
        this.autor.setNome(nome);
        this.autor.setPaisOrigem(paisOrigem);
        this.anoPublicacao = anoPublicacao;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAutorId() { return autor.getId(); }
    public void setAutorId(int autorId) { this.autor.setId(autorId); }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    
    
    //metodos chamados na classe de AutorTO
    
    public int getIdAutor() { return autor.getId(); }
    public void setIdAutor(int id) { this.autor.setId(id); }

    public String getNomeAutor() { return autor.getNome(); }
    public void setNomeAutor(String nome) { this.autor.setNome(nome); }

    public String getPaisOrigem() { return autor.getPaisOrigem(); }
    public void setPaisOrigem(String paisOrigem) { this.autor.setPaisOrigem(paisOrigem);  }

    public String getDataNascimento() { return autor.getDataNascimento(); }
    public void setDataNascimento(String dataNascimento) { this.autor.setDataNascimento(dataNascimento);  }

    // toString
    @Override
    public String toString() {
        return "LivroTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", categoria='" + categoria + '\'' +
                ", quantidade=" + quantidade +
                '}' + "\n"  + autor.toString();
    }

    // equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivroTO)) return false;
        LivroTO livroTO = (LivroTO) o;
        return id == livroTO.id &&
                anoPublicacao == livroTO.anoPublicacao &&
                quantidade == livroTO.quantidade &&
                Objects.equals(titulo, livroTO.titulo) &&
                Objects.equals(categoria, livroTO.categoria) &&
                autor.getId() == livroTO.getIdAutor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor.getId(), anoPublicacao, categoria, quantidade);
    }
}

