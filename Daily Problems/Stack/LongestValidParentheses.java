// Example 1:
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
  
// Example 2:
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
  
// Example 3:
// Input: s = ""
// Output: 0

class Solution {
    public int longestValidParentheses(String s) {
        // if(s.length()==0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);                  //initially we need to put -1
        int max=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
                else{
                    max=Math.max(max,i-st.peek());
                }
            }
        }
        return max;
    }
}
