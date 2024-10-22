public class exercicio2 {
    private Node head;
    int max, count;
    private static class Node {
        String url;
        Node next;

        public Node(String url) {
            this.url = url;
            this.next = null;
        }
    }

    public exercicio2(int max) {
        this.head = null;
        this.max = max;
        this.count = 0;

    }

    public void add(String url) {
        Node newNode = new Node(url);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
        if (count > max) {
            remove();
        }
    }
    public void remove() {
        head = head.next;
        count--;
    }
    public void print() {
        Node current = head;
        System.out.println("Histórico de navegação:");
        while (current != null) {
            System.out.println(current.url);
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        exercicio2 ex = new exercicio2(3);
        ex.add("http://www.google.com");
        ex.add("http://www.yahoo.com");
        ex.add("http://www.googleasrt.com");
        ex.add("http://www.google.com.br");
        ex.print();
    }
}

