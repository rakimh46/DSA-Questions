https://practice.geeksforgeeks.org/problems/pots-of-gold-game/1
class GfG
{
    static Integer[][]dp;
	public static int maxCoins(int A[],int n)
	{
          //add code here.
          dp=new Integer[n+1][n+1];
          return rec(0,n-1,A);
    }
    
    public static int rec(int l,int r,int[] A){
        if(l>r){
            return 0;
        }
        if(dp[l][r]!=null) return dp[l][r];
        
        int left=A[l]+Math.min(rec(l+1,r-1,A),rec(l+2,r,A));
        int right=A[r]+Math.min(rec(l,r-2,A),rec(l+1,r-1,A));
        
        return dp[l][r]=Math.max(left,right);
    }
}
