package Adapters;
import java.util.LinkedList;

public class stackUsingJavaLL{
    public static class stack{
        private LinkedList<Integer> ll = new LinkedList<>();
        
        public int size(){
            return this.ll.size();
        }

        public boolean isEmpty(){
            return this.ll.size() == 0;
        }

        public void add(int data){
            ll.addFirst(data);
        }

        public int top(){
            return ll.getFirst();
        }

        public int pop(){
            return ll.removeFirst();
        }
    }
    // public static void stackBehaviouUsingLL(){
    //     LinkedList<Integer> st = new LinkedList<>();

    //     for(int i = 1 ; i <= 10 ; i++ ){
    //         st.addFirst(i * 10);
    //     }

    //     while(st.size() != 0){
    //         System.out.println(st.removeFirst());
    //     }
    // }

    public static void stackBehaviouUsingLL(){
        stack st = new stack();
        for(int i = 1 ; i <= 10 ; i++ ){
            st.add(i * 10);
        }

        while(st.size() != 0){
            System.out.println(st.pop());
        }
    }
    public static void main(String [] args){
        stackBehaviouUsingLL();
    } 
}