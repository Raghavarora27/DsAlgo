import java.util.*;
    
    public class GcdLcm{
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        int temp1 = num1;
        int temp2 = num2;
        
        while(num1 % num2 != 0){
            int rem = num1 % num2;
            num1 = num2;
            num2 = rem;
        }
        System.out.println(num2);
        System.out.println((temp1*temp2)/num2);
       
     }
    }
