public class stack {

    // Variables

    private int[] arr;
    private int tos;
    private int NoOfElements;
    private int MaxCapacity;

    // Constructor

    stack(int size) {
        initialize(size);
    }

    stack() {
        this(15);
    }

    // Initialize

    protected void initialize(int size) {
        this.arr = new int[size];
        this.tos = -1;
        this.MaxCapacity = size;
        this.NoOfElements = 0;
    }

    // Exceptions

    private void StackOverFlowException() throws Exception {
        if (this.NoOfElements == this.MaxCapacity)
            throw new Exception("StackOverFlowException:-1");
    }

    private void StackIsEmptyException() throws Exception {
        if (this.NoOfElements == 0)
            throw new Exception("StackIsEmptyException:-1");
    }

    // Functions / Methods

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.arr.length; i++) {
            sb.append(this.arr[i]);
            if (i + 1 != this.arr.length)
                sb.append(",");
        }
        sb.append("]");

        return sb.toString();
    }

    public boolean IsEmpty() {
        return this.NoOfElements == 0;
    }

    public int size() {
        return this.NoOfElements;
    }

    public int capacity() {
        return this.MaxCapacity;
    }

    private void push_(int ele) {
        this.arr[++this.tos] = ele;
        this.NoOfElements++;
    }

    public void push(int ele) throws Exception {
        StackOverFlowException();
        push_(ele);
    }

    private int peek_() {
        return this.arr[this.tos];
    }

    public int peek() throws Exception {
        StackIsEmptyException();
        return peek_();
    }

    private int pop_() {
        int rn = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.NoOfElements--;
        return rn;
    }

    public int pop() throws Exception {
        StackIsEmptyException();
        return pop_();
    }
}