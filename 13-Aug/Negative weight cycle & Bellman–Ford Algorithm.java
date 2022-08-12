//https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int[] ans=new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        for(int i=0;i<n-1;i++){
            for(int[] e:edges){
                int u=e[0];
                int v=e[1];
                int wt=e[2];
                if(ans[u]!=Integer.MAX_VALUE && ans[u]+wt<ans[v]){
                    ans[v]=ans[u]+wt;
                }
            }
        }
        
        //check for negative
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            if(ans[u]!=Integer.MAX_VALUE && ans[u]+wt<ans[v]){
                return 1;
            }
        }
        return 0;
    }
}
