package Questions;

public class LongestWordWithAllPrefixes {
    public static class Node{
        Node [] link = new Node[26];
        boolean flag = false;
        
        public Node(){
            
        }
        
        boolean containsKey(char ch){
            return link[ch - 'a'] != null;
        }
        
        void put(char ch,Node node){
            link[ch - 'a'] = node;
        } 
        
        Node get(char ch){
            return link[ch - 'a'];
        }
        
        boolean getEnd(){
            return flag;
        }
        
        void setEnd(){
            flag = true;
        }
    }
    
    public static class trie{
        private static Node root;
        
        public trie(){
            root = new Node();        
        }
        
        public static void insert(String word){
            Node node = root;
            for(int i = 0;i < word.length();i++){
                if(!node.containsKey(word.charAt(i))){
                    node.put(word.charAt(i),new Node());
                }
                node = node.get(word.charAt(i));
            }
            node.setEnd();
        }
        
        public static boolean checkIfprefixExists(String word) {
            Node node = root;
            boolean flag = true;
            for(int i = 0;i < word.length();i++){
                if(node.containsKey(word.charAt(i))){
                    node = node.get(word.charAt(i));
                    flag = flag && node.getEnd();
                }
                else{
                    return false;
                }
            }
            
            return flag;
        }
    }
    
    class Solution {
    
    public static String completeString(int n, String[] a) {
        trie obj = new trie();
        // O(n * len) 
        for(int i = 0;i < n;i++){
            obj.insert(a[i]);
        }

        String longest = "";
        // O(n * len) 
        for(int i = 0;i < n;i++){
            if(obj.checkIfprefixExists(a[i])){
                if(a[i].length() > longest.length()){
                    longest = a[i];
                }
                else if(a[i].length() == longest.length()){
                    longest = a[i];
                }
            }
        }
        if(longest == "")    return "None";
        return longest;
    }
    }
}
