import java.util.LinkedList;
import java.util.ArrayList;

public class HashMap {

    // Data Members=========================================

    private class Node {
        Integer key = null;
        Integer value = null;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] Buckets;
    private int TotalNoOfNodes = 0;
    private int BucketLen = 0;

    // Constructor==========================================

    private void initialize(int size) {
        BucketLen = size;
        Buckets = new LinkedList[size]; // initalizing Array of LinkedList

        for (int i = 0; i < size; i++)
            Buckets[i] = new LinkedList<>();

        TotalNoOfNodes = 0;
    }

    public HashMap() {
        initialize(10); // Default size = 10
    }

    // Display==========================================
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int temp = this.TotalNoOfNodes;
        for (int i = 0; i < BucketLen; i++) {
            int size = Buckets[i].size();
            LinkedList<Node> group = this.Buckets[i];

            while (size-- > 0) {
                Node node = group.removeFirst();
                sb.append(node.key + "=" + node.value);
                group.addLast(node);

                if (--temp != 0)
                    sb.append(",");
            }
        }

        sb.append("}");
        return sb.toString();
    }

    // Basic Functions======================================

    public int size() {
        return this.TotalNoOfNodes;
    }

    public boolean isEmpty() {
        return this.TotalNoOfNodes == 0;
    }

    // DS Functions=========================================

    public ArrayList<Integer> keySet() {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < BucketLen; i++) {
            LinkedList<Node> group = this.Buckets[i];
            int size = group.size();
            while (size-- > 0) {
                Node node = group.removeFirst();
                ans.add(node.key);
                group.addLast(node);
            }
        }

        return ans;
    }

    private void rehash() {
        LinkedList<Node>[] temp = this.Buckets;
        initialize((int) (this.BucketLen * 1.5)); // 1 <= factor <= 2

        for (int i = 0; i < temp.length; i++) {
            LinkedList<Node> group = temp[i];
            int size = group.size();

            while (size-- > 0) {
                Node node = group.removeFirst();
                put(node.key, node.value);
            }
        }
    }

    public void put(Integer key, Integer value) {
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);

        if (res) {
            group.getFirst().value = value;
        } else {
            Node node = new Node(key, value);
            group.addLast(node);
            this.TotalNoOfNodes++;

            double lambda = group.size() / (1.0 * this.BucketLen);
            if (lambda > 0.4) // yeh hum khud assume kar rhe h ki
                rehash(); // ek 10 size ke group me atmax 4 node aasakte hai,
                          // if exceeded then it will call rehash
        }
    }

    public void putIfAbsent(Integer key, Integer defaultValue) {
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);

        if (!res) {
            Node node = new Node(key, defaultValue);
            group.addLast(node);
            this.TotalNoOfNodes++;
        }
    }

    public Integer get(Integer key) {
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);

        return res ? group.getFirst().value : null;
    }

    public Integer getOrDefault(Integer key, Integer defaultValue) {
        Integer res = get(key);
        return res != null ? res : defaultValue;
    }

    public Integer remove(Integer key) {
        boolean res = containsKey(key);
        LinkedList<Node> group = getGroup(key);

        if (res) {
            this.TotalNoOfNodes--;
            return group.removeFirst().key;
        }

        return null;
    }

    public boolean containsKey(Integer key) { // we can't Iterate in the LL // as we dont have head and next
        LinkedList<Node> group = getGroup(key); // so we are removing 1st node and adding it to the last
        int size = group.size();
        boolean res = false;
        while (size-- > 0) {
            if (group.getFirst().key.equals(key)) {
                res = true;
                break;
            }
            group.addLast(group.removeFirst());
        }

        return res;
    }

    private LinkedList<Node> getGroup(Integer key) {
        int hc = getHashCode(key);
        return Buckets[hc];
    }

    private int getHashCode(Integer key) {

        return Math.abs(key.hashCode()) % BucketLen; // Dividing by Bucket Length - Hashcode will be in the range
    }
}