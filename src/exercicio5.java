import java.util.Scanner;

public class exercicio5 {
    private Node head;
    private int count;

    private static class Node {
        String carta;
        Node next;
        Node prev;

        public Node(String carta) {
            this.carta = carta;
            this.next = null;
            this.prev = null;
        }
    }

    public exercicio5() {
        this.head = null;
        this.count = 0;
    }

    public void add(String carta) {
        Node newNode = new Node(carta);
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
        while (current != null && count < index) {
            current = current.next;
            count++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido");
        }

        current.prev = current.next;
    }

    public void moverInicio(int index) {
        Node current = this.head;
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index negativo");
        }
        while (current != null && index > count) {
            current = current.next;
            count++;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index inválido");
        }
        current.prev.next = current.next;
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        current.prev = null;
        current.next = head;
        this.head = current;

    }

    public void imprimirMao() {
        if (head == null) {
            System.out.println("Lista vazia");
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.carta + " -> ");
            current = current.next;
        }
        System.out.println("nada");
    }

    public static void main(String[] args) {
        exercicio5 mao = new exercicio5();
        mao.add("As");
        mao.add("3 de ouros");
        mao.moverInicio(1);
        mao.add("3 de Copas");
        mao.remove(0);
        mao.imprimirMao();
    }
}

