public class dynamicStack extends stack {
    dynamicStack(int size) {
        super(size);
    }

    dynamicStack() {
        super();
    }

    @Override
    public void push(int data) throws Exception {
        if (super.capacity() == super.size()) {
            int[] temp = new int[super.size()];
            int idx = super.size() - 1;
            while (super.size() != 0) {
                temp[idx--] = super.pop();
            }

            super.initialize(temp.length * 2);
            for (int ele : temp) {
                super.push(ele);
            }
        }
        super.push(data);
    }
}
