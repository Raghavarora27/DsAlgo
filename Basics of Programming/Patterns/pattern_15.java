import java.util.*;

public class pattern_15 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        
        int n = scn.nextInt();
        
        int space = n/2;
        int star = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=space;j++){
                System.out.print("	");
            }
            int countcopy = i;
            if(i>n/2+1){
                countcopy = n - i + 1;
            }
            for(int j=1;j<=star;j++){
                System.out.print(countcopy+"	");

                if(j<=star/2){
                    countcopy++;
                }
                else{
                    countcopy--;
                }
            }
            if(i<=n/2){
                star += 2;
                space--;
            }
            else{
                star -= 2;
                space++;
            }
            System.out.println();
        }

    }
}