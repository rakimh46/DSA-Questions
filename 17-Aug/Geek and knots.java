https://practice.geeksforgeeks.org/problems/little-murph-and-knots0402/1
Pascal triangle combination

class Solution{
    static int mod=(int)(1e9+7);
    static long[][] dp;
    static int knots(int m, int n, int k){
        // code here
        dp = new long[Math.max(m,n)+1][Math.max(m,n)+1];
        
        for (int i=0;i<=Math.max(m,n);i++){
            dp[i][0]=dp[i][i]=1;
            for (int j=1;j<i;j++){
                dp[i][j]=(dp[i-1][j-1]%mod+dp[i-1][j])%mod;
            }
        }
        
        long res = (dp[m][k] * dp[n][k])%mod;
        return (int)res;
    }
}

