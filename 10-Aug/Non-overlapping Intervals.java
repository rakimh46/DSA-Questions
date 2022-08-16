https://leetcode.com/problems/non-overlapping-intervals/

class Solution {
    public int eraseOverlapIntervals(int[][] Intervals) {
        Arrays.sort(Intervals,(a,b)->a[1]-b[1]);
        
        int c=0;
        
        int start=Integer.MIN_VALUE;
        int end=Integer.MIN_VALUE;
        
        for(int[] i:Intervals){
            if(end>i[0]){
                c++;
            }else{
                end=i[1];
                start=i[0];
            }
        }
        return c;
    }
}
