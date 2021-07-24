import java.util.*;

public class pattern_16{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int star=1;
    int space = 2*n-3;
    for(int i=1;i<=n;i++){
        int count=0;
        for(int j=1;j<=star;j++){
            count++;
            System.out.print(count + "\t");
        }
        for(int j=1;j<=space;j++){
            System.out.print("\t");
        }
        if(i==n){
            star--;
            count--;
            }
        for(int j=1;j<=star;j++){
            System.out.print(count + "\t");
            count--;
        }
        System.out.println();
        
        space -= 2;
        star++;
    }

 }
}