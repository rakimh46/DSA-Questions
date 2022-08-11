class Solution 
{ 
    class Pair{
        int home;
        int dia;
        Pair(int home,int dia){
            this.home=home;
            this.dia=dia;
        }
    }
    ArrayList<ArrayList<Integer>> solve(int n, int p, ArrayList<Integer> a ,ArrayList<Integer> b ,ArrayList<Integer> d) 
    { 
         // code here
         HashMap<Integer,ArrayList<Pair>> mp=new HashMap<>();
         int in[]=new int[n+1];
         int out[]=new int[n+1];
         boolean[] vis=new boolean[21];
         for(int i=0;i<p;i++){
             out[a.get(i)]=1;
             in[b.get(i)]=1;
             mp.putIfAbsent(a.get(i),new ArrayList<Pair>());
             mp.get(a.get(i)).add(new Pair(b.get(i),d.get(i)));
         }
         ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
         for(int i=0;i<=n;i++){
             if(!vis[i] && in[i]==0 && out[i]==1){
                 int s=i;
                 int e=0;
                 int wt=Integer.MAX_VALUE;
                 dfs(mp,vis,i,i,e,wt,ans);
             }
         }
         Collections.sort(ans,(A,B)->{return A.get(0)-B.get(0);});
         return ans;
     }
     
     void dfs(HashMap<Integer,ArrayList<Pair>> mp,boolean[] vis,int i,int housein,int houseout,int wt,ArrayList<ArrayList<Integer>> ans){
         vis[i]=true;
         ArrayList<Pair> x=mp.getOrDefault(i,new ArrayList<>());
         for(Pair neighbour:x){
             if(!vis[neighbour.home]){
                dfs(mp,vis,neighbour.home,housein,neighbour.home,Math.min(wt,neighbour.dia),ans);
             } 
         }
         if(x.size()==0){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.add(
                temp.add(houseout);
                temp.add(wt);
                ans.add(temp);
         }
     }
} 
