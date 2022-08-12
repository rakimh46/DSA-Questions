//https://leetcode.com/problems/rotting-oranges/
class Solution {
    class Pair{
        int r;
        int c;
        Pair(int i,int j){
            r=i;
            c=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int t=0;
        Queue<Pair> qu=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) t++;
                if(grid[i][j]==2){
                    qu.add(new Pair(i,j));
                } 
            }
        }
        
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        int l=0;
        while(!qu.isEmpty()){
            int size=qu.size();
            while(size-->0){
                Pair r=qu.remove();
                for(int[]d:dir){
                    int i=r.r+d[0];
                    int j=r.c+d[1];
                    if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==1){
                        grid[i][j]=2;
                        t--;
                        qu.add(new Pair(i,j));
                    }
                }
            }
            
            if(qu.size()!=0) l++;
        }
        
        if(t==0){
            return l;
        }else{
            return -1;
        }
    }
}

//2nd way
class Solution {
    
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 2) rotAdjacent(grid, i, j, 2);
            }
        }
        
        int minutes = 2;
        for(int[] row : grid) {
            for(int cell : row) {
                if(cell == 1) return -1;
                minutes = Math.max(minutes, cell);
            }
        }
        
        return minutes - 2;
    }
    
    private void rotAdjacent(int[][] grid, int i, int j, int minutes) {
        if(i < 0 || i >= grid.length /* out of bounds */
          || j < 0 || j >= grid[0].length /* out of bounds */
          || grid[i][j] == 0 /* empty cell */
          || (1 < grid[i][j] && grid[i][j] < minutes) /* this orange is already rotten by another rotten orange */
          ) return;
        else {
            grid[i][j] = minutes;
            rotAdjacent(grid, i - 1, j, minutes + 1);
            rotAdjacent(grid, i + 1, j, minutes + 1);
            rotAdjacent(grid, i, j - 1, minutes + 1);
            rotAdjacent(grid, i, j + 1, minutes + 1);
        }
    }
}
