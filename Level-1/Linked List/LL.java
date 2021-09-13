import jdk.internal.logger.SurrogateLogger;

public class LL {
    private class Node {
        int data = 0;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    // ========= Add First Node ============ //
    private void addFirstNode(Node node) {
        if (this.size == 0)
            this.head = this.tail = node;
        else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    public void addFirst(int data) {
        Node node = new Node(data);
        addFirstNode(node);
    }
    // ===================================== //

    // ========== Add Last Node ============ //
    private void addLastNode(Node node) {
        if (this.size == 0)
            this.head = this.tail = node;
        else {
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    public void addLast(int data) {
        Node node = new Node(data);
        addLastNode(node);
    }
    // ===================================== //

    // =========== Add Node At ============= //
    private void addNodeAt(Node node, int idx) {
        if (idx == 0)
            addFirstNode(node);
        else if (idx == this.size)
            addLastNode(node);
        else {
            Node prevNode = getNodeAt(idx - 1);
            Node forwNode = prevNode.next;

            prevNode.next = node;
            node.next = forwNode;
            this.size++;
        }
    }

    public void addAt(int idx, int data) {
        if (idx < 0 || idx > this.size)
            return;

        Node node = new Node(data);
        addNodeAt(node, idx);
    }
    // ===================================== //

    // ========= Remove First Node ========= //
    private Node removeFirstNode() {
        Node node = this.head;
        if (this.size == 1)
            this.head = this.tail = null;
        else {
            this.head = this.head.next;
            node.next = null;
        }

        this.size--;
        return node;
    }

    public int removeFirst() {
        if (this.size == 0)
            return -1;

        Node node = removeFirstNode();
        return node.data;
    }
    // ===================================== //

    // ========= Remove Last Node ========= //
    private Node removeLastNode() {
        Node node = this.tail;
        if (this.size == 1)
            this.head = this.tail = null;
        else {
            Node secondLast = getNodeAt(this.size - 2);
            secondLast.next = null;
            this.tail = secondLast;
        }
        this.size--;
        return node;
    }

    public int removeLast() {
        if (this.size == 0)
            return -1;

        return removeLastNode().data;
    }
    // ===================================== //

    // =========== Remove Node At ========== //
    private Node removeNodeAt(int idx) {
        if (idx == 0)
            return removeFirstNode();
        else if (idx == this.size - 1)
            return removeLastNode();
        else {
            Node prevNode = getNodeAt(idx - 1);
            Node node = prevNode.next;
            Node forwNode = node.next;

            node.next = null;
            prevNode.next = forwNode;
            this.size--;

            return node;
        }

    }

    public int removeAt(int idx) {
        if (idx < 0 || idx >= this.size)
            return -1;

        return removeNodeAt(idx).data;
    }

    // ===================================== //

    // =========== Get First Node ========== //
    private Node getFirstNode() {
        return this.head;
    }

    public int getFirst() {
        if (this.size == 0)
            return -1;

        return getFirstNode().data;
    }
    // ===================================== //

    // =========== Get Last Node ========== //
    private Node getLastNode() {
        return this.tail;
    }

    public int getLast() {
        if (this.size == 0)
            return -1;

        return getLastNode().data;
    }
    // ===================================== //

    // =========== Get Node At ========== //
    private Node getNodeAt(int idx) {
        Node curr = this.head;
        while (idx-- > 0) {
            curr = curr.next;
        }

        return curr;
    }

    public int getAt(int idx) {
        if (idx < 0 || idx >= this.size)
            return -1;

        return getNodeAt(idx).data;
    }
    // ===================================== //

    // ============ Odd Even LL ============ //

    public void oddEven() {
        Node Even = new Node(-1); // Dummy Node
        Node ep = Even;

        Node Odd = new Node(-1); // Dummy Node
        Node op = Odd;

        Node curr = this.head;
        while (curr != null) {
            if (curr.data % 2 == 0) {
                ep.next = curr;
                ep = ep.next;
            } else {
                op.next = curr;
                op = op.next;
            }
            curr = curr.next;
        }

        op.next = ep.next;
        ep.next = null;

        this.head = Odd.next;
        this.tail = ep;
    }

    // ======================================= //
}
