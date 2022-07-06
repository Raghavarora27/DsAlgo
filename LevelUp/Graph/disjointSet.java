import java.util.Scanner;

public class disjointSet {
    private static int [] rank = new int[100000];
    private static int [] parent = new int[100000];

    public static void makeSet(){
        for(int i = 1;i <= 10;i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // path compression
    public static int findPar(int node){
        if(node == parent[node])
            return node;

        return parent[node] = findPar(parent[node]);
    }

    public static void union(int u,int v){
        u = findPar(u);
        v = findPar(v);

        if(rank[u] < rank[v])
            parent[u] = v;
        else if(rank[u] > rank[v])
            parent[v] = u;
        else{
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        makeSet();
        int n = sc.nextInt();
        while(n-- > 0){
            int u = sc.nextInt();
            int v = sc.nextInt();
            
            union(u, v);
        }

        if(findPar(2) != findPar(3))
            System.out.println("Different Component");
        else
            System.out.println("Same Component");

        sc.close();
    }
}