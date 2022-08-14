//DFS
https://practice.geeksforgeeks.org/problems/merging-details/1
class Solution {
    HashSet<String> visited = new HashSet<>();
    Map<String, List<String>> adjacent = new HashMap<String, List<String>>();

    private void DFS(List<String> mergedAccount, String email) {
        visited.add(email);
        // Add the email vector that contains the current component's emails
        mergedAccount.add(email);

        // if (!adjacent.containsKey(email)) {
        //     return;
        // }

        for (String neighbor : adjacent.get(email)) {
            if (!visited.contains(neighbor)) {
                DFS(mergedAccount, neighbor);
            }
        }
    }
    public List<List<String>> mergeDetails(List<List<String>> details) {
        int detailsSize = details.size();

        for (List<String> detail : details) {
            int detailSize = detail.size();

            // Building adjacency list
            // Adding edge between first email to all other emails in the
            // account
            String detailFirstEmail = detail.get(1);
            adjacent.putIfAbsent(detailFirstEmail,new ArrayList<String>());
            for (int j = 2; j < detailSize; j++) {
                String detailEmail = detail.get(j);
                adjacent.get(detailFirstEmail).add(detailEmail);
                adjacent.putIfAbsent(detailEmail,new ArrayList<String>());
                adjacent.get(detailEmail).add(detailFirstEmail);
            }
        }

        // Traverse over all th accounts to store components
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (List<String> detail : details) {
            String accountName = detail.get(0);
            String accountFirstEmail = detail.get(1);

            // If email is visited, then it's a part of different component
            // Hence perform DFS only if email is not visited yet
            if (!visited.contains(accountFirstEmail)) {
                List<String> mergedAccount = new ArrayList<>();
                // Adding account name at the 0th index
                mergedAccount.add(accountName);

                DFS(mergedAccount, accountFirstEmail);
                Collections.sort(mergedAccount.subList(1, mergedAccount.size()));
                mergedAccounts.add(mergedAccount);
            }
        }

        return mergedAccounts;
    }
}

//By DSu
// leetcode 721
class Solution {
    int[] par;
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        par=new int[10001];
        for(int i=0;i<10001;i++){
            par[i]=i;
        }
        int id=0;
        
        Map<String,Integer> uqid=new HashMap<>(); 
        Map<String,String> uqn=new HashMap<>();
        
        for(List<String> acc: accounts){
            String name="";
            
            for(String email:acc){
                if(name==""){
                    name=email;
                    continue;
                }
                if(!uqn.containsKey(email)){
                    uqn.put(email,name);
                }
                if(!uqid.containsKey(email)){
                    uqid.put(email,id);
                    id++;
                }
                
                int u=uqid.get(acc.get(1));
                int v=uqid.get(email);
                
                union(u,v);
            }
        }
        
        Map<Integer,List<String>> pte=new HashMap<>(); 
        
        for(String email : uqn.keySet()){
            int idx=uqid.get(email);
            
            int pt=find(idx);
            
            if(pte.containsKey(pt)){
               pte.get(pt).add(email); 
            }else{
                pte.put(pt,new ArrayList<>());
                pte.get(pt).add(email); 
            }
        }
        
        List<List<String>> ans=new ArrayList<>();
        
        for(List<String> email : pte.values()){
            Collections.sort(email);
            
            String name=uqn.get(email.get(0));
            List<String> t=new ArrayList<>();
            t.add(name);
            for(String e:email){
                t.add(e);
            }
            ans.add(t);
        }
        return ans;
    }
    
    int find(int x){
        if(x==par[x]){
            return x;
        }
        return par[x]=find(par[x]);
    }
    
    void union(int u,int v){
        int p1=find(u);
        int p2=find(v);
        if(p1!=p2){
            par[p2]=p1;
        }
    }
}
