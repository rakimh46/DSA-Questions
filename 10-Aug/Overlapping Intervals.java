https://leetcode.com/problems/merge-intervals/
class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        // Code here
        Arrays.sort(Intervals,(a,b)->a[0]-b[0]);
        
        List<int[]> ans=new ArrayList<>();
        
        int start=Intervals[0][0];
        int end=Intervals[0][1];
        
        for(int i[]:Intervals){
            if(i[0]<=end){
                end=Math.max(end,i[1]);
            }else{
                ans.add(new int[]{start,end});
                start=i[0];
                end=i[1];
            }
        }
        ans.add(new int[]{start,end});
        return ans.toArray(new int[0][]);
    }
}
