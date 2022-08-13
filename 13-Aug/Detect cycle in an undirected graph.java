https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?page=1&category[]=union-find&sortBy=submissions

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis=new boolean[adj.size()];
        
        for(int i=0;i<V;i++){
            if(!vis[i]){
                boolean ans=dfs(i,vis,adj,-1);
                if(ans==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i,boolean[] vis,ArrayList<ArrayList<Integer>> adj,int parent){
        vis[i]=true;
        for(Integer nbr:adj.get(i)){
            if(vis[nbr]==false){
                if(dfs(nbr,vis,adj,i)==true) return true;
            }else if(nbr!=parent) return true;
        }
        return false;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


