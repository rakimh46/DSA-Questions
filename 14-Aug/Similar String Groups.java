https://leetcode.com/problems/similar-string-groups/
class Solution {
    public int numSimilarGroups(String[] strs) {
        int len=strs.length;
        
        UnionFind uf=new UnionFind(len);
        
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(strs[i].length()!=strs[j].length()) continue;
                if(Issimilar(strs[i],strs[j])){
                    uf.union(i,j);
                }
            }
        }
        
        return uf.size;
    }
    
    public boolean Issimilar(String w1,String w2){
        int count=0;
        for(int i=0;i<w1.length();i++){
            if(w1.charAt(i)!=w2.charAt(i)){
                if(count==2) return false;
                count++;
            }
        }
        return true;
    }
    public class UnionFind{
        int[] par;
        int size;
        
        UnionFind(int vtx){
            par=new int[vtx];
            for(int i=0;i<vtx;i++){
                par[i]=i;
            }
            size=vtx;
        }
        
        void union(int u,int v){
            int rt1=find(u);
            int rt2=find(v);
            
            if(rt1==rt2) return;
            par[rt2]=rt1;
            size--;
        }
        
        int find(int v){
            if(par[v]==v){
                return v;
            }
            
            return par[v]=find(par[v]);
        }
    }
    
}
