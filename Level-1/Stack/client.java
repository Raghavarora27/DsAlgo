import jdk.dynalink.DynamicLinkerFactory;

public class client {

    public static void queuetest() throws Exception {
        queue que = new queue(10);

        for (int i = 1; i <= 10; i++) {
            que.add(i * 10);
        }
        System.out.println(que);

        while (que.size() != 0) {
            System.out.println(que.remove());
        }
    }

    public static void stacktest() throws Exception {
        dynamicStack st = new dynamicStack(20);
        for (int i = 1; i <= 10; i++) {
            st.push(i * 10);
        }
        System.out.println(st.top());
        System.out.println(st);
    }

    public static void main(String[] args) throws Exception {
        stacktest();
    }
}
