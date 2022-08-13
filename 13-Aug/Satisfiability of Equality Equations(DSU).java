class Solution {
    int[] par;
    int[] rank;

    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        rank = new int[26];
        for (int i = 0; i < 26; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                union(str.charAt(0) - 'a', str.charAt(3) - 'a');
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int lx = find(str.charAt(0) - 'a');
                int ly = find(str.charAt(3) - 'a');
                if (lx == ly) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int v1, int v2) {
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

    public int find(int vtx) {
        if (par[vtx] == vtx) {
            return vtx;
        }
        return par[vtx] = find(par[vtx]);
    }
}
