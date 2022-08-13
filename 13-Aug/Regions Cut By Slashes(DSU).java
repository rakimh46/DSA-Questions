https://leetcode.com/problems/regions-cut-by-slashes/
class UnionFind{
    int count=1;
    int[]par;
    int[]rank;
    UnionFind(int n){
        int m=n*n;
        par=new int[m];
        rank=new int[m];
        for(int i=0;i<m;i++){
            par[i]=i;
            rank[i]=1;
        }
    }
    
    void union(int x,int y){
        int px=find(x);
        int py=find(y);
        if(px!=py){
            if(rank[x]<rank[y]){
                par[px]=py;
            }else{
                par[py]=px;
                if(rank[x]==rank[y]) rank[x]++;
            }
        }else{
            count++;
        }
    }
    int find(int x){
        if(x==par[x]) return x;
        return par[x]=find(par[x]);
    }
}
class Solution {
    
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        UnionFind uf=new UnionFind(n+1);
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0) continue;
                
                if(i==0 || j==0 || i==n || j==n){
                    int idx=i*(n+1)+j;
                    uf.union(0,idx);
                }
            }
        }
        int i=0;
        for(String inp:grid){
            for(int j=0;j<inp.length();j++){
                char ch=inp.charAt(j);
                if(ch=='/'){
                    int pt1=i*(n+1)+(j+1);
                    int pt2=(i+1)*(n+1)+j;
                    uf.union(pt1,pt2);
                }else if(ch=='\\'){
                    int pt1=i*(n+1)+j;
                    int pt2=(i+1)*(n+1)+(j+1);
                    uf.union(pt1,pt2);
                }
            }
            i++;
        }
        return uf.count;
    }
}
