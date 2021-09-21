public class Leetcode_225 {
    // Push Efficient
    class MyStack {

        LinkedList<Integer> que = new LinkedList();
        LinkedList<Integer> temp = new LinkedList();

        int TopEle = 0;

        public MyStack() {

        }

        // O(1)
        public void push(int x) {
            TopEle = x;
            que.addLast(x);
        }

        // O(n)
        public int pop() {
            while (que.size() > 1)
                temp.addLast(que.removeFirst());
            int rv = que.removeFirst();

            while (temp.size() != 0)
                push(temp.removeFirst());
            return rv;
        }

        public int top() {
            return TopEle;
        }

        public boolean empty() {
            return que.size() == 0;
        }
    }

}
