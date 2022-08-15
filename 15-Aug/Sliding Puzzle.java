https://leetcode.com/problems/sliding-puzzle/

class Solution {
    public int slidingPuzzle(int[][] board) {
        String tar="123450";
        
        List<List<Integer>> adj=new ArrayList<>();
        adj.add(Arrays.asList(1,3));
        adj.add(Arrays.asList(0,2,4));
        adj.add(Arrays.asList(1,5  ));
        adj.add(Arrays.asList(0,4));
        adj.add(Arrays.asList(1,3,5));
        adj.add(Arrays.asList(2,4));
        
        Set<String> vis=new HashSet<>();
        
        StringBuilder sb=new StringBuilder();
        for(int[]b:board){
            for(int v:b){
                sb.append(v);
            }
        }
        
        String init = sb.toString();
        Queue<String> pq = new LinkedList();
        pq.offer(init);
        vis.add(init);
        int step=0;
        while(!pq.isEmpty()){
            int size=pq.size();
            while(size-->0){
                String curr=pq.poll();
                if(curr.equals(tar)) return step;
                
                int i=curr.indexOf('0');
                for(int j:adj.get(i)){
                    String next=get(curr,i,j);
                    if(!vis.contains(next)){
                        vis.add(next);
                        pq.offer(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    public String get(String curr,int i,int j){
        char[] arr=curr.toCharArray();
        char ch=arr[i];
        arr[i]=arr[j];
        arr[j]=ch;
        return new String(arr);
    }
}
