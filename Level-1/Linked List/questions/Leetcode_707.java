public class Leetcode_707 {

  class MyLinkedList {

    private class Node {

      int data = 0;
      Node next = null;

      Node(int data) {
        this.data = data;
      }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
      this.head = null;
      this.tail = null;
      this.size = 0;
    }

    private Node getAt(int index) {
      Node curr = this.head;
      while (index-- > 0) {
        curr = curr.next;
      }
      return curr;
    }

    public int get(int index) {
      if (index < 0 || index >= this.size) return -1;
      return getAt(index).data;
    }

    public void addAtHead(int val) {
      Node node = new Node(val);
      if (this.size == 0) {
        this.head = this.tail = node;
      } else {
        node.next = this.head;
        this.head = node;
      }
      this.size++;
    }

    public void addAtTail(int val) {
      Node node = new Node(val);

      if (this.size == 0) {
        this.head = this.tail = node;
      } else {
        this.tail.next = node;
        this.tail = node;
      }
      this.size++;
    }

    public void addAtIndex(int index, int val) {
      if (index < 0 || index > this.size) return;

      if (index == 0) {
        addAtHead(val);
      } else if (index == this.size) {
        addAtTail(val);
      } else {
        Node node = new Node(val);
        Node prev = getAt(index - 1);

        node.next = prev.next;
        prev.next = node;
        this.size++;
      }
    }

    private Node removeFirstNode() {
      Node node = this.head;
      if (this.size == 1) this.head = this.tail = null; else {
        this.head = this.head.next;
        node.next = null;
      }

      this.size--;
      return node;
    }

    private Node removeLastNode() {
      Node node = this.tail;
      if (this.size == 1) this.head = this.tail = null; else {
        Node secondLast = getAt(this.size - 2);
        secondLast.next = null;
        this.tail = secondLast;
      }
      this.size--;
      return node;
    }

    public void deleteAtIndex(int index) {
      if (index < 0 || index >= this.size) return;

      if (index == 0) {
        removeFirstNode();
      } else if (index == this.size - 1) {
        removeLastNode();
      } else {
        Node prevNode = getAt(index - 1);
        Node node = prevNode.next;
        Node forwNode = node.next;

        node.next = null;
        prevNode.next = forwNode;
        this.size--;
      }
    }
  }
  /**
   * Your MyLinkedList object will be instantiated and called as such:
   * MyLinkedList obj = new MyLinkedList(); int param_1 = obj.get(index);
   * obj.addAtHead(val); obj.addAtTail(val); obj.addAtIndex(index,val);
   * obj.deleteAtIndex(index);
   */
}
