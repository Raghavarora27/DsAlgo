public class NumberOfDistinctSubstrings{
    public class Node{
        Node [] link = new Node[26];

        boolean containsKey(char ch){
            return link[ch - 'a'] != null;
        }

        void put(char ch,Node node){
            link[ch - 'a'] = node;
        }

        Node get(char ch){
            return link[ch - 'a'];
        }
    }

    // TC : O(N^2)
    // SC : (N^2)
    public static int distinctSubstring(String word) {
        Node root = new Node();
        int n = word.length(),count = 0;
        for(int i = 0;i < n;i++){
            Node node = root;
            for(int j = i;j < n;j++){
                if(!node.containsKey(word.charAt(j))){
                    node.put(word.charAt(j), new Node());
                    count++;
                }
                node = node.get(word.charAt(j));
            }
        }

        return count + 1; // adding 1 for the empty string if written in ques else return count only
    }
}