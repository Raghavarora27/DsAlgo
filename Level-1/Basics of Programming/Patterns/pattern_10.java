import java.util.*;

public class pattern_10{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    
    int space1 = n/2;
    int space2 = -1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=space1;j++){
            System.out.print("	");
        }
        System.out.print("*	");
        for(int j=1;j<=space2;j++){
            System.out.print("	");
        }
        if(i==1 || i==n){
            System.out.print("	");
        }
        else{
            System.out.print("*	");
        }
        System.out.println();
        if(i<=n/2){
            space1--;
            space2 += 2;
        }
        else{
            space1++;
            space2 -= 2;
        }
    }

 }
}