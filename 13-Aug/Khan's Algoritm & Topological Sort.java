//https://leetcode.com/problems/course-schedule-ii/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];
        
        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> qu=new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                qu.add(i);
            }
        }
//         int i=0;
//         for(int v: deg){
//             if(v==0) qu.add(i);
//             i++;
//         }
        

        int count=0;
        boolean[] vis=new boolean[numCourses];
        int[] ans=new int[numCourses];
        while(qu.size()>0){
            int rem=qu.remove();
            vis[rem]=true;
            ans[count]=rem;
            count++;

            ArrayList<Integer> nbrs=graph.get(rem);
            for (int nbr : nbrs) {
                indegree[nbr]--;

                if(vis[nbr]==false && indegree[nbr]==0){
                    qu.add(nbr);
                }
            }
        }
        if(count==numCourses){
            return ans;
        }else{
            return new int[0];
        }
    }
}
