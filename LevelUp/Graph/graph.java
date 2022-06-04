import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class graph {

  // BFS
  // Traversing the Adjacent Nodes at first and after that move to the next nodes
  // As graph can have mutiple components,so we run for-loop for every node
  // and if node is unvisited, we call the BFS from that node
  // TC : O(N + E) SC : O(N + E) + O(N) + O(N)
  public static ArrayList<Integer> BFS(
    int V,
    ArrayList<ArrayList<Integer>> adj
  ) {
    ArrayList<Integer> ans = new ArrayList<>();
    boolean[] vis = new boolean[V + 1]; // doing with 1 based indexing

    for (int i = 1; i <= V; i++) { // graph have multiple components, is not then remove this loop
      if (!vis[i]) {
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(i);
        vis[i] = true;

        while (que.size() != 0) {
          Integer node = que.removeFirst();
          ans.add(node);

          for (Integer ele : adj.get(node)) {
            if (!vis[ele]) {
              vis[ele] = true;
              que.addLast(ele);
            }
          }
        }
      }
    }

    return ans;
  }

  // DFS
  // TC : O(N + E) SC : O(N + E) + O(N) + O(N)
  public static void DFS_(
    int node,
    boolean[] vis,
    ArrayList<ArrayList<Integer>> adj,
    ArrayList<Integer> ans
  ) {
    ans.add(node);
    vis[node] = true;
    for (Integer ele : adj.get(node)) {
      if (!vis[ele]) DFS_(ele, vis, adj, ans);
    }
  }

  public static ArrayList<Integer> DFS(
    int V,
    ArrayList<ArrayList<Integer>> adj
  ) {
    ArrayList<Integer> ans = new ArrayList<>();
    boolean[] vis = new boolean[V + 1];

    for (int i = 1; i <= V; i++) {
      if (!vis[i]) DFS_(i, vis, adj, ans);
    }

    return ans;
  }

  // Cycle Detection In Undirected Graph Using BFS
  public static boolean CycleDetectionInUndirectedGraph(
    int V,
    ArrayList<ArrayList<Integer>> adj
  ) {
    boolean[] vis = new boolean[V + 1];
    for (int i = 1; i <= V; i++) {
      if (!vis[i]) if (checkForCycleBFS(i, adj, vis)) return true;
    }

    return false;
  }

  public static class pair {

    int node;
    int parent;

    pair(int node, int parent) {
      this.node = node;
      this.parent = parent;
    }
  }

  public static boolean checkForCycleBFS(
    int StartingNode,
    ArrayList<ArrayList<Integer>> adj,
    boolean[] vis
  ) {
    LinkedList<pair> que = new LinkedList<>();
    que.addLast(new pair(StartingNode, -1));
    vis[StartingNode] = true;

    while (que.size() != 0) {
      pair rn = que.removeFirst();

      for (Integer ele : adj.get(rn.node)) {
        if (!vis[ele]) {
          que.addLast(new pair(ele, rn.node));
          vis[ele] = true;
        } else if (rn.parent != ele) return true; // cycle
      }
    }

    return false;
  }

  // Cycle Detection In Undirected Graph Using DFS
  // TC : O(N) SC : O(N)
  public static boolean checkForCycleDFS(
    int node,
    int parent,
    ArrayList<ArrayList<Integer>> adj,
    boolean[] vis
  ) {
    vis[node] = true;
    for (Integer ele : adj.get(node)) {
      if (!vis[ele]) {
        if (checkForCycleDFS(ele, node, adj, vis)) return true;
      } else if (parent != ele) return true;
    }

    return false;
  }

  public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean[V + 1];
    for (int i = 1; i <= V; i++) {
      if (!vis[i]) if (checkForCycleDFS(i, -1, adj, vis)) return true;
    }

    return false;
  }

  // Bipartite Graph BFS
  // -1 : No color , 0 : red, 1 : blue
  public static boolean checkBipartiteBFS(
    ArrayList<ArrayList<Integer>> adj,
    int n
  ) {
    int[] color = new int[n];
    for (int i = 0; i < n; i++) {
      color[i] = -1;
    }

    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        if (!bfsCheck(adj, i, color)) return false;
      }
    }

    return true;
  }

  public static boolean bfsCheck(
    ArrayList<ArrayList<Integer>> adj,
    int startingNode,
    int[] color
  ) {
    LinkedList<Integer> que = new LinkedList<>();
    que.addLast(startingNode);
    color[startingNode] = 1;
    while (que.size() != 0) {
      Integer node = que.removeFirst();

      for (int ele : adj.get(node)) {
        if (color[ele] == -1) {
          color[ele] = 1 - color[node]; // setting the opposite color compared to prev node
          que.addLast(ele);
        } else if (color[ele] == color[node]) return false;
      }
    }

    return true;
  }

  // Bipartite Graph BFS
  static boolean dfsCheck(
    ArrayList<ArrayList<Integer>> graph,
    int node,
    int color[]
  ) {
    for (Integer it : graph.get(node)) {
      if (color[it] == -1) {
        //Color of variable neighbor is the inverted color of variable node
        color[it] = 1 - color[node];

        if (!dfsCheck(graph, it, color)) return false;
      } else if (color[it] == color[node]) {
        return false;
      }
    }
    return true;
  }

  static boolean checkBipartiteDFS(ArrayList<ArrayList<Integer>> graph, int n) {
    int color[] = new int[n];

    for (int i = 0; i < n; i++) {
      color[i] = -1;
    }

    for (int i = 0; i < n; i++) {
      if (color[i] == -1) {
        if (!dfsCheck(graph, i, color)) {
          return false;
        }
      }
    }
    return true;
  }

  // Cycle Detection in Directed Graph using DFS
  public static boolean checkCycleDFS(
    ArrayList<ArrayList<Integer>> adj,
    int node,
    int[] vis,
    int[] dfsvis
  ) {
    vis[node] = 1;
    dfsvis[node] = 1;

    for (int ele : adj.get(node)) {
      if (vis[ele] == 0) {
        if (checkCycleDFS(adj, ele, vis, dfsvis)) return true;
      } else if (dfsvis[ele] == 1) return true;
    }
    dfsvis[node] = 0;
    return false;
  }

  public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
    int[] vis = new int[V];
    int[] dfsvis = new int[V];

    for (int i = 0; i < V; i++) {
      if (vis[i] == 0) if (checkCycleDFS(adj, i, vis, dfsvis)) return true;
    }

    return false;
  }

  // Topological Sort
  // TC : O(N + E) SC : O(N)
  public static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
    LinkedList<Integer> st = new LinkedList<>();
    int[] vis = new int[N];

    for (int i = 0; i < N; i++) {
      if (vis[i] == 0) {
        FindTopoSort(adj, vis, st, i);
      }
    }

    int[] ans = new int[N];
    int i = 0;
    while (st.size() != 0) {
      ans[i++] = st.removeFirst();
    }

    return ans;
  }

  public static void FindTopoSort(
    ArrayList<ArrayList<Integer>> adj,
    int[] vis,
    LinkedList<Integer> st,
    int node
  ) {
    vis[node] = 1;

    for (int ele : adj.get(node)) {
      if (vis[ele] == 0) {
        FindTopoSort(adj, vis, st, ele);
      }
    }

    st.addFirst(node);
  }

  // Topological Sort using BFS (Kahn's Algorithm)
  public static int[] topoSort_2(ArrayList<ArrayList<Integer>> adj, int N) {
    int[] indegree = new int[N];
    int[] ans = new int[N];

    // Adding indegree of all the nodes
    for (int i = 0; i < N; i++) {
      for (int ele : adj.get(i)) {
        indegree[ele]++;
      }
    }

    LinkedList<Integer> que = new LinkedList<>();
    // Adding the nodes with indegree == 0
    for (int i = 0; i < N; i++) {
      if (indegree[i] == 0) que.addLast(i);
    }

    // Iterating in queue and decreasing the indegree value of nodes
    int ind = 0;
    while (que.size() != 0) {
      int node = que.removeFirst();
      ans[ind++] = node;

      for (int ele : adj.get(node)) {
        indegree[ele]--;
        if (indegree[ele] == 0) que.addLast(ele);
      }
    }

    return ans;
  }

  // Cycle Detection in Directed Graph using BFS(Kahn's Algo)
  public static boolean isCyclic_2(ArrayList<ArrayList<Integer>> adj, int N) {
    int[] indegree = new int[N];

    // Adding indegree of all the nodes
    for (int i = 0; i < N; i++) {
      for (int ele : adj.get(i)) {
        indegree[ele]++;
      }
    }

    LinkedList<Integer> que = new LinkedList<>();
    // Adding the nodes with indegree == 0
    for (int i = 0; i < N; i++) {
      if (indegree[i] == 0) que.addLast(i);
    }

    // Iterating in queue and decreasing the indegree value of nodes
    int count = 0;
    while (que.size() != 0) {
      int node = que.removeFirst();
      count++;

      for (int ele : adj.get(node)) {
        indegree[ele]--;
        if (indegree[ele] == 0) que.addLast(ele);
      }
    }

    if (count == N) return false;

    return true;
  }

  // Shortest Path in Undirected Graph with Unit Weights (BFS)
  // TC : O(N + E) SC : O(N) + O(N)
  public static void shortestDistance(
    ArrayList<ArrayList<Integer>> adj,
    int N,
    int src
  ) {
    int[] dist = new int[N];
    for (int i = 0; i < dist.length; i++) dist[i] = (int) 1e9;

    LinkedList<Integer> que = new LinkedList<>();
    dist[src] = 0;
    que.addLast(0);

    while (que.size() != 0) {
      int node = que.removeFirst();

      for (int ele : adj.get(node)) {
        if (dist[node] + 1 < dist[ele]) {
          dist[ele] = dist[node] + 1;
          que.addLast(ele);
        }
      }
    }

    for (int i = 0; i < N; i++) System.out.print(dist[i] + " ");
  }

  // Shortest Path in DAG with weights
  public static class Pair {

    private int v;
    private int weight;

    Pair(int _v, int _w) {
      v = _v;
      weight = _w;
    }

    int getV() {
      return v;
    }

    int getWeight() {
      return weight;
    }
  }

  public static void shortestPath() {
    int n = 6;
    ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

    for (int i = 0; i < n; i++) adj.add(new ArrayList<Pair>());

    adj.get(0).add(new Pair(1, 2));
    adj.get(0).add(new Pair(4, 1));
    adj.get(1).add(new Pair(2, 3));
    adj.get(2).add(new Pair(3, 6));
    adj.get(4).add(new Pair(2, 2));
    adj.get(4).add(new Pair(5, 4));
    adj.get(5).add(new Pair(3, 1));

    shortestPath_(0, adj, n);
  }

  public static void shortestPath_(
    int src,
    ArrayList<ArrayList<Pair>> adj,
    int N
  ) {
    LinkedList<Integer> st = new LinkedList<>();
    int[] dist = new int[N];
    boolean[] vis = new boolean[N];

    for (int i = 0; i < N; i++) {
      if (!vis[i]) {
        topologicalSortUtil(i, vis, st, adj);
      }
    }
    Arrays.fill(dist, (int) 1e9);
    dist[src] = 0;

    while (st.size() != 0) {
      int node = st.removeFirst();

      if (dist[node] != (int) 1e9) {
        for (Pair p : adj.get(node)) {
          if (dist[node] + p.getWeight() < dist[p.getV()]) {
            dist[p.getV()] = dist[node] + p.getWeight();
          }
        }
      }
    }

    for (int i = 0; i < N; i++) {
      if (dist[i] == Integer.MAX_VALUE) System.out.print(
        "INF "
      ); else System.out.print(dist[i] + " ");
    }
  }

  public static void topologicalSortUtil(
    int node,
    boolean[] visited,
    LinkedList<Integer> st,
    ArrayList<ArrayList<Pair>> adj
  ) {
    visited[node] = true;
    for (Pair it : adj.get(node)) {
      if (visited[it.getV()] == false) {
        topologicalSortUtil(it.getV(), visited, st, adj);
      }
    }
    st.addFirst(node);
  }

  // Dijkstra's Algorithm | Shortest Path in Undirected Graphs
  // Time Complexity: O((N+E)*logN). Going through N nodes and E edges and log N for priority queue
  // Space Complexity: O(N). Distance array and priority queue
  public static class Node implements Comparator<Node> {

    private int v;
    private int weight;

    Node(int _v, int _w) {
      v = _v;
      weight = _w;
    }

    Node() {}

    int getV() {
      return v;
    }

    int getWeight() {
      return weight;
    }

    @Override
    public int compare(Node node1, Node node2) {
      if (node1.weight < node2.weight) return -1;
      if (node1.weight > node2.weight) return 1;
      return 0;
    }
  }

  public static void shortestPath(
    int s,
    ArrayList<ArrayList<Node>> adj,
    int N
  ) {
    int dist[] = new int[N];

    for (int i = 0; i < N; i++) dist[i] = 100000000;
    dist[s] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new Node());
    pq.add(new Node(s, 0));

    while (pq.size() > 0) {
      Node node = pq.poll();

      for (Node it : adj.get(node.getV())) {
        if (dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
          dist[it.getV()] = dist[node.getV()] + it.getWeight();
          pq.add(new Node(it.getV(), dist[it.getV()]));
        }
      }
    }
    System.out.println("The distances from source " + s + " are : ");
    for (int i = 0; i < N; i++) {
      System.out.print(dist[i] + " ");
    }
  }

  public static void printAns(ArrayList<Integer> ans) {
    for (int i = 0; i < ans.size(); i++) {
      System.out.print(ans.get(i) + " ");
    }
  }

  public static void main(String args[]) {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i <= 5; i++) {
      adj.add(new ArrayList<>());
    }
    adj.get(1).add(2);
    adj.get(2).add(1);
    adj.get(1).add(3);
    adj.get(3).add(1);
    adj.get(1).add(4);
    adj.get(4).add(1);
    adj.get(2).add(5);
    adj.get(5).add(2);

    ArrayList<Integer> ans = DFS(5, adj);
    printAns(ans);
  }
}
