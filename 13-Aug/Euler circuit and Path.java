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

