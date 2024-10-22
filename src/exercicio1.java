import java.util.Scanner;

public class exercicio1 {
    private Node head;

    private static class Node {
        String tarefa;
        boolean concluida;
        Node next;

        public Node(String tarefa) {
            this.tarefa = tarefa;
            this.concluida = false;
            this.next = null;
        }
    }

    public exercicio1() {
        this.head = null;
    }

    public void add(String tarefa) {
        Node newNode = new Node(tarefa);
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

    public void remove(int index) {
        Node current = this.head;
        if (this.head == null) {
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido");
        }
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        int count = 0;
        Node previous = null;
        while (current != null && count < index) {
            previous = current;
            current = current.next;
            count++;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido");
        }

        previous.next = current.next;
    }

    public void tarefaconcluida(int index) {
        Node current = this.head;
        int count = 0;
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido");
        }
        current.concluida = true;
    }

    public void print() {
        if (head == null) {
            System.out.println("Nenhuma tarefa encontrada.");
            return;
        }

        Node current = head;
        int index = 0;

        System.out.println("Lista de tarefas:");
        while (current != null) {
            System.out.println(index + ". " + current.tarefa + " " + current.concluida);
            current = current.next;
            index++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        exercicio1 i = new exercicio1();

        while (true) {
            System.out.println("\nGerenciador de Tarefas:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Remover tarefa");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Exibir tarefas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int l = scanner.nextInt();
            scanner.nextLine();

            switch (l) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String description = scanner.nextLine();
                    i.add(description);
                    break;
                case 2:
                    System.out.print("Digite o índice da tarefa a ser removida: ");
                    int removeIndex = scanner.nextInt();
                    i.remove(removeIndex);
                    break;
                case 3:
                    System.out.print("Digite o índice da tarefa a ser marcada como concluída: ");
                    int completeIndex = scanner.nextInt();
                    i.tarefaconcluida(completeIndex);
                    break;
                case 4:
                    i.print();
                    break;
                case 5:
                    System.out.println("Saindo do gerenciador de tarefas...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}