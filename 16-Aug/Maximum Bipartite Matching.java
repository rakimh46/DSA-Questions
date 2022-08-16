https://practice.geeksforgeeks.org/problems/maximum-bipartite-matching/1
class Solution
{
    public int maximumMatch(int[][] G)
    {
        // Code here
        if(G.length<=G[0].length) return G.length;
        Set<Integer> applicant=new HashSet<>();
        Set<Integer> job=new HashSet<>();
        int c=0;
        for(int i=0;i<G.length;i++){
            var check=false;
            applicant.add(i);
            for(int j=0;j<G[0].length;j++){
                if(check) break;
                if(G[i][j]==1){
                    if(!job.contains(j)){
                        check=true;
                        job.add(j);
                    }else{
                        continue;
                    }
                }
            }
            if(!check){
                applicant.remove(i);
            }else{
                c++;
            }
        }
        return c;
    }
}
