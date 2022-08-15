https://leetcode.com/problems/k-similar-strings/
class Solution {
    public String swap(String a,int i,int j){
        StringBuilder sb=new StringBuilder(a);
        sb.setCharAt(i,a.charAt(j));
        sb.setCharAt(j,a.charAt(i));
        return sb.toString();
    }
    public ArrayList<String> neighbour(String a,String b){
        int n=a.length();
        int idx;
        for(idx=0;idx<n;idx++){
            if(a.charAt(idx)!=b.charAt(idx)){
                break;
            }
        }
        
        ArrayList<String> res=new ArrayList<String>();
        for(int j=idx+1;j<n;j++){
            if(a.charAt(j)==b.charAt(idx)){
                String s=swap(a,idx,j);
                res.add(s);
            }
        }
        return res;
    }

    public int kSimilarity(String s1, String s2) {
        Set<String> vis=new HashSet<>();
        Queue<String> qu=new ArrayDeque<>();
        
        qu.add(s1);
        vis.add(s1);
        
        int l=0;
        while(!qu.isEmpty()){
            int sz=qu.size();
            while(sz-->0){
                String rem=qu.remove();
                if(rem.equals(s2)) return l;
                for(String nbr:neighbour(rem,s2)){
                    if(!vis.contains(nbr)){
                        vis.add(nbr);
                        qu.add(nbr);
                    }
                }
            }
            l++;
        }
        return l;
    }
}
