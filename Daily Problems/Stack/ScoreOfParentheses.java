// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.
 

// Example 1:
// Input: s = "()"
// Output: 1
  
// Example 2:
// Input: s = "(())"
// Output: 2
  
// Example 3:
// Input: s = "()()"
// Output: 2

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push(0);
            }
            else{
                int inner=st.pop();
                int score= inner==0?1:2*inner;
                st.push(st.pop()+score);
            }
        }
        return st.pop();
    }
}
