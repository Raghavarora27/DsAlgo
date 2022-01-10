import java.util.List;

public class DoublyLL {
    private class Node {
        int data = 0;
        Node prev = null;
        Node next = null;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private boolean ListIsEmptyException() {
        if (this.size == 0) {
            System.out.print("ListIsEmpty: ");
            return true;
        }
        return false;
    }

    private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
        if (index < leftRange || index > rightRange) {
            System.out.print("IndexIsInValid: ");
            return true;
        }
        return false;
    }

    private void addFirstNode(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
        size++;
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        addFirstNode(node);
    }

    private void addLastNode(Node node) {
        if (this.size == 0) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            node.prev = tail;
            tail = node;
        }
        this.size++;
    }

    public void addLast(int val) {
        Node node = new Node(val);
        addLastNode(node);
    }

    private Node removeFirstNode() {
        Node rnode = this.head;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            Node forw = rnode.next;
            rnode.next = null;
            forw.prev = null;

            this.head = forw;
        }
        this.size--;
        return rnode;
    }

    public int removeFirst() {
        if (ListIsEmptyException())
            return -1;

        return removeFirstNode().data;
    }

    private Node removeLastNode() {
        Node rnode = this.tail;
        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            Node back = rnode.prev;
            rnode.prev = null;
            back.next = null;

            this.tail = back;
        }
        this.size--;
        return rnode;
    }

    public int removeLast() {
        if (ListIsEmptyException())
            return -1;

        return removeLastNode().data;
    }

    public int getFirst() {
        if (ListIsEmptyException())
            return -1;
        return this.head.data;
    }

    public int getLast() {
        if (ListIsEmptyException())
            return -1;
        return this.tail.data;
    }

    private Node getNodeAt(int index) {
        Node curr = this.head;
        while (index-- > 0) {
            curr = curr.next;
        }
        return curr;
    }

    public int getAt(int index) {
        if (ListIsEmptyException())
            return -1;
        else if (indexIsInvalidException(index, 0, this.size - 1))
            return -1;

        return getNodeAt(index).data;
    }

    private void addNodeAt(int index, Node node) {
        if (index == 0) {
            addFirstNode(node);
        } else if (index == this.size) {
            addLastNode(node);
        } else {
            Node forw = getNodeAt(index);
            Node back = forw.prev;

            back.next = node;
            node.prev = back;

            node.next = forw;
            forw.prev = node;

            this.size++;
        }
    }

    public void addAt(int index, int data) {
        if (indexIsInvalidException(index, 0, this.size))
            System.out.println(-1);
        else {
            Node node = new Node(data);
            addNodeAt(index, node);
        }
    }

    private Node removeNodeAt(int index) {
        if (index == 0)
            return removeFirstNode();
        else if (index == this.size - 1)
            return removeLastNode();
        else {
            Node node = getNodeAt(index);
            Node back = node.prev;
            Node forw = node.next;

            back.next = forw;
            forw.prev = back;

            node.next = node.prev = null;
            this.size--;
            return node;
        }
    }

    public int removeAt(int index) {
        if (ListIsEmptyException())
            return -1;
        else if (indexIsInvalidException(index, 0, this.size - 1))
            return -1;

        return removeNodeAt(index).data;
    }

    // O(1)
    public void addBefore(Node refNode, int data) {
        Node node = new Node(data);
        Node prev = refNode.prev;

        if (prev == null) {
            node.next = refNode;
            refNode.prev = node;
            this.head = node;
        } else {
            prev.next = node;
            node.prev = prev;

            node.next = refNode;
            refNode.prev = node;
        }

        this.size++;
    }

    public void addBefore(int idx, int data) {
        Node node = getNodeAt(idx);
        addBefore(node, data);
    }

    // O(1)
    public void addAfter(Node refNode, int data) {
        Node node = new Node(data);
        Node forw = refNode.next;

        if (forw == null) {
            node.prev = refNode;
            refNode.next = node;
            this.tail = node;
        } else {
            forw.prev = node;
            node.next = forw;

            node.prev = refNode;
            refNode.next = node;
        }

        this.size++;
    }

    public void addAfter(int idx, int data) {
        Node node = getNodeAt(idx);
        addAfter(node, data);
    }

    private Node removeAfterNode(Node refNode) {
        Node forw = refNode.next;
        if (forw.next == null) {
            refNode.next = null;
            forw.prev = null;

            this.tail = refNode;
        } else {
            refNode.next = forw.next;
            forw.next.prev = refNode;

            forw.next = null;
            forw.prev = null;
        }
        this.size--;
        return forw;
    }

    public int removeAfter(Node refNode) {
        if (refNode.next == null) {
            System.out.print("LocationIsInvalid: ");
            return -1;
        }
        return removeAfterNode(refNode).data;
    }

    public int removeAfter(int idx) {
        Node node = getNodeAt(idx);
        return removeAfter(node);
    }

    private Node removeBeforeNode_(Node refNode) {
        Node back = refNode.prev;
        if (back.prev == null) {
            refNode.prev = null;
            back.next = null;

            this.head = refNode;
        } else {
            refNode.prev = back.prev;
            back.prev.next = refNode;

            back.next = null;
            back.prev = null;
        }
        this.size--;
        return back;
    }

    public int removeBeforeNode(Node refNode) {
        if (refNode.prev == null) {
            System.out.print("LocationIsInvalid: ");
            return -1;
        }
        return removeBeforeNode_(refNode).data;
    }

    public int removeBefore(int idx) {
        Node node = getNodeAt(idx);
        return removeBeforeNode(node);
    }

    public int removeNode(Node refNode) {
        Node prev = refNode.prev;
        Node forw = refNode.next;
        if (this.size == 1)
            this.head = this.tail = null;
        else if (prev == null)
            this.head = forw;
        else if (forw == null)
            this.tail = prev;
        else {
            prev.next = forw;
            forw.prev = prev;
        }

        refNode.prev = refNode.next = this.head.prev = this.tail.next = null;
        this.size--;
        return refNode.data;
    }

    public void displayForw() {
        StringBuilder sb = new StringBuilder();
        Node curr = this.head;
        sb.append("[");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.next != null)
                sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");

        System.out.println(sb.toString());
    }

    public void displayBack() {
        StringBuilder sb = new StringBuilder();
        Node curr = this.tail;
        sb.append("[");
        while (curr != null) {
            sb.append(curr.data);
            if (curr.prev != null)
                sb.append(", ");
            curr = curr.prev;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}