import java.util.*;

public class pattern_18{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    
    int star = n;
    int space = 0;
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=space;j++){
            System.out.print("	");
        }
        for(int j=1;j<=star;j++){
            if(i<=n/2 && i>1 && j>1 && j<star){
                System.out.print("	");
            }
            else{
                System.out.print("*	");
            }
        }
        System.out.println();
        
        if(i<=n/2){
            space++;
            star -= 2;
        }
        else{
            space--;
            star += 2;
        }
        
    }

 }
}