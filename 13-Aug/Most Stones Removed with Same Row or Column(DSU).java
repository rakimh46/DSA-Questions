https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int m=stones.length;
        
        UnionFind uf=new UnionFind(n);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    uf.union(i,j);
                }
            }
        }
        
        return n-uf.count;
    }
    
    class UnionFind{
        int[]par;
        int count;
        UnionFind(int n){
            par=new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
            }
            count=n;
        }
        
        void union(int u,int v){
            int pt1=find(u);
            int pt2=find(v);
            if(pt1!=pt2){
                par[pt2]=pt1;
                count--;
            }
        }
        
        int find(int x){
            if(x==par[x]) return x;
            return par[x]=find(par[x]);
        }
    }
}
