class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        String[] words=S.split("\\.");
        Collections.reverse(Arrays.asList(words));
        return String.join(".",words);
    }
}
