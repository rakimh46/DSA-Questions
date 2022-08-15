//bellman frod algo
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        for(int i=0;i<=k;i++){
            int[]temp=Arrays.copyOf(ans,n); //minor change only update from src only
            for(int[] e:flights){
                int u=e[0];
                int v=e[1];
                int wt=e[2];
                if(ans[u]==Integer.MAX_VALUE) continue;
                temp[v]=Math.min(ans[u]+wt,temp[v]);
            }
            ans=temp;
        }
        return ans[dst]==Integer.MAX_VALUE ? -1:ans[dst];
    }
}

//by dijkstra algo

class Solution {
    class Edge{
        int nbr;
        int cost;
        Edge(int n,int c){
            nbr=n;
            cost=c;
        }
    }
    class Pair{
        int city;
        int stop;
        int cost;
        Pair(int cc,int s,int c){
            city=cc;
            stop=s;
            cost=c;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int s, int dst, int k) {
        // Build the graph 
        Map<Integer,ArrayList<Edge>> graph=new HashMap<>();
        
        for(int[] f:flights){
            int src=f[0];
            int nbr=f[1];
            int cost=f[2];
            graph.putIfAbsent(src,new ArrayList<Edge>());
            graph.get(src).add(new Edge(nbr,cost));
        }
        
        PriorityQueue<Pair> minHeap=new PriorityQueue<>((a,b) -> Integer.compare(a.cost,b.cost));
        minHeap.add(new Pair(s,0,0));
        HashMap<Integer, Integer> seen = new HashMap<>();

        while(!minHeap.isEmpty()){
            Pair rem=minHeap.poll();
            int city=rem.city;
            int stops=rem.stop;
            int cost=rem.cost;
            System.out.println(city+"  "+cost+"  "+stops);

            if(!seen.containsKey(city) || stops < seen.get(city))
                seen.put(city, stops);
            else
                continue;
            
            if(city == dst)
                return cost;
            
            if(stops > k || !graph.containsKey(city))
                continue;
            
            for(Edge e: graph.get(city)){
                minHeap.add(new Pair(e.nbr,stops+1,e.cost+cost));
            }
        }
        return -1;
    }
    
}
