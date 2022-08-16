https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates0744/1
class Solution{
    String rremove(String s){
        if(s.length()==0) return s;
        
        Stack<Character>s1=new Stack<>();
        int result=1;
        int flag=1;
        s1.push(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
            if(s1.peek()==s.charAt(i)){
                flag=-1;
                result=-1;
            }else if(flag==-1&&s1.peek()!=s.charAt(i)){
               s1.pop();
               s1.push(s.charAt(i));
               flag=1;
            }else  s1.push(s.charAt(i));
        }
        if(flag==-1)
        s1.pop();
        StringBuilder str=new StringBuilder();
        while(!s1.empty()){
            str.append(s1.pop());
        }
        String ss=str.toString();
        if(result==-1)
        return rremove(ss);
        return ss;     
        }
}
