class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] indeg = new int[n + 1];
        Arrays.fill(indeg, -1);
        int bl1 = -1;
        int bl2 = -1;

        for (int i = 0; i < edges.length; i++) {
            int edge[] = edges[i];
            int u = edge[0];
            int v = edge[1];
            if (indeg[v] == -1) {
                indeg[v] = i;
            } else {
                bl1 = i; // last index
                bl2 = indeg[v]; // second last index
            }
        }

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            int edge[] = edges[i];
            int u = edge[0];
            int v = edge[1];

            if (bl1 == -1) {
                if (uf.isConnexted(u, v)) {
                    return edge;
                } else {
                    uf.union(u, v);
                }
            } else {
                if (i != bl1) {
                    if (uf.isConnexted(u, v)) {
                        return edges[bl2];
                    } else {
                        uf.union(u, v);
                    }
                }
            }
        }
        return edges[bl1];
    }

    class UnionFind {
        int par[];
        int rank[];

        UnionFind(int vtx) {
            par = new int[vtx + 1];
            rank = new int[vtx + 1];
            for (int i = 1; i <= vtx; i++) {
                par[i] = i;
                rank[i] = 1;
            }
        }

        void union(int v1, int v2) {
            int rt1 = find(v1);
            int rt2 = find(v2);

            if (rt1 != rt2) {
                int rank2 = rank[v2];
                int rank1 = rank[v1];

                if (rank1 > rank2) {
                    par[rt2] = rt1;
                } else if (rank1 < rank2) {
                    par[rt1] = rt2;
                } else {
                    par[rt2] = rt1;
                    rank[rt1]++;
                }
            }
        }

        int find(int vtx) {
            if (par[vtx] == vtx) {
                return vtx;
            }
            return par[vtx] = find(par[vtx]);
        }

        boolean isConnexted(int v1, int v2) {
            return find(v1) == find(v2);
        }
    }
}
