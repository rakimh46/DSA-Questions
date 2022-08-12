//https://leetcode.com/problems/number-of-islands/
class Solution {
    public int numIslands(char[][] grid) {
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    c++;
                    dfs(grid,i,j);
                }
            }
        }
        return c;
    }
    static int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
    public void dfs(char[][] grid,int i,int j){
        grid[i][j]='2';
        for(int[] d:dir){
            int r=i+d[0];
            int c=j+d[1];
            if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || grid[r][c]!='1'){
                continue;
            }
            dfs(grid,r,c);
        }
    }
}
