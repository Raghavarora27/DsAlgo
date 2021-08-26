import java.util.*;

public class Print_BoardPath{
    
    public static int boardPath(int n,String ans){
        if(n == 0){
            System.out.println(ans);
            return 1;
        }
        
        int count = 0;
        
        for(int dice = 1;dice<=6 && n-dice >= 0 ;dice++){
            count += boardPath(n-dice,ans + dice);
        }
        
        
        return count;
    }
    
    
    public static Scanner sc = new Scanner(System.in);
    public static void main(String [] args){
        int n = sc.nextInt();
        System.out.println(boardPath(n,""));
    }
}