package Exercicios.Lab1;
import java.util.Objects;

public class Professor extends Pessoa {
    private float salario;
    private String disciplina;

    // Construtor de Professor
    public Professor(String nome, int idade, char sexo,  float salario, String disciplina) {
        super(nome, idade, sexo);
        this.salario = salario;
        this.disciplina = disciplina;
    }

    // Getters e Setters para salario e disciplina
    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }


}
