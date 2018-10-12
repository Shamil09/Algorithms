public class RelatedList {
    private class Node {
        Cat c;
        Node next;
        public Node(Cat c) {
            this.c = c;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return c.equals(node.c);
        }
        @Override
        public String toString() {
            return c.toString();
        }
    }

    private Node head;

    public RelatedList() {
        head = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void insert(Cat c) {
        Node n = new Node(c);
        n.next = head;
        head = n;
    }
    public Cat remove() {
        if (isEmpty())
            return null;
        Cat c = head.c;
        head = head.next;
        return c;
    }
    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }
    public boolean contains(Cat c) {
        if (isEmpty())
            return false;
        Node current = head;
        while (!current.c.equals(c)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }
    public boolean delete(Cat c) {
        Node n = new Node(c);
        Node current = head;
        Node previous = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        return true;
    }
}
