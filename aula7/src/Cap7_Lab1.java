import dados.*;

public class Cap7_Lab1 {
    public static void main(String[] args) {
        // Criando três objetos Cadastro
        Cadastro cadastro1 = new Cadastro();  // Construtor padrão
        Cadastro cadastro2 = new Cadastro("Cláudio", "Abreu");  // Construtor com nome e sobrenome
        Cadastro cadastro3 = new Cadastro("Lourdes", "Souza", 40);  // Construtor com nome, sobrenome e idade

        // Usando o método mostrar para exibir os valores dos atributos de cada objeto
        cadastro1.mostrar();
        cadastro2.mostrar();
        cadastro3.mostrar();
    }
}

class Cadastro {
    // Atributos privados
    private String nome;
    private String sobrenome;
    private int idade;

    // Construtor padrão
    public Cadastro() {
        // Valores padrão atribuídos implicitamente: null para Strings e 0 para int
    }

    // Construtor com nome e sobrenome
    public Cadastro(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        // A idade permanece o valor padrão de 0
    }

    // Construtor com nome, sobrenome e idade
    public Cadastro(String nome, String sobrenome, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }

    // Método para mostrar os dados
    public void mostrar() {
        System.out.println("Nome: " + nome);
        System.out.println("Sobrenome: " + sobrenome);
        System.out.println("Idade: " + idade);
    }

    // Getters e setters omitidos para brevidade
}