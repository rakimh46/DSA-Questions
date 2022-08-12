//https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1

// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> graph)
    {
        //dfs to stack
        Stack<Integer> st = new Stack<>();
        boolean[]vis = new boolean[V];
        for (int vtx = 0; vtx < V; vtx++) {
            if (vis[vtx] == false) {
                dfs1(graph, vtx, vis, st);
            }
        }
        
        // rev graph
        ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
        for (int vtx = 0; vtx < V; vtx++) {
            revGraph.add(new ArrayList<Integer>());
        }

        for (int vtx = 0; vtx < V; vtx++) {
            ArrayList<Integer> nbrs = graph.get(vtx);
            for (int nbr : nbrs) {
                revGraph.get(nbr).add(vtx);
            }
        }
        
        //dfs & rev graph
        int count = 0;
        vis = new boolean[V];
        while (st.size() > 0) {
            int vtx = st.pop();
            if (vis[vtx] == false) {
                count++;
                dfs2(revGraph, vtx, vis);
            }
        }
        return count;
        
    }
    public static void dfs1(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, Stack<Integer> st) {
        visited[src] = true;
        ArrayList<Integer> nbrs = adj.get(src);
        for (int nbr : nbrs) {
            if (visited[nbr] == false) {
                dfs1(adj, nbr, visited, st);
            }
        }
        st.push(src);
    }

    public static void dfs2(ArrayList<ArrayList<Integer>> adj, int vtx, boolean[] visited) {
        visited[vtx] = true;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for (int nbr : nbrs) {
            if (visited[nbr] == false) {
                dfs2(adj, nbr, visited);
            }
        }
    }
}
