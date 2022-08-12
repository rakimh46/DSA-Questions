//https://leetcode.com/problems/number-of-enclaves/
class Solution {
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[0].length-1){
                    dfs(grid,i,j);
                }
            }
        }
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    c++;
                }
            }
        }
        return c;
    }
    public void dfs(int[][] grid,int i,int j){
        if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==1){
            grid[i][j]=0;
            dfs(grid,i+1,j);
            dfs(grid,i,j+1);
            dfs(grid,i-1,j);
            dfs(grid,i,j-1);

        } 
        
            }
}


// 2nd way

class Solution {
    int n;
    int m;
    public int numEnclaves(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int count=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    dfs(grid,i,j);
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    
    int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
    public void dfs(int a[][], int i, int j) {
        if(i >= 0 && i <= a.length - 1 && j >= 0 && j <= a[i].length - 1 && a[i][j] == 1) {
            a[i][j] = 0;
            dfs(a, i + 1, j);
            dfs(a, i - 1, j);
            dfs(a, i, j + 1);
            dfs(a, i, j - 1);
        }
    }
}
