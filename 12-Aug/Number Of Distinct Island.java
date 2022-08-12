//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/graphs/number-of-distinct-island-official/ojquestion

class Solution {
  public static StringBuilder psf = new StringBuilder();

  public static int numDistinctIslands(int[][] arr) {
    //write your code here
    Set<String> set=new HashSet<>();
    for(int i=0;i<arr.length;i++){
        for(int j=0;j<arr[0].length;j++){
            if(arr[i][j]==1){
                psf = new StringBuilder("X");
                dfs(arr,i,j);
                set.add(psf.toString());
            }
        }
    }
    return set.size();
  }
  
  public static void dfs(int[][] grid,int r,int c){
      grid[r][c]=2;
      
      if(r-1>=0 && grid[r-1][c]==1){
          psf.append("N");
          dfs(grid,r-1,c);
      }
      if(c-1>=0 && grid[r][c-1]==1){
          psf.append("W");
          dfs(grid,r,c-1);
      }
      if(r+1<grid.length && grid[r+1][c]==1){
          psf.append("S");
          dfs(grid,r+1,c);
      }
      if(c+1<grid[0].length && grid[r][c+1]==1){
          psf.append("S");
          dfs(grid,r,c+1);
      }
      psf.append("Z");
  }
}
