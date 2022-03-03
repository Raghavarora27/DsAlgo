import java.util.ArrayList;

public class heap {
    private ArrayList<Integer> arr;
    private boolean IsMaxHeap = true;

    public heap(boolean IsMaxHeap) {
        this.arr = new ArrayList<>();
        this.IsMaxHeap = IsMaxHeap;
    }

    // O(n + nlogn)
    public heap(int[] arr,boolean IsMaxHeap) {
        this(IsMaxHeap);
        for (int ele : arr)
            this.arr.add(ele);

        for (int i = this.arr.size() - 1; i >= 0; i--)
            downheapify(i);
    }

    // O(1)
    public boolean compareTo(int x, int y) {
        // when min Heap --> this - other
        // when max Heap --> other - this
        return this.IsMaxHeap ? this.arr.get(x) > this.arr.get(y) : this.arr.get(y) > this.arr.get(x);
    }

    // O(1)
    private void swap(int x, int y) {
        int v1 = this.arr.get(x);
        int v2 = this.arr.get(y);

        this.arr.set(x, v2);
        this.arr.set(y, v1);
    }

    public int size() {
        return this.arr.size();
    }

    // O(logn)
    private void downheapify(int pi) {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int maxIdx = pi;

        if (lci < arr.size() && compareTo(lci, maxIdx))
            maxIdx = lci;

        if (rci < arr.size() && compareTo(rci, maxIdx))
            maxIdx = rci;

        if (maxIdx != pi) {
            swap(maxIdx, pi);
            downheapify(maxIdx);
        }
    }

    // O(logn)
    private void upheapify(int ci) {
        int pi = (ci - 1) / 2;

        if (pi >= 0 && compareTo(ci, pi)) {
            swap(ci, pi);
            upheapify(pi);
        }
    }

    // O(logn)
    public int remove() {
        int rn = this.arr.get(0);
        swap(0, this.arr.size() - 1);
        this.arr.remove(this.arr.size() - 1);
        downheapify(0);
        return rn;
    }

    // O(logn)
    public void add(int data) {
        this.arr.add(data);
        upheapify(this.arr.size() - 1);
    }

    // O(1)
    public int peek() {
        return this.arr.get(0);
    }
}