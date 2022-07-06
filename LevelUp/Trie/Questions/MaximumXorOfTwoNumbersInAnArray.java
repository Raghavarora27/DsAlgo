import java.util.ArrayList;
import java.util.Arrays;

// https://takeuforward.org/data-structure/maximum-xor-of-two-numbers-in-an-array/

public class MaximumXorOfTwoNumbersInAnArray{
    public class Node{
        Node [] link = new Node[2];
        
        public Node(){

        }

        boolean containsKey(int ind){
            return link[ind] != null;
        }

        Node get(int ind){
            return link[ind];
        }

        void put(int ind,Node node){
            link[ind] = node;
        }
    }

    public class Trie{
        private Node root;

        public Trie(){
            root = new Node();
        }

        public void insert(int num){
            Node node = root;
            for(int i = 31;i >= 0;i--){
                int bit = (num >> i) & 1;
                if(!node.containsKey(bit)){
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

       public int getMax(int num){
            Node node = root;
            int maxi = 0;
            for(int i = 31;i >= 0;i--){
                int bit = (num >> i) & 1;
                if(node.containsKey(1 - bit)){
                    maxi = maxi | (1 << i);
                    node = node.get(1 - bit);
                }                
                else{
                    node = node.get(bit);
                }
            }            
            return maxi;
        }
    }

    public class Solution {
        // TC : O(n * 32) + O(m * 32)
    	public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
	        Trie trie = new Trie();
            for(int i = 0;i < n;i++){
                trie.insert(arr1.get(i));
            }

            int maxi = 0;
            for(int i = 0;i < m;i++){
                maxi = Math.max(maxi,trie.getMax(arr2.get(i)));
            }
            return maxi;
	    }
    }
    
    // public class Main {
    //     public static void main(String[] args) {
    //         int n = 2,m = 3;
    //         ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(new Integer[]
    //         {6,8}));
    //         ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(new Integer[]
    //         {7,8, 2}));
    //         Solution obj = new Solution();
    //         System.out.println(obj.maxXOR(n,m,arr1,arr2));
    //     }
    // }
}