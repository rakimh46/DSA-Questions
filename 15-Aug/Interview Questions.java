Interview Questions
https://practice.geeksforgeeks.org/contest/interview-series-63/problems/#

1. Distinct Difference
class Solution {
    public static ArrayList<Integer> getDistinctDifference(int N, int[] A) {
        // code here
        int[]left=new int[N];
        Set<Integer> set=new HashSet<>();
        var count=0;
        for(int i=0;i<N;i++){
            left[i]=count;
            if(!set.contains(A[i])){
                count++;
                set.add(A[i]);
            }
        }
        
        set.clear();
        int[]right=new int[N];
        count=0;
        for(int i=N-1;i>=0;i--){
            right[i]=count;
            if(!set.contains(A[i])){
                count++;
                set.add(A[i]);
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        for(int i=0;i<N;i++){
            ans.add(left[i]-right[i]);
        }
        return ans;
    }
}
        
2. Minimum days

class Solution {
    public static int getMinimumDays(int N, String S, int[] p) {
        // code here
        int c=0;
        char[]arr=S.toCharArray();
        
        for(int i=0;i<N-1;i++){
            if(arr[i]==arr[i+1])c++;
        }
        
        if(c==0) return 0;
        
        for(int i=0;i<N-1;i++){
            if(p[i]>0 && arr[p[i]]==arr[p[i]-1] ) c--;
            if(p[i]<N-1 && arr[p[i]]==arr[p[i]+1] ) c--;
            arr[p[i]]='?';
            if(c==0) return i+1;
        }
        
        return -1;
    }
}
        
3. Good Pair  
Bit Masking


