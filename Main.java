import entities.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionario;
        List<Funcionario> funcionarios = new ArrayList<>();

        System.out.print("Digite o número de funcionários que serão registrados: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Funcionário " + (i + 1));
            System.out.print("Id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            while (checarFuncionarioRepetido(funcionarios, id)) {
                System.out.println("Este funcionário já existe no quadro, digite um Id novo.");
                System.out.print("Id: ");
                id = scanner.nextInt();
                scanner.nextLine();
            }
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Salário: ");
            double salario = scanner.nextDouble();
            funcionario = new Funcionario(id, nome, salario);
            funcionarios.add(funcionario);
        }
        System.out.println();
        System.out.print("Digite o id do funcionário que receberá o aumento: ");
        int idFunc = scanner.nextInt();
        while(checarSeFuncionarioExiste(funcionarios, idFunc)) {
            System.out.println("Este funcionário não existe na lista de funcionários. Tente novamente.");
            System.out.print("Id: ");
            idFunc = scanner.nextInt();
            scanner.nextLine();
        }
        System.out.println();
        System.out.print("Digite a porcentagem do aumento: ");
        double porcentagem = scanner.nextDouble();
        for (Funcionario funcionarioAumento: funcionarios){
            if (funcionarioAumento.getId() == idFunc){
                funcionarioAumento.aumentoSalario(porcentagem);
            }
        }

        System.out.println("Lista de funcionários");
        for (Funcionario func: funcionarios){
            System.out.println("Id: " + func.getId());
            System.out.println("Nome: " + func.getNome());
            System.out.println("Salario: " + func.getSalario());
            System.out.println("-----------------------------------");
        }

    }

    public static boolean checarFuncionarioRepetido(List<Funcionario> funcionarios, int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static boolean checarSeFuncionarioExiste(List<Funcionario> funcionarios, int id){
        for (Funcionario funcionario: funcionarios){
            if (funcionario.getId() == id) {
                return false;
            }
        }
        return  true;
    }


}
