DSU


/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    class DisjointSet{
        int parent[];
        DisjointSet(int n)
        {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++)
                parent[i] = i;
        }
        
        int find(int s)
        {
            if (s == parent[s])
                return s;
            return parent[s] = find(parent[s]);
        }
     
        
        void merge(int u, int v)
        {
            parent[v] = u;
        }
    }
    
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int max=Integer.MIN_VALUE;
        for(Job temp :arr){
            max=Math.max(temp.deadline,max);
        }
        DisjointSet dsu = new DisjointSet(max+1);
        
        Arrays.sort(arr,(a,b)-> b.profit-a.profit);
        int[] ans=new int[2];
        for (Job temp : arr)
        {
            int availableSlot = dsu.find(temp.deadline);
 
            if (availableSlot > 0)
            {
                dsu.merge(dsu.find(availableSlot - 1),
                                  availableSlot);
                ans[0]++;
                ans[1]+=temp.profit;
            }
        }
        
        return ans;
    }
}

