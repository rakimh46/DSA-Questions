//DSu
public class Solution {  
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        // write your code here
        UnionFind uf=new UnionFind();

        for(List<String> p:pairs){
            String w1=p.get(0);
            String w2=p.get(1);

            uf.addSelf(w1);
            uf.addSelf(w2);

            uf.union(w1,w2);
        }

        if(words1.length != words2.length) {
            return false;
        }

        for(int i=0; i < words1.length;i++) {
            String w1 = words1[i];
            String w2 = words2[i];

            if(w1.equals(w2)) {
                continue;
            }

            if(!uf.containsKey(w1) || !uf.containsKey(w2) || !uf.check(w1,w2)) {
                return false;
            }
        }

        return true;
    }
}

class UnionFind{
    Map<String,String> par;
    Map<String,Integer> rank;
    UnionFind(){
        par=new HashMap<>();
        rank=new HashMap<>();
    }
    boolean containsKey(String w1){
        return par.containsKey(w1);
    }
    boolean check(String w1,String w2){
        return par.get(w1).equals(par.get(w2));
    }
    String find(String str){
        if(str.equals(par.get(str))) return str;

        String tmp=find(par.get(str));
        par.put(str,tmp);
        return tmp;
    }
    void addSelf(String str){
        par.putIfAbsent(str, str);
        rank.putIfAbsent(str, 1);
    }
    void union(String w1,String w2){
        String l1 = find(w1);
        String l2 = find(w2);

        if(l1.equals(l2) == false) {
            //merge on the basis rank
            int r1 = rank.get(l1);
            int r2 = rank.get(l2);

            if(r1 < r2) {
                par.put(l1,l2);
            }
            else if(r1 > r2) {
                par.put(l2,l1);
            }
            else {
                par.put(l1,l2);
                rank.put(l2,rank.get(l2) + 1);
            }
        }
    }    
}
