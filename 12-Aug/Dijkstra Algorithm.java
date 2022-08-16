https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[]vis=new int[adj.size()];
        Arrays.fill(vis,-1);
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.add(new int[]{S,0});
        
        while(pq.size()>0 ){
            int[] p=pq.remove();
            if(vis[p[0]]!=-1) continue;
            vis[p[0]]=p[1];
            ArrayList<ArrayList<Integer>> edges=adj.get(r[0]);
            for(ArrayList<Integer> e: edges){
                int nbr=e.get(0);
                int wt=e.get(1);
                if(vis[nbr]==-1){
                    pq.add(new int[]{nbr,p[1]+wt});
                }
            }
        }
        return vis;
    }
}
