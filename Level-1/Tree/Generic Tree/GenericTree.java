import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenericTree {
    public class Node {
        int data = 0;
        ArrayList<Node> childs;

        Node(int data) {
            this.data = data;
            this.childs = new ArrayList<>();
        }
    }

    public static int size(Node node) {
        int count = 0;

        for (Node child : node.childs)
            count += size(child);

        return count + 1;
    }

    public static int height(Node root) {
        int h = 0;
        for (Node child : root.childs)
            h = Math.max(height(child) + 1, h);

        return h;
    }

    public static int maximum(Node node) {
        int max = node.data;
        for (Node child : node.childs)
            max = Math.max(maximum(child), max);
        return max;
    }

    public static int minimum(Node node) {
        int min = node.data;
        for (Node child : node.childs)
            min = Math.min(maximum(child), min);
        return min;
    }

    public static int sum(Node node) {
        int sum = node.data;
        for (Node child : node.childs)
            sum += sum(child);
        return sum;
    }

    public static boolean find(Node node, int data) {
        if (node.data == data)
            return true;

        boolean res = false;
        for (Node child : node.childs)
            res = res || find(child, data);
        return res;
    }

    public static boolean find2(Node node, int data) {
        if (node.data == data)
            return true;

        boolean res = false;
        for (Node child : node.childs) {
            if (find(child, data)) {
                res = true;
                break;
            }
        }
        return res;
    }

    public static int countLeaves(Node node) {
        if (node.childs.size() == 0)
            return 1;

        int count = 0;
        for (Node child : node.childs)
            count += countLeaves(child);
        return count;
    }

    public static boolean nodeToRootPath_(Node node, int data, ArrayList<Node> ans) {
        if (node.data == data) {
            ans.add(node);
            return true;
        }

        boolean res = false;
        for (Node child : node.childs)
            res = res || nodeToRootPath_(child, data, ans);

        if (res)
            ans.add(node);

        return res;
    }

    public static ArrayList<Node> nodeToRootPath(Node node, int data) {
        if (node == null)
            return new ArrayList<>();
        ArrayList<Node> ans = new ArrayList<>();
        nodeToRootPath_(node, data, ans);
        return ans;
    }

    public static ArrayList<Node> nodeToRootPath2(Node node, int data) {
        if (node.data == data) {
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }

        ArrayList<Node> smallAns = new ArrayList<>();
        for (Node child : node.childs) {
            smallAns = nodeToRootPath2(child, data);
            if (smallAns.size() != 0)
                break;
        }

        if (smallAns.size() != 0)
            smallAns.add(node);

        return smallAns;
    }

    public static Node lowestCommonAncestor(Node root, int p, int q) {
        ArrayList<Node> list1 = nodeToRootPath(root, p);
        ArrayList<Node> list2 = nodeToRootPath(root, q);

        int i = list1.size() - 1;
        int j = list2.size() - 1;

        Node LCA = null;
        while (i >= 0 && j >= 0) {
            if (list1.get(i) != list2.get(j))
                break;
            LCA = list2.get(j);
            i--;
            j--;

        }

        return LCA;
    }

    // Distance Between 2 Nodes
    public static int distanceBetweenNodes(Node node, int d1, int d2) {
        ArrayList<Node> p1 = nodeToRootPath(node, d1);
        ArrayList<Node> p2 = nodeToRootPath(node, d2);

        int i = p1.size() - 1;
        int j = p2.size() - 1;

        while (i >= 0 && j >= 0 && p1.get(i) == p2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return i + j;
    }

    // Are Tree Similar
    public static boolean AreSimilar(Node n1, Node n2) {
        if (n1.childs.size() != n2.childs.size())
            return false;

        boolean res = true;
        for (int i = 0; i < n1.childs.size(); i++) {
            Node c1 = n1.childs.get(i);
            Node c2 = n2.childs.get(i);

            res = res && AreSimilar(c1, c2);
        }
        return res;
    }

    // Mirror Tree
    public static boolean Mirror(Node n1, Node n2) {
        if (n1.childs.size() != n2.childs.size())
            return false;

        boolean res = true;
        int size = n1.childs.size();
        for (int i = 0; i < size; i++) {
            Node c1 = n1.childs.get(i);
            Node c2 = n2.childs.get(size - i - 1);

            res = res && Mirror(c1, c2);
        }
        return res;
    }

    // Is Generic Tree Symmetric
    public static boolean IsSymmetric(Node node) {
        return Mirror(node, node);
    }

    // Ceil and Floor
    static int floor;
    static int ceil;

    public static void ceilAndFloor_(Node node, int data) {
        if (node.data < data)
            floor = Math.max(floor, node.data);
        if (node.data > data)
            ceil = Math.min(ceil, node.data);

        for (Node child : node.childs)
            ceilAndFloor_(child, data);
    }

    public static void ceilAndFloor(Node node, int data) {
        floor = -(int) 1e9;
        ceil = (int) 1e9;
        ceilAndFloor_(node, data);
    }

    // Kth Largest element

    public static int Floor_(Node node, int ub) {
        int maxRes = -(int) 1e9;
        for (Node child : node.childs) {
            int recRes = Floor_(child, ub);
            maxRes = Math.max(maxRes, recRes);
        }

        return node.data < ub ? Math.max(node.data, maxRes) : maxRes;
    }

    public static int kLargestNode(Node node, int k) {
        int ub = (int) 1e9;
        for (int i = 0; i < k; i++) {
            ub = Floor_(node, ub);
        }
        return ub;
    }

    // Linearize
    public static Node getTail(Node node) {
        for (Node child : node.childs)
            node = node.childs.get(0);
        return node;
    }

    public static void linearize(Node node) {
        for (Node child : node.childs)
            linearize(child);

        for (int i = node.childs.size() - 1; i > 0; i--) {
            Node tail = getTail(node.childs.get(i - 1));
            tail.childs.add(node.childs.get(i));

            node.childs.remove(i);
        }
    }

    
    public static void levelOrderLineWise(Node root) {
        LinkedList<Node> que = new LinkedList<>(); // removeFirst, addLast
        que.addLast(root);
        // int level = 0;

        while(que.size() != 0) {
            int size = que.size(); // size of current level
            while (size-- > 0) {
                Node rn = que.removeFirst();
                System.out.print(rn.data + " ");

                for(Node child : rn.childs){
                    que.addLast(child);
                }
            }

            // level++;
            System.out.println();
        }
    }

    public static void levelOrderZigZag(Node root) {
        if(root == null)    return;
        LinkedList<Node> que = new LinkedList<>(); // removeFirst, addLast
        LinkedList<Node> st = new LinkedList<>(); // removeFirst, addFirst
        que.addLast(root);

        int level = 0;
        List<List<Integer>> ans = new ArrayList<>();
        while(que.size() != 0) {
            int size = que.size(); // size of current level
            List<Integer> res = new ArrayList<>();
            while (size-- > 0) {
                Node rn = que.removeFirst();
                res.add(rn.data);
                
                if(level % 2 == 0){
                    for(Node child : rn.childs){
                        st.addFirst(child);
                    }
                }
                else{
                    for(int i = rn.childs.size()-1;i>=0;i--){
                        Node child = rn.childs.get(i);
                        st.addFirst(child);
                    }
                }
            }
            ans.add(res);
            level++;
            LinkedList<Node> temp = que;
            que = st;
            st = temp;
        }
        for(List<Integer> a : ans){
            for(int ele : a)
                System.out.print(ele + " ");
            System.out.println();
        }
    }
}