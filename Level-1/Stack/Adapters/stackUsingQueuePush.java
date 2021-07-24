package Adapters;
import java.util.LinkedList;
    
public class stackUsingQueuePush{ 
    LinkedList<Integer> que = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    
    int TopEle = 0;
    public stackUsingQueuePush() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        TopEle = x;
        que.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(que.size() > 1)   temp.addLast(que.removeFirst());
        int res = que.removeFirst();
        
        while(temp.size() != 0) push(temp.removeFirst());
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        return TopEle;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.size() == 0;
    }
}