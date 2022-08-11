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

2nd way

class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        Stack<String> st=new Stack<>();
        
        StringBuilder sb=new StringBuilder("");
        
        for(int i=0;i<S.length();i++){
            char ch=S.charAt(i);
            if(ch!='.'){
                sb.append(ch);
            }
            if(ch=='.'){
                String str=sb.toString();
                st.push(str);
                sb.delete(0,sb.length());
            }
        }
        String str=sb.toString();
        st.push(str);
        sb.delete(0,sb.length());
        while(st.size()>1){
            str=st.pop();
            sb.append(str);
            sb.append(".");
        }
        str=st.pop();
        sb.append(str);
        return sb.toString();
    }
}

