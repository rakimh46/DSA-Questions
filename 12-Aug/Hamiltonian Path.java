class Solution 
{ 
   boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
   {
      // code here
       HashMap<Integer,ArrayList<Integer>> mp=new HashMap<>();
       for(ArrayList<Integer> ans : Edges){
          int src = ans.get(0);
          int des = ans.get(1);
          mp.putIfAbsent(src,new ArrayList<Integer>());
          mp.get(src).add(des);
          mp.putIfAbsent(des,new ArrayList<Integer>());
          mp.get(des).add(src);
       }
       
       HashSet<Integer> set = new HashSet<>();
       
       for(int i=1;i<=N;i++){
           if(count(mp,i,set)){
               return true;
           }
       }
       return false;
   }
   boolean count(HashMap<Integer,ArrayList<Integer>> mp,int src , HashSet<Integer> set){
       set.add(src);
       if(set.size()==mp.size()){   
           return true;
       }
       ArrayList<Integer> e=mp.getOrDefault(src,new ArrayList<>());
       for(Integer nbr : e){
           if(!set.contains(nbr)){
               boolean ans1=count(mp,nbr,set);
               if(ans1==true){
                   return ans1;
               }
           }
       }
       set.remove(src);
       return false;
   }
   
} 
