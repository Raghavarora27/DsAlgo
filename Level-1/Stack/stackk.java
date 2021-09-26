public class stackk {
    private int [] arr;
    private int size;
    private int maxSize;
    private int tos;

    protected void initialise(int len){
        this.arr = new int[len];
        this.size = 0;
        this.maxSize = len;
        this.tos = -1;
    }

    stackk(int size){
        initialise(size);
    }

    stack(){
        initialise(5);
    }

    public void stackIsEmptyException() throws Exception{
        if(this.size == 0)
            throw new Exception("stackIsEmptyException : -1");
    }
    
    public void stackoverFlowException() throws Exception{
        if(this.size == this.maxSize)
            throw new Exception("stackoverFlowException : -1");
    }

    public int size(){
        return this.size;
    }

    public int IsEmpty(){
        return this.size == 0;
    }

    private int top_(){
        return this.arr[this.tos];    
    }

    public int maxsize(){
        return this.maxSize;
    }

    public int top() throws Exception{
        stackIsEmptyException();
        return top_();
    }

    private void push_(int x){
        this.arr[++this.tos] = x;
        this.size++;
    }

    public void push(int x) throws Exception{
        stackoverFlowException();
        push_(x);
    }

    private int pop_(){
        int rv = this.arr[this.tos];
        this.arr[this.tos--] = 0;
        this.size--;
        return rv;
    }

    public int pop() throws Exception{
        stackIsEmptyException();
        return pop_();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for(int i = this.tos ; i >= 0 ;i--){
            sb.append(this.arr[i]);
            if(i != 0)
                sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }
}
