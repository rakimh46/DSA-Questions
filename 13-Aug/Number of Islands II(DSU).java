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
   static final int[][] DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        if (isNullOrEmpty(operators)) return Collections.emptyList();
        
        UF uf = new UF(rows * cols + 1);
        List<Integer> result = new ArrayList<>(operators.length);
        for (int[] op : operators) {
            int curr = op[0] * cols + op[1] + 1;
            uf.addLand(curr);

            for (int[] dir : DIRS) {
                int r = op[0] + dir[0];
                int c = op[1] + dir[1];
                int adj = r * cols + c + 1;
                
                if (isSafe(rows, cols, r, c) && uf.isLand(adj)) {
                    uf.union(curr, adj);
                }
            }
            
            result.add(uf.count);
        }
        return result;
    }
    
    private boolean isSafe(int rows, int cols, int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }
    
    private boolean isNullOrEmpty(int[][] arr) {
        return arr.length == 0;
    }
}
class UF {
    int[] parent;
    int count = 0; // number of components
    
    UF(int n) {
        parent = new int[n];
    }
    
    public void addLand(int p) {
        if (isLand(p)) return;
        parent[p] = p;
        count++;
    }
    
    public boolean isLand(int p) {
        return parent[p] > 0;
    }
    
    public int find(int p) {
       if(p==parent[p]) return p;
       return parent[p]=find(parent[p]);
    }
    
    public void union(int p, int q) {
        int pr = find(p);
        int qr = find(q);
        if (pr != qr){
            parent[qr] = pr;
            count--;
        }
    }
}
