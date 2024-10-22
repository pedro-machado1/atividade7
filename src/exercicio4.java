import java.util.Scanner;

public class exercicio4 {
    private Node head;
    private Node tail;

    private static class Node {
        String texto;
        Node next;
        Node prev;

        public Node(String texto) {
            this.texto = texto;
            this.next = null;
            this.prev = null;
        }
    }

    public exercicio4() {
        this.head = null;
        this.tail = null;
    }

    public void add(String texto) {
        Node newNode = new Node(texto);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
                ;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void undo() {
        Node current = this.head;
        while (current.next != null) {
            current = head.next;
        }
        current.prev.next = null;
        if (tail == null) {
            tail = current;
        } else {
            tail.prev = current;
            current.next = tail;
            tail = current;
        }
    }

    public void redo() {
        Node no = this.head;
        while (no.next != null) {
            no = no.next;
        }
        no.next = tail;
        tail = tail.next;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.texto + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        exercicio4 textEditor = new exercicio4();

        while (true) {
            System.out.println("\nEditor de Texto:");
            System.out.println("1. Adicionar texto");
            System.out.println("2. Desfazer última ação");
            System.out.println("3. Refazer última ação");
            System.out.println("4. Exibir texto atual");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o texto a ser adicionado: ");
                    String text = sc.nextLine();
                    textEditor.add(text);
                    break;
                case 2:
                    textEditor.undo();
                    break;
                case 3:
                    textEditor.redo();
                case 4:
                    textEditor.print();
                    break;
                case 5:
                    System.out.println("Saindo do editor...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

