package Adapters;
import java.util.LinkedList;

class queueUsingstackPop {
    LinkedList<Integer> l1 = new LinkedList<>();
    LinkedList<Integer> l2 = new LinkedList<>();

    int peekEle = 0;
    public queueUsingstackPop() {
        
    }
    private void transfer(LinkedList<Integer> l1 , LinkedList<Integer> l2){
        while(l1.size() != 0){
            l2.addFirst(l1.removeFirst());
        }
    }
    // O(n)
    public void push(int x) {
        transfer(l1, l2);
        l1.addFirst(x);  
        transfer(l2, l1);  
    }
    // O(1)    
    public int pop() {
        return l1.removeFirst();
    }
    // O(1)
    public int peek() {
        return l1.getFirst();
    }
    // O(1)
    public boolean empty() {
        return l1.size() == 0;    
    }
}