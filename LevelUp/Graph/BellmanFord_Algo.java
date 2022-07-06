import java.util.*; 
public class BellmanFord_Algo {

    public static class Node {
        private int u;
        private int v;
        private int weight;
        
        Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }
        
        Node() {}
        
        int getV() { return v; }
        int getU() { return u; }
        int getWeight() { return weight; }

    }
    
    // Bellman Ford Algorithm
    // gives the shortest path from src to any given node
    // Dijkstra Algo also gives shortest path but failed when graph has negative weight edges
    // In Bellman Ford Algo -
    // Directed Graph -> doesnot work for -ve cycle but can detect the -ve Weight cycle
    // undirected Graph -> Convert into directed graph then same as Directed graph


    public static void bellmanFord(ArrayList<Node> edges, int N, int src){
        int dist[] = new int[N];
        for(int i = 0;i<N;i++) dist[i] = 10000000; 
        
        dist[src] = 0;
    
        // Why N - 1 Relaxation ? as if N = 5 vertices are there then longest path will be N - 1 Edges
    	for(int i = 1;i<=N-1;i++) {
    		for(Node node : edges) {
    			if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) { // Relaxation Condition
    				dist[node.getV()] = dist[node.getU()] + node.getWeight(); 
    			}
    		}
    	}

    	int fl = 0; // flag to check -ve cycle exist or not by doing one more relaxation
    	for(Node node: edges) {
    		if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
    			fl = 1;
    			System.out.println("Negative Cycle"); 
    			break;
    		}
    	}

    	if(fl == 0) {
    		for(int i = 0;i<N;i++) {
    			System.out.print(  dist[i]+" "); 
    		}
    	}
    }
    public static void main(String args[]){
        int n = 6;
        ArrayList<Node> adj = new ArrayList<Node>();
			
		adj.add(new Node(3, 2, 6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));

	
		bellmanFord(adj, n, 0);
		
    }
}

