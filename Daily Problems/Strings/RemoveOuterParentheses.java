// Example 1:
// Input: s = "(()())(())"
// Output: "()()()"
// Explanation: 
// The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
// After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
  
// Example 2:
// Input: s = "(()())(())(()(()))"
// Output: "()()()()(())"
// Explanation: 
// The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
// After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
  
// Example 3:
// Input: s = "()()"
// Output: ""
// Explanation: 
// The input string is "()()", with primitive decomposition "()" + "()".
// After removing outer parentheses of each part, this is "" + "" = "".

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int depth=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                if(depth>0){
                    sb.append(c);
                }
                depth++;
            }
            else{
                depth--;
                if(depth>0){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
