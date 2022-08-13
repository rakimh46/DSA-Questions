// https://practice.geeksforgeeks.org/problems/mother-vertex/1
class Solution
{
    //Function to find a Mother Vertex in the Graph.
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int vtx = 0; vtx < V; vtx++) {
            if (visited[vtx] == false) {
                dfs1(adj, vtx, visited, st);
            }
        }
        
        count=0;
        dfs2(adj,st.peek(),new boolean[V]);
        if(count==V){
            return st.peek();
        }else{
            return -1;
        }
        
    }
    
    public static void dfs1(ArrayList<ArrayList<Integer>> adj, int vtx, boolean[] visited, Stack<Integer> st) {
        visited[vtx] = true;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for (int nbr : nbrs) {
            if (visited[nbr] == false) {
                dfs1(adj, nbr, visited, st);
            }
        }
        st.push(vtx);
    }
    static int count;
    public static void dfs2(ArrayList<ArrayList<Integer>> adj, int vtx, boolean[] visited) {
        visited[vtx] = true;
        count++;
        ArrayList<Integer> nbrs = adj.get(vtx);
        for (int nbr : nbrs) {
            if (visited[nbr] == false) {
                dfs2(adj, nbr, visited);
            }
        }
    }
    
}
