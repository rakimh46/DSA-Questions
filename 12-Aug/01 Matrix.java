https://leetcode.com/problems/01-matrix/
class Solution {
    
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        
        Queue<int[]>pq=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    pq.add(new int[]{i,j,0});
                }
            }
        }
        int[][] ans=new int[n][m];
        int[][] dir={{1,0},{0,1},{-1,0},{0,-1}};
        while(pq.size()>0){
            int[] p= pq.remove();
            ans[p[0]][p[1]]=p[2];
            
            for(int[]d:dir){
                int r=p[0]+d[0];
                int c=p[1]+d[1];
                
                if(r<0 || c<0 || r>=n || c >= m || mat[r][c]!=1){
                    continue;
                }
                mat[r][c]=0;
                pq.add(new int[]{r,c,1+p[2]});
            }
        }
        return ans;
    }
}
