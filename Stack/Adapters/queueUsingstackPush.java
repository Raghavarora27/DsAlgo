package Adapters;
import java.util.LinkedList;

class queueUsingstackPush {
    LinkedList<Integer> l1 = new LinkedList<>();
    LinkedList<Integer> l2 = new LinkedList<>();

    int peekEle = 0;
    
    public queueUsingstackPush() {
        
    }
    // // O(1)
    public void push(int x) {
        if(l1.size() == 0)  peekEle = x;
        l1.addFirst(x);    
    }
    
    private void transfer(LinkedList<Integer> l1 , LinkedList<Integer> l2){
        while(l1.size() != 0){
            l2.addFirst(l1.removeFirst());
        }
    }
    // O(n)    
    public int pop() {
        transfer(l1,l2);
        int res = l2.removeFirst();
        
        while(l2.size() != 0){
            this.push(l2.removeFirst());
        } 
        return res;
    }
    // O(1)
    public int peek() {
        return peekEle;    
    }
    
    // O(1)
    public boolean empty() {
        return l1.size() == 0;    
    }
}