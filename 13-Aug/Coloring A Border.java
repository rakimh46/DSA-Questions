//https://leetcode.com/problems/coloring-a-border/

class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid,row,col,grid[row][col],color,new boolean[grid.length][grid[0].length]);
        return grid;
    }
    
    public void dfs(int[][] grid, int r, int c,int pc, int cl,boolean[][]vis){
        vis[r][c]=true;
        int ct=0;
        if(r-1>=0){
            if(vis[r-1][c]){
                ct++;
            }else if(grid[r-1][c]==pc){
                ct++;
                dfs(grid,r-1,c,pc,cl,vis);
            }
        }
        if(c-1>=0){
            if(vis[r][c-1]){
                ct++;
            }else if(grid[r][c-1]==pc){
                ct++;
                dfs(grid,r,c-1,pc,cl,vis);
            }
        }
        if(r+1<grid.length){
            if(vis[r+1][c]){
                ct++;
            }else if(grid[r+1][c]==pc){
                ct++;
                dfs(grid,r+1,c,pc,cl,vis);
            }
        }
        if(c+1<grid[0].length){
            if(vis[r][c+1]){
                ct++;
            }else if(grid[r][c+1]==pc){
                ct++;
                dfs(grid,r,c+1,pc,cl,vis);
            }
        }
        if(ct!=4){
            grid[r][c]=cl;
        }
    }
}
