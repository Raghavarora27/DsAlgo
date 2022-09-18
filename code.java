import java.util.*;
class Main{
    public static void main(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> v = new ArrayList<>();
        for(int i = 0;i < n;i++){
            v.add(sc.nextInt());
        }

        System.out.println(maxCoins(v,n));
    }

    public static int maxCoins(ArrayList<Integer> v,int n){
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for(int g = 0;g < n;g++){
            for(int i = 0,j = g;j < n;i++,j++){
                if(g == 0){
                    dp.get(i).set(j, v.get(i));
                }
                else if(g == 1){
                    dp.get(i).set(j, Math.max(v.get(i),v.get(j)));
                }
                else{
                    int val1 = v.get(i) + Math.min(dp.get(i + 2).get(j),dp.get(i + 1).get(j - 1));
                    int val2 = v.get(j) + Math.min(dp.get(i + 1).get(j - 1),dp.get(i).get(j - 2));
                    dp.get(i).set(j, Math.max(val1, val2));
                }
            }
        }

        return dp.get(0).get(n - 1);
    }
}