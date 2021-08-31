import java.util.*;

public class PermutationsWithDuplicates{
    
    // void type -- making answer while going up
    public static int permutations(String str,String ans){
        if(str.length() == 0){
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for(int i=0;i<str.length();i++){
            String ros = str.substring(0,i) + str.substring(i+1); 
            count += permutations(ros,ans + str.charAt(i));
        }        
        
        return count;
    }
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        String str = sc.nextLine();
        System.out.println(permutations(str,""));
    }
}