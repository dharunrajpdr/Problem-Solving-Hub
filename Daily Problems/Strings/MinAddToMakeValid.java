
// Input: s = "())"
// Output: 1

// Input: s = "((("
// Output: 3

class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                st.push('(');
            }
            else if(!st.isEmpty() && st.peek()=='(' && c==')'){
                st.pop();
            }
            else{
                st.push(')');
            }
        }
        return st.size();
    }
}
