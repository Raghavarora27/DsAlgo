import java.util.ArrayList;

public class Graph {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public static void display(ArrayList<Edge>[] graph, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(i + " -> ");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.nbr + ", " + e.wt + ")");
            }
            System.out.println();
        }
    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {

        ArrayList<Edge> list = graph[u];
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (e.nbr == v)
                return i;
        }
        return -1;
    }

    public static void removeEdge(ArrayList<Edge>[] graph,int u, int v) {
        int i1 = findEdge(graph, u, v); // u ke andar v dhundlo
        int i2 = findEdge(graph, v, u); // v ke andar u dhundlo

        graph[u].remove(i1);
        graph[v].remove(i2);
    }

    public static void removeVtx(ArrayList<Edge>[] graph,int u) {
        ArrayList<Edge> list = graph[u];
        for (int i = list.size()-1;i>=0;i--) {
            Edge e = list.get(i);
            removeEdge(graph,e.src, e.nbr);
        }
    }

    public static void construction() {
        int N = 7;
        ArrayList<Egde>[] graph = new ArrayList[N]; // Array of ArrayList eg int [] arr, so int ki jagah arraylist
        // Array ke andar ArrayList jo edge type ki h (jisme src,nbr or wt hai)

        for (int i = 0; i < N; i++) { // N = Number of Vertices
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
        addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
        addEdge(graph, 5, 6, 3);
    }
}
