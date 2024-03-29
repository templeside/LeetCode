class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if( c == '(' || c == '[' || c == '{'){
                st.push(c);
            }else if(c ==')'){
                if(st.size() !=0 && st.peek() == '(')
                    st.pop();
                else
                    return false;
            }else if(c ==']'){
                if(st.size() !=0 && st.peek() == '[')
                    st.pop();
                else
                    return false;
            }else if(c =='}'){
                if(st.size() !=0 && st.peek() == '{')
                    st.pop();
                else
                    return false;
            }
        }
        return st.size() == 0;
    }
}