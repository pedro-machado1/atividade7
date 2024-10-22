import java.util.Scanner;

public class exercicio3 {
    private Node head;

    private static class Node {
        String texto;
        Node next;

        public Node(String texto) {
            this.texto = texto;
            this.next = null;
        }
    }

    public exercicio3() {
        this.head = null;
    }

    public void add(String texto) {
        Node newNode = new Node(texto);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void undo() {
        Node current = this.head;
        Node trail = this.head;
        while (current.next != null) {
            trail = current;
            current = head.next;
        }
        trail.next = null;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.texto + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exercicio3 textEditor = new exercicio3();

        while (true) {
            System.out.println("\nEditor de Texto:");
            System.out.println("1. Adicionar texto");
            System.out.println("2. Desfazer última ação");
            System.out.println("3. Exibir texto atual");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o texto a ser adicionado: ");
                    String text = scanner.nextLine();
                    textEditor.add(text);
                    break;
                case 2:
                    textEditor.undo();
                    break;
                case 3:
                    textEditor.print();
                    break;
                case 4:
                    System.out.println("Saindo do editor...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}