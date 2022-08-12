//https://leetcode.com/problems/is-graph-bipartite/
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited=new int[graph.length];
        Arrays.fill(visited,-1);
        for(int vtx=0;vtx<graph.length;vtx++){
            if(visited[vtx]==-1){
                boolean res=IsCompatiableBipartite(graph,vtx,visited);
                if(res==false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean IsCompatiableBipartite(int[][] graph,int vtx,int[] visited){
        Queue<Pair>qu=new ArrayDeque<>();    
        qu.add(new Pair(vtx,0));
        
        while(qu.size()>0){
            Pair tmp=qu.remove();
            if(visited[tmp.vtx]!=-1){
                if(visited[tmp.vtx]%2!=tmp.level%2){
                    return false;
                }
            }else{
                visited[tmp.vtx]=tmp.level;
                for(int v:graph[tmp.vtx]){
                    qu.add(new Pair(v,tmp.level+1));
                }
            }
        }
        return true;
    }
    
    public class Pair{
        int vtx;
        int level;
        Pair(int vtx,int level){
            this.vtx=vtx;
            this.level=level;
        }
    }
}
