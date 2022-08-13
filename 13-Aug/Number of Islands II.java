//By dfs
public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        List<Integer> ans = new ArrayList<Integer>();
        int[][] mat=new int[rows][cols];
        for(int[] o:operators){
            mat[o[0]][o[1]]=1;
            ans.add(findisland(mat));
        }
        return ans;
    }
    int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public void dfs(int i,int j,int[][] mat,boolean[][] vis){
        vis[i][j]=true;
        for(int[]d:dir){
            int r=i+d[0];
            int c=j+d[1];
            if(r<0 || c<0 || r>=mat.length || c>=mat[0].length || mat[r][c]!=1 || vis[r][c]){
                continue;
            }
            dfs(r,c,mat,vis);
        }
    }
    
    public int findisland(int[][] mat){
        boolean[][]vis=new boolean[mat.length][mat[0].length];
        int c=0;
        for(int i = 0; i<vis.length ;i++){
            for(int j = 0;j<vis[0].length ;j++){
                if(mat[i][j]==1 && !vis[i][j]){
                    c++;
                    dfs(i,j,mat,vis);
                }
            }
        }
        return c;
    }


// dsu

class Solution {
    
    public List<Integer> numOfIslands(int m, int n, int[][] positions) {
        //Your code here
        List<Integer> ans=new ArrayList<>();
        UnionFind unf = new UnionFind(m * n);
        int[][]dir={{1,0},{0,1},{-1,0},{0,-1}};
        int i = 0;
        for(int[] pos : positions) {
            int r = pos[0], c = pos[1];
            int id = r * n + c;
            unf.setParent(id);
            for(int[] d:dir) {
                int newR = r + d[0];
                int newC = c + d[1];
                int newId = newR * n + newC;
                if(newR >= 0 && newR < m && newC >= 0 && newC < n && unf.parent[newId]>=0) {
                    unf.union(newId, id);
                }
            }
            ans.add(unf.count);
        }
        return ans;
    }
}

class UnionFind {
    int count;
    int[] parent;
    int[] rank;

    UnionFind(int n) {
        count = 0;
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = -1;
            rank[i] = 0;
        }
    }
    void setParent(int i) {
        parent[i] = i;
        count++;
    }

    int find(int i) {
        if(parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if(rootx != rooty) {
            parent[rooty] = rootx;
            count--;
        }
    }
}
