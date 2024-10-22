import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.List;

class exercicio7 {
    private String arquivo;

    public exercicio7(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getNomeArquivo() {
        return arquivo;
    }
 public static void main(String[] args) {
        Queue<exercicio7> filaImpressao = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Adicionar trabalho de impressão");
            System.out.println("2. Processar próximo trabalho");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do arquivo: ");
                    String nomeArquivo = scanner.nextLine();
                    filaImpressao.add(new exercicio7(nomeArquivo));
                    System.out.println("Trabalho de impressão " + nomeArquivo + " adicionado à fila.");
                    break;
                case 2:
                    if (!filaImpressao.isEmpty()) {
                        exercicio7 proximoTrabalho = filaImpressao.poll();
                        System.out.println("Processando " + proximoTrabalho.getNomeArquivo());
                    } else {
                        System.out.println("Nenhum trabalho na fila.");
                    }
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}