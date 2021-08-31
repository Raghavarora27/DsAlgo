import java.util.*;

public class PermutationsWithoutDuplicates{
    
    public static int permutationsWithoutDuplicates(String str,String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        char prev = '$';
        
        for(int i=0;i<str.length();i++){
            if(prev != str.charAt(i)){
                String ros = str.substring(0,i) + str.substring(i+1);
                count += permutationsWithoutDuplicates(ros,ans + str.charAt(i));
            }
            prev = str.charAt(i);
        }
        
        return count;
    }
    
    //Sorting string -- O(n)
    public static void permutationsWithoutDuplicates(String str){
        int [] arr = new int[26];
        StringBuilder sb = new StringBuilder();
        
        // O(n)
        for(int i=0;i<str.length();i++)
            arr[str.charAt(i) - 'a']++;
        
        //O(n) -- length of string tak hi chala h loop
        for(int i=0;i<26;i++){
            for(int j=0;j<arr[i];j++){
                sb.append((char)(i + 'a'));
            }
        }    
        // System.out.println((char)(2 + 'a'));
        // toString() -- O(n)
        System.out.println(permutationsWithoutDuplicates(sb.toString(),""));    
    }
    
    
    public static Scanner sc = new Scanner(System.in); 
    public static void main(String [] args){
        String str = sc.nextLine();
        permutationsWithoutDuplicates(str);
    }
}