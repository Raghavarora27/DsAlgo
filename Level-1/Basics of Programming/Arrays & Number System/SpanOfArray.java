import java.util.*;

public class SpanOfArray{

    public static int span(int [] arr){
        int maxx = -(int)1e9;
        int minn = (int)1e9;

        for(int r : arr){
            maxx = Math.max(r,maxx);
            minn = Math.min(r,minn);
        }
        return maxx - minn;
    }

    public static void main(String [] args){
        int [] arr = {2,34,33,56,4,23,1};
        System.out.println(span(arr));
    }
} 