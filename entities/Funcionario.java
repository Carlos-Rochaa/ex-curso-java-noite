package entities;

public class Funcionario {
    private final int id;
    private final String nome;
    private double salario;


    public Funcionario(int id, String nome, double salario) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }


    public double getSalario() {
        return salario;
    }


    public void aumentoSalario(double porcentagem) {
        salario += salario * porcentagem / 100;
    }


}

