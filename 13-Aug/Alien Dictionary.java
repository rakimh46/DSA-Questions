//https://practice.geeksforgeeks.org/problems/alien-dictionary/1
class Solution
{
    public String ans = "";
    public static ArrayList<ArrayList<Integer>> graph;
    public String findOrder(String [] words, int N, int K)
    {
        // Write your code here
        graph=new ArrayList<>();
        for(int l=0;l<K;l++){
            graph.add(new ArrayList<Integer>());
        }
        int[] indeg=new int[K];
        for (int k = 0; k < words.length - 1; k++) {
            String w1 = words[k];
            String w2 = words[k + 1];

            int i = 0, j = 0;

            while (i < w1.length() && j < w2.length()) {
                char ch1 = w1.charAt(i);
                char ch2 = w2.charAt(j);

                if (ch1 != ch2) {
                    graph.get(ch1-'a').add(ch2-'a');
                    indeg[ch2-'a']++;
                    break;
                }

                i++;
                j++;
            }

            if (i < w1.length() && j == w2.length()) {
                return ""; //invalid order of words
            }

        }
        
        Queue<Integer> qu=new ArrayDeque<>();
        for(int i=0;i<K;i++){
            if(indeg[i]==0){
                qu.add(i);
            }
        }
        
        while(qu.size()>0){
            int x=qu.remove();
            ans = ans + (char)(x + 'a');
            for(int xx:graph.get(x)){
                indeg[xx]--;
                if(indeg[xx]==0){
                    qu.add(xx);
                }
            }
        }
        return ans;
    }
}

