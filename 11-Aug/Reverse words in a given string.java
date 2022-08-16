https://leetcode.com/problems/reverse-words-in-a-string/
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}

2nd way

class Solution {
    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<String> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=' '){
                sb.append(ch);
            }else{
                if(sb.length()>0){
                    st.push(sb.toString());
                    sb=new StringBuilder();
                }
            }
        }
        
        if(sb.length()>0){
            st.push(sb.toString());
        }
        sb=new StringBuilder();
        
        while(st.size()>1){
            sb.append(st.pop());
            sb.append(" ");
        }
        sb.append(st.pop());
        
        return sb.toString();
    }
}
