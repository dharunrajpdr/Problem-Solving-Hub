
// Example 1:
// Input: s = "(abcd)"
// Output: "dcba"
  
// Example 2:
// Input: s = "(u(love)i)"
// Output: "iloveu"
// Explanation: The substring "love" is reversed first, then the whole string is reversed.

class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c==')'){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                if(!st.isEmpty()){
                    st.pop();
                }
                for(int j=0;j<sb.length();j++){
                    st.push(sb.charAt(j));
                }
            }
            else{
                st.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}
