import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
public class exercicio8 {
    public static void main(String[] args) {
        Queue<String> controle = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        String processo;
        while (true) {
            System.out.println("\n1. Adicionar processo");
            System.out.println("2. Desfazer última processo");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Descrição da processo: ");
                    processo = scanner.nextLine();
                    controle.add(processo);
                    break;
                case 2:
                    String executavel=controle.remove();
                    System.out.println("O processo "+ executavel+" foi removido com sucesso e está pronto para ser executado" );
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

