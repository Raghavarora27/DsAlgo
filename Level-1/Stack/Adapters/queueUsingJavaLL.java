package Adapters;

import java.util.LinkedList;

public class queueUsingJavaLL{
    public static class queue{
        private LinkedList<Integer> ll = new LinkedList<>();
        
        public int size(){
            return this.ll.size();
        }

        public boolean isEmpty(){
            return this.size() == 0;
        }

        public void add(int data){
            ll.addLast(data);
        }

        public int peak(){
            return ll.getFirst();
        }

        public int remove(){
            return ll.removeFirst();
        }
    }
    public static void queueBehaviouUsingLL(){
        LinkedList<Integer> st = new LinkedList<>();

        for(int i = 1 ; i <= 10 ; i++ ){
            st.addLast(i * 10);
        }

        while(st.size() != 0){
            System.out.println(st.removeFirst());
        }
    }

    public static void main(String [] args){
        queueBehaviouUsingLL();
    } 
}