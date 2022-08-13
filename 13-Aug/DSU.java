class UF {
    int[] parent;
    int[] rank;
    
    UF(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
                parent[i]=i;
                rank[i]=1;
        }
    }
        
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    
    public void union(int p, int q) {
        int pr = find(p);
        int qr = find(q);
        if (pr == qr) return;
        
        if (rank[pr] < rank[qr]) {
            parent[pr] = qr;
        } else {
            parent[qr] = pr;
            if (rank[pr] == rank[qr]) rank[pr]++;
        }
    }
}
