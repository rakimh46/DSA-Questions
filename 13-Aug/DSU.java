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

class solution{
  UnionFind uf=new UnionFind(n);
}
