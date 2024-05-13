package Exercicios.Lab1;

public class RG {
    private int numero;
    private String dataNasc;

    // Construtor
    public RG(int numero, String dataNasc) {
        this.numero = numero;
        this.dataNasc = dataNasc;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    // Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
}