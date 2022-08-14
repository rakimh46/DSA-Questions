https://practice.geeksforgeeks.org/problems/euler-circuit-and-path/1

class Solution
{
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        int count=0;
        
        for(int i=0;i<V;i++){
            if(adj.get(i).size()%2==1){
                count++;
            }
        }
        
        if(count==0) return 2;
        else if(count==2) return 1;
        else return 0;
    }
}

1 graph contains Eulerian Path 
2 graph contains Eulerian Circuit 
0 otherwise.
    
class Solution
{
    public int isPossible(int[][] paths)
    {
        // Code here
        int result = 0;
        if(paths.length == 1) return 1;
        for(int i = 0; i < paths.length; i++){
            result = 0;
            for(int j = 0; j < paths[i].length; j++){
                if(paths[i][j] == 1) result++;
            }
            if(result == 0 || result%2 != 0){
                return 0;
            }
        }
        return 1;
    }
}

