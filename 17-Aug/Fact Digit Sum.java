https://practice.geeksforgeeks.org/problems/fact-digit-sum4125/1
class Solution
{
    ArrayList<Integer> FactDigit(int N)
    {
        // code here
        ArrayList<Integer> fact=new ArrayList<>();
        fact.add(1);
        fact.add(1);
        fact.add(2);
        fact.add(6);
        fact.add(24);
        fact.add(120);
        fact.add(720);
        fact.add(5040);
        fact.add(40320);
        fact.add(362880);
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=9;i>0;i--){
            while(N>=fact.get(i)){
                N=N-fact.get(i);
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
