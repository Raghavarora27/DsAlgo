package Adapters;

import java.util.LinkedList;
    
public class stackUsingQueuePop{ 
    LinkedList<Integer> que = new LinkedList<>();
    LinkedList<Integer> temp = new LinkedList<>();
    
    int TopEle = 0;
    public stackUsingQueuePop() {
        
    }
    
    public void push(int x) {
        TopEle = x;
        que.addLast(x);
    }
    
    public int pop() {
        while(que.size() > 1)   temp.addLast(que.removeFirst());
        int res = que.removeFirst();
        
        while(temp.size() != 0) push(temp.removeFirst());
        return res;
    }
    
    public int top() {
        return TopEle;
    }
    
    public boolean empty() {
        return que.size() == 0;
    }
}
