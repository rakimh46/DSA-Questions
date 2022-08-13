// hash table
public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        // write your code here
        if (words1.length != words2.length) return false;
        Map<String, HashSet<String> > mp = new HashMap<>();
        HashSet<String> hash;
        for (int i = 0; i < pairs.size(); ++i) {
            if (mp.get (pairs.get (i).get (0)) != null) hash = mp.get (pairs.get (i).get (0));
            else hash = new HashSet<>();
            hash.add (pairs.get (i).get (1));
            mp.put (pairs.get (i).get (0), hash);
        }
        for (int i = 0; i < words1.length; ++i) {
            if (words1[i].equals (words2[i])) continue;
            if ( (mp.get (words1[i]) == null || !mp.get (words1[i]).contains (words2[i])) &&
                    (mp.get (words2[i]) == null || !mp.get (words2[i]).contains (words1[i]))) return false;
        }
        return true;
}
