public class stack{
    private int [] arr;
    private int size;
    private int tos;
    private int maxsize;

    protected void initialise(int len){
        this.arr = new int[len];
        this.tos = -1;
        this.size = 0;
        this.maxsize = len;
    }

    public stack(){
        initialise(5);
    }

    public stack(int size){
        initialise(size);
    }

    private void stackIsEmptyException() throws Exception{
        if(this.size == 0){
            throw new Exception("stackIsEmptyException : -1");
        }
    }
    
    private void stackoverflowException() throws Exception{
        if(this.size == this.maxsize){
            throw new Exception("stackoverflowException : -1");
        }
    }

    // O(1)
    public int size(){
        return this.size;
    }

    // O(1)
    public boolean isEmpty(){
        return this.size == 0;
    }

    public int maxSize(){
        return this.maxsize;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = tos; i >= 0;i--){
            sb.append(this.arr[i]);
            if(i != 0)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    // O(1)
    private void push_(int data){
        this.arr[++this.tos] = data;
        this.size++;
    }

    // O(1)
    public void push(int data) throws Exception{
        stackoverflowException();
        push_(data);
    }

    // O(1)
    private int pop_(){
        int res = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.size--;
        return res;
    }

    // O(1)
    public int pop() throws Exception{
        stackIsEmptyException();
        return pop_();
    }

    // O(1)
    private int top_(){
        return this.arr[this.tos];
    }

    // O(1)
    public int top() throws Exception{
        stackIsEmptyException();
        return top_();
    }
}