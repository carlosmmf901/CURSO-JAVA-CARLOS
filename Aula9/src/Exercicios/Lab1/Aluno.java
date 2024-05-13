package Exercicios.Lab1;

public class Aluno extends Pessoa {
    private float mensalidade;
    private String curso;

    // Construtor de Aluno
    public Aluno(String nome, int idade, char sexo,  float mensalidade, String curso) {
        super(nome, idade, sexo );
        this.mensalidade = mensalidade;
        this.curso = curso;
    }

    // Getters e setters
    public float getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(float mensalidade) {
        this.mensalidade = mensalidade;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

 }
