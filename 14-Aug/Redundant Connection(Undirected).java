https://leetcode.com/problems/redundant-connection/
class Solution {
    class UnionFind {
        int par[];
        int rank[];

        UnionFind(int vtx) {
            par = new int[vtx+1];
            rank = new int[vtx+1];
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

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);

        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (uf.isConnexted(v1, v2) == false) {
                uf.union(v1, v2);
            } else {
                return edge;
            }
        }

        return new int[0];
    }
}
