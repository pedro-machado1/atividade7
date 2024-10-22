import java.util.Scanner;
public class exercicio6 {

    private Node first;
    private Node last;

    public exercicio6() {
        this.first = null;
        this.last = null;
    }

    private static class Node {
        String cliente;
        Node next;

        public Node(String cliente) {
            this.cliente = cliente;
            this.next = null;
        }
    }

    public void enqueue(String cliente) {
        Node newNode = new Node(cliente);

        if (this.last == null) {
            this.first = newNode;
            this.last = newNode;
        } else {
            this.last.next = newNode;
            this.last = newNode;
        }
    }

    public String dequeue() {
        if (this.first == null) {
            throw new IllegalStateException("Fila vazia!");
        }

        String cliente = this.first.cliente;
        this.first = this.first.next;
        if (this.first == null) {
            this.last = null;
        }

        return cliente;
    }

    public static void main(String[] args) {
        exercicio6 fila = new exercicio6();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Adicionar cliente à fila");
            System.out.println("2. Chamar próximo cliente");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = sc.nextLine();
                    fila.enqueue(nome);
                    System.out.println(nome + " foi adicionado à fila.");
                    break;
                case 2:
                    System.out.println("O cliente "+fila.dequeue()+" foi chamado");
                    break;
                case 3:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}

