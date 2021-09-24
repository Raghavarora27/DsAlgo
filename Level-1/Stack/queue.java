public class queue {
    private int [] arr;
    private int size;
    private int front;
    private int back;
    private int maxsize;

    protected void initialise(int len){
        this.arr = new int[len];
        this.front = 0;
        this.back = 0;
        this.size = 0;
        this.maxsize = len;
    }

    // Default size = 5
    public queue(){
        initialise(5);
    }

    public queue(int size){
        initialise(size);
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.size;i++){
            int idx = (i + this.front) % this.maxsize;
            sb.append(this.arr[idx]);
            if(i != this.size - 1)
                sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

    private void queueIsEmptyException() throws Exception{
        if(this.size == 0){
            throw new Exception("queueIsEmptyException : -1");
        }
    }
    
    private void queueoverflowException() throws Exception{
        if(this.size == this.maxsize){
            throw new Exception("queueoverflowException : -1");
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

    private int peak_(){
        return this.arr[this.front];
    }

    public int peak() throws Exception{
        queueIsEmptyException();
        return peak_();
    }

    private int remove_(){
        int rev = this.arr[this.front];
        this.arr[this.front] = 0;
        this.front = (this.front + 1) % this.maxsize;
        this.size--; 
        return rev;           
    }

    public int remove() throws Exception{
        queueIsEmptyException();
        return remove_();
    }

    private void add_(int data){
        this.arr[this.back] = data;
        this.back = (this.back + 1) % this.maxsize;
        this.size++;
    }

    public void add(int data) throws Exception{
        queueoverflowException();
        add_(data);
    }

}
