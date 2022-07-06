public class trie2 {
    public static class Node{
        Node [] link = new Node[26];
        int cnt_ends_with = 0;
        int cnt_prefix = 0;

        // Constructor
        public Node(){

        }

        boolean containsKey(char ch){
            return link[ch - 'a'] != null;
        }

        Node get(char ch){
            return link[ch - 'a'];
        }

        void put(char ch,Node node){
            link[ch - 'a'] = node;
        }

        void increaseEnd(){
            cnt_ends_with++;
        }

        void increasePrefix(){
            cnt_prefix++;
        }

        void deleteEnd(){
            cnt_ends_with--;
        }

        void reducePrefix(){
            cnt_prefix--;
        }

        int getEnd(){
            return cnt_ends_with;
        }

        int getPrefix(){
            return cnt_prefix;
        }
    }

    public static class Trie {
        private Node root;

        public Trie() {
            root = new Node();
        }
    
        public void insert(String word) {
            Node node = root;
            for(int i = 0;i < word.length();i++){
                if(!node.containsKey(word.charAt(i))){
                    node.put(word.charAt(i), new Node());
                }
                node = node.get(word.charAt(i));
                node.increasePrefix();
            }
            node.increaseEnd();
        }
    
        public int countWordsEqualTo(String word) {
            Node node = root;
            for(int i = 0;i < word.length();i++){
                if(node.containsKey(word.charAt(i))){
                    node = node.get(word.charAt(i));
                }
                else{
                    return 0;
                }
            }
            return node.getEnd();
        }
    
        public int countWordsStartingWith(String word) {
            Node node = root;
            for(int i = 0;i < word.length();i++){
                if(node.containsKey(word.charAt(i))){
                    node = node.get(word.charAt(i));
                }
                else{
                    return 0;
                }
            }
            return node.getPrefix();
        }
    
        public void erase(String word) {
            Node node = root;
            for(int i = 0;i < word.length();i++){
                if(node.containsKey(word.charAt(i))){
                    node = node.get(word.charAt(i));
                    node.reducePrefix();
                }
                else{
                    return;
                }
            }
            node.deleteEnd();
        }
    }
        
    public static void main(String args[]) {
        Trie T = new Trie();
        
        T.insert("apple");
        T.insert("apple");
        T.insert("apps");
        T.insert("apps");
        
        String word1 = "apps";
        System.out.println("Count Words Equal to "+word1+" "+T.countWordsEqualTo(word1));
        
        String word2 = "abc";
        System.out.println("Count Words Equal to "+word2+" "+T.countWordsEqualTo(word2));
        
        String word3 = "ap";
        System.out.println("Count Words Starting With "+word3+" "+T.countWordsStartingWith(word3));
        
        String word4 = "appl";
        System.out.println("Count Words Starting With "+word4+" "+T.countWordsStartingWith(word4));
        
        T.erase(word1);
        System.out.println("Count Words equal to "+word1+" "+T.countWordsEqualTo(word1));
    }
}
