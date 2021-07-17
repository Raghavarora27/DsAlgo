import java.util.*;
public class Removehi {
    public static void remove(String str){
        int n = str.length();
        int i = 0;
        String s = "";
        while(i < n-1){
            if(i+1 < n && str.charAt(i) == 'h' && str.charAt(i+1) == 'i'){
                i += 2;
            }
            else{
                s += str.charAt(i);
                i++;
            }
        }
        System.out.println(s);
    }

    public int countHi(String str) {
        if(str.length() <= 1) return 0;
        int count = 0,n = str.length();
        int i = 0;
        while(i < n-1){
          if(str.charAt(i) == 'h' && str.charAt(i+1) == 'i'){
            if(i+2<n && str.charAt(i+2) == 't'{
              i += 3;
            }else{
              count++;
              i += 2;
            }
          }else{
            i++;
          }
        }
        return count;
      }
      
    
    public static void main(String [] args){
        String str = "h";
        remove(str);
    }
}
